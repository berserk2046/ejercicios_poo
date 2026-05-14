import java.util.Scanner;

public class Persona {
    String nombre;
    String apellido;
    String numeroDocumentoIdentidad;
    int anioNacimiento;

    Persona(String nombre, String apellido, String numero_de_documento, int anio_nacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumentoIdentidad = numero_de_documento;
        this.anioNacimiento = anio_nacimiento;
    }
    public void imprimir(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellido);
        System.out.println("Documento: " + numeroDocumentoIdentidad);
        System.out.println("Año nacimiento: " + anioNacimiento);
    }
    public static Persona Crear_persona(Scanner scan){        
    System.out.print("Ingrsese su Nombre: ");
    String nombre = scan.nextLine();

    System.out.print("Ingrese su Apellido: ");
    String apellido = scan.nextLine();

    System.out.print("Ingrese su Numero de Documento: ");
    String numeroDocumentoIdentidad = scan.nextLine();
    int anioNacimiento = LeerEntero(scan, "Ingrese su Año de Nacimiento: ");

    return new Persona(nombre, apellido, numeroDocumentoIdentidad, anioNacimiento);
    }
    public static int LeerEntero(Scanner scan, String mensaje){
    int numero = 0;
    boolean correto = false;
    while(!correto){
        try {
            System.out.print(mensaje);
            numero = scan.nextInt();
            scan.nextLine();
            correto = true;
        } catch (Exception e) {
            System.out.println("Error: ingreso un caracter no valido intentalo de nuevo:");
            scan.nextLine();
        }
    }
    return numero;
    }
}

public class e1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Persona 1");

        Persona p1 = Persona.Crear_persona(scan);
        System.out.println("Persona 2");
        Persona p2 = Persona.Crear_persona(scan);
        
        System.out.println("Persona 1");
        p1.imprimir();
        System.out.println("Persona 2");
        p2.imprimir();
            
    }
    
}
