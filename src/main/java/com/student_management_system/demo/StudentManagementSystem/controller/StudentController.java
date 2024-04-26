package com.student_management_system.demo.StudentManagementSystem.controller;


import com.student_management_system.demo.StudentManagementSystem.model.Student;
import com.student_management_system.demo.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping()
    public Student addNewStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        studentService.updateStudent(id, updatedStudent);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
