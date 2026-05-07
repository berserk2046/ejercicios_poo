import java.util.Scanner;

class persona{
	int age;
	String name;
	public persona(int age, String name){
		this.age = age;
		this.name = name;
		System.out.println("Edad de " + name + ": " + age);
	}
}

public class e1{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Ingrese la edad de juan: ");
		persona juan = new persona(input.nextInt(), "juan");
		persona alberto = new persona((juan.age*2)/3, "alberto");
		persona ana = new persona((juan.age*4)/3,"ana");
		persona mama = new persona(juan.age + alberto.age + ana.age, "mama");
		
	}
}
