import java.util.Scanner;
enum TipoPlaneta {
    GASEOSO,
    TERRESTRE,
    ENANO
}

class Planeta {
    
    // Atributos
    private final String nombre;
    private final int cantidadSatelites;
    private final double masa;
    private final double volumen;
    private final int diametro;
    private final int distanciaSol;
    private final TipoPlaneta tipoPlaneta;
    private final boolean observable;
    
    // Constructor
    public Planeta(String nombre,
                   int cantidadSatelites,
                   double masa,
                   double volumen,
                   int diametro,
                   int distanciaSol,
                   TipoPlaneta tipoPlaneta,
                   boolean observable) {
        
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaSol = distanciaSol;
        this.tipoPlaneta = tipoPlaneta;
        this.observable = observable;
    }
    
    // Método para imprimir atributos
    public void mostrarInformacion() {
        
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad de satélites: " + cantidadSatelites);
        System.out.println("Masa: " + masa + " kg");
        System.out.println("Volumen: " + volumen + " km³");
        System.out.println("Diámetro: " + diametro + " km");
        System.out.println("Distancia al Sol: " + distanciaSol + " millones de km");
        System.out.println("Tipo de planeta: " + tipoPlaneta);
        System.out.println("Observable a simple vista: " + observable);
    }
    
    // Método para calcular densidad
    public double calcularDensidad() {
        return masa / volumen;
    }
    
    // Método para determinar si es exterior
    public boolean esPlanetaExterior() {
        return distanciaSol > 340;
    }
}

public class Main {

    public static void main(String[] args) {

        // Datos del primer planeta
        try (Scanner scanner = new Scanner(System.in)) {
            // Datos del primer planeta
            System.out.println("=== INGRESO DE DATOS DEL PRIMER PLANETA ===");
            
            System.out.print("Ingrese el nombre del planeta: ");
            String nombre1 = scanner.nextLine();
            
            System.out.print("Ingrese la cantidad de satelites: ");
            int satelites1 = scanner.nextInt();
            
            System.out.print("Ingrese la masa del planeta: ");
            double masa1 = scanner.nextDouble();
            
            System.out.print("Ingrese el volumen del planeta: ");
            double volumen1 = scanner.nextDouble();
            
            System.out.print("Ingrese el diametro del planeta: ");
            int diametro1 = scanner.nextInt();
            
            System.out.print("Ingrese la distancia al Sol (millones de km): ");
            int distancia1 = scanner.nextInt();
            
            // Mostrar tipos de planeta
            System.out.println("\nTipos de planeta:");
            System.out.println("1. GASEOSO");
            System.out.println("2. TERRESTRE");
            System.out.println("3. ENANO");
            
            System.out.print("Seleccione una opcion: ");
            int opcionTipo1 = scanner.nextInt();
            
            TipoPlaneta tipo1 = TipoPlaneta.TERRESTRE;
            
            switch (opcionTipo1) {
                case 1 -> tipo1 = TipoPlaneta.GASEOSO;
                case 2 -> tipo1 = TipoPlaneta.TERRESTRE;
                case 3 -> tipo1 = TipoPlaneta.ENANO;
            }
            
            System.out.print("¿Es observable a simple vista? (true/false): ");
            boolean observable1 = scanner.nextBoolean();
            
            scanner.nextLine();
            
            // Crear primer planeta
            Planeta planeta1 = new Planeta(
                    nombre1,
                    satelites1,
                    masa1,
                    volumen1,
                    diametro1,
                    distancia1,
                    tipo1,
                    observable1
            );
            
            // Datos del segundo planeta
            System.out.println("\n=== INGRESO DE DATOS DEL SEGUNDO PLANETA ===");
            
            System.out.print("Ingrese el nombre del planeta: ");
            String nombre2 = scanner.nextLine();
            
            System.out.print("Ingrese la cantidad de satelites: ");
            int satelites2 = scanner.nextInt();
            
            System.out.print("Ingrese la masa del planeta: ");
            double masa2 = scanner.nextDouble();
            
            System.out.print("Ingrese el volumen del planeta: ");
            double volumen2 = scanner.nextDouble();
            
            System.out.print("Ingrese el diametro del planeta: ");
            int diametro2 = scanner.nextInt();
            
            System.out.print("Ingrese la distancia al Sol (millones de km): ");
            int distancia2 = scanner.nextInt();
            
            // Mostrar tipos de planeta
            System.out.println("\nTipos de planeta:");
            System.out.println("1. GASEOSO");
            System.out.println("2. TERRESTRE");
            System.out.println("3. ENANO");
            
            System.out.print("Seleccione una opcion: ");
            int opcionTipo2 = scanner.nextInt();
            
            TipoPlaneta tipo2 = TipoPlaneta.TERRESTRE;
            
            switch (opcionTipo2) {
				case 1:tipo2 = TipoPlaneta.GASEOSO;
				case 2:tipo2 = TipoPlaneta.TERRESTRE;
				case 3:tipo2 = TipoPlaneta.ENANO;
            }
            
            System.out.print("¿Es observable a simple vista? (true/false): ");
            boolean observable2 = scanner.nextBoolean();
            
            // Crear segundo planeta
            Planeta planeta2 = new Planeta(
                    nombre2,
                    satelites2,
                    masa2,
                    volumen2,
                    diametro2,
                    distancia2,
                    tipo2,
                    observable2
            );
            
            // Mostrar informacion primer planeta
            System.out.println("\n=== INFORMACION DEL PRIMER PLANETA ===");
            
            planeta1.mostrarInformacion();
            
            System.out.println("Densidad: " + planeta1.calcularDensidad());
            System.out.println("¿Es planeta exterior?: " + planeta1.esPlanetaExterior());
            
            // Mostrar informacion segundo planeta
            System.out.println("\n=== INFORMACION DEL SEGUNDO PLANETA ===");
            
            planeta2.mostrarInformacion();
            
            System.out.println("Densidad: " + planeta2.calcularDensidad());
            System.out.println("¿Es planeta exterior?: " + planeta2.esPlanetaExterior());
        }
    }
}
