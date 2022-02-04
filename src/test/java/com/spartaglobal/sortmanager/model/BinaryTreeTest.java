package com.spartaglobal.sortmanager.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
    private BinaryTree binaryTree;

    @BeforeEach
    public void initialiseBinaryTree(){binaryTree = new BinaryTree();}

    @Test
    void givenAnInitialisedBinaryTree_expectToIntArrayToReturnAnEmptyArray(){
        int[] expected = new int[0];
        int[] actual = binaryTree.toIntArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void givenABinaryTreeWhereSingleValueIsAdded_expectIntArrayToReturnAnArrayWithTheSingleElement(){
        int[] expected = new int[]{64};
        binaryTree.addValue(64);
        Assertions.assertArrayEquals(expected, binaryTree.toIntArray());
    }

    @Test
    void givenABinaryTree_AfterInsertingTheValues_16_5_17_ExpectTheseResults(){
        binaryTree.addValue(16);
        binaryTree.addValue(5);
        binaryTree.addValue(17);
        Assertions.assertEquals(16, binaryTree.getHead().getValue());
        Assertions.assertEquals(5, binaryTree.getHead().getLeftNode().getValue());
        Assertions.assertEquals(17, binaryTree.getHead().getRightNode().getValue());

    }

    @Test
    void givenABinaryTree_AfterInsertingTheValues_16_16_17_ExpectTheseResults(){
        binaryTree.addValue(16);
        binaryTree.addValue(16);
        binaryTree.addValue(17);

        Assertions.assertEquals(16, binaryTree.getHead().getValue());
        Assertions.assertEquals(16, binaryTree.getHead().getLeftNode().getValue());
        Assertions.assertEquals(17, binaryTree.getHead().getRightNode().getValue());

    }
}
