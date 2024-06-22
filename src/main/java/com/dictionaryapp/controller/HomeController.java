package com.dictionaryapp.controller;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final UserSession userSession;
    private final WordService wordService;

    public HomeController(UserSession userSession, WordService wordService) {
        this.userSession = userSession;

        this.wordService = wordService;
    }

    @GetMapping("/")
    public String notLogged(){
    if (userSession.isLoggedIn()){
        return "redirect:/home";
    }
        return "index";
    }
@GetMapping("/home")
    public String logged(Model model){
    if (!userSession.isLoggedIn()){
        return "redirect:/";
    }
    List<Word> spanishWords=
    wordService.findSpanishWords();
model.addAttribute("spanishWords",spanishWords);


        return "home";
    }
}
