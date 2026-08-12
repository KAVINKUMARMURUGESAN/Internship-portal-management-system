package com.example.internship_portal.controller;

import com.example.internship_portal.entity.Admin;
import com.example.internship_portal.service.AdminService;
import com.example.internship_portal.service.ApplicationService;
import com.example.internship_portal.service.InternshipService;
import com.example.internship_portal.service.StudentService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private InternshipService internshipService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private AdminService adminService;

    /* =========================
       ADMIN LOGIN PAGE
    ========================= */

    @GetMapping("/admin-login")
    public String adminLoginPage(){

        return "admin-login";

    }

    /* =========================
       ADMIN LOGIN AUTHENTICATION
    ========================= */

    @PostMapping("/adminLogin")
    public String adminLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model){

        Admin admin =
                adminService.loginAdmin(
                        username,
                        password
                );

        if(admin != null){

            session.setAttribute(
                    "loggedInAdmin",
                    admin
            );

            return "redirect:/admin-dashboard";

        }else{

            model.addAttribute(
                    "error",
                    "Invalid Username or Password"
            );

            return "admin-login";

        }

    }

    /* =========================
       ADMIN DASHBOARD
    ========================= */

    @GetMapping("/admin-dashboard")
    public String adminDashboard(
            HttpSession session,
            Model model){

        Object admin =
                session.getAttribute(
                        "loggedInAdmin"
                );

        if(admin == null){

            return "redirect:/admin-login";

        }

        model.addAttribute(
                "studentsCount",
                studentService.getAllStudents().size()
        );

        model.addAttribute(
                "internshipsCount",
                internshipService.getAllInternships().size()
        );

        model.addAttribute(
                "applicationsCount",
                applicationService.getAllApplications().size()
        );

        return "admin-dashboard";

    }

    /* =========================
       STUDENTS PAGE
    ========================= */

    @GetMapping("/students")
    public String students(
            HttpSession session,
            Model model){

        Object admin =
                session.getAttribute(
                        "loggedInAdmin"
                );

        if(admin == null){

            return "redirect:/admin-login";

        }

        model.addAttribute(
                "students",
                studentService.getAllStudents()
        );

        return "students";

    }

    /* =========================
       APPLICATIONS PAGE
    ========================= */

    @GetMapping("/applications")
    public String applications(
            HttpSession session,
            Model model){

        Object admin =
                session.getAttribute(
                        "loggedInAdmin"
                );

        if(admin == null){

            return "redirect:/admin-login";

        }

        model.addAttribute(
                "applications",
                applicationService.getAllApplications()
        );

        return "applications";

    }

    /* =========================
       ADMIN LOGOUT
    ========================= */

    @GetMapping("/admin-logout")
    public String adminLogout(HttpSession session){

        session.invalidate();

        return "redirect:/admin-login";

    }

}