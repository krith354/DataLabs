import java.util.Scanner;

public class calcAreaOfCircle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the radius of the circle you wish to calculates its area: ");
		double radius = input.nextDouble();
		double area = Math.pow(radius, 2) * Math.PI;
		System.out.println("Area of the circle: " + area);
	}

}
