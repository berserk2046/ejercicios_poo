import java.lang.Math;

public class e2{
	public static void main(String[] args){
		double suma = 0, x = 20, y = 40;
		suma = suma + x;
		x = x + Math.pow(y,2);
		suma = suma + x/y;
		System.out.println("El valor de la suma es: " + suma);
	}
}
