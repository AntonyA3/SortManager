package com.spartaglobal.sortmanager;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class Program {

    public static void main(String[] args) {
        Random random = new Random();
        int[] intArray = new int[10];
        for(int i = 0; i < 10; i++){
            intArray[i] = random.nextInt(101);
        }

        int[] mergeSortResult = mergeSort(intArray);

        System.out.println(printIntArray(mergeSortResult));

    }

    public static String printIntArray(int[] intArray){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < intArray.length; i++){
            sb.append(intArray[i]);
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(']');
        return sb.toString();
    }

    public static int[] bubbleSort(int[] intArray){
        int[] sortArray =  Arrays.copyOf(intArray, intArray.length);
        if(sortArray.length <= 1) return sortArray;
        for (int i = 0; i < sortArray.length; i++){
            for(int j = 0; j < sortArray.length - 1 - i; j++){
                int smaller = Math.min(sortArray[j], sortArray[j + 1]);
                int larger = Math.max(sortArray[j], sortArray[j + 1]);
                sortArray[j] = smaller;
                sortArray[j + 1] = larger;
            }
        }
        return sortArray;

    }




    public static int[] mergeSort(int[] intArray){
        if(intArray.length == 0) return new int[0];
        if(intArray.length == 1) return Arrays.copyOf(intArray,1);

        int[] leftArray = mergeSort(Arrays.copyOfRange(intArray,0, intArray.length / 2));
        int[] rightArray = mergeSort(Arrays.copyOfRange(intArray,intArray.length / 2, intArray.length));
        int[] mergeArray = new int[intArray.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        while (mergeIndex < intArray.length){
            if(leftIndex == leftArray.length){
                for(int i = rightIndex; i < rightArray.length; i++){
                    mergeArray[mergeIndex] = rightArray[rightIndex];
                    mergeIndex++;
                }
            }else if(rightIndex == rightArray.length){
                for(int i = leftIndex; i < leftArray.length; i++){
                    mergeArray[mergeIndex] = leftArray[leftIndex];
                    mergeIndex++;
                }
            }else {
                if(leftArray[leftIndex] <= rightArray[rightIndex]){
                    mergeArray[mergeIndex] = leftArray[leftIndex];
                    leftIndex++;
                }else {
                    mergeArray[mergeIndex] = rightArray[rightIndex];
                    rightIndex++;
                }
                mergeIndex++;
            }
        }
        return mergeArray;
    }
}
