package com.spartaglobal.sortmanager.view;

import com.spartaglobal.sortmanager.model.SortingAlgorithmPerformanceResult;

import java.util.ArrayList;
import java.util.Scanner;

public class DisplayManager {

    public void displayMessage(String message){
        System.out.println(message);
    }

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void displayArray(int[] result) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for(int i = 0; i <  Math.min(result.length, 50); i++){
            sb.append(result[i]);
            sb.append(", ");
        }
        if(result.length > 50){
            sb.append(",.....");
        }

        if(sb.length() > 2){
            sb.setLength(sb.length() - 2);
            sb.append(']');

        }
        System.out.println(sb);

    }

    public void displaySortingAlgorithmResults(ArrayList<SortingAlgorithmPerformanceResult> results) {
        if(results.size() == 0){
            System.out.println("====No to Sorting algorithm selected======");
        }else {
            long totalElased = 0;
            for(SortingAlgorithmPerformanceResult otherResults : results) {
                totalElased += otherResults.getElapsed();
            }
                System.out.println("=========Sort Complete===========");
            for (SortingAlgorithmPerformanceResult result : results) {



                String name = result.getAlgorithmName();
                long elapsed = result.getElapsed();
                String output = String.format("%s Algorithm took %dns (nano seconds) to sort", name, elapsed);
                System.out.println(output);
                double fraction = elapsed / (double)totalElased;
                int dots = (int) (100 * fraction);
                System.out.println("-".repeat(dots));

                System.out.println("===================================");




            }
            SortingAlgorithmPerformanceResult fastest = null;
        }
    }

}
