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
	//if tree is empty
	if (root == null) {
		//create new node
		root = new IntBTNode(element, null, null);
	} else {//else cont searching new ele
		//add new node to leaf
		IntBTNode newNode = new IntBTNode(element, null, null);
		if (element <= root.getData()) {//recursively search left subtree
			
			if (root.getLeft() == null) {
				root.setLeft(newNode);
			} else {
				IntBTNode cursor = new IntBTNode(root.getData(), root.getLeft(), root.getRight());
				while (cursor.getLeft() != null) {
					cursor = cursor.getLeft();
				}
				if (cursor.getData() >= element) {
					cursor.setLeft(newNode);
				} else {
					cursor.setRight(newNode);
				}
				
			}			
		} else if (element > root.getData()) {//recursively search right subtree
			if (root.getRight() == null) {
				root.setRight(newNode);
			} else {
				IntBTNode cursor = new IntBTNode(root.getData(), root.getLeft(), root.getRight());
				while (cursor.getRight() != null) {
					cursor = cursor.getRight();
				}
				if (cursor.getData() > element) {
					cursor.setLeft(newNode);
				} else {
					cursor.setRight(newNode);
				}
				
			}	
			
		}
//		else if (element == root.getData()){//increment the count and recursively search left subtree
//			if (root.getLeft() == null) {
//				root.setLeft(newNode);
//			} else {
//				IntBTNode cursor = new IntBTNode(root.getLeft().getData(), root.getLeft(), root.getRight());
//				while (cursor.getLeft() != null) {
//					cursor = cursor.getLeft();
//				}
//				cursor.setLeft(newNode);
//			}

//		}
	}


	
	
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
   // Implemented by student.
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
public int countOccurrences(int target)
{
   // Student will replace this return statement with their own code:
   return 0;
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
private boolean remove(int target)
{
   // Student will replace this return statement with their own code:
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
   // Student will replace this return statement with their own code:
   return null;
}

 public static void main(String[ ] args){
		  
		// for testing
		IntTreeBag itb = new IntTreeBag();	   

		itb.add(17);
		itb.add(10);
		itb.add(25);
		itb.add(25);
		itb.add(17);
		itb.add(6);
		itb.add(20);
	   
		itb.root.inorderPrint(); // should print 6 10 17 17 20 25 25
	}
   
}
        