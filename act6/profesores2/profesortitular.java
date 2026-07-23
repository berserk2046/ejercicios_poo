package profesores2;

public class profesortitular extends profesor{
	int anos = 0;
	protected void imprimir(){
		System.out.println("Es un profesor titular");
	}
	protected void imprimirAnos(){
		System.out.println("Anos = " + anos);
	}
}
