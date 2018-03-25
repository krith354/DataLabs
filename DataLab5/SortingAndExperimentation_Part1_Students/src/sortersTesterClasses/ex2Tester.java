package sortersTesterClasses;

import sorterClasses.BubbleSortSorter;

public class ex2Tester {
	
	public static void main(String[] args) {
		
		Integer[] dataInts = {5, 9, 20, 22, 20, 5, 4, 13, 17, 8, 22, 1, 3, 7, 11, 9, 10};
		
		showArray("Nonsorted Entero Array\n", dataInts);
		
		BubbleSortSorter<Integer> bubbleSort = new BubbleSortSorter<>();
		bubbleSort.sort(dataInts, null);
		
		showArray("Bubble sorted Entero Array\n", dataInts);
		
	}
	
	private static void showArray(String msg, Integer[] a) {
		System.out.print(msg); 
		for (int i=0; i<a.length; i++) 
			System.out.print("\t" + a[i]); 
		System.out.println();
	}
}
