package com.student.management.service;

import java.util.List;

import com.student.management.model.Student;

public interface IStudentService {
	
	public Student addStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Student getStudentByID(Long id);
	
	public Student updateStudent(Student student, Long id);
	
	public void deleteStudent(Long id);

}
