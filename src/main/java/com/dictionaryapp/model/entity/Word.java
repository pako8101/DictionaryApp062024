package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String term;
    @Column(nullable = false)
    private String translation;
    private String example;
    @Column(nullable = false)
    private LocalDate date;
    @ManyToOne(optional = false)
    private Language language;
    @ManyToOne(optional = false)
    private User addedBy;

    public Word() {
    }

    public long getId() {
        return id;
    }

    public String getTerm() {
        return term;
    }

    public Word setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public Word setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public Word setExample(String example) {
        this.example = example;
        return this;
    }

    public Word setId(long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Word setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public Word setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public Word setAddedBy(User addedBy) {
        this.addedBy = addedBy;
        return this;
    }
}
