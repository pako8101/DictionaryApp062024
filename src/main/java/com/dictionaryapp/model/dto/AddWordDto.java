package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.LanguageEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;

public class AddWordDto {
    @Size(min = 2, max = 40, message = "The term length must be between 2 and 40 characters!")
    @NotNull
    private String term;
    @Size(min = 2, max = 80, message = "The translation length must be between 2 and 80 characters!")
    @NotNull
    private String translation;
    @Size(min = 2, max = 200, message = "The example length must be between 2 and 200 characters!")

    private String example;
    @NotNull(message = "You must select a language!")
    private LanguageEnum language;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "The input date must be in the past or present!")

    private LocalDate inputDate;

    public AddWordDto() {
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public AddWordDto setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public AddWordDto setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public AddWordDto setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public AddWordDto setExample(String example) {
        this.example = example;
        return this;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public AddWordDto setLanguage(LanguageEnum language) {
        this.language = language;
        return this;
    }
}
