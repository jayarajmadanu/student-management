package com.jayaraj.sm.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jayaraj.sm.api.Student;
import com.jayaraj.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Student> loadStudents() {
				
		String sql = "select * from students";
		
		List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());
		return studentList;
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		
			Object sqlParams[] = {student.getName(), student.getMobile(), student.getCountry()};
			String sql = "insert into students(name, mobile, country) values(?,?,?)";
			jdbcTemplate.update(sql, sqlParams);

	}

	@Override
	public Student getStudentById(int id) {
		Object sqlParams[] = {id};
		String sql = "select * from students where id=?";
		
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(),id);
		return student;
	}
	
	@Override
	public void updateStudent(Student student) {

		Object sqlParams[] = { student.getName(), student.getMobile(), student.getCountry(), student.getId()};
		String sql = "update students set name=?, mobile=?, country=? where id=?";
		jdbcTemplate.update(sql, sqlParams);
	}

	@Override
	public void deleteStudent(int id) {
		String sql = "DELETE FROM students WHERE id=?";
		jdbcTemplate.update(sql, id);
		
	}

}
