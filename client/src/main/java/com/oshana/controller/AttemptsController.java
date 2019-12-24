package com.oshana.controller;

import com.oshana.controller.attempts.AttemptsControllerInterface;

public class AttemptsController implements AttemptsControllerInterface {

    public int attemptsCount(int level){
        switch(level) {
            case 1:
                return (3);
            case 2:
                return (3);
            case 3:
                return (3);
            case 4:
                return (4);
            case 5:
                return (5);
            case 6:
                return (5);
            default:
                return 5;
        }
    }

}
