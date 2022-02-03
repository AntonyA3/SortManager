package com.spartaglobal.sortmanager;

import com.spartaglobal.sortmanager.controller.SortManager;
import com.spartaglobal.sortmanager.model.Sort;
import com.spartaglobal.sortmanager.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Program {
    public static Logger logger = LogManager.getLogger(Program.class.getName());
    public static void main(String[] args) {
        logger.debug("Program Begin");
        boolean toContinue;
        DisplayManager view = new DisplayManager();
        SortManager controller = new SortManager();
        do {
            view.displayMessage(controller.getAskForAlgorithmMessage());
            String chosenSortingAlgorithm = view.getSortingAlgorithm();

            Program.logger.debug("User typed in this as a sorting Algorithm: " + chosenSortingAlgorithm);
            view.displayMessage(controller.getAskForArrayMessage());
            String arrayRecieved = view.getArray();
            Program.logger.debug("User typed in this for an Array: " + arrayRecieved);
            Sort sortingAlgorithm = controller.getSortingAlgorithm(chosenSortingAlgorithm);
            int[] arrayToSort = controller.getArrayToSort(arrayRecieved);
            Program.logger.debug("Array to sort is: " + arrayToSort);
            int[] result = controller.getSortedArray(
                    sortingAlgorithm,
                    arrayToSort
            );

            Program.logger.debug("Result array is: " + result);

            view.displayArray(result);
            view.displayMessage(controller.getContinueQuestion());
            toContinue = controller.shouldContinue(
                    view.decideContinuation()
            );
            logger.debug("Loop Program");
        }while (toContinue);

        logger.debug("Program Finished");
    }


}
