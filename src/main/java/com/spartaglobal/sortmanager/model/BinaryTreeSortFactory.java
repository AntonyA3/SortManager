package com.spartaglobal.sortmanager.model;

public class BinaryTreeSortFactory extends SortFactory {
    @Override
    public Sort getSortingAlgorithm() {
        return new BinaryTreeSort();
    }

    @Override
    public String getAlgorithmName() {
        return "Binary Tree Sort";
    }
}
