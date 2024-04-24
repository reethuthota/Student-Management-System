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
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "attendance_sequence"
//    )
    private Integer SlNum;

    private String USN;
    @ManyToOne
    @JoinColumn(name = "USN", referencedColumnName = "USN", insertable = false, updatable = false)
    private Student student;


    private Long SubjectID;
    @ManyToOne
    @JoinColumn(name = "SubjectID", referencedColumnName = "subjectID", insertable = false, updatable = false)
    private Subject subject;

    private LocalDate date;
    private String status; // Present or Absent

    public enum AttendanceStatus {
        Present,
        Absent
    }

    // Getters and setters
    public String getUSN() {
        return USN;
    }

    public void setUSN(String USN) {
        this.USN = USN;
    }

    public Long getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(Long subjectID) {
        SubjectID = subjectID;
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
