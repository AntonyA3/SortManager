package com.spartaglobal.sortmanager.model;

public class BubbleSortFactory implements SortFactory{
    @Override
    public Sort getSortingAlgorithm() {
        return new BubbleSort();
    }
}
