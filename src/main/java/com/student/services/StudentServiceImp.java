package com.student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepo;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	StudentRepo srepo;

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		Student s=srepo.save(student);
		return s;
		
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Optional<Student> s=srepo.findById(id);
		if(s.isEmpty()) {
			throw new RuntimeException("Student is not present");
		}
		Student s_found=s.get();
		return s_found;
	}

	@Override
	public List<Student> getAllStudentsDetails() {
		// TODO Auto-generated method stub
		List<Student> s=srepo.findAll();
		return s;
	}


	@Override
	public Student deleteStudent(int id)
	{
		Optional<Student> stud=srepo.findById(id);
		if(stud.isEmpty()) {
			throw new RuntimeException("Students is not present");
		}
		Student existingStudent = stud.get();
	    
	    // Delete the student from the repository
	    srepo.delete(existingStudent);
	    
	    // Return the deleted student
	    return existingStudent;
		
		
	}

	

	

	@Override
	public Student updtaetStudent(int id,Student s) {
		// TODO Auto-generated method stub
		Optional<Student> stud=srepo.findById(id);
		if(stud.isEmpty()) {
			throw new RuntimeException("Students is not present");
		}
		Student existingStudent = stud.get();
	    
	    
	    existingStudent.setFname(s.getFname()); 
	    existingStudent.setLname(s.getLname());
	    existingStudent.setBranch(s.getBranch()); 
	    existingStudent.setPer(s.getPer()); 
	    
	    
	    return srepo.save(existingStudent);
		
	}

}
