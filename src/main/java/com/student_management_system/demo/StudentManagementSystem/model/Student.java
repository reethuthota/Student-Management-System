package com.student_management_system.demo.StudentManagementSystem.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

@Entity
@Table
public class Student {
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    @Id
    private String USN;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;

    @Transient
    private Integer Age;

    public Student() {
    }

    public Student(String USN, String firstName, String lastName, String email, LocalDate dob) {
        this.USN = USN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }

    public Student(String firstName, String lastName, String email, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }

    public String getUSN() {
        return USN;
    }

    public void setUSN(String USN) {
        this.USN = USN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "USN=" + USN +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", Age=" + Age +
                '}';
    }

    @OneToMany(mappedBy = "student")
    private Collection<Attendance> attendance;

    public Collection<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(Collection<Attendance> attendance) {
        this.attendance = attendance;
    }
}

