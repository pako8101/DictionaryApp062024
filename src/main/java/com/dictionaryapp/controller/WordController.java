package com.dictionaryapp.controller;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.AddWordDto;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class WordController {

    private final WordService wordService;
    private final UserSession userSession;

    public WordController(WordService wordService,
                          UserSession userSession) {
        this.wordService = wordService;
        this.userSession = userSession;
    }

    @ModelAttribute
    public AddWordDto addWordDto(){
        return new AddWordDto();
    }

@GetMapping("/words")
    public String viewAddWord(){
        if (!userSession.isLoggedIn()){
            return "redirect:/login";
        }
        return "word-add";
    }
    @PostMapping("/words")
    public String addWord(
            @Valid AddWordDto wordData,
            BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (!userSession.isLoggedIn()){
            return "redirect:/login";
        }else {
            if (bindingResult.hasErrors()){
                redirectAttributes.addFlashAttribute("addWordDto",wordData);
                redirectAttributes.addFlashAttribute("org.springframework" +
                                ".validation.BindingResult" +
                                ".addWordDto",
                        bindingResult);
                return "redirect:/words";

            }
            wordService.add(wordData);

            return "redirect:/";
        }
        }

}
