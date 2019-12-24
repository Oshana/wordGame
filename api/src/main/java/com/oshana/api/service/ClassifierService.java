package com.oshana.api.service;

import com.oshana.api.util.LevelAssignLogicStrategy;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ClassifierService {

    private LevelAssignLogicStrategy levelAssignLogicStrategy;

    public ClassifierService(LevelAssignLogicStrategy levelAssignLogicStrategy) {
        this.levelAssignLogicStrategy = levelAssignLogicStrategy;
    }

    public void classifier(String data) throws IOException {
        levelAssignLogicStrategy.classifier(data);
    }
}
