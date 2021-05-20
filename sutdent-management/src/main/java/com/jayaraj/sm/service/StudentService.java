package com.jayaraj.sm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jayaraj.sm.api.Student;

public interface StudentService {
	
	List<Student> loadStudents();
	
	void saveStudent(Student student);
	
	Student getStudentById(int id);

	void updateStudent(Student student);

	void deleteStudentById(int id);
}
