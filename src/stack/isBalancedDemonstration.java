package stack;

//FILE: IsBalancedDemonstration.java
//This small demonstration program showing the isBalanced method, which uses 
//a stack of characters to determine whether a string has balanced
//parentheses. 

import java.util.Stack;
import java.util.Scanner;

public class isBalancedDemonstration
{

	public static void main(String[ ] args)
	{
	   Scanner stdin = new Scanner(System.in);
	   String expression;
	   
	   System.out.println("Please type a string containing various kinds");
	   System.out.println("of parentheses ( ) { } [ ]. I'll check whether");
	   System.out.println("the parentheses are balanced.");
	
	   do
	   {
		 System.out.print("Your string: ");
	      expression = stdin.nextLine( );
	      if (isBalanced(expression))
	         System.out.println("That is balanced.");
	      else
	         System.out.println("That is not balanced.");
	   }
	   while (query(stdin, "Another string?"));
	
	   System.out.println("Thanks for that balancing act.");
	}
	
	public static boolean query(Scanner input, String prompt)
	{
	   String answer;
		
	   System.out.print(prompt + " [Y or N]: ");
	   answer = input.nextLine( ).toUpperCase( );
	   while (!answer.startsWith("Y") && !answer.startsWith("N"))
	   {
		 System.out.print("Invalid response. Please type Y or N: ");
		 answer = input.nextLine( ).toUpperCase( );
	   }
	
	   return answer.startsWith("Y");
	}
	  
	public static boolean isBalanced(String expression)
// Postcondition: A true return value indicates that the parentheses in the
// given expression are balanced. Otherwise the return value is false.
// Note that characters other than ( ) { } and [ ] are ignored.
{
   // Meaningful names for characters
   final char LEFT_NORMAL  = '(';
   final char RIGHT_NORMAL = ')';
   final char LEFT_CURLY   = '{';
   final char RIGHT_CURLY  = '}';
   final char LEFT_SQUARE  = '[';
   final char RIGHT_SQUARE = ']';
   
   Stack<Character> store = new Stack<Character>( ); // Stores parens
   int i;                              // An index into the string
   boolean failed = false;             // Change to true for a mismatch
   
   for (i = 0; !failed && (i < expression.length( )); i++)
   {
      switch (expression.charAt(i))
      {
         case LEFT_NORMAL:
         case LEFT_CURLY:
         case LEFT_SQUARE: 
            store.push(expression.charAt(i));
            break;
         case RIGHT_NORMAL:
            if (store.isEmpty( ) || (store.pop( ) != LEFT_NORMAL))
               failed = true;
            break;
         case RIGHT_CURLY:
            if (store.isEmpty( ) || (store.pop( ) != LEFT_CURLY))
               failed = true;
            break;
         case RIGHT_SQUARE:
            if (store.isEmpty( ) || (store.pop( ) != LEFT_SQUARE))
               failed = true;
            break;
      }
   }
   
   return (store.isEmpty( ) && !failed);
}

}