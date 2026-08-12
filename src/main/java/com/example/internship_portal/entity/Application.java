package com.example.internship_portal.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "application")
public class Application {

    /* =========================
       PRIMARY KEY
    ========================= */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* =========================
       STUDENT ID
    ========================= */

    private Long studentId;

    /* =========================
       INTERNSHIP ID
    ========================= */

    private Long internshipId;

    /* =========================
       RESUME
    ========================= */

    private String resumePath;

    /* =========================
       STATUS
    ========================= */

    private String status = "Pending";

    /* =========================
       APPLIED DATE
    ========================= */

    private LocalDate appliedDate =
            LocalDate.now();

    /* =========================
       CONSTRUCTOR
    ========================= */

    public Application() {

    }

    /* =========================
       GETTERS & SETTERS
    ========================= */

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public Long getStudentId() {

        return studentId;

    }

    public void setStudentId(Long studentId) {

        this.studentId = studentId;

    }

    public Long getInternshipId() {

        return internshipId;

    }

    public void setInternshipId(Long internshipId) {

        this.internshipId = internshipId;

    }

    public String getResumePath() {

        return resumePath;

    }

    public void setResumePath(String resumePath) {

        this.resumePath = resumePath;

    }

    public String getStatus() {

        return status;

    }

    public void setStatus(String status) {

        this.status = status;

    }

    public LocalDate getAppliedDate() {

        return appliedDate;

    }

    public void setAppliedDate(LocalDate appliedDate) {

        this.appliedDate = appliedDate;

    }

}