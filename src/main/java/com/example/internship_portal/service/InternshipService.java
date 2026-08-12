package com.example.internship_portal.service;

import com.example.internship_portal.entity.Internship;
import com.example.internship_portal.repository.InternshipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternshipService {

    @Autowired
    private InternshipRepository internshipRepository;

    /* =========================
       SAVE INTERNSHIP
    ========================= */

    public Internship saveInternship(Internship internship){

        return internshipRepository.save(internship);

    }

    /* =========================
       GET ALL INTERNSHIPS
    ========================= */

    public List<Internship> getAllInternships(){

        return internshipRepository.findAll();

    }

    /* =========================
       GET INTERNSHIP BY ID
    ========================= */

    public Internship getInternshipById(Long id){

        Optional<Internship> optionalInternship =
                internshipRepository.findById(id);

        return optionalInternship.orElse(null);

    }

    /* =========================
       DELETE INTERNSHIP
    ========================= */

    public void deleteInternship(Long id){

        internshipRepository.deleteById(id);

    }

}