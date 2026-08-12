package com.example.internship_portal.controller;

import com.example.internship_portal.entity.Student;
import com.example.internship_portal.service.StudentService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    /* =========================
       REGISTER PAGE
    ========================= */

    @GetMapping("/register")
    public String registerPage(Model model){

        model.addAttribute("student", new Student());

        return "register";

    }

    /* =========================
       SAVE STUDENT
    ========================= */

    @PostMapping("/saveStudent")
    public String saveStudent(
            @ModelAttribute Student student){

        studentService.saveStudent(student);

        return "redirect:/login";

    }

    /* =========================
       LOGIN PAGE
    ========================= */

    @GetMapping("/login")
    public String loginPage(){

        return "login";

    }

    /* =========================
       LOGIN AUTHENTICATION
    ========================= */

    @PostMapping("/studentLogin")
    public String loginStudent(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model){

        Student student =
                studentService.loginStudent(
                        email,
                        password
                );

        if(student != null){

            session.setAttribute(
                    "loggedInStudent",
                    student
            );

            return "redirect:/dashboard";

        }else{

            model.addAttribute(
                    "error",
                    "Invalid Email or Password"
            );

            return "login";

        }

    }

    /* =========================
       LOGOUT
    ========================= */

    @GetMapping("/logout")
    public String logout(HttpSession session){

        session.invalidate();

        return "redirect:/login";

    }

}