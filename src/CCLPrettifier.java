import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.regex.*;

/**
 * 
 */

/**
 * @author CH165496
 *
 */
public class CCLPrettifier {
	public static String clipboardInput = "";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String output = "";
		
		output = getClipboardVal().toString();
		boolean toutput = processInput(output);
		
		System.out.print(toutput);

	}

	/*
	 * @Name: processInput
	 * 
	 * @Function/Purpose: Validates string input
	 * 
	 * @Parameters: {vc} String input
	 * 
	 * @Additionl Comments: called from validate method
	 * 
	 * @Return true/false based on valid 
	 */
	public static boolean processInput(String cp) {
		String processInput = "";
		String recordStructure = "record";
		
		Pattern pattern = Pattern.compile(recordStructure);
		Matcher matcher = pattern.matcher(cp);
		boolean matches = matcher.matches();
/*
		for (int charCnt = 0; cp.length() > charCnt; charCnt++) {

			// iterate over each char in input as converted to ascii integer
			int charac = (int) cp.charAt(charCnt);

			// look for (A-Z)
			if (charac > 64 && charac < 91) {
				//rebuild string
				processInput += cp.substring(charCnt, charCnt + 1).toLowerCase();
//
//			} else if (charac == 32) {
//
//				processInput = cp.replaceAll("\\s", "");

			} else {

				// Invalid char a-z/A-Z
				processInput += cp.substring(charCnt, charCnt + 1);


			}
		} // end for loop
		*/

		return matches;

	}// end method
	
	/**
	 * @param args
	 * @return 
	 */
	public static Object getClipboardVal() {
		// instantiate toolkit
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// instantiate clipboard
		Clipboard clipboard = toolkit.getSystemClipboard();
		Object clipboardInput = "";
		try {
			clipboardInput = clipboard.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException e) {
			System.out.print("Error");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		if (clipboardInput != null) {
			return (clipboardInput);
		} else {
			clipboardInput = "Invalid Copy Method";
			return clipboardInput;	
		}

	}

}
