package com.spartaglobal.sortmanager.model;

public class BubbleSortFactory extends SortFactory {
    @Override
    public Sort getSortingAlgorithm() {
        return new BubbleSort();
    }

    @Override
    public String getAlgorithmName() {
        return "Bubble Sort";
    }
}
