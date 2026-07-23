public class articulocientifico{
	String titulo;
	String autor;
	String[] palabrasClaves=new String[3];
	String publicacion;
	int ano;
	String resumen;

	public articulocientifico(String titulo, String autor){
		this.titulo = titulo;
		this.autor = autor;
	}
	public articulocientifico(String titulo, String autor, String[] palabrasClaves, String publicacion, int ano){
		this(titulo, autor);
		this.palabrasClaves = palabrasClaves;
		this.publicacion = publicacion;
		this.ano = ano;
	}
	public articulocientifico(String titulo, String autor, String[] palabrasClaves, String publicacion, int ano, String resumen){
		this(titulo, autor, palabrasClaves, publicacion, ano);
		this.resumen = resumen;
	}

	public void imprimir(){
		System.out.println("Titulo del articulo = " + titulo);
		System.out.println("Autor del articulo = " + autor);
		System.out.println("Palabras clave = ");
		for(int i=0;i<palabrasClaves.length;i++){
			System.out.println(palabrasClaves[i]);
		}
		System.out.println("Publicacion = " +  publicacion);
		System.out.println("Ano = " + ano);
		System.out.println("Resumen = "+ resumen);
	}
	public static void main(String args[]){
		String[] palabras = {"fisica", "espacio", "tiempo"};
		articulocientifico articulo = new articulocientifico("La teoria especial de la relatividad", "Albert Einstein", palabras, "Anales de Fisica", 1913, "Las leyes de la fisica son las mismas en todos los sistemas de referencia inerciales.");
		articulo.imprimir();
	}
}
