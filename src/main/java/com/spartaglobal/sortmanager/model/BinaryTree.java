package com.spartaglobal.sortmanager.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTree {
    private Node head;
    private int size;

    public class Node{

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

        public Node getLeftNode() {
            return this.leftNode;
        }

        public Node getRightNode(){
            return this.rightNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value && Objects.equals(leftNode, node.leftNode) && Objects.equals(rightNode, node.rightNode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, leftNode, rightNode);
        }
    }
    BinaryTree(){
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
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

    @Override
    public String toString() {
        return "BinaryTree{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree that = (BinaryTree) o;
        return size == that.size && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }
}
