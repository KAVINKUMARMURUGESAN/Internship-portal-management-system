package com.example.internship_portal.service;

import com.example.internship_portal.entity.Student;
import com.example.internship_portal.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /* =========================
       SAVE STUDENT
    ========================= */

    public Student saveStudent(Student student){

        return studentRepository.save(student);

    }

    /* =========================
       GET ALL STUDENTS
    ========================= */

    public List<Student> getAllStudents(){

        return studentRepository.findAll();

    }

    /* =========================
       GET STUDENT BY ID
    ========================= */

    public Student getStudentById(Long id){

        Optional<Student> optionalStudent =
                studentRepository.findById(id);

        return optionalStudent.orElse(null);

    }

    /* =========================
       GET STUDENT BY EMAIL
    ========================= */

    public Student getStudentByEmail(String email){

        Optional<Student> optionalStudent =
                studentRepository.findByEmail(email);

        return optionalStudent.orElse(null);

    }

    /* =========================
       LOGIN AUTHENTICATION
    ========================= */

    public Student loginStudent(
            String email,
            String password){

        Student student =
                getStudentByEmail(email);

        if(student != null &&
           student.getPassword().equals(password)){

            return student;

        }

        return null;

    }

    /* =========================
       DELETE STUDENT
    ========================= */

    public void deleteStudent(Long id){

        studentRepository.deleteById(id);

    }

}