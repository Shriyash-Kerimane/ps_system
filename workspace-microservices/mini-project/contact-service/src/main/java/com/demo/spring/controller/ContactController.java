package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Contact;
import com.demo.spring.exceptions.ContactAlreadyExistsException;
import com.demo.spring.exceptions.ContactNotFoundException;
import com.demo.spring.exceptions.UserNotFoundException;
import com.demo.spring.repository.ContactRepository;
import com.demo.spring.util.Message;

@RestController
@RequestMapping(path = "/contact")
public class ContactController {

	@Autowired
	ContactRepository contactRepository;
	
	@PostMapping(path="/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> saveContact(@RequestBody Contact contact) throws ContactAlreadyExistsException{
		if(contactRepository.existsById(contact.getContactId())) {
			throw new ContactAlreadyExistsException();
			}else {
			contactRepository.save(contact);
			return ResponseEntity.ok(new Message("Contact saved"));
		}
	}
	
	
	@GetMapping(path = "/listall",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contact>> listAll(){
		return ResponseEntity.ok(contactRepository.findAll());
	}
	
	@DeleteMapping(path="/delete/{contactId}")
	public ResponseEntity<Message> deleteContact(@PathVariable("contactId") int contactId) throws ContactNotFoundException{
		if(contactRepository.existsById(contactId)) {
			contactRepository.deleteById(contactId);
			return ResponseEntity.ok(new Message("Contact deleted"));
		}else {
			throw new ContactNotFoundException();
		}
	}
	
	@PatchMapping(path="/update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateContact(@RequestBody Contact contact) throws ContactNotFoundException{
		if(contactRepository.existsById(contact.getContactId())) {
			contactRepository.updateContactById(contact.getUserId(), contact.getEmail());
			return ResponseEntity.ok(new Message("Contact email updated"));
		}else {
			throw new ContactNotFoundException();		
			}
	}
	
	@DeleteMapping(path="/deleteall/{userId}")
	public ResponseEntity<Message> deleteAllContactByUser(@PathVariable("userId") int userId) throws UserNotFoundException {
		if(contactRepository.existsByUserId(userId)) {
			contactRepository.deleteAllByUserId(userId);
			return ResponseEntity.ok(new Message("Contacts deleted"));
		}else {
			throw new UserNotFoundException();		}
	}
	
	@GetMapping(path = "/list/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contact>> getContactsOfUser(@PathVariable("userId")int userId)
	{
		return ResponseEntity.ok(contactRepository.findAllByUserId(userId));
	}
	
	@GetMapping(path = "/list/{contactTag}/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contact>> getContactsforContactTagOfUser(@PathVariable("contactTag") String contactTag, @PathVariable("userId")int userId)
	{
		return ResponseEntity.ok(contactRepository.findContactsOfUserByTag(contactTag,userId));
	}
	
	@ExceptionHandler(ContactNotFoundException.class)
	public ResponseEntity<Message> handleContactNotFoundException() {
		return ResponseEntity.ok(new Message("Contact not found"));
	}

	@ExceptionHandler(ContactAlreadyExistsException.class)
	public ResponseEntity<Message> handleContactAlreadyExistsException() {
		return ResponseEntity.ok(new Message("Contact already exists"));
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Message> handleUserNotFoundException() {
		return ResponseEntity.ok(new Message("User not found"));
	}
}
