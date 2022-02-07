package com.spartaglobal.sortmanager.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

public class BinaryTreeSortTest {
    private static BinaryTreeSort binaryTreeSort;
    @BeforeAll
    public static void initialiseMergeSort(){
        binaryTreeSort = new BinaryTreeSort();
    }

    @ParameterizedTest
    @ValueSource(ints = {34, 23, 43, 5454343, 23 ,-2323 })
    @DisplayName("Given 10 seeded random arrays , after these arrays have been sorted all elements should be in order")
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
    @DisplayName("Given an Empty array, after sorting the array a new empty array is expeceted")
    void givenAnEmptyArray_expectANewEmptyArray(){
        int[] inputArray = new int[0];
        int[] resultArray = binaryTreeSort.sort(inputArray);
        int[] expectedArray = new int[0];
        Assertions.assertNotSame(inputArray, resultArray);
        Assertions.assertArrayEquals(expectedArray, resultArray);

    }

    @Test
    @DisplayName("Given an array with a single element , after sorting the array a new array with the same single element is expeceted")
    void givenAnArrayWithALengthOf1_expectANewArrayThatIsEqualToTheInputArray(){
        int[] inputArray = new int[]{65};
        int[] resultArray = binaryTreeSort.sort(inputArray);
        int[] expectedArray = new int[]{65};

        Assertions.assertNotSame(inputArray, resultArray);
        Assertions.assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    @DisplayName("Given an array that is already in order, after sorting the array expect an new array that is equal to the input array")

    void givenAnArrayOfALengthGreaterThan1ThatIsInOrder_expectADiffrentArrayThatIsEqual(){
        int[] inputArray = new int[]{1,2,3,4,5,6,7,8,9};
        int[] resultArray = binaryTreeSort.sort(inputArray);

        int[] expectedArray = new int[]{1,2,3,4,5,6,7,8,9};

        Assertions.assertArrayEquals(expectedArray, resultArray);

        Assertions.assertNotSame(inputArray, resultArray);
    }

    @Test
    @DisplayName("Given an array that is out of order, after sorting the array expect an new array that is in order")

    void givenAnArrayThatIsOutOfOrder_expectADiffrentArrayThatIsInOrder(){
        int[] inputArray = new int[]{3,2,9,1,4,5,9,7,8,6};
        int[] resultArray = binaryTreeSort.sort(inputArray);
        int[] expectedArray = new int[]{1,2,3,4,5,6,7,8,9,9};
        Assertions.assertArrayEquals(expectedArray, resultArray);
        Assertions.assertNotSame(inputArray, resultArray);
    }

}