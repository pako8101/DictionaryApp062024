package com.dictionaryapp.service;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.AddWordDto;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.LanguageEnum;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WordService {
    private final LanguageRepository languageRepository;
    private final UserSession userSession;
    private final UserRepository userRepository;
    private final WordRepository wordRepository;


    public WordService(LanguageRepository languageRepository,
                       UserSession userSession,
                       UserRepository userRepository, WordRepository wordRepository) {
        this.languageRepository = languageRepository;
        this.userSession = userSession;
        this.userRepository = userRepository;
        this.wordRepository = wordRepository;
    }

    public void add(AddWordDto wordData) {
        Word word = new Word();
        Language language = this.languageRepository.
                findByLanguageName(wordData.getLanguage());
        User userById = userRepository.
                findById(userSession.getId()).orElse(null);


        word.setTerm(wordData.getTerm())
                .setTranslation(wordData.getTranslation())
                .setExample(wordData.getExample())
                .setDate(wordData.getInputDate())
                .setLanguage(language)
                .setAddedBy(userById);

        Set<Word> userByIdAssignedWords = userById.getAddedWords();
        userByIdAssignedWords.add(word);
        userById.setAddedWords(userByIdAssignedWords);

        this.wordRepository.save(word);
        this.userRepository.save(userById);


    }

    public List<Word> findSpanishWords() {
        Optional<User> user =
                userRepository.findById(userSession.getId());

        if (user.isEmpty()) {
            return new ArrayList<>();
        }
        Language language =
                languageRepository.
                        findByLanguageName(LanguageEnum.SPANISH);

        List<Word> result =
                wordRepository
                        .findByLanguageAndAndAddedBy(language, user.get());

        return result;
    }

    public void delete(String id) {
        userRepository.findById(userSession.getId())
                .flatMap(user ->
                        wordRepository.findByIdAndAddedBy(id, user))
                .ifPresent(wordRepository::delete);
    }

//        Optional<User> user =
//                userRepository.findById(userSession.getId());
//        if (user.isEmpty()) {
//            return;
//        }
//        Optional<Word> mayBeWord =
//                wordRepository.findByIdAndAddedBy(id, user.get());
//
//        if (mayBeWord.isEmpty()) {
//            return;
//        }
//        wordRepository.delete(mayBeWord.get());
//
//    }
}
