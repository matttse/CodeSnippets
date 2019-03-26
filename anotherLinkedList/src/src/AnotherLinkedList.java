package src;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tsemd
 */
public class AnotherLinkedList {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        // import test data
        List<Integer> firstList = Arrays.asList(36, 92, 10, 55, 23, 5, 106, 88);
        List<Integer> secondList = Arrays.asList(900, 421, 1, 13, 79);
        // instantiate bags
//        IntArrayBag firstBag = new IntArrayBag();
//        IntArrayBag secondBag = new IntArrayBag();
//        IntArrayBag connectorBag = new IntArrayBag();
        LinkedList<Integer> firstBag = new LinkedList<Integer>();
        LinkedList<Integer> secondBag = new LinkedList<Integer>();
        LinkedList<Integer> connectorBag = new LinkedList<Integer>();
        // loop into first test list
        for (int i = 0; i < firstList.size(); i++) 
        {   // add to first bag
            firstBag.add(firstList.get(i));            
        }
                
        // loop into second test list
        for (int i = 0; i < secondList.size(); i++) 
        {   // add to second bag
            secondBag.add(secondList.get(i));
                        
        }
        // print statements
        System.out.println("---First Bag---");
        for (int i = 0; i < firstBag.size(); i++) {
            System.out.println(firstBag.get(i));// print statements
            
        }
        System.out.println("---Second Bag---");
        for (int i = 0; i < secondBag.size(); i++) {
            System.out.println(secondBag.get(i));// print statements
            
        }
        // add values to 3rd bag
        connectorBag.addAll(firstBag);
        connectorBag.addAll(secondBag);
        System.out.println("--Third Bag---");
        for (int i = 0; i < connectorBag.size(); i++) {
            System.out.println("unsorted union Bag "+connectorBag.get(i));// print statements
        }
        Collections.sort(connectorBag);//ascending sort
        System.out.println("---Ascended Sort Complete---");
        for (Iterator<Integer> iterator = connectorBag.iterator(); iterator.hasNext();) {
            Integer next = iterator.next();
            System.out.println("sorted ascending "+next);
        }
        // shuffle
        Collections.shuffle(connectorBag);
        System.out.println("---Shuffle Complete---");
        for (int i = 0; i < connectorBag.size(); i++) {
            System.out.println("shuffled "+connectorBag.get(i));
        }
        // sort then reverse
        Collections.sort(connectorBag);
        Collections.reverse(connectorBag);        
        System.out.println("---Reverse Sort Complete---");
        for (int i = 0; i < connectorBag.size(); i++) {
            System.out.println("reversed "+connectorBag.get(i));
        }
        Collections.reverse(connectorBag);//re reverse
        System.out.println("Min = "+connectorBag.peekFirst());// find min
        System.out.println("Max = "+connectorBag.peekLast());// find max
        
    }
    
}
