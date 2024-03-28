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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.services.StudentService;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService sserv;
	
	
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		
		Student newStudent=sserv.createStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		Student s=sserv.getStudentById(id);
		return s;
	}
	
	@GetMapping("/getDetails")
	public List<Student> getAllStudentDetails() {
		List<Student> allStudents=sserv.getAllStudentsDetails();
		return allStudents;
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudents(@PathVariable int id,@RequestBody Student s) {
	Student updatedStudent=sserv.updtaetStudent(id,s);
	return ResponseEntity.status(HttpStatus.CREATED).body(updatedStudent);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public Student deleteStudent(@PathVariable int id) {
		Student stud=sserv.deleteStudent(id);
		return stud;
	}
}
