package com.oshana.controller;

import com.oshana.controller.attempts.AttemptsControllerInterface;
import com.oshana.controller.attempts.AttemptsFactory;
import com.oshana.dataSource.DataSourceInterface;
import com.oshana.dataSource.DataSourceFactory;
import com.oshana.dataSource.DataSourceType;
import com.oshana.view.UIFactory;
import com.oshana.view.UIType;
import com.oshana.view.UIControllerInterface;

import java.util.ArrayList;
import java.util.List;

public class GameController implements GameControllerInterface {

    public void start(int levels) throws Exception {
        int key = 0;

        DataSourceInterface wordController = DataSourceFactory.create(DataSourceType.API_DATA);
        AttemptsControllerInterface attemptsController = AttemptsFactory.create();
        UIControllerInterface ui = UIFactory.create(UIType.COMMAND_LINE);

        ui.printInNewLine("Guess the Word");

        for(int level = 1;level<levels+1;level++){
            int subLevel = 0;
            int attempts  = attemptsController.attemptsCount(level);
            char[] word = wordController.wordBank(level);
            List<Integer> places = new ArrayList<Integer>();

            ui.print("\n"+word[0]);
            for (int i = 0 ; i< word.length-1; i++){
                ui.print(" _");
            }
            ui.printInNewLine("\nlevel "+level);
            ui.printInNewLine(attempts+" Attempts Remaining");
            ui.printInNewLine("Enter a character:");

            while(subLevel< 1){
                char letter = Character.toUpperCase(ui.scan());
                int count = 0;
                for (int i = 1 ; i< word.length; i++){
                    if (letter == word[i]){
                        places.add(i);
                        count++;
                    }
                }
                if(count != 0){
                    ui.printInNewLine("\n"+attempts+" Attempts Remaining");
                    ui.printChar(word[0]);
                    Integer[] placesArray = new Integer[places.size()];
                    placesArray = places.toArray(placesArray);

                    int temp = 0;
                    for (int i = 0; i < placesArray.length; i++) {
                        for (int j = i+1; j < placesArray.length; j++) {
                            if(placesArray[i] > placesArray[j]) {
                                temp = placesArray[i];
                                placesArray[i] = placesArray[j];
                                placesArray[j] = temp;
                            }
                        }
                    }

                    for(int i=1; i<word.length; i++ ){
                        for (Integer integer : placesArray) {
                            if (i == integer) {
                                ui.print(" " + word[i]);
                                key = 1;
                            }
                        }
                        if(key != 1){
                            ui.print(" _");
                        }
                        key = 0;
                    }

                    if(placesArray.length == word.length-1) {
                        subLevel = 2;
                        ui.printInNewLine("\n");
                        if(level == levels ){
                            ui.printInNewLine("Congratulations - You Win !!!");
                        }else {
                            ui.printInNewLine("\nCongratulations - Next Level");
                        }

                    }else {
                        ui.printInNewLine("\nEnter a character:");
                    }

                }else{
                    attempts  = attempts-1;
                    ui.printInNewLine("\n"+attempts+" Attempts Remaining");

                    ui.printChar(word[0]);
                    Integer[] placesArray = new Integer[places.size()];
                    placesArray = places.toArray(placesArray);

                    int temp = 0;
                    for (int i = 0; i < placesArray.length; i++) {
                        for (int j = i+1; j < placesArray.length; j++) {
                            if(placesArray[i] > placesArray[j]) {
                                temp = placesArray[i];
                                placesArray[i] = placesArray[j];
                                placesArray[j] = temp;
                            }
                        }
                    }

                    for(int i=1; i<word.length; i++ ){
                        for (Integer integer : placesArray) {
                            if (i == integer) {
                                ui.print(" " + word[i]);
                                key = 1;
                            }
                        }
                        if(key != 1){
                            ui.print(" _");
                        }
                        key = 0;
                    }

                    if(attempts == 0){
                        ui.printInNewLine("\n");
                        ui.printInNewLine("\nGame Over");
                        System.exit(0);
                    }else {
                        ui.printInNewLine("\nEnter a character:");
                    }

                }
            }
        }
        System.exit(0);
    }
}
