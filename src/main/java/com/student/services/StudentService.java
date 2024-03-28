package com.student.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.entity.Student;

@Service
public interface StudentService {

	public Student createStudent(Student student);
	public Student getStudentById(int id);
	public List<Student> getAllStudentsDetails();
	
	public Student deleteStudent(int id);

	
	Student updtaetStudent(int id, Student s);
}
