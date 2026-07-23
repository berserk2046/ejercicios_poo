package animales;

public class prueba{
	public static void main(String[] args){
		animal[] animals = new animal[4];
		animals[0] = new gato();
		animals[1] = new perro();
		animals[2] = new lobo();
		animals[3] = new leon();
		for(int i=0;i<animals.length;i++){
			System.out.println(animals[i].getnombrecientifico());
			System.out.println("Sonido: "+ animals[i].getsonido());
			System.out.println("Alimentos: "+ animals[i].getalimentos());
			System.out.println("Habitat: "+animals[i].gethabitat());
			System.out.println();
		}
	}
}
