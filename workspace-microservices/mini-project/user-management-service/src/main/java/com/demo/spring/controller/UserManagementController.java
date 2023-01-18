package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.ContactDTO;
import com.demo.spring.UserDTO;
import com.demo.spring.util.Message;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(path = "/management")
public class UserManagementController {

	@Autowired
	RestTemplate restTemplate1;

	@Autowired
	@Qualifier("restTemplate2")
	RestTemplate restTemplate2;
	
	@GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name = "user-management-service", fallbackMethod = "fallbackGetContactInUser")
	public ResponseEntity getContactInUser(@PathVariable("userId") Integer userId) {

		UserDTO userDTO = null;

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> req = new HttpEntity<>(headers);

		ResponseEntity<UserDTO> response1 = restTemplate1.exchange("http://user-service/user/" + userId, HttpMethod.GET,
				req, UserDTO.class);
		userDTO = response1.getBody();
		ResponseEntity<List<ContactDTO>> response2 = restTemplate2.exchange(
				"http://contact-service/contact/list/" + userId, HttpMethod.GET, req,
				new ParameterizedTypeReference<List<ContactDTO>>() {
				});

		List<ContactDTO> contacts = response2.getBody();
		userDTO.setContactList(contacts);
		return ResponseEntity.ok(userDTO);
	}

	@GetMapping(path = "/{contactTag}/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name = "user-management-service", fallbackMethod = "fallbackGetContactByContactTag")
	public ResponseEntity<List<ContactDTO>> getContactByContactTag(@PathVariable("contactTag") String contactTag,
			@PathVariable("userId") Integer userId) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> req = new HttpEntity<>(headers);

		ResponseEntity<List<ContactDTO>> response2 = restTemplate2.exchange(
				"http://contact-service/contact/list/" + contactTag + "/" + userId, HttpMethod.GET, req,
				new ParameterizedTypeReference<List<ContactDTO>>() {
				});

		List<ContactDTO> contactDTO = response2.getBody();
		return ResponseEntity.ok(contactDTO);
	}

	@PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE )
	@CircuitBreaker(name="user-management-service",fallbackMethod = "fallbackCreateUserWithContact")
	public ResponseEntity<Message> createUserWithContact(@RequestBody UserDTO userDTO){
				
		ContactDTO contactDTO = userDTO.getContactList().get(0);
				
		HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("content-type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<UserDTO> req1 = new HttpEntity<>(userDTO,headers);
        HttpEntity<ContactDTO> req2 = new HttpEntity<>(contactDTO,headers);
        
        ResponseEntity<Message> response1 = restTemplate1.exchange("http://user-service/user/save", HttpMethod.POST,req1, Message.class);
        if(response1.getBody().getStatus().equals("User saved")) {
        	restTemplate2.exchange("http://contact-service/contact/save", HttpMethod.POST,req2, Message.class);
        	return ResponseEntity.ok(new Message("User and contact saved successfully"));
        }else {
        	return ResponseEntity.ok(new Message("User already exists"));

        }
	}
	
	@DeleteMapping(path = "/delete/{userId}")
	@CircuitBreaker(name="user-management-service",fallbackMethod = "fallbackDeleteUserWithContacts")
	public ResponseEntity<Message> deleteUserWithContacts(@PathVariable("userId") Integer userId){
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Void> req = new HttpEntity<>(headers);
        
        ResponseEntity<Message> response1 = restTemplate1.exchange("http://user-service/user/delete/"+userId, HttpMethod.DELETE,req, Message.class);
        if(response1.getBody().getStatus().equals("User deleted")) {
        	restTemplate2.exchange("http://contact-service/contact/deleteall/"+userId, HttpMethod.DELETE,req, Message.class);
        	return ResponseEntity.ok(new Message("User with contacts deleted successfully")); 
        }else {
        	return ResponseEntity.ok(new Message("User does not exists"));
        }
	}

	public ResponseEntity<Message> fallbackGetContactInUser() {
		return ResponseEntity.ok(new Message("server down..try after sometime.."));
	}

	public ResponseEntity<Message> fallbackGetContactByContactTag() {
		return ResponseEntity.ok(new Message("server down..try after sometime.."));
	}

	public ResponseEntity<Message> fallbackCreateUserWithContact() {
		return ResponseEntity.ok(new Message("server down..try after sometime.."));
	}
	
	public ResponseEntity<Message> fallbackDeleteUserWithContacts() {
		return ResponseEntity.ok(new Message("server down..try after sometime.."));
	}
}