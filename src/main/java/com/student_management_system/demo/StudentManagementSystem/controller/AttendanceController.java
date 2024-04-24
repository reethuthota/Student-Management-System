package com.student_management_system.demo.StudentManagementSystem.controller;


import com.student_management_system.demo.StudentManagementSystem.model.Attendance;
import com.student_management_system.demo.StudentManagementSystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/")
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable String id) {
        return attendanceService.getAttendanceById(id);
    }

    @PostMapping("/")
    public Attendance saveAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable String id) {
        attendanceService.deleteAttendance(id);
    }
}
