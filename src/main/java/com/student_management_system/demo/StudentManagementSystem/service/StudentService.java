package com.student_management_system.demo.StudentManagementSystem.service;

import com.student_management_system.demo.StudentManagementSystem.model.Student;
import com.student_management_system.demo.StudentManagementSystem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

//    public Student addNewStudent(Student student) {
//        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
//        if (studentOptional.isPresent()) {
//            throw new IllegalStateException("Email taken");
//        }
//        studentRepository.save(student);
//        // System.out.println(student);
//        return student;
//    }

    public Student addNewStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new IllegalStateException("Email is already taken");
        }
        return studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Long id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            // Update firstName if present in the request body
            if (updatedStudent.getFirstName() != null && !updatedStudent.getFirstName().isBlank()) {
                student.setFirstName(updatedStudent.getFirstName().trim());
            }

            // Update lastName if present in the request body
            if (updatedStudent.getLastName() != null && !updatedStudent.getLastName().isBlank()) {
                student.setLastName(updatedStudent.getLastName().trim());
            }

            // Update email if present in the request body
            if (updatedStudent.getEmail() != null && !updatedStudent.getEmail().isBlank()) {
                student.setEmail(updatedStudent.getEmail().trim());
            }

            // Update dob if present in the request body
            if (updatedStudent.getDob() != null) {
                student.setDob(updatedStudent.getDob());
            }

            // Update other fields as needed

            studentRepository.save(student);
        } else {
            throw new IllegalStateException("Student with id " + id + " not found");
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
