package com.student.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public Optional<Student> findByEmail(String email);

}
