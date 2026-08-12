package com.example.internship_portal.controller;

import com.example.internship_portal.entity.Internship;
import com.example.internship_portal.service.InternshipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InternshipController {

    @Autowired
    private InternshipService internshipService;

    /* =========================
       INTERNSHIP LIST
    ========================= */

    @GetMapping("/internships")
    public String internships(Model model){

        model.addAttribute(
                "internships",
                internshipService.getAllInternships()
        );

        return "internships";

    }

    /* =========================
       ADD INTERNSHIP PAGE
    ========================= */

    @GetMapping("/add-internship")
    public String addInternshipPage(Model model){

        model.addAttribute(
                "internship",
                new Internship()
        );

        return "add-internship";

    }

    /* =========================
       SAVE INTERNSHIP
    ========================= */

    @PostMapping("/saveInternship")
    public String saveInternship(
            @ModelAttribute Internship internship){

        internshipService.saveInternship(internship);

        return "redirect:/manage-internships";

    }

    /* =========================
       MANAGE INTERNSHIPS
    ========================= */

    @GetMapping("/manage-internships")
    public String manageInternships(Model model){

        model.addAttribute(
                "internships",
                internshipService.getAllInternships()
        );

        return "manage-internships";

    }

    /* =========================
       DELETE INTERNSHIP
    ========================= */

    @GetMapping("/delete-internship/{id}")
    public String deleteInternship(
            @PathVariable Long id){

        internshipService.deleteInternship(id);

        return "redirect:/manage-internships";

    }

}