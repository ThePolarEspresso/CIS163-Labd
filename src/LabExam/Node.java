package LabExam;

public class Node {

    /** The element that this Node holds */
	private  String element;

	/** A next pointer in the linked list */
	private Node next;


	/******************************************************************
	 * A constructor that sets the element, next to null
	 */
	public Node() {
		this.element = null;
		this.next = null;
	}

	/******************************************************************
	 * A constructor that sets the element, next to
	 * specified values
	 * @param element that represents the element to set for this Node
	 * @param next that represents the next Node in the linked
	 * 		list
	 */
	public Node(String element, Node next) {
		this.element = element;
		this.next = next;
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
	 * @return E that represents the element of this Node
	 */
	public String getElement() {
		return this.element;
	}

	/******************************************************************
	 * A setter for the next Node in the linked list
	 * @param next that represents the next Node in the linked
	 * 		list
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/******************************************************************
	 * A getter for the next Node in the linked list
	 * @return MyNode<T> that represents the next Node in the
	 * 		linked list
	 */
	public Node getNext() {
		return this.next;
	}
}

