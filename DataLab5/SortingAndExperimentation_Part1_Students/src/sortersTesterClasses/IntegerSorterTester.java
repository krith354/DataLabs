package sortersTesterClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import sorterClasses.BubbleSortSorter;
import sorterClasses.CocktailSortSorter;
import sorterClasses.CombSortSorter;
import sorterClasses.HeapSortSorter;
import sorterClasses.InsertionSortSorter;
import sorterClasses.SelectionSortSorter;
import interfaces.Sorter;

public class IntegerSorterTester {
	//private static Sorter<Integer> sorter; 
	private static Random rnd; 
	private static ArrayList<Sorter<Integer>> sortersList = new ArrayList<>(); 
	
	public static void main(String[] args) { 
		//Framework
		System.out.println("Choose one of these sorting algorithms (type the number): ");
		System.out.println("1. Bubble Sort\n2. Selection Sort\n3. Insertion Sort\n4. Heap Sort\n5. Comb Sort\n6. Cocktail Sort");
		Scanner input = new Scanner(System.in);
		int opt = input.nextInt();
		if(opt>6 || opt<0) {
			System.out.print("Please enter a number between 1 and 6: ");
			while(opt>6 && opt<0) {
				opt = input.nextInt();
			}
		}
		sortersList.add(new BubbleSortSorter<Integer>()); 
		sortersList.add(new SelectionSortSorter<Integer>()); 
		sortersList.add(new InsertionSortSorter<Integer>()); 
		sortersList.add(new HeapSortSorter<Integer>()); 
		sortersList.add(new CombSortSorter<Integer>()); 
		sortersList.add(new CocktailSortSorter<Integer>()); 
		
		test("Sorting Using Default Comparator<Integer>", null, opt); 
		test("Sorting Using IntegerComparator1", new IntegerComparator1(), opt); 
		test("Sorting Using IntegerComparator2", new IntegerComparator2(), opt); 
	}
	
	private static void test(String msg, Comparator<Integer> cmp, int opt) { 
		rnd = new Random(101); 

		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");
		
		Integer[] original, arr; 
		// generate random arrays is size i and test...
		for (int i=1; i<=20; i += 5) { 
			original = randomValues(i);
			showArray("\n ---Original array of size " + i + " to sort:", original);
			//framework
			Sorter<Integer> sorter = sortersList.get(opt-1); 
		    arr = original.clone(); 
		    sorter.sort(arr, cmp);
		    showArray(sorter.getName() + ": ", arr); 
		}
	}

	private static void showArray(String msg, Integer[] a) {
		System.out.print(msg); 
		for (int i=0; i<a.length; i++) 
			System.out.print("\t" + a[i]); 
		System.out.println();
	}

	private static Integer[] randomValues(int i) {
		Integer[] a = new Integer[i]; 
		for (int j=0; j<i; j++) 
			a[j] = rnd.nextInt(100); 
		return a;
	}

}
