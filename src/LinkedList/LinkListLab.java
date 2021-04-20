package LinkedList;

public class LinkListLab {
    private Node top;

    public LinkListLab() {
        top = null;
    }

    /****************************************************************
     *
     * Determines the size, that is, the number of elements in the list
     *
     * @return the size of the list
     *
     ****************************************************************/
    public int getLen() {
        int total = 0;

        Node temp = top;
        while (temp != null) {
            total++;
            temp = temp.getNext();
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

    public void insertBefore (int index, String data) {
        //case 0: list does not exist & index = 0
        if (index == 0 && top == null) {
            top = new Node(data, null);
            return;
        }

        //case 1: list does not exist & index != 1
        if (top == null)
            throw new MyIllegalArgumentException();

        //case 2: list exists & index < 0 or index > list size
        if (index < 0 || index > getLen() -1)
            throw new MyIllegalArgumentException();

        //case 3: list exists & index = 0
        if (index == 0) {
            top = new Node(data, top);
            return;
        }

        //case 4: list exists & index > 0 & index < list size
        Node temp = top;
        for (int i = 0; i < index - 1; i++)
            temp = temp.getNext();

        temp.setNext(new Node(data, temp.getNext()));

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

    public void insertAfter (int index, String data) {
        //case 0: index is less than 0
        if (index < 0)
            throw new MyIllegalArgumentException();

        //case 1: no list & index = 0
        if (top == null && index == 0) {
            top = new Node(data, top);
            return;
        }

        //case 2: list exists & index is less than list size
        if (index > getLen())
            throw new MyIllegalArgumentException();

        //case 3: list exists & index = the last item of list
        if (index == getLen() - 1) {
            Node temp = top;
            for (int i = 0; i < index; i++)
                temp = temp.getNext();

            temp.setNext(new Node(data, temp.getNext()));
            return;
        }

        //case 4: list exists and index > 0 & index < list size
        Node temp = top;
        for (int i = 0; i < index; i++)
            temp = temp.getNext();

        temp.setNext(new Node(data, temp.getNext()));

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

    public String removeTop () {
        if (top == null)
            throw new MyIllegalArgumentException();

        String temp=top.getData();
        top = top.getNext();
        return temp;
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
        if (index < 0 || index >= getLen())
            throw new MyIllegalArgumentException();

        //no list
        if (top == null)
            return null;

        //remove top
        Node temp = top;
        if (index == 0) {
            top = top.getNext();
            return temp.getData();
        }

        //remove from middle or bottom
        try {
            for (int i = 0; i < index - 1; i++)
                temp = temp.getNext();
        } catch (Exception e) {
            return null;
        }

        String tstring = temp.getNext().getData();
        temp.setNext(temp.getNext().getNext());
        return tstring;
    }

    public static void main(String[] args) {
        LinkListLab list = new LinkListLab();

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
    }

    public void display() {
        Node temp = top;

        System.out.println("___________ List ________________________");
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
