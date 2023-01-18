package com.demo.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Employee;
import com.demo.spring.exception.EmpNotFoundException;
import com.demo.spring.repository.EmpRepository;
import com.demo.spring.util.Message;

import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.OpenAPI30;

@RestController
@OpenAPI30
@RequestMapping(path="/employee") //strictly this path in api gateway yml
@RefreshScope
public class EmpRestController {
	
	@Autowired
	EmpRepository empRepo;
	
	@GetMapping(path="/{empId}", produces = MediaType.APPLICATION_JSON_VALUE) //rest endpoint
//	@ApiResponses(@ApiResponse(responseCode = "404"), @ApiResponse(responseCode = "200"))
	@Timed(value = "requests.count.findbyid")
	public ResponseEntity<Employee> findOneEmp(@PathVariable("empId") int empId) throws EmpNotFoundException{
		Optional<Employee> empOp = empRepo.findById(empId);
		if(empOp.isPresent()) {
			return ResponseEntity.ok(empOp.get());
		}else {
			throw new EmpNotFoundException();
		}
		
	}
	
	@PostMapping(path="/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> saveEmp(@RequestBody Employee emp){
		if(empRepo.existsById(emp.getEmpId())) {
			return ResponseEntity.ok(new Message("Employee already exists"));
		}else {
			empRepo.save(emp);
			return ResponseEntity.ok(new Message("Employee saved"));
		}
		
	}
	
	@PutMapping(path="/update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateEmp(@RequestBody Employee emp){
		if(empRepo.existsById(emp.getEmpId())) {
			empRepo.save(emp);
			return ResponseEntity.ok(new Message("Employee updated"));
		}else {
			return ResponseEntity.ok(new Message("Employee doesn't exist"));
			
		}
		
	}
	
	@DeleteMapping(path="/delete/{empId}")
	public ResponseEntity<Message> deleteEmp(@PathVariable("empId") int empId) {
		if(empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			return ResponseEntity.ok(new Message("Employee deleted"));
		}else {
			return ResponseEntity.ok(new Message("Employee not found"));
		}
	}
	
	@GetMapping(path = "/listall",produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(value = "requests.count.listAll")
	public ResponseEntity<List<Employee>> listAll(){
		return ResponseEntity.ok(empRepo.findAll());
	}
	
	@GetMapping(path = "/list/{dno}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAlldept(@PathVariable("dno")int dno)
	{
		return ResponseEntity.ok(empRepo.findAllByDeptNo(dno));
	}
	
	@Value("${message:Message not found}")
	String msg;
	@GetMapping("/info")
	public String getMessage() {
		return msg;
	}
	
	public ResponseEntity<Message> handleDeptNotFoundException(){
		return ResponseEntity.ok(new Message("Employee not found"));
	}
}
