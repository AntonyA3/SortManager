package com.spartaglobal.sortmanager.model;

import org.junit.jupiter.api.*;

public class BinaryTreeTest {
    private BinaryTree binaryTree;

    @BeforeEach
    public void initialiseBinaryTree(){binaryTree = new BinaryTree();}

    @Test
    @DisplayName("Given an initialised Binary tree, when toIntArray() is called, expect an empty array")
    void givenAnInitialisedBinaryTree_expectToIntArrayToReturnAnEmptyArray(){
        int[] expected = new int[0];
        int[] actual = binaryTree.toIntArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Given a Binary tree, when 64 has been inserted into the binary tree, after calling toIntArray() expect array of length 1 containing 64")
    void givenABinaryTreeWhereSingleValueIsAdded_expectIntArrayToReturnAnArrayWithTheSingleElement(){
        int[] expected = new int[]{64};
        binaryTree.addValue(64);
        Assertions.assertArrayEquals(expected, binaryTree.toIntArray());
    }

    @Test
    @DisplayName("Given a binary tree, after inseting the values 16, 5 and 17. Expect the tree to have 3 nodes where the head node has a value of 16," +
            "the left child of head has a value of 5 and the right child of head has a value of 16")
    void givenABinaryTree_AfterInsertingTheValues_16_5_17_ExpectTheseResults(){
        binaryTree.addValue(16);
        binaryTree.addValue(5);
        binaryTree.addValue(17);
        Assertions.assertEquals(16, binaryTree.getHead().getValue());
        Assertions.assertEquals(5, binaryTree.getHead().getLeftNode().getValue());
        Assertions.assertEquals(17, binaryTree.getHead().getRightNode().getValue());

    }

    @Test
    @DisplayName("Given a binary tree, after inseting the values 16, 16 and 17. Expect the tree to have 3 nodes where the head node has a value of 16," +
            "the left child of head has a value of 16 and the right child of head has a value of 16")
    void givenABinaryTree_AfterInsertingTheValues_16_16_17_ExpectTheseResults(){
        binaryTree.addValue(16);
        binaryTree.addValue(16);
        binaryTree.addValue(17);

        Assertions.assertEquals(16, binaryTree.getHead().getValue());
        Assertions.assertEquals(16, binaryTree.getHead().getLeftNode().getValue());
        Assertions.assertEquals(17, binaryTree.getHead().getRightNode().getValue());

    }
}
