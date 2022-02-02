package com.spartaglobal.sortmanager.view;

import java.util.Scanner;

public class DisplayManager {

    public void displayMessage(String message){
        System.out.println(message);
    }

    public String getSortingAlgorithm() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    public String getArray() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void displayArray(int[] result) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < result.length; i++){
            sb.append(result[i]);
            sb.append(", ");
        }
        if(sb.length() > 2){
            sb.setLength(sb.length() - 2);
            sb.append(']');

        }
        System.out.println(sb.toString());

    }
}
