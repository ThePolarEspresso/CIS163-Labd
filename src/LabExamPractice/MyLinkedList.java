package LabExamPractice;

public class MyLinkedList {
    /** Pointers to the first MyNodes in this linked list */
    private MyNode head;

    public MyLinkedList() {
        // the following code builds the list.

        this.head = new MyNode("donut");
        MyNode temp1 = new MyNode("pie");
        MyNode temp2 = new MyNode("iceCream");
        MyNode temp3 = new MyNode("iceCream");
        MyNode temp4 = new MyNode("pair");
        MyNode temp5 = new MyNode("donut");
        temp1.setPrev(head);
        temp2.setPrev(temp1);
        temp3.setPrev(temp2);
        temp4.setPrev(temp3);
        temp5.setPrev(temp4);
        head.setNext(temp1);
        temp1.setNext(temp2);
        temp2.setNext(temp3);
        temp3.setNext(temp4);
        temp4.setNext(temp5);
    }

    /**
     * A function to delete all occurrences of the parameter data from
     * the linked list.  If data does not appear at least once in the list, then
     * throw IllegalArgumentException.
     *
     * NOTE: the code must work for all list inputs. Not just the list
     * I am testing it with.
     *
     *
     */
    public void delALL(String data) {
        //no list
        if (head == null)
            throw new IllegalArgumentException();

        //single-item list
        if (head.getNext() == null) {
            if (head.getElement().equals(data)) {
                head = null;
                return;
            } else if (!head.getElement().equals(data))
                throw new IllegalArgumentException();
        }

        //multi-item list
        int count = 0;
        MyNode temp = head;
        while (temp != null) {
            //top
            if (head.getElement().equals(data)) {
                head = head.getNext();
                head.setPrev(null);
                count++;
            }
            //middle
            else if (temp.getElement().equals(data) && temp.getNext() != null) {
                temp.getNext().setPrev(temp.getPrev());
                temp.getPrev().setNext(temp.getNext());
                count++;
            }
            //tail
            else if (temp.getElement().equals(data) && temp.getNext() == null) {
                temp.getPrev().setNext(null);
                temp.setPrev(null);
                count++;
            }
            temp = temp.getNext();
        }

        if (count == 0) //if data doesn't appear in list
            throw new IllegalArgumentException();
    }

    /**
     * Delete every third element in the list
     */
    public void del3rd() {
        //no list
        if (head == null)
            throw new IllegalArgumentException();

        //single or double-item list
        if (head.getNext() == null || head.getNext().getNext() == null)
            return;

        //>double-item list
        int count = 1;
        MyNode temp = head;
        while (temp != null) {
            //middle
            if (count % 3 == 0 && temp.getNext() != null) {
                temp.getNext().setPrev(temp.getPrev());
                temp.getPrev().setNext(temp.getNext());
                count = 1;
            }
            //tail
            else if (count % 3 == 0) {
                temp.getPrev().setNext(null);
                temp.setPrev(null);
                return;
            }
            else
                count++;
            temp = temp.getNext();
        }
    }

    public void addEvery2(String data) {
        //no list
        if (head == null) {
            head = new MyNode(data, null, null);
            return;
        }

        int count = 1;
        MyNode temp = head;
        while (temp != null) {
            //middle of list
            if (temp.getNext() != null && count % 2 == 0) {
                temp.setNext(new MyNode(data, temp.getNext(), temp));
                temp.getNext().getNext().setPrev(temp.getNext());
                temp = temp.getNext();
            }
            //end of list
            else if (count % 2 == 0){
                temp.setNext(new MyNode(data, null, temp));
                return;
            }
            count++;
            temp = temp.getNext();
        }
    }

    /**
     * A method to create a String representation of this linked
     * list.  DO NOT MODIFY THIS METHOD!
     *
     * @return String that is the String representation of this
     * 		linked list
     */
    @Override
    public String toString() {

        // Show the linked list forward
        String string = "Forward: ";
        MyNode currentNode = this.head;
        while (currentNode != null) {
            string += currentNode.getElement()  + " ";
            currentNode = currentNode.getNext();
        }

        currentNode = this.head;
        while (currentNode != null && currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }


        // Show the linked list backward
        string += "\nBackward: ";
        while (currentNode != null) {
            string += currentNode.getElement() + " ";
            currentNode = currentNode.getPrev();
        }
        // Return the String representation that shows the linked list
        // both forward and backward
        return string;
    }
}

/********************** Answer **********************************
 * THis answer will not be included in the real exam

 public void delALL(String data) {

 if (delete (data) == false)
 throw new IllegalArgumentException();
 while (delete (data) != false);

 }


 public boolean delete (String data) {

 if (head == null)
 return false;

 if (head.getElement().equals(data)) {
 head = head.getNext();
 if (head != null)
 head.setPrev(null);

 return true;
 }

 MyNode temp = head;
 while (temp.getNext() != null) {

 if (temp.getElement().equals(data)) {
 temp.getPrev().setNext(temp.getNext());
 temp.getNext().setPrev(temp.getPrev());
 return true;
 }
 temp = temp.getNext();
 }

 if (temp.getElement().equals(data)) {
 temp.getPrev().setNext(null);
 }

 return false;
 }
*/