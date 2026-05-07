import java.util.Scanner;

class empleado{
	int hours = 48;
	int pay_per_hour = 5000;
	double retention = 0.125;
	int full_salary = hours * pay_per_hour;
	double salary_retention = full_salary * retention;
	double net_salary = full_salary - salary_retention;
	
	public empleado(){
		System.out.println("Salario bruto: " + full_salary);
		System.out.println("Retencion en la fuente: " + salary_retention);
		System.out.println("Salario neto: " + net_salary);
	}
}

public class e3{
	public static void main(String[] args){
		empleado x = new empleado();
	}
}
