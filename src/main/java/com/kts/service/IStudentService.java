package com.kts.service;

import java.util.List;

import com.kts.entity.Student;

public interface IStudentService {
	
	List<Student> getAllStudents();
	
	Student addStudent(Student s);
	
	Student getStudentByRno(Integer rno);
	
	void deleteStudent(Integer rno);
}
