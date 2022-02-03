package com.spartaglobal.sortmanager.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ParameterizedTest
    @CsvSource(
            delimiter = '|',
            value = {"{}|{}"}
    )
    void givenArrayEdgeCases_OutputShouldBeExpectedsOutput(int[] inputArray, int[] expectedOutput){
        Assertions.assertArrayEquals(mergeSort.sort(inputArray) , expectedOutput);
    }
}
