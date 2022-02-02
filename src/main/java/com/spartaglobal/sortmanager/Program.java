package com.spartaglobal.sortmanager;

import com.spartaglobal.sortmanager.controller.SortManager;
import com.spartaglobal.sortmanager.model.BubbleSort;
import com.spartaglobal.sortmanager.model.Sort;
import com.spartaglobal.sortmanager.view.DisplayManager;

import java.util.Random;

public class Program {

    public static void main(String[] args) {
        DisplayManager view = new DisplayManager();
        SortManager controller = new SortManager();

        view.displayMessage(controller.getAskForAlgorithmMessage());
        String chosenSortingAlgorithm = view.getSortingAlgorithm();
        view.displayMessage(controller.getAskForArrayMessage());
        String arrayRecieved = view.getArray();

        Sort sortingAlgorithm = controller.getSortingAlgorithm(chosenSortingAlgorithm);
        int[] arrayToSort = controller.getArrayToSort(arrayRecieved);
        int[] result = controller.getSortedArray(sortingAlgorithm, arrayToSort);

        view.displayArray(result);
    }


}
