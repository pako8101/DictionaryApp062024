package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.UserRegisterDTO;
import com.dictionaryapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

private final UserService userService;
    @ModelAttribute("registerData")
    public UserRegisterDTO createEmptyDTO(){
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String viewRegister(){


        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegisterDTO data,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerData",
                    data);
            redirectAttributes.addFlashAttribute("org.springframework" +
                            ".validation.BindingResult" +
                            ".registerData",
                    bindingResult);

            return "redirect:/register";
        }





        return "redirect:/login";
    }
    @PostMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

}
