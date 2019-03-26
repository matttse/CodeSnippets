package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import node.IntArrayBag;
import java.util.LinkedList;
import java.util.Set;

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

    // quickSort
  private static int QUICKSORT_CUTOFF = 10;

  public static void setQuicksortCutoff(int cutoff) {
    QUICKSORT_CUTOFF = cutoff;
  }

  public static int getQuicksortCutoff() {
    return QUICKSORT_CUTOFF;
  }

  private static void insertionSort(int[] a, int from, int to) {
    for (int i = from + 1; i < to; ++i) {
      int insert_value = a[i];
      int j;
      for (j = i; j > from; --j) {
        if (a[j - 1] > insert_value) {
          a[j] = a[j - 1];
        }
        else {
          break;
        }
      }
      if (j != i) {
        a[j] = insert_value;
      }
    }
  }

  private static int medianOf3(int a[], int from, int to) {
    int mid = (from + to) / 2;

    ArrayList<Integer> positions = new ArrayList<>(
        Arrays.asList(new Integer[]{from, to - 1, mid})
    );
//    System.out.println(showSelections(a, positions));

    int center = (from + to) / 2;
    int left = from;
    int right = to - 1;

    // do insertionsort on a[left], a[center], a[right]
    if (a[left] > a[center]) {
      int tmp = a[left];
      a[left] = a[center];
      a[center] = tmp;
    }
    // now a[left] <= a[center]
    int insert = a[right];
    if (a[center] > insert) {
      a[right] = a[center];
      if (a[left] > insert) {
        a[center] = a[left];
        a[left] = insert;
      }
      else {
        a[center] = insert;
      }
    }
    System.out.println(arrayPortion(a, from, to) + " pivot = " + a[center]);
    return a[center];
  }

  private static int partition(int[] a, int from, int to) {
    int pivot = medianOf3(a, from, to);
    int i = from, j = to - 1;
    ArrayList<Integer> positions = new ArrayList<>();
    positions.add(i);
    positions.add(j);
//    System.out.println(showSelections(a, positions, "_"));
//    System.out.println(arrayPortion(a, from, to));
    while (true) {
      while (a[++i] < pivot) {
      }
      while (pivot < a[--j]) {
      }
      
      positions.clear();
      positions.add(i);
      positions.add(j);
//      System.out.println(showSelections(a, positions, "_") + "  i = " + i + ", j = " + j);
//      System.out.println(arrayPortion(a, from, to));

      if (i < j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
//        System.out.println(arrayPortion(a, from, to));
      }
      else {              // swap, then advance both
        break;
      }
    }
    return i;
  }

  private static void quickSort(int[] a, int from, int to) {
//    System.out.printf("\n=> quickSort(%d,%d)", from, to);
//    if (to - from <= QUICKSORT_CUTOFF) {
//      System.out.print(" = insertionSort");
//    }
    System.out.println("");
    System.out.println(showIndices(a, from, to));
    System.out.println(arrayPortion(a, from, to));
    if (to - from <= QUICKSORT_CUTOFF) {
      insertionSort(a, from, to);
//      System.out.println(arrayPortion(a, from, to));
    }
    else {

      int i = partition(a, from, to);
      quickSort(a, from, i);
      quickSort(a, i, to);
    }
  }

  public static void quickSort(int[] a) {
    quickSort(a, 0, a.length);
//    System.out.println("\n" + Arrays.toString(a));
  }
 private static String showSelections(int[] a, List<Integer> positions) {
    return showSelections(a, positions, "^");
  }

  private static String showSelections(int[] a, List<Integer> positions, String disp) {
    String output = " ";
    for (int j = 0; j < a.length; ++j) {
      int intlen = Integer.toString(a[j]).length();
      int fieldlen = intlen;
      if (j != 0) {
        fieldlen = intlen + 2;
      }
      String repl = positions.contains(j) ? disp : " ";
      String print = new String(new char[intlen]).replace("\0", repl);
      String format = "%" + fieldlen + "s";
      output += String.format(format, print);
    }
    return output;
  }

  private static String showIndices(int[] array) {
    return showIndices(array, 0, array.length);
  }

  private static String showIndices(int[] array, int from, int to) {
    String output = " ";
    for (int i = 0; i < array.length; ++i) {
      int intlen = Integer.toString(array[i]).length();
      int fieldlen = intlen;
      if (i > 0) {
        fieldlen += 2;
      }
      if (i >= from && i < to) {
        String format = "%" + fieldlen + "d";
        output += String.format(format, i);
      }
      else {
        String format = "%" + fieldlen + "s";
        String print = new String(new char[intlen]).replace("\0", " ");
        output += String.format(format, print);
      }
    }
    return output;
  }

  private static String arrayPortion(int[] array, int from, int to) {
    String output = "";
    for (int i = 0; i < array.length; ++i) {
      if (i == from) {
        output += "[";
      }
      if (i >= from && i < to - 1) {
        output += array[i] + ", ";
      }
      else if (i == to - 1) {
        output += array[i] + "]";
      }
      else {
        int intlen = Integer.toString(array[i]).length();
        output += new String(new char[intlen]).replace("\0", " ");
        output += "  ";
      }
    }
    return output;
  } 
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
        
        Collections.shuffle(connectorBag);
        System.out.println("---Shuffle Complete---");
        for (int i = 0; i < connectorBag.size(); i++) {
            System.out.println("shuffled "+connectorBag.get(i));
        }
        Collections.sort(connectorBag);
        Collections.reverse(connectorBag);        
        System.out.println("---Reverse Sort Complete---");
        for (int i = 0; i < connectorBag.size(); i++) {
            System.out.println("reversed "+connectorBag.get(i));
        }
        Collections.reverse(connectorBag);
        System.out.println("Min = "+connectorBag.peekFirst());// find min
        System.out.println("Max = "+connectorBag.peekLast());// find max
        
    }
    
}

  
  
  
  // then, compare bag1 and bag2 using the equals method
//  System.out.println("\nbag1 equals bag2: " + bag1.equals(bag2));
  
  
  