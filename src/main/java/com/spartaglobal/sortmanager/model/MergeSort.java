package com.spartaglobal.sortmanager.model;

import com.spartaglobal.sortmanager.Program;

import java.util.Arrays;

public class MergeSort implements Sort{
    @Override
    public int[] sort(int[] array) {
        if(array.length == 0) return new int[0];
        if(array.length == 1) return Arrays.copyOfRange(array,0,1);

        int start = 0;
        int midpoint = array.length / 2;
        int end = array.length;

        int[] leftArray = this.sort(Arrays.copyOfRange(array, start, midpoint));
        int[] rightArray = this.sort(Arrays.copyOfRange(array, midpoint , end));

        int[] mergeArray = new int[array.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        while (mergeIndex < mergeArray.length){
            if(leftIndex == leftArray.length){
                for(int i = rightIndex; i < rightArray.length; i++){
                    mergeArray[mergeIndex] = rightArray[i];
                    mergeIndex++;
                }
            }else if(rightIndex == rightArray.length){
                for(int i = leftIndex; i < leftArray.length; i++){
                    mergeArray[mergeIndex] = leftArray[i];
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
