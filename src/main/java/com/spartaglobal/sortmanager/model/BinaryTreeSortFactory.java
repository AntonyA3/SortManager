package com.spartaglobal.sortmanager.model;

public class BinaryTreeSortFactory implements SortFactory{
    @Override
    public Sort getSortingAlgorithm() {
        return new BinaryTreeSort();
    }
}
