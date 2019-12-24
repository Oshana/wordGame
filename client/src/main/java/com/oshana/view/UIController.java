package com.oshana.view;

import java.util.Scanner;

public class UIController implements UIControllerInterface {

    public UIController(Scanner scanner) {
    }

    public void printInNewLine(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void printChar(char message) {
        System.out.print(message);
    }

    public char scan() {
        Scanner input = new Scanner(System.in);
        return (input.next().charAt(0));
    }
}
