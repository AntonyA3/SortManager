package com.spartaglobal.sortmanager.model;

import java.util.Arrays;

public class BinaryTreeSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        if(array.length == 0) return new int[0];
        if(array.length == 1) return Arrays.copyOfRange(array, 0, 1);
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < array.length; i++){
            tree.addValue(array[i]);
        }

        return tree.toIntArray();
    }
}
