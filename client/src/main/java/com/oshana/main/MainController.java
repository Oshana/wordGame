//was tested with SonarCube
//sonar.projectKey=Assignment
//sonar.projectName=Assignment
//sonar.projectVersion=1.0
//sonar.source=C:/Users/dtc/IdeaProjects/assignment/src/main/java/com/oshana/controller

package com.oshana.main;


import com.oshana.APIConnection.APIConnectionFactory;
import com.oshana.APIConnection.APIConnectionInterface;
import com.oshana.controller.GameController;
import com.oshana.controller.GameControllerInterface;
import com.oshana.APIConnection.APIConnection;

public class MainController {

    public static void main(String[] args) throws Exception {
        APIConnectionInterface apiConnectionInterface = APIConnectionFactory.create();
        int levels = apiConnectionInterface.NumberOfLevels();
        GameControllerInterface newGame = new GameController();
        newGame.start(levels);
    }
}