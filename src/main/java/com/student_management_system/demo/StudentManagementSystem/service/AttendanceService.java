package com.student_management_system.demo.StudentManagementSystem.service;

import com.student_management_system.demo.StudentManagementSystem.model.Attendance;
import com.student_management_system.demo.StudentManagementSystem.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    public List<Attendance> getAttendanceBySubjectAndDate(Long subjectID, LocalDate date) {
        return attendanceRepository.findBySubjectIDAndDate(subjectID, date);
    }

    public List<Attendance> getAttendanceByStudentAndSubject(Long USN, Long subjectID) {
        return attendanceRepository.findByUSNAndSubjectID(USN, subjectID);
    }
}
