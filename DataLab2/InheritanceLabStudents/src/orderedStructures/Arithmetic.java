package orderedStructures;

import interfaces.Combinable;

public class Arithmetic extends Progression implements Combinable {
	private double commonDifference; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
	}
	
	@Override
	public double nextValue() {
		try {
			super.firstValue();
		}
		catch(IllegalStateException e) {
			e.getMessage();
		}
		current = current + commonDifference; 
		return current;
	}
	
	@Override
	public String toString() {
		return "Arith(" + (int)this.firstValue() + "," + (int)this.commonDifference + ")"; 
	}
	
	public double getTerm(int n) throws IndexOutOfBoundsException { 
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 
		double value = this.firstValue() + (n-1)*this.commonDifference;
		return value;
	}
	
	public boolean equals(Object o) {
		return ((Arithmetic) o).firstValue() == this.firstValue() && ((Arithmetic) o).commonDifference == this.commonDifference;
	}

	@Override
	public Progression add(Progression p) {
		// TODO Auto-generated method stub
		return new Arithmetic(((Arithmetic) p).firstValue() + this.firstValue(), ((Arithmetic) p).commonDifference + this.commonDifference);
	}

	@Override
	public Progression subtract(Progression p) {
		// TODO Auto-generated method stub
		return new Arithmetic(((Arithmetic) p).firstValue() - this.firstValue(), Math.abs(((Arithmetic) p).commonDifference - this.commonDifference));
	}

}
