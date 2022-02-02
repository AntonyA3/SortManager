package com.spartaglobal.sortmanager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest {
    @ParameterizedTest
    @CsvSource( value = {"0"}, delimiter = '|')
    @Test
    void testBubbleSort(int expected){
        int[] inputArray = new int[0];
        int[] inputArray2 = new int[]{2};
        int[] inputArray3 = new int[]{2,5,2,4};
        //int actual = Program.bubbleSort(inputArray).length;
       // assertEquals(expected, actual);
    }

    @Test
    void testMergeSort(){

    }


}
