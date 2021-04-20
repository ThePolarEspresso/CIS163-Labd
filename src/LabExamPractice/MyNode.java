package LabExamPractice;

/**
 * A custom class to define a single position in a custom double linked
 * list 
 * 
 * @author Roger Ferguson
 *
 */
public class MyNode {

    /** The element that this Node holds */
	private String element;

	/** A next pointer in the double linked list */
	private MyNode next;

	/** A previous pointer in the double Linked list */
    private MyNode prev;

	/******************************************************************
	 * A constructor that sets the element, next, and previous of this
	 * Node to null 
	 */
	public MyNode(String data) {
		this.element = data;
		this.next = null;
		this.prev = null;
	}

	/******************************************************************
	 * A constructor that sets the element, next, and previous to the
	 * specified values
	 * @param element that represents the element to set for this Node
	 * @param next that represents the next Node in the double linked
	 * 		list
	 */
	public MyNode(String element, MyNode next, MyNode prev) {
		this.element = element;
		this.next = next;
		this.prev = prev;
    }

	/******************************************************************
	 * A setter for the element of this Node
	 * @param element that represents the element to set for this Node
	 */
	public void setElement(String element) {
		this.element = element;
	}

	/******************************************************************
	 * A getter for the element of this Node
	 * @return String that represents the element of this Node
	 */
	public String getElement() {
		return this.element;
	}

	/******************************************************************
	 * A setter for the next Node in the double linked list
	 * @param next that represents the next Node in the double linked
	 * 		list
	 */
	public void setNext(MyNode next) {
		this.next = next;
	}

	/******************************************************************
	 * A getter for the next Node in the double linked list
	 * @return MyNode<T> that represents the next Node in the double
	 * 		linked list
	 */
	public MyNode getNext() {
		return this.next;
	}

	/******************************************************************
	 * A setter for the previous Node in the double linked list
	 * @param prev that represents the previous Node in the double
	 * 		linked list
	 */

    public void setPrev(MyNode prev) {
        this.prev = prev;
    }

    /******************************************************************
     * A getter for the prev Node in the double linked list
     * @return MyNode that represents the next Node in the double
     * 		linked list
     */
    public MyNode getPrev() {
        return this.prev;
    }
}

