package com.student_management_system.demo.StudentManagementSystem.repository;

import com.student_management_system.demo.StudentManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * StudentRepository
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    // SElECT* FROM student WHERE email = ?
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
