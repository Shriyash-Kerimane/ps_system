package com.demo.spring.contoller;

import java.util.List;
import java.util.Optional;

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

import com.demo.spring.entity.User;
import com.demo.spring.exception.UserAlreadyExistsException;
import com.demo.spring.exception.UserNotFoundException;
import com.demo.spring.repository.UserRepository;
import com.demo.spring.util.Message;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping(path="/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> saveUser(@RequestBody User user) throws UserAlreadyExistsException{
		if(userRepository.existsById(user.getUserId())) {
			throw new UserAlreadyExistsException();
		}else {
			userRepository.save(user);
			return ResponseEntity.ok(new Message("User saved"));
		}	
	}
	
	@GetMapping(path="find/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findUser(@PathVariable("userId") int userId) throws UserNotFoundException{
		Optional<User> userOp = userRepository.findById(userId);
		if(userOp.isPresent()) {
			return ResponseEntity.ok(userOp.get());
		}else {
			throw new UserNotFoundException();
		}
	}
	
	@GetMapping(path = "/listall",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> listAll(){
		return ResponseEntity.ok(userRepository.findAll());
	}
	
	@DeleteMapping(path="/delete/{userId}")
	public ResponseEntity<Message> deleteEmp(@PathVariable("userId") int userId) throws UserNotFoundException {
		if(userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			return ResponseEntity.ok(new Message("User deleted"));
		}else {
			throw new UserNotFoundException();
		}
	}
	
	@PatchMapping(path="/update/{userId}/{userName}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> saveUser(@PathVariable("userId") Integer userId, @PathVariable("userName") String userName) throws UserNotFoundException{
		if(userRepository.existsById(userId)) {
			userRepository.updateUserById(userId, userName);
			return ResponseEntity.ok(new Message("User updated"));
		}else {
			throw new UserNotFoundException();
		}
	}
	
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Message> handleUserNotFoundException(UserNotFoundException une) {
        return ResponseEntity.ok(new Message("User not found"));
    }
	
	@ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Message> handleExsistsNotFoundException(UserAlreadyExistsException uae) {
        return ResponseEntity.ok(new Message("User already exists"));
    }
	
}
