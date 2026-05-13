import java.util.Scanner;
import java.lang.Math;

class Circulo{
	int radio;
	Circulo(int radio){
		this.radio = radio;
	}
	double calcular_area(){
		return Math.PI*Math.pow(radio,2);
	}
	double calcular_perimetro(){
		return Math.PI*2*radio;
	}
}
class Rectangulo{
	int base, altura;
	Rectangulo(int base, int altura){
		this.base = base;
		this.altura = altura;
	}
	double calcular_area(){
		return base * altura;
	}
	double calcular_perimetro(){
		return (2*base) + (2*altura);
	}
}

class Cuadrado {
	int lado;
	public Cuadrado(int lado){
		this.lado = lado;
	}
	double calcular_area(){ return lado*lado; }
	double calcular_perimetro(){ return 4*lado; }
}
class TrianguloRectangulo{
	int base, altura;
	public TrianguloRectangulo(int base, int altura){
		this.base = base;
		this.altura = altura;
	}
	double calcular_area(){ return (base*altura/2); }
	double calcular_perimetro(){ return (base+altura+calcular_hipotenusa()); }
	double calcular_hipotenusa(){ return Math.pow(base*base + altura*altura, 0.5); }
	void determinar_triangulo(){
		if((base == altura) && (base == calcular_hipotenusa()) && (altura == calcular_hipotenusa()))
			System.out.println("Es un triangulo equilatero");
		else if((base!=altura) && (base!=calcular_hipotenusa()) && (altura != calcular_hipotenusa()))
			System.out.println("Es un trangulo escaleno");
		else
			System.out.println("Es isoceles");
	}
}

class Rombo {
    int diagonalMayor, diagonalMenor, lado;

    public Rombo(int diagonalMayor, int diagonalMenor, int lado) {
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
        this.lado = lado;
    }

    double calcular_area() {
        return (double) (diagonalMayor * diagonalMenor) / 2;
    }

    double calcular_perimetro() {
        return 4 * lado;
    }
}

class Trapecio {
    int baseMayor, baseMenor, altura, lado1, lado2;
    public Trapecio(int baseMayor, int baseMenor, int altura, int lado1, int lado2) {
        this.baseMayor = baseMayor;
        this.baseMenor = baseMenor;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

	double calcular_area(){
        return (double) ((baseMayor + baseMenor) * altura) / 2;
	}
    double calcular_perimetro() {
        return baseMayor + baseMenor + lado1 + lado2;
    }
}

public class e4{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el radio del circulo: ");
        Circulo figura1 = new Circulo(sc.nextInt());

        System.out.print("Ingrese la base del rectangulo: ");
        int base = sc.nextInt();
        System.out.print("Ingrese la altura del rectangulo: ");
        int altura = sc.nextInt();
        Rectangulo figura2 = new Rectangulo(base, altura);

        System.out.print("Ingrese el lado del cuadrado: ");
        Cuadrado figura3 = new Cuadrado(sc.nextInt());

        System.out.print("Ingrese la base del triangulo: ");
        base = sc.nextInt();
        System.out.print("Ingrese la altura del triangulo: ");
        altura = sc.nextInt();
        TrianguloRectangulo figura4 = new TrianguloRectangulo(base, altura);

        System.out.print("Ingrese diagonal mayor, diagonal menor y lado del rombo: ");
        int dma = sc.nextInt();
        int dme = sc.nextInt();
        int lador = sc.nextInt();
        Rombo figura5 = new Rombo(dma, dme, lador);

        System.out.print("Ingrese base mayor, base menor, altura, lado 1 y lado 2 del trapecio: ");
        int bM = sc.nextInt();
        int bm = sc.nextInt();
        altura = sc.nextInt();
        int l1 = sc.nextInt();
        int l2 = sc.nextInt();
        Trapecio figura6 = new Trapecio(bM, bm, altura, l1, l2);

		System.out.println("El area del circulo es = " + figura1.calcular_area());
		System.out.println("El perimetro del circulo es = " + figura1.calcular_perimetro());
		System.out.println();
		System.out.println("El area del rectangulo es = " + figura2.calcular_area());
		System.out.println("El perimetro del rectangulo es = " + figura2.calcular_perimetro());
		System.out.println();
		System.out.println("El area del cuadrado es = " + figura3.calcular_area());
		System.out.println("El perimetro del cuadrado es = " + figura3.calcular_perimetro());
		System.out.println();
		System.out.println("El area del triangulo es = " + figura4.calcular_area());
		System.out.println("El perimetro del triangulo es = " + figura4.calcular_perimetro());
		figura4.determinar_triangulo();
		System.out.println("Area del rombo: " + figura5.calcular_area());
        System.out.println("Perimetro del rombo: " + figura5.calcular_perimetro());
        System.out.println();
        System.out.println("Area del trapecio: " + figura6.calcular_area());
        System.out.println("Perimetro del trapecio: " + figura6.calcular_perimetro());
	}
}
