package com.spartaglobal.sortmanager.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

public class MergeSortFactory implements SortFactory{
    @Override
    public Sort getSortingAlgorithm() {
        return new MergeSort();
    }


}
