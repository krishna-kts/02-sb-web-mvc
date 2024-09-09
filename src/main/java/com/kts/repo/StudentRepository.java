package com.kts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kts.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
