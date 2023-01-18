package com.example.demo.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.EmpRepository;
import com.example.demo.spring.entity.Emp;
import com.example.demo.spring.entity.Message;

@RestController
public class EmpRestController {

	@Autowired
	EmpRepository empRepository;

//	@RequestMapping(path="/find/{empNo}" ,method=RequestMethod.GET)
//	public Emp findOneEmp(@PathVariable("empNo") int id) {
////        Optional<Emp> empOp = empRepository.findById(103);
//		Optional<Emp> empOp = empRepository.findById(id);
//
//        if(empOp.isPresent()) {
//            return empOp.get();
//        }else {
//            throw new RuntimeException("Emp not found");
//        }
//    }

//	@RequestMapping(path="/find/{empNo}" ,method=RequestMethod.GET)
	@GetMapping(path = "/find/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findOneEmp(@PathVariable("empId") int id) {
//        Optional<Emp> empOp = empRepository.findById(103);
		Optional<Emp> empOp = empRepository.findById(id);

		if (empOp.isPresent()) {
			return ResponseEntity.ok(empOp.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("Emp not found with id " + id));
		}
	}

	@GetMapping(path = "/list")
	public ResponseEntity<List<Emp>> getEmpList() {
		List<Emp> empOp = empRepository.findAll();
		return ResponseEntity.ok(empOp);
	}

	@PostMapping(path="/save" , produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Message> saveEmp(@RequestBody Emp e)
	{
		if(empRepository.existsById(e.getEmpId()))
		{
			return ResponseEntity.ok(new Message("Employee already exists"));
		}
		else {
			empRepository.save(e);
			return ResponseEntity.ok(new Message("Employee Saved"));
		}
	}
	
	@DeleteMapping(path="/delete/{empNo}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> deleteEmp(@PathVariable("empNo") int id)
	{
		if(empRepository.existsById(id))
		{
			empRepository.deleteById(id);
			return ResponseEntity.ok(new Message("Employee Deleted Successfully"));
		}
		else {
			return ResponseEntity.ok(new Message("Employee Does Not Exists"));
		}
		
	}
	

	/*
	 * @PatchMapping(path="/patch",produces =
	 * MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<Message> updateSalary(@RequestBody Emp e) {
	 * 
	 * if(empRepository.existsById(e.getEmpId())) { empRepository.save(e); return
	 * ResponseEntity.ok(new Message("Employee Updated Successfully")); } else {
	 * empRepository.save(e); return ResponseEntity.ok(new
	 * Message("Employee Created as it didn't existed earlier")); }
	 * 
	 * }
	 */
	
	// Updating only one column
	@PatchMapping(path="/updatesal/{empId}/{salary}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateSalary(@PathVariable("empId") int id,@PathVariable("salary") double sal)
	{
		
		Optional<Emp> empOp = empRepository.findById(id);
		if(empOp.isPresent())
		{
			empRepository.updateSalary(id,sal);
			
			return ResponseEntity.ok(new Message("Salary Updated"));
		}
		
		else {
			return ResponseEntity.ok(new Message("Employee Does not Exists"));
		}
	}
	
	@PutMapping(path="/put",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateEmpDetails(@RequestBody Emp e)
	{
		
		if(empRepository.existsById(e.getEmpId()))
		{
			empRepository.save(e);	
			return ResponseEntity.ok(new Message("Employee Updated Successfully"));
		}
		else {
			return ResponseEntity.ok(new Message("Employee Doesn't Exist"));
		}
		
	}
	
	@ExceptionHandler(EmpNotFoundException.class)
	public ResponseEntity<Message> handleEmpError(EmpNotFoundException e)
	{
		return ResponseEntity.ok(new Message("Emp Not Found"));
	}
	

}
