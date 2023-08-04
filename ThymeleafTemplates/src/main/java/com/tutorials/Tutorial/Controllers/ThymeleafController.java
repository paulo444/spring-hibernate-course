package com.tutorials.Tutorial.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("currentDate", new java.util.Date());
        return "mainpage";
    }
}
