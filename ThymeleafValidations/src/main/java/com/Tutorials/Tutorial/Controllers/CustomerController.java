package com.Tutorials.Tutorial.Controllers;

import com.Tutorials.Tutorial.models.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("customer", new Customer());

        return "mainform";
    }

    @PostMapping("/registerUser")
    public String registerUser(@Valid @ModelAttribute("customer") Customer customer,
                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "mainform";
        }else{
            return "confirmationform";
        }
    }
}
