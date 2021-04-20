package DoubleLinkedList;

public class DoubleLinkListLab {
    private DNode top;
    private DNode tail;

    public DoubleLinkListLab() {
        top = null;
        tail = null;
    }

    /****************************************************************
     *
     * Determines the size, that is, the number of elements in the list
     *
     * @return the size of the list
     *
     ****************************************************************/
    public int getLen() {
        // place your code here
        //  GO FROM TAIL UP, NOT FROM TOP DOWN.
        int total = 0;

        DNode temp = tail;
        while (temp != null) {
            total++;
            temp = temp.getPrev();
        }

        return total;
    }

    /****************************************************************
     *
     * Inserts a node before a specific index.  When the list is empty
     * that is, top = null, then the index must be 0. After the first
     * element is added, index must be:  0 <= index < size of list
     *
     * @param index a specific index into the list.
     *
     * @throws MyIllegalArgumentException if index < 0 or
     *           index >= size of the list
     ****************************************************************/

    public void insertBefore(int index, String data) {
        //case 0: no list & index == 0
        if (top == null && index == 0) {
            top = tail = new DNode(data, null, null);
            return;
        }

        //case 1: no list & index != 0
        if (top == null)
            throw new MyIllegalArgumentException();

        //case 2: list exists & index < 0 or index >= list size
        if (index < 0 || index >= getLen())
            throw new MyIllegalArgumentException();

        //case 3: list exists & index == 0
        if (index == 0) {
            DNode temp = new DNode(data, top, null);
            top.setPrev(temp);
            top = temp;
            return;
        }

        //case 4: list exists & index < list size & index > 0
        DNode temp = top;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        temp.getPrev().setNext(new DNode(data, temp, temp.getPrev()));
        temp.setPrev(temp.getPrev().getNext());
    }

    /****************************************************************
     *
     * Inserts a node after a specific index.  When the list is empty
     * that is, top = null, then the index must be 0. After the first
     * element is added, index must be:  0 <= index < size of list
     *
     * @param index a specific index into the list.
     *
     * @throws MyIllegalArgumentException if index < 0 or
     *           index >= size of the list
     ****************************************************************/

    public void insertAfter(int index, String data) {
        //case 0: no list & index == 0
        if (top == null && index == 0) {
            top = tail = new DNode(data, null, null);
            return;
        }

        //case 1: no list & index != 0
        if (top == null)
            throw new MyIllegalArgumentException();

        //case 2: list exists & index < 0 or index >= list size
        if (index < 0 || index >= getLen())
            throw new MyIllegalArgumentException();

        //case 3: list exists & index == 0
        if (index == 0) {
            top.setNext(new DNode(data, top.getNext(), top));
            top.getNext().getNext().setPrev(top.getNext());
            return;
        }

        //list exists & index < list size & index > 0
        DNode temp = top;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        //case 4: list exists & index = bottom of list
        if (temp == tail) {
            temp.setNext(new DNode(data, null, tail));
            tail = temp;
            return;
        }

        //case 4: list exists & index < list size & index > 0
        temp.setNext(new DNode(data, temp.getNext(), temp));
        temp.getNext().getNext().setPrev(temp.getNext());
    }


    /****************************************************************
     *
     * Removes the top element of the list
     *
     * @return returns the element that was removed.
     *
     * @throws MyIllegalArgumentException if top == null, that is,
     *            there is no list.
     *
     ****************************************************************/

    public String removeTop() {
        String tstring = top.getData();

        //case 0: no list
        if (top == null) {
            throw new MyIllegalArgumentException();
        }

        //case 1: list exists & size == 1
        if (top == tail) {
            top = tail = null;
            return tstring;
        }

        //case 2: list exists & size > 1
        top = top.getNext();
        top.setPrev(null);

        return tstring;
    }


    /****************************************************************
     *
     * This Method removes a node at the specific index position.  The
     * first node is index 0.
     *
     * @param index the position in the linked list that is to be
     *           removed.  The first position is zero.
     *
     * @throws MyIllegalArgumentException if index < 0 or
     *           index >= size of the list
     *
     ****************************************************************/
    public String delAt(int index) {
        //case 0: no list
        if (top == null)
            throw new MyIllegalArgumentException();

        //case 1: single-item list and index = top
        if (top.getNext() == null && index == 0) {
            String tstring = top.getData();
            top = null;
            return tstring;
        }

        //case 2: single-item list and index != top
        if (top.getNext() == null)
            throw new MyIllegalArgumentException();

        //case 3: multi-item list and index < 0 or >= list size
        if (index < 0 || index >= getLen())
            throw new MyIllegalArgumentException();

        //case 4: multi-item list and index = top
        if (index == 0) {
            String tstring = top.getData();
            top.getNext().setPrev(null);
            top = top.getNext();
            top.setNext(null);
            return tstring;
        }

        DNode temp = top;
        for (int i = 0; i < index; i++)
            temp = temp.getNext();

        String tstring = temp.getData();

        //case 5: multi-item list and index = tail
        if (temp == tail) {
            tail.getPrev().setNext(null);
            tail.setPrev(null);
            tail = temp;
            return tstring;
        }

        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        return tstring;
    }

    // A simple testing program.  Not complete but a good start.
    public static void main(String[] args) {
        DoubleLinkListLab list = new DoubleLinkListLab();

        list.display();
        System.out.println("Current length = " + list.getLen());

        list.insertBefore(0, "apple");
        list.insertBefore(0, "pear");
        list.insertBefore(1, "peach");
        list.insertBefore(1, "cherry");
        list.insertBefore(3, "donut");
        list.display();

        list.insertAfter(0, "apple");
        list.insertAfter(0, "pear");
        list.insertAfter(1, "peach");
        list.insertAfter(1, "cherry");
        list.insertAfter(3, "donut");
        list.display();

        list.removeTop();
        System.out.println("Deleted pos 4 with value of: " + list.delAt(4));
        System.out.println("Deleted pos 2 with value of: " + list.delAt(2));
        System.out.println("Deleted pos 0 with value of: " + list.delAt(0));
        list.removeTop();
        list.removeTop();

        list.display();
        System.out.println("Current length = " + list.getLen());
    }

    // Once you are done!
    // Change this method to go from the tail up!
    public void display() {
        DNode temp = top;

        System.out.println("___________ List ________________________");
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
