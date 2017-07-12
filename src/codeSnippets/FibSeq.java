/**
 * 
 */
package codeSnippets;

import java.util.ArrayList;

import dhl.UserInputHandler;

/**
 * @author Matt
 *
 */
public class FibSeq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// instantiate
		int cnt = 0;
		ArrayList<Integer> seq = new ArrayList<Integer>();
		
		// instantiate the handler
		UserInputHandler<String> processInput = new UserInputHandler<String>();
		// terminating value
		cnt = Integer.parseInt(processInput.getNum("Enter Integer number of Fibonacci values to Calc to (starts at 0): ", 0));
		addNumbers(0, 1, cnt/2, cnt, seq);
		int dispCnt = 0;
		while (dispCnt < cnt) {
			System.out.println(seq.get(dispCnt));
			dispCnt = dispCnt + 1;
			
		}

	}
	
	public static void addNumbers(int previous, int current, int trkVal, int cnt, ArrayList<Integer> seq) {
		trkVal = trkVal + 1;
		seq.add(previous);	
		if (previous == 0) {		
			previous = previous + current;
			
		} else {
			seq.add(current);
			previous = previous + current;
			current = previous + current;
			
		}

		while (trkVal <= cnt) {	
			addNumbers(previous, current, trkVal, cnt, seq);			
			break;
		}
		
		
	}


}
