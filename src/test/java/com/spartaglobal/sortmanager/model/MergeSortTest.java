package com.spartaglobal.sortmanager.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {
    private static MergeSort mergeSort;
    @BeforeAll
    public static void initialiseMergeSort(){
        mergeSort = new MergeSort();
    }

    @ParameterizedTest
    @ValueSource(ints = {34, 23, 43, 5454343, 23 ,-2323 })
    void givenRandomSeededArrayLength10_allItemsMustBeInOrder(int seed){
        Random random = new Random(seed);
        int[] array = new int[10];
        for (int i = 0; i < 10; i++){
            array[i] = random.nextInt(101);
        }
        int[] sortedArray = new MergeSort().sort(array);

        for (int i = 1 ; i < 10; i++){
            Assertions.assertTrue(sortedArray[i] >= sortedArray[i - 1]);
        }

    }


    @Test
    void givenAnEmptyArray_expectANewEmptyArray(){
        int[] inputArray = new int[0];
        int[] resultArray = mergeSort.sort(inputArray);
        int[] expectedArray = new int[0];
        Assertions.assertNotSame(inputArray, resultArray);
        Assertions.assertArrayEquals(expectedArray, resultArray);

    }

    @Test
    void givenAnArrayWithALengthOf1_expectANewArrayThatIsEqualToTheInputArray(){
        int[] inputArray = new int[]{65};
        int[] resultArray = mergeSort.sort(inputArray);
        int[] expectedArray = new int[]{65};

        Assertions.assertNotSame(inputArray, resultArray);
        Assertions.assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    void givenAnArrayOfALengthGreaterThan1ThatIsInOrder_expectADiffrentArrayThatIsEqual(){
        int[] inputArray = new int[]{1,2,3,4,5,6,7,8,9};
        int[] resultArray = mergeSort.sort(inputArray);

        int[] expectedArray = new int[]{1,2,3,4,5,6,7,8,9};

        Assertions.assertArrayEquals(expectedArray, resultArray);

        Assertions.assertNotSame(inputArray, resultArray);
    }

    @Test
    void givenAnArrayThatIsOutOfOrder_expectADiffrentArrayThatIsInOrder(){
        int[] inputArray = new int[]{3,2,9,1,4,5,9,7,8,6};
        int[] resultArray = mergeSort.sort(inputArray);
        int[] expectedArray = new int[]{1,2,3,4,5,6,7,8,9,9};
        Assertions.assertArrayEquals(expectedArray, resultArray);
        Assertions.assertNotSame(inputArray, resultArray);
    }

}
