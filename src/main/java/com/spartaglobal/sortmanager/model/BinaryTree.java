package com.spartaglobal.sortmanager.model;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTree {
    private Node head;
    private int size;
    private class Node{

        private int value;
        Node leftNode;
        Node rightNode;

        Node(int value){
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
        }

        public int getValue() {
            return this.value;
        }

        public void addValue(int value) {
            if(value <= this.value){
                if(this.leftNode == null){
                    this.leftNode= new Node(value);
                }else {
                    this.leftNode.addValue(value);
                }
            }else {
                if(this.rightNode == null){
                    this.rightNode = new Node(value);
                }else {
                    this.rightNode.addValue(value);
                }
            }
        }

        public void toIntArray(int[] intArray, AtomicInteger i) {

            if(this.leftNode != null){
                this.leftNode.toIntArray(intArray, i);
            }
            intArray[i.incrementAndGet()] = this.value;

            if(this.rightNode != null){
                this.rightNode.toIntArray(intArray, i);
            }
        }
    }
    BinaryTree(){
        this.head = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    void addValue(int value){
        this.size++;
        if(this.head == null){
            this.head = new Node(value);
        }else{
            this.head.addValue(value);
        }
    }

    public int[] toIntArray(){
        int[] intArray = new int[this.size];

        if(this.head != null){

            this.head.toIntArray(intArray, new AtomicInteger(-1));
        }
        return intArray;
    }
}
