package com.example.internship_portal.repository;

import com.example.internship_portal.entity.Application;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository
        extends JpaRepository<Application, Long> {

}