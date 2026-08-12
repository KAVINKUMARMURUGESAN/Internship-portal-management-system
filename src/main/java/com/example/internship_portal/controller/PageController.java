package com.example.internship_portal.controller;

import com.example.internship_portal.entity.Internship;
import com.example.internship_portal.entity.Student;
import com.example.internship_portal.service.ApplicationService;
import com.example.internship_portal.service.InternshipService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private InternshipService internshipService;

    @Autowired
    private ApplicationService applicationService;

    /* =========================
       HOME PAGE
    ========================= */

    @GetMapping("/")
    public String home(){

        return "index";

    }

    /* =========================
       STUDENT DASHBOARD
    ========================= */

    @GetMapping("/dashboard")
    public String dashboard(
            HttpSession session,
            Model model){

        Student student =
                (Student) session.getAttribute(
                        "loggedInStudent"
                );

        if(student == null){

            return "redirect:/login";

        }

        /* =========================
           REAL DATABASE COUNTS
        ========================= */

        int internshipsCount =
                internshipService
                        .getAllInternships()
                        .size();

        int applicationsCount =
                applicationService
                        .getAllApplications()
                        .size();

        long approvedCount =
                applicationService
                        .getAllApplications()
                        .stream()
                        .filter(application ->
                                application.getStatus()
                                        .equalsIgnoreCase("Approved"))
                        .count();

        model.addAttribute(
                "internshipsCount",
                internshipsCount
        );

        model.addAttribute(
                "applicationsCount",
                applicationsCount
        );

        model.addAttribute(
                "approvedCount",
                approvedCount
        );

        return "dashboard";

    }

    /* =========================
       PROFILE PAGE
    ========================= */

    @GetMapping("/profile")
public String profile(
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
            "student",
            student
    );

    return "profile";

}

    /* =========================
       INTERNSHIP DETAILS
    ========================= */

    @GetMapping("/internship-details")
public String internshipDetails(
        HttpSession session,
        Model model){

    Student student =
            (Student) session.getAttribute(
                    "loggedInStudent"
            );

    if(student == null){

        return "redirect:/login";

    }

    Internship internship =
            new Internship();

    internship.setId(1L);

    internship.setTitle(
            "Java Developer Internship"
    );

    internship.setCompanyName(
            "ABC Technologies"
    );

    internship.setDuration(
            "6 Months"
    );

    internship.setSkills(
            "Java, Spring Boot, PostgreSQL"
    );

    internship.setLastDate(
            java.time.LocalDate.now().plusDays(30)
    );

    internship.setDescription(
            "Work on enterprise applications using Spring Boot and PostgreSQL."
    );

    internship.setStatus(
            "Active"
    );

    model.addAttribute(
            "internship",
            internship
    );

    return "internship-details";

}

}