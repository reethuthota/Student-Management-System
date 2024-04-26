package com.student_management_system.demo.StudentManagementSystem.service;

import com.student_management_system.demo.StudentManagementSystem.model.Subject;
import com.student_management_system.demo.StudentManagementSystem.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public Subject saveSubject(Subject subject) {
        if (subjectRepository.existsById(subject.getSubjectID())) {
            throw new IllegalStateException("Email is already taken");
        }
        return subjectRepository.save(subject);
    }
    @Transactional
    public Subject updateSubject(Long id, Subject updatedSubject) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();

            // Update subjectName if present in the request body
            if (updatedSubject.getSubjectName() != null && !updatedSubject.getSubjectName().isBlank()) {
                subject.setSubjectName(updatedSubject.getSubjectName().trim());
            }

            // Update description if present in the request body
            if (updatedSubject.getDescription() != null && !updatedSubject.getDescription().isBlank()) {
                subject.setDescription(updatedSubject.getDescription().trim());
            }

            // Update other fields as needed

            return subjectRepository.save(subject);
        } else {
            throw new IllegalStateException("Subject with id " + id + " not found");
        }
    }
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
