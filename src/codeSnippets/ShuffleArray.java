package codeSnippets;

public class ShuffleArray<T> {

	//************************************************************* 
	// Declare and fully implement generic method named "shuffle"
	public void shuffle(T[] list) {
		int n = list.length;
		for (int i = 0; i < n; i++) {
			//between i and n - 1
			int replacement = i + (int) (Math.random() * (n-i));
			T temp = (T) list[i];
			list[i] = list[replacement];
			list[replacement] = temp;
		}
		
	}

	
	// Declare and fully implement generic method named "print"
	public void printArray(T[] list) {
		
		int n = list.length;
		for (int i = 0; i < n; i++) {
			System.out.print(list[i].toString() + "\t");
		}
		System.out.println("\n");
		
	}
	
	
	// code to test the generic mewthods
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//*********************************************************************** 
		// create a ShuffleArray object "si" with actual type parameter Integer
		ShuffleArray<Integer> si = new ShuffleArray<Integer>();
		
		
		
		// two integer arrays
		Integer[] a = {1,2,3,4,5,6};
		Integer[] b = {1,2,3,4,5,6,7};
		
		// invoke the shuffle method 
		si.shuffle(a);
		si.shuffle(b);
		
		// print the shuffled arrays
		si.printArray(a);
		si.printArray(b);
		
		//********************************************************************** 
		// create a ShuffleArray object "sd" with actual type parameter Double
		ShuffleArray<Double> sd = new ShuffleArray<Double>();
		
		
		// two double arrays
		Double[] d = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
		Double[] e = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
		
		// invoke the shuffle method
		sd.shuffle(d);
		sd.shuffle(e);
		
		// print the shuffled arrays
		sd.printArray(d);
		sd.printArray(e);
		
		//********************************************************************** 
		// create a ShuffleArray object "sc" with actual type parameter Character
		ShuffleArray<Character> sc = new ShuffleArray<Character>();
		
		
		// two character arrays
		Character[] x = {'a', 'b', 'c', 'd', 'e', 'f'};
		Character[] y = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		
		// invoke the shuffle method
		sc.shuffle(x);
		sc.shuffle(y);
		
		// print the shuffled arrays
		sc.printArray(x);
		sc.printArray(y);
		
	}

}
