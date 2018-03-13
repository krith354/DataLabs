package linkedLists;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class DLDHDTList<E> extends AbstractDLList<E> {
	private DNode<E> header, trailer; 
	private int length; 
	
	public DLDHDTList() { 
		// ADD CODE HERE to generate empty linked list of this type 
		this.makeEmpty();
	}
	
	public void addFirstNode(Node<E> nuevo) {
		addNodeAfter(header, nuevo); 
	}
	
	public void addLastNode(Node<E> nuevo) { 
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = trailer.getPrev();  
		nBefore.setNext(dnuevo); 
		trailer.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(trailer); 
		length++; 
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = (DNode<E>) target; 
		DNode<E> nAfter = nBefore.getNext(); 
		nBefore.setNext(dnuevo); 
		nAfter.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(nAfter); 
		length++; 
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		// ADD CODE HERE
		DNode<E> dnuevo = (DNode<E>) nuevo;
		DNode<E> nAfter =  (DNode<E>) target;
		DNode<E> nBefore = nAfter.getPrev();
		nBefore.setPrev(dnuevo); 
		nAfter.setNext(dnuevo); 
		dnuevo.setNext(nBefore); 
		dnuevo.setPrev(nAfter); 
		length++; 
	}

	public Node<E> createNewNode() {
		return new DNode<E>();
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return header.getNext();
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return trailer.getPrev();
	}

	public Node<E> getNodeAfter(Node<E> target)
			throws NoSuchElementException {
		if(this.getLastNode() == target)
			throw new NoSuchElementException("target is the last node");
		DNode<E> dNode = ((DNode<E>) target).getNext();
		return dNode; 
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		if(this.getFirstNode() == target)
			throw new NoSuchElementException("target is the first node, before is the dummy header node");
		DNode<E> dNode = ((DNode<E>) target).getPrev();
		return dNode; 
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		// ADD CODE HERE to disconnect target from the linked list, reduce lent, clean target...
		//PRE: target is a data node (never dummy)
		   DNode<E> dTarget = (DNode<E>) target; 
		   //Get surrounding nodes in the linked list....
		   //They exist! since at least the dummies are
		   // always there....
		   DNode<E> prevNode = dTarget.getPrev(); 
		   DNode<E> nextNode = dTarget.getNext(); 
		   // Properly set the links of those surrounding nodes
		   prevNode.setNext(nextNode); 
		   nextNode.setPrev(prevNode); 
		   // now clean all fields in the removed node.
		   dTarget.clean();
		   length--;
	}
	
	/**
	 * Prepares every node so that the garbage collector can free 
	 * its memory space, at least from the point of view of the
	 * list. This method is supposed to be used whenever the 
	 * list object is not going to be used anymore. Removes all
	 * physical nodes (data nodes and control nodes, if any)
	 * from the linked list
	 */
	private void destroy() {
		while (header != null) { 
			DNode<E> nnode = header.getNext(); 
			header.clean(); 
			header = nnode; 
		}
	}
	
	/**
	 * The execution of this method removes all the data nodes from
	 * the current instance of the list, leaving it as a valid empty
	 * doubly linked list with dummy header and dummy trailer nodes. 
	 */
	public void makeEmpty() { 
		// TODO
		header.clean();
		trailer.clean();
		length = 0;
	}
		
	protected void finalize() throws Throwable {
	    try {
			this.destroy(); 
	    } finally {
	        super.finalize();
	    }
	}
	
	// The following two methods are to be implemented as part of an exercise
		public Object[] toArray() {
			Object[] arr = new Object[this.length()];
			DNode<E> dNode = (DNode<E>) this.getFirstNode();
			int i = 0;
			while(dNode.getNext() != null)
				arr[i] = dNode.getNext().getElement();
				i++;
			return arr;
		}

		public <T1> T1[] toArray(T1[] array) {
			// TODO as in Exercise 3
			if(array.length < this.length()) {
				array = (T1[]) Array.newInstance(array.getClass().getComponentType(), this.length());
			} else if(array.length > this.length()) {
				for(int i=this.length();i<array.length;i++) {
					array[i] = null;
				}
			}
			DNode<E> dNode = (DNode<E>) this.getFirstNode();
			int i = 0;
			while(dNode.getNext() != null)
				array[i] = (T1) dNode.getNext().getElement();
				i++;
			return array;
		}

}
