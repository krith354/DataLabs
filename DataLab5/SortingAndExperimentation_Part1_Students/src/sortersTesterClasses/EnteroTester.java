package sortersTesterClasses;

import dataGenerator.DataGenerator;
import sorterClasses.BubbleSortSorter;

public class EnteroTester { 
		
		public static void main(String[] args) {
			DataGenerator dataGenerator = new DataGenerator(25);
			Integer[] dataInts = dataGenerator.generateData();
			Entero[] newEnteroArr = new Entero[25];
			
			//fill newEnteroArr with data 
			for(int i=0;i<dataInts.length;i++) {
				newEnteroArr[i] = new Entero(dataInts[i]);
			}
			showArray("Nonsorted Entero Array\n", newEnteroArr);
			
			BubbleSortSorter<Entero> bubbleSort = new BubbleSortSorter<>();
			bubbleSort.sort(newEnteroArr, null);
			showArray("Bubble sorted Entero Array\n", newEnteroArr);
			
		}
		
		private static void showArray(String msg, Entero[] a) {
			System.out.print(msg); 
			for (int i=0; i<a.length; i++) 
				System.out.print("\t" + a[i]); 
			System.out.println();
		}

}
