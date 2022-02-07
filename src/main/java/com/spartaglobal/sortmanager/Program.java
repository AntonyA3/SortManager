package com.spartaglobal.sortmanager;

import com.spartaglobal.sortmanager.controller.SortManager;
import com.spartaglobal.sortmanager.model.Sort;
import com.spartaglobal.sortmanager.model.SortingAlgorithmPerformanceResult;
import com.spartaglobal.sortmanager.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static Logger logger = LogManager.getLogger(Program.class.getName());
    public static void main(String[] args) {
        DisplayManager view = new DisplayManager();

        view.displayMessage("Program Begin");
        view.displayMessage("==========Sort Manager============ ");
        view.displayMessage("Available At: https://github.com/AntonyA3/SortManager");

        boolean toContinue = false;
        SortManager controller = new SortManager();
        do {

            view.displayMessage("Choose Sorting Algorithms \n" + "mergeSort \n bubbleSort \n binaryTreeSort");

            view.displayMessage("format \n <name> <name> <name>");
            String chosenSortingAlgorithms = view.getUserInput();
            Program.logger.debug("User typed in this as a sorting Algorithm: " + chosenSortingAlgorithms);

            controller.setSortingAlgorithms(chosenSortingAlgorithms);
            view.displayMessage(controller.getAskForArrayMessage());
            String arrayRecieved = view.getUserInput();
            Program.logger.debug("User typed in this for an Array: " + arrayRecieved);
            controller.setArraysToSort(arrayRecieved);
            Program.logger.debug("Array to sort is: " + arrayRecieved);


            view.displayMessage("=====Waiting=======");
            ArrayList<SortingAlgorithmPerformanceResult> results = controller.sortArrays();
            view.displaySortingAlgorithmResults(results);

            view.displayMessage(controller.getContinueQuestion());
            logger.debug("Loop Program");

        }while (controller.shouldContinue(view.getUserInput()));

        logger.debug("Program Finished");
    }


}
