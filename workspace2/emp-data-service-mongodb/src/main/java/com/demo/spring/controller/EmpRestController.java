package com.demo.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;
import com.demo.spring.util.Message;

@RestController
public class EmpRestController {
	
	@Autowired
	private EmpRepository empRepo;
	
	@PostMapping(path="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> save(@RequestBody Emp e){
		
		if(empRepo.existsById(e.getEmpId())) {
			return ResponseEntity.ok(new Message("Emp Exists..."));
		}else {
			empRepo.save(e);
			return ResponseEntity.ok(new Message("Emp saved..."));
		}
	}
	
	@GetMapping(path="/get/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findById(@PathVariable("empId") String id)
    {
        Optional<Emp> empOp=empRepo.findById(id);
        
        if(empOp.isPresent())
        {
            return ResponseEntity.ok(empOp.get());
        }
        else {
            return ResponseEntity.ok(new Message("Emp does not exists"));
        }   
    }
	
	@DeleteMapping(path = "/delete/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> deleteEmp(@PathVariable("empId") String id) {
		if(empRepo.existsById(id)) {
			empRepo.deleteById(id);
			return ResponseEntity.ok(new Message("Emp by id "+id+" deleted"));
		}else {
			return ResponseEntity.ok(new Message("Emp Not found"));
		}
	}
	
	@PatchMapping (path = "/update/{empId}/{salary}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateEmp(@PathVariable("empId") String id, @PathVariable("salary") double sal){
		 
		if(empRepo.existsById(id)) {
			empRepo.updateSalary(id, sal);
			return ResponseEntity.ok(new Message("Emp by id "+id+" updated"));
		}else {
			return ResponseEntity.ok(new Message("Emp Not found"));
		}
		
	}
	
}
