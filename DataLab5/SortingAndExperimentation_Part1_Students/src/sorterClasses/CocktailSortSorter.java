package sorterClasses;

public class CocktailSortSorter<E> extends AbstractMaxValueSorter<E> {

	public CocktailSortSorter() {
		super("   Cocktail Sort");
	}

	@Override
	protected void relocateMaxValueToLastPositionAmongFirst(int i) {
		
		boolean swap = true;
		int first = 0;
		
		while(swap == true) {
			
			swap = false;
			
			for (int j=first; j < i-1; j++) 
				if (cmp.compare(arr[j], arr[j+1]) > 0) {
					super.swapArrayElements(j, j+1);
					swap = true;
				}
			
			if(swap == false)
				break;
			swap = false;
			i = i-1;
			
			for (int j=i-1; j >= first; j--) 
				if (cmp.compare(arr[j], arr[j+1]) > 0) {
					super.swapArrayElements(j, j+1);
					swap = true;
				}
			first++;
		}
		
	}

}
