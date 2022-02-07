package com.spartaglobal.sortmanager.view;

import com.spartaglobal.sortmanager.model.SortingAlgorithmPerformanceResult;

import java.util.ArrayList;
import java.util.Scanner;

public class DisplayManager {

    public void displayMessage(String message){
        System.out.println(message);
    }

    /*
    public String getSortingAlgorithm() {
        Scanner scanner = new Scanner(System.in);

        return scanner.next();
    }


    public String getArray() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    */
    public String getUserInput(){
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

    public void displaySortingAlgorithmResults(ArrayList<SortingAlgorithmPerformanceResult> results) {
        System.out.println("=========Sort Complete===========");
        for (SortingAlgorithmPerformanceResult result: results) {
            String name = result.getAlgorithmName();
            long elapsed = result.getElapsed();
            String output = String.format("%s Algorithm took %dns (nano seconds) to sort", name, elapsed);
            System.out.println(output);
            System.out.println("===================================");
        }
        SortingAlgorithmPerformanceResult fastest = null;

    }

}
