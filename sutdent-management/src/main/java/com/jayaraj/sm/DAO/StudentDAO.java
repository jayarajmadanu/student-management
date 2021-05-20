package com.jayaraj.sm.DAO;

import java.util.List;

import com.jayaraj.sm.api.Student;

public interface StudentDAO {
	
	List<Student> loadStudents();
	
	void saveStudent(Student student);

	Student getStudentById(int id);

	void updateStudent(Student student);

	void deleteStudent(int id);
}
