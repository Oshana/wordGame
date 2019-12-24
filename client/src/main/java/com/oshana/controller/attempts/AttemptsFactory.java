package com.oshana.controller.attempts;

import com.oshana.controller.AttemptsController;
import com.oshana.exceptions.AttemptsErrorException;

public class AttemptsFactory {

    private AttemptsFactory() {
    }

    public static AttemptsControllerInterface create(){
        try {
            return new AttemptsController();
        }catch (Exception e){
            throw new AttemptsErrorException(e);
        }
    }
}
