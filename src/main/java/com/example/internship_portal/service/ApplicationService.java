package com.example.internship_portal.service;

import com.example.internship_portal.entity.Application;
import com.example.internship_portal.repository.ApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    /* =========================
       SAVE APPLICATION
    ========================= */

    public Application saveApplication(Application application){

        return applicationRepository.save(application);

    }

    /* =========================
       GET ALL APPLICATIONS
    ========================= */

    public List<Application> getAllApplications(){

        return applicationRepository.findAll();

    }

    /* =========================
       GET APPLICATION BY ID
    ========================= */

    public Application getApplicationById(Long id){

        Optional<Application> optionalApplication =
                applicationRepository.findById(id);

        return optionalApplication.orElse(null);

    }

    /* =========================
       APPROVE APPLICATION
    ========================= */

    public void approveApplication(Long id){

        Application application =
                getApplicationById(id);

        if(application != null){

            application.setStatus("Approved");

            applicationRepository.save(application);

        }

    }

    /* =========================
       REJECT APPLICATION
    ========================= */

    public void rejectApplication(Long id){

        Application application =
                getApplicationById(id);

        if(application != null){

            application.setStatus("Rejected");

            applicationRepository.save(application);

        }

    }

    /* =========================
       DELETE APPLICATION
    ========================= */

    public void deleteApplication(Long id){

        applicationRepository.deleteById(id);

    }

}