package com.student.management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.model.Student;
import com.student.management.service.IStudentService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
	
	private final IStudentService studentService;
	
	/*
	 * End point to fetch all students in the database
	 */
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.FOUND);
	}
	
	/*
	 * End point to add a new student to database
	 */
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	/*
	 * End point to update the details of a student
	 */
	@PutMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
		return studentService.updateStudent(student, id);
	}
	
	/*
	 * To fetch the data of a single student by id
	 */
	@GetMapping("student/{id}")
	public Student getStudentByID(@PathVariable Long id) {
		return studentService.getStudentByID(id);
	}
	
	/*
	 * To delete a student by ID
	 */
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}
	
	

}
