package com.example.internship_portal.service;

import com.example.internship_portal.entity.Admin;
import com.example.internship_portal.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    /* =========================
       SAVE ADMIN
    ========================= */

    public Admin saveAdmin(Admin admin){

        return adminRepository.save(admin);

    }

    /* =========================
       FIND ADMIN BY USERNAME
    ========================= */

    public Admin findByUsername(String username){

        Optional<Admin> optionalAdmin =
                adminRepository.findByUsername(username);

        return optionalAdmin.orElse(null);

    }

    /* =========================
       ADMIN LOGIN
    ========================= */

    public Admin loginAdmin(
            String username,
            String password){

        Admin admin =
                findByUsername(username);

        if(admin != null &&
           admin.getPassword().equals(password)){

            return admin;

        }

        return null;

    }

}