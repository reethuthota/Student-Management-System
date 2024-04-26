package com.student_management_system.demo.StudentManagementSystem.model;

import com.student_management_system.demo.StudentManagementSystem.model.Student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.LocalDate;

@Entity
@Table
public class Attendance {
    @Id
    @SequenceGenerator(
            name = "attendance_sequence",
            sequenceName = "attendance_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "attendance_sequence"
    )
    private Integer SlNum;

    @ManyToOne
    @JoinColumn(name = "USN", referencedColumnName = "USN", updatable = false)
    private Student student;
    @Column(insertable=false, updatable=false)
    private Long USN;

    @ManyToOne
    @JoinColumn(name = "subjectID", referencedColumnName = "subjectID", updatable = false)
    private Subject subject;
    @Column(insertable=false, updatable=false)
    private Long subjectID;

    private LocalDate date;
    private String status; // Present or Absent

    public enum AttendanceStatus {
        Present,
        Absent
    }

    // Constructors
    public Attendance() {
    }

    public Attendance(Integer slNum, Long USN, Student student, Long subjectID, LocalDate date, String status) {
        SlNum = slNum;
        this.USN = USN;
        this.student = student;
        this.subjectID = subjectID;
        this.date = date;
        this.status = status;
    }

    public Attendance(Long USN, Student student, Long subjectID, LocalDate date, String status) {
        this.USN = USN;
        this.student = student;
        this.subjectID = subjectID;
        this.date = date;
        this.status = status;
    }

    // Getters and setters
    public Long getUSN() {
        return USN;
    }

    public void setUSN(Long USN) {
        this.USN = USN;
    }

    public Long getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Long subjectID) {
        this.subjectID = subjectID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
