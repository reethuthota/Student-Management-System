package com.student_management_system.demo.StudentManagementSystem.repository;

import com.student_management_system.demo.StudentManagementSystem.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findBySubjectIDAndDate(Long subjectID, LocalDate date);
    List<Attendance> findByUSNAndSubjectID(Long USN, Long subjectID);
}
