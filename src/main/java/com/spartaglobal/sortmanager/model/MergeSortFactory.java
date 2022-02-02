package com.spartaglobal.sortmanager.model;

public class MergeSortFactory implements SortFactory{
    @Override
    public Sort getInstance() {
        return new MergeSort();
    }
}
