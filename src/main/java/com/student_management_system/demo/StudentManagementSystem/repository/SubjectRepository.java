package com.student_management_system.demo.StudentManagementSystem.repository;

import com.student_management_system.demo.StudentManagementSystem.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
