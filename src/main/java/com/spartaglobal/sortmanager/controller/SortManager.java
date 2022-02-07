package com.spartaglobal.sortmanager.controller;

import com.spartaglobal.sortmanager.Program;
import com.spartaglobal.sortmanager.model.*;

import java.util.ArrayList;
import java.util.Random;

public class SortManager {
    private class Pair<T, E>{
        private T left;
        private E right;
        public Pair(T left, E right) {
            this.left = left;
            this.right = right;
        }

        public T getLeft() {
            return left;
        }

        public E getRight() {
            return right;
        }
    }
    private int[] arrayToSort = null;
    private ArrayList<Pair<String, Sort>> sortingAlgorithms = new ArrayList<>();

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
    public void setSortingAlgorithms(String algorithmNames){
        for (String algorithmName: algorithmNames.split(" ")) {
            SortFactory factory = null;
            switch (algorithmName.toLowerCase()){
                case "mergesort", "merge sort" -> factory = new MergeSortFactory();
                case "bubblesort", "bubble sort" -> factory = new BubbleSortFactory();
                case "binarytreesort", "treesort", "binary tree sort"," tree sort" -> factory = new BinaryTreeSortFactory();
                default -> Program.logger.error("Invalid sorting Algorithm");
            }
            sortingAlgorithms.add(new Pair<String, Sort>(factory.getAlgorithmName(), factory.getSortingAlgorithm()));
        }
    }


    public void setArraysToSort(String arrayRecieved) {

        String[] stringArray = arrayRecieved.split(" ");
        int[] intArray = null;
        if(stringArray[0].equalsIgnoreCase("random")){
            int arraySize = Integer.parseInt(stringArray[1]);
            Random random = new Random();
            Program.logger.debug("Sort Using a random array of size " + stringArray[1]);
            intArray = new int[arraySize];
            int bound = Integer.MAX_VALUE;
            if(stringArray.length >= 2){
                bound = Integer.parseInt(stringArray[2]);
            }

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
        this.arrayToSort = intArray;

    }

    public int[] getSortedArray(Sort sortingAlgorithm, int[] arrayToSort) {
        return sortingAlgorithm.sort(arrayToSort);
    }

    public String getAskForArrayMessage() {
        return "Enter and array or characters in this format \n" +
                "<number> <number> <number> ... | random <size> <bounds?>";
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


    public void clearAll(){
        this.arrayToSort = null;
        this.sortingAlgorithms.clear();

    }
    public ArrayList<SortingAlgorithmPerformanceResult> sortArrays() {


        ArrayList<SortingAlgorithmPerformanceResult> results = new ArrayList<>();

        for (Pair<String, Sort> nameAlgorithmPair: sortingAlgorithms) {
            String name = nameAlgorithmPair.getLeft();
            Sort algorithm = nameAlgorithmPair.getRight();

            long start = System.nanoTime();
            algorithm.sort(arrayToSort);
            long end = System.nanoTime();
            long elapsed = end - start;

            results.add(new SortingAlgorithmPerformanceResult(name, elapsed));


        }
        return results;
    }
}
