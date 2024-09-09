package com.kts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.entity.Student;
import com.kts.repo.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		List<Student> list = studentRepository.findAll();
		return list;
	}

	@Override
	public Student addStudent(Student s) {
		Student student = studentRepository.save(s);
		
		return student;
	}
	
	@Override
	public Student getStudentByRno(Integer rno) {
		Optional<Student> optional = studentRepository.findById(rno);
		if(optional.isPresent()) {
			Student student = optional.get();
			return student;
		}
		return null;
	}

	@Override
	public void deleteStudent(Integer rno) {
		studentRepository.deleteById(rno);
	}
}
