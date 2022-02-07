package com.spartaglobal.sortmanager.model;

public abstract class SortFactory {
    public abstract Sort getSortingAlgorithm();
    public abstract String getAlgorithmName();
}
