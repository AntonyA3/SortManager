package com.spartaglobal.sortmanager.model;

import java.util.Arrays;

public class BubbleSort implements Sort{
    @Override
    public int[] sort(int[] array) {
        int[] sortArray =  Arrays.copyOf(array, array.length);
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
}
