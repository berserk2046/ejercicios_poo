import java.util.Scanner;
import java.lang.Math;

class n{
	public n(double x){
		System.out.println("Cuadrado de " + x + ": " + Math.pow(x,2));
		System.out.println("Cubo de " + x + ": " + Math.pow(x,3));
	}
}
public class e4{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Ingrese un numero: ");
		n x = new n(input.nextDouble());
	}
}
