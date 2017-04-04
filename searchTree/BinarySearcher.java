// File: BinarySearcher.java
// A Java application to illustrate the binary search of an array.
// Additional javadoc documentation is available at
//   http://www.cs.colorado.edu/~main/docs/BinarySearcher.html
 
/******************************************************************************
* The <CODE>BinarySearcher</CODE> Java application runs a small test on the 
* <CODE>search</CODE> method from Chapter 11 (using a binary search to
* find a specified number in an array).
*
* <p><b>Java Source Code for this class:</b>
*   <A HREF="../applications/BinarySearcher.java">
*   http://www.cs.colorado.edu/~main/applications/SimpleSearcher.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class BinarySearcher
{

   /**
   * The main method prints a table of test results, searching for numbers
   * in an array that contains 2, 4, 6, 8, 10, 12, and 14.
   * @param args
   *   not used in this implementation
   **/
   public static void main(String[ ] args)
   {
      final int[ ] DATA = { 2, 4, 6, 8, 10, 12, 14 };
      final int[ ] EMPTY = new int[0];
      final int MINIMUM = -1;
      final int MAXIMUM = 16;
      
      int target;
      int answer;

      System.out.println("Searching for numbers in an array.");
      for (target = MINIMUM; target <= MAXIMUM; target++)
      {
          System.out.print("Is " + target + " in the array? ");
          answer = search(DATA, 0, DATA.length, target);
          if (answer == -1)
             System.out.println("No.");
          else
             System.out.println("Yes, at index [" + answer + "].");
      }
      
      System.out.print("Searching for 0 in an empty array: ");
      if (search(EMPTY, 0, 0, 0) == -1)
         System.out.println(" Not found.");
      else
         System.out.println(" Found!");

      System.out.println("End of searching.");
   }
 
        
   /**
   * Search part of a sorted array for a specified target.
   * @param a
   *   the array to search
   * @param first
   *   the first index of the part of the array to search
   * @param size
   *   the number of elements to search, starting at 
   *   <CODE>a[first]</CODE>
   * @param target
   *   the element to search for
   * <b>Precondition:</b>
   *   If <CODE>size &gt; 0</CODE>, then <CODE>first</CODE> through 
   *   <CODE>first+size-1</CODE> must be valid indexes for the array <CODE>a</CODE>.
   *   Also, starting at <CODE>a[first]</CODE>, the next <CODE>size</CODE> 
   *   elements are sorted in increasing order from small to large.
   * @return
   *   If <CODE>target</CODE> appears in the array segment starting at 
   *   <CODE>a[first]</CODE> and containing <CODE>size</CODE> elements,
   *   then the return value is the index of a location that
   *   contains <CODE>target</CODE>; otherwise the return value is -1.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that some index in the range <CODE>first</CODE>
   *   through <CODE>first+size-1</CODE> is outside the range of
   *   valid indexes for the array <CODE>a</CODE>.
   **/
   public static int search(int[ ] a, int first, int size, int target)
   {
      int middle;

      if (size <= 0)
         return -1;
      else
      {
         middle = first + size/2;
         if (target == a[middle])
            return middle;
         else if (target < a[middle])
            // The target is less than a[middle], so search before the middle.
            return search(a, first, size/2, target);
         else 
            // The target must be greater than a[middle], so search after the middle.
            return search(a, middle+1, (size-1)/2, target);
      } 
   }

}