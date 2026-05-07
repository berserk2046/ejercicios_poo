import java.util.Scanner;
import java.lang.Math;

class n{
	public n(double x){
		System.out.println("Area de " + x + ": " + (Math.PI * Math.pow(x,2)));
		System.out.println("Circumferencia de " + x + ": " + (2 * Math.PI * x));
	}
}
public class e5{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Ingrese el radio del circulo: ");
		n x = new n(input.nextDouble());
	}
}
