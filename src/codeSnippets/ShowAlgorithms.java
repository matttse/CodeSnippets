package codeSnippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShowAlgorithms {

  // selectionSort
  public static void selectionSort(int[] a) {
    System.out.println(showIndices(a));
    System.out.println(Arrays.toString(a));

    for (int i = 0; i < a.length - 1; ++i) {
      int selected_index = i;
      for (int j = i + 1; j < a.length; ++j) {
        if (a[j] < a[selected_index]) {
          selected_index = j;
        }
      }

      System.out.println(showSelections(a,
          Arrays.asList(new Integer[]{i, selected_index})));

      if (selected_index != i) {
        // swap a[i] and a[selected_index]
        int tmp = a[i];
        a[i] = a[selected_index];
        a[selected_index] = tmp;
      }

      System.out.println(Arrays.toString(a));
    }
  }

  // insertionSort
  public static void insertionSort(int[] a) {
    System.out.println(showIndices(a));
    System.out.println(Arrays.toString(a));
    for (int i = 1; i < a.length; ++i) {
      System.out.println(showSelections(a,
          Arrays.asList(new Integer[]{i})));
      int insert_value = a[i];
      int j;
      for (j = i; j > 0; --j) {
        if (a[j - 1] > insert_value) {
          a[j] = a[j - 1];
          System.out.println(Arrays.toString(a));
        }
        else {
          break;
        }
      }
      if (j != i) {
        System.out.println(showSelections(a,
            Arrays.asList(new Integer[]{j}), "-"));
        a[j] = insert_value;
      }
      System.out.println(Arrays.toString(a));
    }
  }

  // shellSort
  private static LinkedList<Integer> shellSortIncrements = null;

  public static void setShellSortIncrements(
      LinkedList<Integer> shellSortIncrements) {
    ShowAlgorithms.shellSortIncrements = shellSortIncrements;
  }

  public static void shellSort(int[] a) {
    int size = a.length;

    if (shellSortIncrements == null) {
      // set increments to the default
      shellSortIncrements = new LinkedList<>();
      for (int inc = 1; inc < size; inc = 2 * (inc + 1) - 1) {
        shellSortIncrements.add(inc);
      }
    }
    Iterator<Integer> iter = shellSortIncrements.descendingIterator();

    while (iter.hasNext()) {
      int gap = iter.next();
      for (int k = 0; k < gap; ++k) {
        if (k + gap >= a.length) {
          continue;
        }

        ArrayList<Integer> positions = new ArrayList<>();
        int next = k;
        do {
          positions.add(next);
          next += gap;
        }
        while (next < a.length);
        System.out.println(showIndices(a));
        System.out.println(Arrays.toString(a));
        System.out.println(showSelections(a, positions));

        // insertionSort on ( a[k], a[k+gap], ...  )
        for (int i = k + gap; i < a.length; i += gap) {

          int insert_value = a[i];
          int j = i;
          for (; j >= k + gap; j -= gap) {

            if (a[j - gap] > insert_value) {

              a[j] = a[j - gap];
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
    }
    System.out.println(Arrays.toString(a));
  }

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
    System.out.println(showSelections(a, positions));

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
    System.out.println(showSelections(a, positions, "_"));
    System.out.println(arrayPortion(a, from, to));
    while (true) {
      while (a[++i] < pivot) {
      }
      while (pivot < a[--j]) {
      }
      
      positions.clear();
      positions.add(i);
      positions.add(j);
      System.out.println(showSelections(a, positions, "_") + "  i = " + i + ", j = " + j);
      System.out.println(arrayPortion(a, from, to));

      if (i < j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        System.out.println(arrayPortion(a, from, to));
      }
      else {              // swap, then advance both
        break;
      }
    }
    return i;
  }

  private static void quickSort(int[] a, int from, int to) {
    System.out.printf("\n=> quickSort(%d,%d)", from, to);
    if (to - from <= QUICKSORT_CUTOFF) {
      System.out.print(" = insertionSort");
    }
    System.out.println("");
    System.out.println(showIndices(a, from, to));
    System.out.println(arrayPortion(a, from, to));
    if (to - from <= QUICKSORT_CUTOFF) {
      insertionSort(a, from, to);
      System.out.println(arrayPortion(a, from, to));
    }
    else {

      int i = partition(a, from, to);
      quickSort(a, from, i);
      quickSort(a, i, to);
    }
  }

  public static void quickSort(int[] a) {
    quickSort(a, 0, a.length);
    System.out.println("\n" + Arrays.toString(a));
  }

  // mergeSort
  public static void mergeSort(int[] a, int from, int to) {

    int[] b = new int[a.length];

    boolean merge_to_a = true;  // merge direction: final merge => a

    mergeSort(a, b, merge_to_a, from, to);
  }

  private static void merge(
      int[] source, int[] target, int from, int middle, int to) {

    int i = from, j = middle, // source indices in from array
        k = from;             // target index in to array

    while (i < middle || j < to) {
      if (i == middle) {
        target[k++] = source[j++];
      }
      else if (j == to) {
        target[k++] = source[i++];
      }
      else {
        if (source[i] <= source[j]) { // "<=" gives stability
          target[k++] = source[i++];
        }
        else {
          target[k++] = source[j++];
        }
      }
    }
  }

  // private helper function
  private static void mergeSort(
      int[] a, int[] b, boolean merge_to_a, int from, int to) {

    if (to - from == 0) {
      return;
    }
    if (to - from == 1) {
      if (!merge_to_a) { // must end up in b
        b[from] = a[from];
        System.out.println("b:" + arrayPortion(a, from, to));
      }
      return;
    }
    // recursively sort halves merging in the opposite direction

    int middle = (to + from) / 2;
    mergeSort(a, b, !merge_to_a, from, middle);
    mergeSort(a, b, !merge_to_a, middle, to);

    // merge in the direction indicated by merge_to_a
    int[] source, target;
    if (merge_to_a) {
      source = b;
      target = a;
    }
    else {
      source = a;
      target = b;
    }

    merge(source, target, from, middle, to);
    System.out.println((merge_to_a ? "a:" : "b:") + arrayPortion(target, from, to));
  }

  public static void mergeSort(int[] a) {
    System.out.println("  " + showIndices(a));
    System.out.println("a:" + Arrays.toString(a));
    mergeSort(a, 0, a.length);
  }

  // heapSort
  private static void heapSort(int[] a, int from, int to) {
    class ShowHeap {
      int from;
      int[] data;
      Integer markedPos;
      String indentString = "   ";

      ShowHeap(int[] data, int from) {
        this.data = data;
        this.from = from;
      }

      void setMarkedPos(Integer markedPos) {
        this.markedPos = markedPos;
      }

      void setIndentString(String indentString) {
        this.indentString = indentString;
      }

      void reverseInorderOutput(int upTo) {
        reverseInorderOutput(from, upTo, 0);
      }

      void reverseInorderOutput(int pos, int upTo, int level) {
        if (pos <= upTo) {
          int nodePos = pos - from + 1;
          int lchildPos = 2 * nodePos + from - 1;
          int rchildPos = 2 * nodePos + from;
          reverseInorderOutput(rchildPos, upTo, level + 1);

          System.out.print(
              new String(new char[level]).replace("\0", indentString) + data[pos]
          );

          if (markedPos != null && pos == markedPos) {
            System.out.print("*");
            markedPos = null;
          }
          System.out.println();
          reverseInorderOutput(lchildPos, upTo, level + 1);
        }
      }
    }

    ShowHeap showheap = new ShowHeap(a, from);

    //showheap.reverseInorderOutput(toIndex-1);
    int start = (to - from) / 2;
    showheap.setMarkedPos(from + start - 1);
    showheap.reverseInorderOutput(to - 1);
    String spacer 
        = new String(new char[Arrays.toString(a).length()]).replace("\0", "-");
    while (start > 0) {
      System.out.println(spacer);
      int heapInd = start;
      int par = from + heapInd - 1;
      int insert = a[par];
      int j = to;
      int lchild = par + heapInd;
      int rchild = lchild + 1;
      while (true) {
        if (lchild > j - 1) { // par is a leaf
          break;
        }
        int child;  // child with the largest value

        if (lchild == j - 1) {
          // i has only a left child
          child = lchild;
          heapInd = 2 * heapInd;
        }
        else {
          if (a[lchild] >= a[rchild]) {
            // 2 children with bigger or equal left
            child = lchild;
            heapInd = 2 * heapInd;
          }
          else {
            // 2 children with smaller right
            child = rchild;
            heapInd = 2 * heapInd + 1;
          }
        }
        if (insert >= a[child]) {
          break;
        }
        else {
          a[par] = a[child];  // shift child up
        }
        par = from + heapInd - 1;
        lchild = par + heapInd;
        rchild = lchild + 1;
      }
      a[par] = insert;
      --start;
      showheap.setMarkedPos(from + start - 1);
      showheap.reverseInorderOutput(to - 1);
    }

    System.out.println("\n" + Arrays.toString(a));

    System.out.println("\n------------- buildHeap complete\n");

    // move the heap top a[fromIndex] (greatest element)
    // into position a[j] and reinsert a[j]
    for (int j = to - 1; j > from; --j) {
      int insert = a[j];
      a[j] = a[from];
      int heapInd = 1;

      int par = from + heapInd - 1;
      int lchild = par + heapInd;
      int rchild = lchild + 1;
      while (true) {
        if (lchild > j - 1) { // par is a leaf
          break;
        }
        int child;  // child with the largest value

        if (lchild == j - 1) {
          // i has only a left child
          child = lchild;
          heapInd = 2 * heapInd;
        }
        else {
          if (a[lchild] >= a[rchild]) {
            // 2 children with bigger or equal left
            child = lchild;
            heapInd = 2 * heapInd;
          }
          else {
            // 2 children with smaller right
            child = rchild;
            heapInd = 2 * heapInd + 1;
          }
        }
        if (insert >= a[child]) {
          break;
        }
        else {
          a[par] = a[child];  // shift child up
        }
        par = from + heapInd - 1;
        lchild = par + heapInd;
        rchild = lchild + 1;
      }
      a[par] = insert;

      System.out.println("" + ShowAlgorithms.arrayPortion(a, from, to));
      ArrayList<Integer> pos = new ArrayList<>(
          Arrays.asList(new Integer[]{j})
      );
      System.out.println("" + ShowAlgorithms.showSelections(a, pos));
      showheap.reverseInorderOutput(j - 1);
      System.out.println();
    }
  }

  public static void heapSort(int[] a) {
    System.out.println(Arrays.toString(a) + "\n");
    heapSort(a, 0, a.length);
    System.out.println("\n" + Arrays.toString(a));
  }

  // ============================================
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
//    String output = " ";
//    for (int i = 0; i < array.length; ++i) {
//      int fieldlen = Integer.toString(array[i]).length();
//      if (i > 0) {
//        fieldlen += 2;
//      }
//      String format = "%" + fieldlen + "d";
//      output += String.format(format, i);
//    }
//    return output;
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

}
