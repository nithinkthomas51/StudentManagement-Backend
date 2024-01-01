package com.student.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.management.exception.StudentAlreadyExistsException;
import com.student.management.exception.StudentNotFoundException;
import com.student.management.model.Student;
import com.student.management.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
	
	private final StudentRepository studentRepo;

	@Override
	public Student addStudent(Student student) {
		
		if (studentExists(student.getEmail())) {
			throw new StudentAlreadyExistsException(student.getEmail() + " already exists!");
		}
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentByID(Long id) {
		return studentRepo.findById(id).
				orElseThrow(() -> new StudentNotFoundException("Sorry, no student with the ID :" + id));
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		return studentRepo.findById(id).map(st -> {
			st.setFirstName(student.getFirstName());
			st.setLastName(student.getLastName());
			st.setEmail(student.getEmail());
			st.setDepartment(student.getDepartment());
			return studentRepo.save(st);
		}).orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
	}

	@Override
	public void deleteStudent(Long id) {
		
		if (!studentRepo.existsById(id)) {
			throw new StudentNotFoundException("Student with ID " + id + " not found");
		}
		studentRepo.deleteById(id);

	}
	
	private boolean studentExists(String email) {
		return studentRepo.findByEmail(email).isPresent();
	}

}
