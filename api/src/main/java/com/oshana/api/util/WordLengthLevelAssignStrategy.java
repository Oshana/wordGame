package com.oshana.api.util;

import com.oshana.api.entity.Level;
import com.oshana.api.service.LevelService;
import com.oshana.api.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordLengthLevelAssignStrategy implements LevelAssignLogicStrategy {

    @Autowired
    private LevelService levelService;
    @Autowired
    private WordsService wordService;

    public void classifier(String data){

        String[] words = data.split("[\\W]");

        for (String word : words) {
            if(word.length() > 3 ){
                Level level = levelService.findLevelByLevelNo(word.length()-3);
                if(level == null){
                    level = new Level();
                    level.setLevelNo(word.length()-3);
                    levelService.saveLevel(level);
                    wordService.saveWord(level,word);
                } else{
                    level = levelService.findLevelByLevelNo(word.length()-3);
                    wordService.saveWord(level,word);
                }
            }
        }
    }
}
