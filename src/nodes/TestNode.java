/**
 * 
 */
package nodes;

/**
 * @author think-Matt
 *
 */
public class TestNode<E> {
	//data
	private E data;
	//pointers
	private Node<E> next;
	private Node<E> previous;
	//size
	private int size;
	//special pointers
	private Node<E> head;
	private Node<E> tail;
	
	//constructor
	public TestNode (E e) {
		data = e;
		previous = null;
		next = null;
		head = null;
		tail = null;
		size = 0;
		
	}
	//add
	//remove
	//find
	//add to head
	//add to tail
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public E getData() {
		return data;
	}


	public void setData(E data) {
		this.data = data;
	}


	public Node<E> getNext() {
		return next;
	}


	public void setNext(Node<E> next) {
		this.next = next;
	}


	public Node<E> getPrevious() {
		return previous;
	}


	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}


}
