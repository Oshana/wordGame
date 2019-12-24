package com.oshana.api.service;

import com.oshana.api.entity.Level;
import com.oshana.api.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {

    @Autowired
    private LevelRepository levelRepository;

    public List<Level> findAllLevels(){
        return levelRepository.findAll();
    }

    public Level findLevel(Integer id){
        return levelRepository.findById(id).orElse(null);
    }

    public Level saveLevel(Level word){
        return levelRepository.save(word);
    }

    public Level findLevelByLevelNo(int level){
        return levelRepository.findByLevelNo(level);
    }
}
