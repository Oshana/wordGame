package com.oshana.api.service;

import com.oshana.api.entity.Level;
import com.oshana.api.entity.Word;
import com.oshana.api.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsService {
    @Autowired
    private WordsRepository wordsRepository;

    public List<Word> findAllWords(){
        return wordsRepository.findAll();
    }

    public Word findWord(Long id){
        return wordsRepository.findById(id).orElse(null);
    }

    public void saveWord(Level level,String word){
        if(!findByWord(word)) {
            Word saveWord = new Word();
            saveWord.setword(word);
            saveWord.setLevel(level);
            wordsRepository.save(saveWord);
        }
    }

    public boolean findByWord(String word) {
        Word data = wordsRepository.findByWord(word);
        return data != null;
    }
}
