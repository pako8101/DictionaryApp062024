package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.LanguageEnum;

import java.time.Instant;
import java.time.LocalDate;

public class AddWordDto {

    private String term;
    private String translation;
    private String example;
    private LanguageEnum language;

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
