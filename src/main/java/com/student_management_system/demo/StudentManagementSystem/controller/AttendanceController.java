package com.student_management_system.demo.StudentManagementSystem.controller;


import com.student_management_system.demo.StudentManagementSystem.model.Attendance;
import com.student_management_system.demo.StudentManagementSystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/attendances")
@CrossOrigin(origins = "http://localhost:3000")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("")
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping("/{USN}")
    public Attendance getAttendanceById(@PathVariable Long USN) {
        return attendanceService.getAttendanceById(USN);
    }

    @GetMapping("/{subjectID}/{date}")
    public Attendance getAttendanceBySubjectAndDate(@PathVariable Long subjectID, @PathVariable LocalDate date) {
        return (Attendance) attendanceService.getAttendanceBySubjectAndDate(subjectID, date);
    }

    @GetMapping("/{USN}/{subjectID}")
    public Attendance getAttendanceByStudentAndSubject(@PathVariable Long USN, @PathVariable Long subjectID) {
        return (Attendance) attendanceService.getAttendanceByStudentAndSubject(USN, subjectID);
    }

    @PostMapping("")
    public Attendance saveAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }
}
