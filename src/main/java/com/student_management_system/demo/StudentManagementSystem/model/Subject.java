package com.student_management_system.demo.StudentManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table
public class Subject {
    @Id
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

    private Long subjectID;
    private String subjectName;
    private String Description;

    public Subject() {
    }

    public Subject(Long subjectID, String subjectName, String description) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        Description = description;
    }

    public Subject(String subjectName, String description) {
        this.subjectName = subjectName;
        Description = description;
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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
