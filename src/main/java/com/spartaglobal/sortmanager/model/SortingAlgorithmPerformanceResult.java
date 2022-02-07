package com.spartaglobal.sortmanager.model;

public class SortingAlgorithmPerformanceResult {
    private String algorithmName;
    private long elapsed;

    public SortingAlgorithmPerformanceResult(String algorithmName, long elapsed){
        this.algorithmName = algorithmName;
        this.elapsed = elapsed;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public long getElapsed() {
        return elapsed;
    }
}
