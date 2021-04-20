package LabExam;

import DoubleLinkedList.MyIllegalArgumentException;

public class MyLinkedList {
    private Node top;
    private Node tail;

    public MyLinkedList(boolean empty) {
        // the following code builds the list.
        // Do not modify this method!

        if (empty)
            top = tail = null;
        else {
            this.top = new Node("donut", null);
            Node temp1 = new Node("pie", null);
            Node temp2 = new Node("iceCream", null);
            Node temp3 = new Node("iceCream", null);
            Node temp4 = new Node("pair", null);
            Node temp5 = new Node("donut", null);
            top.setNext(temp1);
            temp1.setNext(temp2);
            temp2.setNext(temp3);
            temp3.setNext(temp4);
            temp4.setNext(temp5);
            tail = temp5;

        }
    }

    /**
     * A function to delete all occurrences of the parameter data from
     * the linked list.  If data does not appear at least once in the list, then
     * throw IllegalArgumentException.
     *
     * NOTE: the code must work for all list inputs. Not just the list
     * I am testing with.
     */
    public void delALL(String data) {
        //no list
        if (top == null)
            throw new IllegalArgumentException();

        //single-element list and data != top
        if (top == tail && !top.getElement().equals(data))
            throw new MyIllegalArgumentException();

        //multi-element list
        int count = 0;
        Node temp = top;
        while (temp.getNext() != null) {
            //single list and data exists
            if (top.getElement().equals(data) && top == tail) {
                top = tail = null;
                count++;
            }
            //data at top
            if (top.getElement().equals(data)) {
                top = top.getNext();
                count++;
            }
            //data at tail
            if (temp.getNext() == tail && temp.getNext().getElement().equals(data)) {
                tail = temp;
                tail.setNext(null);
                count++;
            }
            //data in middle
            if (temp.getNext().equals(data)) {
                temp.setNext(temp.getNext().getNext());
                count++;
            }
            temp = temp.getNext();
        }

        if (count < 1)
            throw new IllegalArgumentException();

    }

    /**
     * A method to create a String representation of this linked
     * list
     *
     * @return String that is the String representation of this
     * linked list
     *
     * DO NOT MODIFY THIS CODE IN THIS METHOD
     */
    @Override
    public String toString() {

        // Show the linked list forward
        String string = "";
        Node currentNode = this.top;
        while (currentNode != tail) {
            string += currentNode.getElement() + " ";
            currentNode = currentNode.getNext();
        }
        string += tail.getElement();
        return string;
    }
}