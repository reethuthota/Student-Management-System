package com.student_management_system.demo.StudentManagementSystem.repository;

import com.student_management_system.demo.StudentManagementSystem.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    boolean existsById(Long subjectId);
}
