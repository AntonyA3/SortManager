package com.spartaglobal.sortmanager.model;

public class BubbleSortFactory implements SortFactory{
    @Override
    public Sort getInstance() {
        return new BubbleSort();
    }
}
