import java.util.ArrayList;
import java.util.Scanner;

public class NRequests {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of requests: ");
		int N = input.nextInt();
		
		int count = 0;
		ArrayList<Integer> arrLs = new ArrayList<>();
		
		while(count != N) {
			int requestType = input.nextInt();
			if(requestType > 3 || requestType <= 0){
				System.out.println("Please enter options: 1, 2, or 3");
			} else if(requestType == 1) {
				System.out.println(putAtEnd(arrLs, input.nextInt()));
				count++;
			  } else if(requestType == 2) {
				  System.out.println(removeAllYs(arrLs, input.nextInt()));
				  count++;
			    } else if(requestType == 3) {
			    	System.out.println(arrLs.size());
					count++;
			      }
			}
		System.out.println("You are out of requests!");
	}
	
	public static ArrayList<Integer> putAtEnd(ArrayList<Integer> newArrLs, int X) {
		
		newArrLs.add(newArrLs.size(), X);
		return newArrLs;
	}
	
	public static ArrayList<Integer> removeAllYs(ArrayList<Integer> newArrLs, int Y) {
		
		for(int i=0; i < newArrLs.size(); i++) {
			if(newArrLs.get(i) == Y) {
				newArrLs.remove(i);
			}
		}
		
		return newArrLs;
	}
}
