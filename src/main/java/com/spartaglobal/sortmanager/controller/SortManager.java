package com.spartaglobal.sortmanager.controller;

import com.spartaglobal.sortmanager.Program;
import com.spartaglobal.sortmanager.model.*;

import java.util.Random;

public class SortManager {
    private String[] algorithNames = {
            "mergeSort",
            "bubbleSort",
            "binaryTreeSort"
    };
    public String getAskForAlgorithmMessage(){
        StringBuilder sb = new StringBuilder();
        sb.append("Choose sorting algorithm or enter quit ");
        for (String name: algorithNames) {
            sb.append("\n \t ");
            sb.append(name);
        }
        sb.append(" quit");
        return sb.toString();
    }
    public Sort getSortingAlgorithm(String algorithmName){
        SortFactory algorithm;
        switch (algorithmName){
            case "mergeSort" -> algorithm = new MergeSortFactory();
            case "bubbleSort" -> algorithm = new BubbleSortFactory();
            case "binaryTreeSort" ->algorithm = new BinaryTreeSortFactory();
            case "quit" -> {
                algorithm = null;
                System.exit(1);
            }
            default -> algorithm = null;
        }

        return algorithm.getSortingAlgorithm();
    }


    public int[] getArrayToSort(String arrayRecieved) {

        String[] stringArray = arrayRecieved.split(" ");
        int[] intArray = null;
        if(stringArray[0].toLowerCase().equals("random")){
            int arraySize = Integer.parseInt(stringArray[1]);
            int bound = Integer.parseInt(stringArray[2]);
            Random random = new Random();
            Program.logger.debug("Sort Using a random array of size " + stringArray[1]);
            intArray = new int[arraySize];
            for (int i =0; i < arraySize; i++){
                intArray[i] = random.nextInt(bound);
            }
        }else {
            intArray = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                try {
                    intArray[i] = Integer.parseInt(stringArray[i]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Program.logger.error("Invalid number added to sort array, Invalid number will default to the minimum Integer");
                    intArray[i] = Integer.MIN_VALUE;
                }
            }
        }
        return intArray;
    }

    public int[] getSortedArray(Sort sortingAlgorithm, int[] arrayToSort) {
        return sortingAlgorithm.sort(arrayToSort);
    }

    public String getAskForArrayMessage() {
        return "Enter and array or characters in this format \n" +
                "<number> <number> <number> ... | random <size>";
    }

    public String getContinueQuestion() {
        return "Continue Y|N";
    }

    public boolean shouldContinue(String decideContinuation) {
        decideContinuation = decideContinuation.toLowerCase();
        boolean toContinue = false;
        if(decideContinuation.equals("yes") || decideContinuation .equals("y")){
            toContinue = true;
        }

        return toContinue;
    }
}
