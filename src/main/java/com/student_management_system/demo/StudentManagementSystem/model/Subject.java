package com.student_management_system.demo.StudentManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table
public class Subject {

    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )
//    @GeneratedValue(
//            strategy = GenerationType.IDENTITY
//    )
    @Id
    private Long subjectID;
    private String subjectName;
    private String description;

    public Subject() {
    }

    public Subject(Long subjectID, String subjectName, String description) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.description = description;
    }

    public Subject(String subjectName, String description) {
        this.subjectName = subjectName;
        this.description = description;
    }

    // Getters and setters
    public Long getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Long subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
