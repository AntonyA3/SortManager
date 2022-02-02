package com.spartaglobal.sortmanager.model;

import java.util.Arrays;

public class MergeSort implements Sort{
    @Override
    public int[] sort(int[] array) {
        if(array.length == 0) return new int[0];
        if(array.length == 1) return Arrays.copyOf(array,1);

        int[] leftArray = this.sort(Arrays.copyOfRange(array,0, array.length / 2));
        int[] rightArray = this.sort(Arrays.copyOfRange(array,array.length / 2, array.length));
        int[] mergeArray = new int[array.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        while (mergeIndex < array.length){
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
