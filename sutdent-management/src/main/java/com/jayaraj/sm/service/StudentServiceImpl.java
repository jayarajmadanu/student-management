package com.jayaraj.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayaraj.sm.DAO.StudentDAO;
import com.jayaraj.sm.api.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public List<Student> loadStudents() {
		List<Student> students = studentDAO.loadStudents();
		return students;
	}

	@Override
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);
	}

	@Override
	public Student getStudentById(int id) {
		Student student = studentDAO.getStudentById(id);
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentDAO.updateStudent(student);
	}

	@Override
	public void deleteStudentById(int id) {
		studentDAO.deleteStudent(id);
	}

}
