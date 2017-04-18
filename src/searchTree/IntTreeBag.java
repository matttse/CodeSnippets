package searchTree;

//File: IntTreeBag.java from the package edu.colorado.collections

//The implementation of most methods in this file is left as a student
//exercise from Section 9.5 of "Data Structures and Other Objects Using Java"

//Check with your instructor to see whether you should put this class in
//a package. At the moment, it is declared as part of edu.colorado.collections:

import nodes.IntBTNode; 

/******************************************************************************
* This class is a homework assignment;
* An <CODE>IntTreeBag</CODE> is a collection of int numbers.
*
* <b>Limitations:</b> 
*   Beyond <CODE>Integer.MAX_VALUE</CODE> elements, <CODE>countOccurrences</CODE>,
*   and <CODE>size</CODE> are wrong. 
*
* <b>Outline of Java Source Code for this class:</b>
*   <A HREF="../../../../edu/colorado/collections/IntTreeBag.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/IntTreeBag.java
*   </A>
*
* <b>Note:</b>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* @version Feb 10, 2016
*
* @see IntArrayBag
* @see IntLinkedBag
******************************************************************************/
public class IntTreeBag implements Cloneable
{
// Invariant of the IntTreeBag class:
//   1. The elements in the bag are stored in a binary search tree.
//   2. The instance variable root is a reference to the root of the
//      binary search tree (or null for an empty tree).
private IntBTNode root;   


/**
* Insert a new element into this bag.
* @param element
*   the new element that is being inserted
* <b>Postcondition:</b>
*   A new copy of the element has been added to this bag.
* @exception OutOfMemoryError
*   Indicates insufficient memory a new IntBTNode.
**/
public void add(int element)
{
	boolean done = false;
	//if tree is empty
	if (root == null) {
		//create new node
		root = new IntBTNode(element, null, null);
	} else {//else cont searching new ele
		//add new node to leaf
		IntBTNode newNode = new IntBTNode(element, null, null);
		IntBTNode cursor = new IntBTNode(root.getData(), root.getLeft(), root.getRight());
		while (done == false) {
			if (element <= root.getData()) {//recursively search left subtree				
				if (root.getLeft() == null) {//check left child null
					root.setLeft(newNode);//create new node
					done = true;
				} else {//cont search left	
					
					if (element <= cursor.getData()) {//set smaller element to the left of this cursor
						if (cursor.getLeft() == null) {
							cursor.setLeft(newNode);//create new node
							done = true;//exit
						} else {//iterate cursor
							cursor = cursor.getLeft();
						}	
					} else {//scan right side of this cursor
						if (cursor.getRight() == null) {
							cursor.setRight(newNode);//create new node
							done = true;//exit
						} else {//iterate cursor
							cursor = cursor.getRight();
						}					
					}//end left search					
				}
			
			} else {//recursively search right subtree
				if (root.getRight() == null) {//check left child null
					root.setRight(newNode);//create new node
					done = true;
				} else {//cont search left
					if (element <= cursor.getData()) {//set smaller element to the left of this cursor
						if (cursor.getLeft() == null) {
							cursor.setLeft(newNode);//create new node
							done = true;//exit
						} else {//iterate cursor
							cursor = cursor.getLeft();
						}	
					} else {//scan right side of this cursor
						if (cursor.getRight() == null) {
							cursor.setRight(newNode);//create new node
							done = true;//exit
						} else {//iterate cursor
							cursor = cursor.getRight();
						}						
					}					
				}//end left search	
				
			}//left or right tree check
		}//done while loop
	}//empty tree check
}


/**
* Add the contents of another bag to this bag.
* @param addend
*   a bag whose contents will be added to this bag
* <b>Precondition:</b>
*   The parameter, <CODE>addend</CODE>, is not null.
* <b>Postcondition:</b>
*   The elements from <CODE>addend</CODE> have been added to this bag.
* @exception IllegalArgumentException
*   Indicates that <CODE>addend</CODE> is null.
* @exception OutOfMemoryError
*   Indicates insufficient memory to increase the size of the bag.
**/
public void addAll(IntTreeBag addend)
{
    IntBTNode addroot;

    if (addend == null)
    {
       throw new IllegalArgumentException("Null addend");
    }
	if (root == addend.root) {
		//addend is the same as the bag that activated this method
		addroot = IntBTNode.treeCopy(addend.root);
		addTree(addroot);
	} else {
		addTree(addend.root);
	}
}

//precondition: addroot is a reference to the root of a binary search tree
//that is separate from the binary search tree of the bag that activated
//this method
//postcondition: all the elements from the addroot's binary search tree
//have been added to the binary search tree of the bag that actvated this
//method
private void addTree(IntBTNode addroot) {
	if(addroot != null) {
		add(addroot.getData());		
		//make recusrive call to add all of addroots left subtree
		if (addroot.getLeft() != null)
			addTree(addroot.getLeft());//pass back IntBTNode
		//make recusrive call to add all of addroots right subtree
		if (addroot.getRight() != null)
			addTree(addroot.getRight());//pass back IntBTNode
	
	}
}

/**
* Generate a copy of this bag.
* @return
*   The return value is a copy of this bag. Subsequent changes to the
*   copy will not affect the original, nor vice versa. Note that the return
*   value must be type cast to an <CODE>IntTreeBag</CODE> before it can be used.
* @exception OutOfMemoryError
*   Indicates insufficient memory for creating the clone.
**/ 
public Object clone( )
{  // Clone an IntTreeBag object.
   // Student will replace this return statement with their own code:
   return null; 
}


/**
* Accessor method to count the number of occurrences of a particular element
* in this bag.
* @param target
*   the element that needs to be counted
* @return
*   the number of times that <CODE>target</CODE> occurs in this bag
**/
public int countOccurrences(int target) {
	int count = 0;

	boolean done = false;
	//if tree is empty
	if (root == null) {
		//create new node
		return count;
	} else {//else continue searching new target
		IntBTNode cursor = new IntBTNode(root.getData(), root.getLeft(), root.getRight());
		while (done == false) {							
			if (cursor == null) {//case 1: cursor is null
				done = true;
			} else if (target < cursor.getData()) {//case 2: target smaller than data at cursor node
				cursor = cursor.getLeft();
			} else if (target > cursor.getData()) {//case 3: target larger than data at cursor node
				cursor = cursor.getRight();
			} else if (target == cursor.getData()) {//case 4: equal increment count
				count++;
				cursor = cursor.getLeft();
			}
		}//done while loop
	}//empty tree check
   return count;
}

          
/**
* Remove one copy of a specified element from this bag.
* @param target
*   the element to remove from the bag
* <b>Postcondition:</b>
*   If <CODE>target</CODE> was found in the bag, then one copy of
*   <CODE>target</CODE> has been removed and the method returns true. 
*   Otherwise the bag remains unchanged and the method returns false. 
**/
private boolean remove(int target) {
	IntBTNode cursor = root;
	IntBTNode parentOfCursor = null;
	//case 1: cursor is null
	if (root == null || cursor == null) {//skip all searching and return false
		return false;
	} else {
		while (target != cursor.getData()) {
			if (target <= root.getData()) {//search left tree
				if (target <= cursor.getData()) {//cont searching downwards
					parentOfCursor = cursor;
					cursor = cursor.getLeft();
				} else {//cont searching downwards
					parentOfCursor = cursor;
					cursor = cursor.getRight();
				}
			}
		}//check left tree or right tree 			
	
	
		if (target == cursor.getData()) {
			
			if (cursor == root && cursor.getLeft() == null) {//case 2: cursor at root, and no left child
				root = root.getRight();
				return true;
			
			} else if (cursor.getLeft() == null) {//case 3: cursor has no left child and is below root
				if (cursor == parentOfCursor.getLeft()) {
					//cursor on left side of parent
					//change parents left link
					parentOfCursor.setLeft(cursor.getRight());
				} else {
					//cursor on right side of parent
					//change parents right link
					parentOfCursor.setRight(cursor.getRight());
				}
				return true;
			
			} else if (cursor != null && cursor.getLeft() != null) {//case 4: cursor non-null and cursor has left child
				cursor.setData(cursor.getLeft().getRightmostData());//sets data in cursor to rightmost ele in left tree
				cursor.setLeft(cursor.getLeft().removeRightmost());//remove "extra"/original copy from tree					
				return true;
			}
		}
		
	}//check root null
	return false;

	
}

   
/**
* Determine the number of elements in this bag.
* @return
*   the number of elements in this bag
**/                           
public int size( )
{
   return IntBTNode.treeSize(root);
}


/**
* Create a new bag that contains all the elements from two other bags.
* @param b1
*   the first of two bags
* @param b2
*   the second of two bags
* <b>Precondition:</b>
*   Neither b1 nor b2 is null.
* @return
*   the union of b1 and b2
* @exception IllegalArgumentException
*   Indicates that one of the arguments is null.
* @exception OutOfMemoryError
*   Indicates insufficient memory for the new bag.
**/   
public static IntTreeBag union(IntTreeBag b1, IntTreeBag b2)
{
   IntTreeBag newBag = new IntTreeBag();
   newBag.addTree(b1.root);
   newBag.addTree(b2.root);
   return null;
}

 public static void main(String[ ] args){
		  
		// for testing
		IntTreeBag itb = new IntTreeBag();	   
		
		itb.add(17);
		itb.add(10);
		itb.add(25);
		itb.add(25);
//		itb.add(17);
		itb.add(6);
		itb.add(20);
		itb.add(16);
//		itb.remove(25);
//		itb.remove(25);
//		itb.remove(6);
		itb.remove(17);
		itb.root.preorderPrint();
		
//		itb.root.inorderPrint(); // should print 6 10 17 17 20 25 25
//		System.out.println(itb.countOccurrences(6));
		//IntTreeBag itbTwo = new IntTreeBag();
		
		//itbTwo.addAll(itb);	   
//		itbTwo.root.inorderPrint(); // should print 6 10 17 17 20 25 25
		
		//System.out.println(union(itb, itbTwo));
		
		
		
	}
   
}
        