package com.kts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kts.entity.Student;
import com.kts.service.IStudentService;

@Controller
public class StudentController {
	
	@Autowired
	IStudentService studentService;
	
	@GetMapping("/report")
	public ModelAndView reportStudents() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Student> list = studentService.getAllStudents();
		
		mav.addObject("students", list);
		
		mav.setViewName("report");
		
		return mav;
	}
	
	@GetMapping("/addstudent")
	public ModelAndView addStudentForm() {
		ModelAndView mav = new ModelAndView(); 
		
		Student s1 = new Student();
		mav.addObject("student", s1);
		
		mav.setViewName("studentregister");
		
		return mav;
	}
	
	@PostMapping("/savestudent")
	public ModelAndView saveStudentData(Student s) {
		ModelAndView mav = new ModelAndView();
		
		Student student = studentService.addStudent(s);
		
		//mav.addObject("student", student);
		Student s1 = new Student();
		mav.addObject("student", s1);
		mav.addObject("statusMessage", "Rno "+student.getRno()+" is Ctreated / Updated!");
		
		mav.setViewName("studentregister");
		
		return mav;
	}
	
	@GetMapping("/updatestudent")
	public ModelAndView updateStudent(@RequestParam int rno) {
		ModelAndView mav = new ModelAndView();
		
		Student student = studentService.getStudentByRno(rno);
		
		mav.addObject("student", student);
		mav.setViewName("studentregister");
		
		return mav;
	}
	
	@GetMapping("/deletestudent/{rno}")
	public ModelAndView deleteStudent(@PathVariable int rno) {
		ModelAndView mav = new ModelAndView();
		
		studentService.deleteStudent(rno);
		
		List<Student> list = studentService.getAllStudents();
		
		mav.addObject("students", list);
		
		mav.setViewName("report");
		
		return mav;
	}
}
