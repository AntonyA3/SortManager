package com.spartaglobal.sortmanager.controller;

import com.spartaglobal.sortmanager.model.BubbleSortFactory;
import com.spartaglobal.sortmanager.model.MergeSortFactory;
import com.spartaglobal.sortmanager.model.Sort;
import com.spartaglobal.sortmanager.model.SortFactory;

import java.util.Arrays;

public class SortManager {

    public String getAskForAlgorithmMessage(){
        return "Choose and algrithm \n \t mergeSort \n \t bubbleSort";
    }
    public Sort getSortingAlgorithm(String algorithmName){
        SortFactory algorithm;
        switch (algorithmName){
            case "mergeSort" -> algorithm = new MergeSortFactory();
            case "bubbleSort" -> algorithm = new BubbleSortFactory();
            default -> algorithm = null;
        }

        return algorithm.getInstance();
    }


    public int[] getArrayToSort(String arrayRecieved) {
        String[] stringArray = arrayRecieved.split(" ");

        int[] intArray = new int[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    public int[] getSortedArray(Sort sortingAlgorithm, int[] arrayToSort) {
        return sortingAlgorithm.sort(arrayToSort);
    }

    public String getAskForArrayMessage() {
        return "Enter and array or characters in this format \n" +
                "<number> <number> <number> ...";
    }
}
