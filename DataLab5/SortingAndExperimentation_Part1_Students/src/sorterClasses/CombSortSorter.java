package sorterClasses;

public class CombSortSorter<E> extends AbstractMaxValueSorter<E> {

	public CombSortSorter() {
		super("   Comb Sort");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void relocateMaxValueToLastPositionAmongFirst(int i) {
		
		int gap = i;
		boolean swap = false;
		
		while (gap != 1 || swap == true) {
			
			gap = nextGap(gap);
			swap = false;
			
			for (int j=0; j < i-gap; j++) 
				if (cmp.compare(arr[j], arr[j+gap]) > 0) {
					super.swapArrayElements(j, j+gap);
					swap = true;
				}
		}
		
	}
	
	int nextGap(int gap) {
		
		gap = (gap*10)/13;
		if(gap < 1)
			return 1;
		return gap;
	}

}
