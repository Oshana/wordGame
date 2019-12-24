package com.oshana.view;

import java.util.Scanner;

public class UIFactory {

    private UIFactory() {
    }

    public static UIControllerInterface create(UIType uiType){
        if(uiType == UIType.COMMAND_LINE){
            return new UIController(new Scanner(System.in));
        }else{
            throw new UITypeNotFoundException(uiType.toString());
        }
    }
}
