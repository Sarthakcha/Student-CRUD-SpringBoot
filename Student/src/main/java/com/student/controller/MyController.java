package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.services.Services;

@RestController
public class MyController {
	@Autowired
	private Services studentServices;
	
	
	//to get students
	@GetMapping("/")
	public List<Student> getStudent(){
		
		return this.studentServices.getStudents();
	}
	//get student by Id
	@GetMapping("student/{studentId}")
	public Student getStudent(@PathVariable  Integer studentId) {
		return  this.studentServices.getStudent(studentId);
		
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		return this.studentServices.addStudent(student);

}
	
	@PutMapping("/student/{studentId}")
	public Student updateStudent(@RequestBody Student student,@PathVariable Integer studentId){
		return this.studentServices.updateStudent(student, studentId);
	}
	
	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Integer studentId) {
		try {
		this.studentServices.deleteStudent(studentId);
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
