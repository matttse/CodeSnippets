package src;

import java.util.Arrays;
import java.util.List;

import node.IntArrayBag;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ender_Laptop
 */
public class AnotherLinkedList {
//    public IntArrayBag firstBag = new IntArrayBag();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        List<Integer> firstList = Arrays.asList(36, 92, 10, 55, 23, 5, 106, 88);
        List<Integer> secondList = Arrays.asList(900, 421, 1, 13, 79);
        IntArrayBag firstBag = new IntArrayBag();
        IntArrayBag secondBag = new IntArrayBag();
        IntArrayBag connectorBag = new IntArrayBag();
        for (int i = 0; i < firstList.size(); i++) 
        {
            firstBag.add(firstList.get(i));            
        }
        firstBag.trimToSize();
        
        for (int i = 0; i < secondList.size(); i++) 
        {

            secondBag.add(secondList.get(i));
                        
        }
        secondBag.trimToSize();
        System.out.println("FirstBag");
        firstBag.printBag();
        System.out.println("SecondBag");
        secondBag.printBag();
        System.out.println("LastBag");
        connectorBag.addAll(firstBag);
        connectorBag.addAll(secondBag);
        connectorBag.printBag();
        
        
    }
    
}

//  IntArrayBag bag1 = new IntArrayBag();
//  for (int i=0; i<6; i++)
//         bag1.add(i);
//  bag1.addMany(1,3,5,4,3,5,3,1,6);
//  
//  System.out.println("Bag1 has: ");
//  // print elements in bag 1
//  bag1.printBag();
//  // create bag2 which is a clone of bag1
//  IntArrayBag bag2 = new IntArrayBag();
//  bag2 = bag1.clone();
//  // first, print elements of bag2
//  bag2.printBag();  
//
//  // then, compare bag1 and bag2 using the equals method
//  System.out.println("\nbag1 equals bag2: " + bag1.equals(bag2));
  
  	   
  // modify bag2 using add or remove method and test the equality again
  // you may want to repeat this multiple times with different contents of bag2
  // first, print bag2
  
  
  
  // then, compare bag1 and bag2 using the equals method
//  System.out.println("\nbag1 equals bag2: " + bag1.equals(bag2));
  
  
  