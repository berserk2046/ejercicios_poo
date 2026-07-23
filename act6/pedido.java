public class pedido{
	public void calcularPedido(String primerPlato, double costoPrimerPlato, String bebida, double costoBebida){
		double total = costoPrimerPlato + costoBebida;
		System.out.println("El costo de " + primerPlato + "+" + bebida + " es $"+total);
	}
	public void calcularPedido(String primerPlato, double costoPrimerPlato, String segundoPlato, double costoSegundoPlato,String bebida, double costoBebida){
		double total = costoPrimerPlato + costoSegundoPlato + costoBebida;
		System.out.println("El costo de " + primerPlato + "+" + segundoPlato + "+" + bebida + " es $"+total);
	}
	public void calcularPedido(String primerPlato, double costoPrimerPlato, String segundoPlato, double costoSegundoPlato, String postre, double costoPostre, String bebida, double costoBebida){
		double total = costoPrimerPlato + costoSegundoPlato + costoBebida + costoPostre;
		System.out.println("El costo de " + primerPlato + "+" + segundoPlato + "+" + bebida + "+" + postre +" es $"+total);
	}

	public static void main(String args[]){
		pedido pedido1 = new pedido();
		pedido1.calcularPedido("Sancocho", 5000, "Gaseosa", 2000);
		pedido pedido2 = new pedido();
		pedido2.calcularPedido("Crema de verduras", 5000, "Churrasco", 6000, "Gaseosa", 2000);
		pedido pedido3 = new pedido();
		pedido3.calcularPedido("Crema de espinacas", 5000, "Salmon", 10000, "Tiramisu", 5000, "Gaseosa", 2000);
		
	}
}
