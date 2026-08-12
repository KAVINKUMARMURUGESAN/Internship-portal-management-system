package com.example.internship_portal.controller;

import com.example.internship_portal.entity.Application;
import com.example.internship_portal.entity.Student;
import com.example.internship_portal.service.ApplicationService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    /* =========================
       APPLY PAGE
    ========================= */

    @GetMapping("/apply")
    public String applyPage(
            HttpSession session,
            Model model){

        Student student =
                (Student) session.getAttribute(
                        "loggedInStudent"
                );

        if(student == null){

            return "redirect:/login";

        }

        model.addAttribute(
                "application",
                new Application()
        );

        return "apply";

    }

    /* =========================
       SAVE APPLICATION
    ========================= */

    @PostMapping("/saveApplication")
    public String saveApplication(
            @ModelAttribute Application application){

        applicationService.saveApplication(application);

        return "redirect:/application-status";

    }

    /* =========================
       APPLICATION STATUS
    ========================= */

    @GetMapping("/application-status")
    public String applicationStatus(
            HttpSession session,
            Model model){

        Student student =
                (Student) session.getAttribute(
                        "loggedInStudent"
                );

        if(student == null){

            return "redirect:/login";

        }

        model.addAttribute(
                "applications",
                applicationService.getAllApplications()
        );

        return "application-status";

    }

    /* =========================
       APPROVE APPLICATION
    ========================= */

    @GetMapping("/approve-application/{id}")
    public String approveApplication(
            @PathVariable Long id){

        applicationService.approveApplication(id);

        return "redirect:/applications";

    }

    /* =========================
       REJECT APPLICATION
    ========================= */

    @GetMapping("/reject-application/{id}")
    public String rejectApplication(
            @PathVariable Long id){

        applicationService.rejectApplication(id);

        return "redirect:/applications";

    }

}