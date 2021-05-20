package com.jayaraj.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jayaraj.sm.api.Student;
import com.jayaraj.sm.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/showStudent")
	public String showStudentsList(Model model) {
		List<Student> students = studentService.loadStudents();
		model.addAttribute("students", students);
		
		return "studentList";
	}
	
	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add-student";
	}
	
	@PostMapping("/save-student")
	public String saveStudent(Student student) {
		if(student.getId()==0) 								// insert new record
			studentService.saveStudent(student);
		else  												//update exisisting record
			studentService.updateStudent(student);
		return "redirect:/showStudent";
	}
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId")int id, Model model) {
		// spring will create student obj and send it to model parameter
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "add-student";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {
		studentService.deleteStudentById(id);
		
		return "redirect:/showStudent";
	}
	
}
