import java.util.Scanner;

enum TipoAutomovil {
    CIUDAD,
    SUBCOMPACTO,
    COMPACTO,
    FAMILIAR,
    EJECUTIVO,
    SUV
}

enum TipoCombustible {
    GASOLINA,
    BIOETANOL,
    DIESEL,
    BIODIESEL,
    GAS_NATURAL
}

enum Color {
    BLANCO,
    NEGRO,
    ROJO,
    NARANJA,
    AMARILLO,
    VERDE,
    AZUL,
    VIOLETA
}

class Automovil {
    
    // Atributos
    private final String marca;
    private final int modelo;
    private final double motor;
    private final TipoCombustible tipoCombustible;
    private final TipoAutomovil tipoAutomovil;
    private final int numeroPuertas;
    private final int cantidadAsientos;
    private final int velocidadMaxima;
    private Color color;
    private int velocidadActual;
    
    // Constructor
    public Automovil(String marca,
                     int modelo,
                     double motor,
                     TipoCombustible tipoCombustible,
                     TipoAutomovil tipoAutomovil,
                     int numeroPuertas,
                     int cantidadAsientos,
                     int velocidadMaxima,
                     Color color) {
        
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
        this.numeroPuertas = numeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.color = color;
        this.velocidadActual = 0;
    }
    
    // Getters
    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public double getMotor() {
        return motor;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public TipoAutomovil getTipoAutomovil() {
        return tipoAutomovil;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public Color getColor() {
        return color;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }
    
    // Setters
    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }
    
    // Metodo acelerar
    public void acelerar(int incremento) {
        
        if (velocidadActual + incremento <= velocidadMaxima) {
            velocidadActual += incremento;
        } else {
            velocidadActual = velocidadMaxima;
        }
        
        System.out.println("Velocidad actual: " + velocidadActual + " km/h");
    }
    
    // Metodo desacelerar
    public void desacelerar(int decremento) {
        
        if (velocidadActual - decremento >= 0) {
            velocidadActual -= decremento;
        } else {
            velocidadActual = 0;
        }
        
        System.out.println("Velocidad actual: " + velocidadActual + " km/h");
    }
    
    // Metodo frenar
    public void frenar() {
        velocidadActual = 0;
        System.out.println("El automovil se ha detenido");
    }
    
    // Metodo calcular tiempo de llegada
    public double calcularTiempoLlegada(double distancia) {
        return distancia / velocidadActual;
    }
    
    // Metodo mostrar atributos
    public void mostrarInformacion() {
        
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Motor: " + motor + " litros");
        System.out.println("Tipo de combustible: " + tipoCombustible);
        System.out.println("Tipo de automovil: " + tipoAutomovil);
        System.out.println("Numero de puertas: " + numeroPuertas);
        System.out.println("Cantidad de asientos: " + cantidadAsientos);
        System.out.println("Velocidad maxima: " + velocidadMaxima + " km/h");
        System.out.println("Color: " + color);
        System.out.println("Velocidad actual: " + velocidadActual + " km/h");
    }
}


public class Main {
    public static void main(String[] args) {

        // Entrada de datos
        try (Scanner scanner = new Scanner(System.in)) {
            // Entrada de datos
            System.out.print("Ingrese la marca del automovil: ");
            String marca = scanner.nextLine();
            
            System.out.print("Ingrese el modelo: ");
            int modelo = scanner.nextInt();
            
            System.out.print("Ingrese el tamano del motor en litros: ");
            double motor = scanner.nextDouble();
            
            // Mostrar tipos de combustible
            System.out.println("\nTipos de combustible:");
            System.out.println("1. GASOLINA");
            System.out.println("2. BIOETANOL");
            System.out.println("3. DIESEL");
            System.out.println("4. BIODIESEL");
            System.out.println("5. GAS_NATURAL");
            
            System.out.print("Seleccione una opcion: ");
            int opcionCombustible = scanner.nextInt();
            
            TipoCombustible tipoCombustible = TipoCombustible.GASOLINA;
            
            switch (opcionCombustible) {
                case 1 -> tipoCombustible = TipoCombustible.GASOLINA;
                case 2 -> tipoCombustible = TipoCombustible.BIOETANOL;
                case 3 -> tipoCombustible = TipoCombustible.DIESEL;
                case 4 -> tipoCombustible = TipoCombustible.BIODIESEL;
                case 5 -> tipoCombustible = TipoCombustible.GAS_NATURAL;
            }
            
            // Mostrar tipos de automovil
            System.out.println("\nTipos de automovil:");
            System.out.println("1. CIUDAD");
            System.out.println("2. SUBCOMPACTO");
            System.out.println("3. COMPACTO");
            System.out.println("4. FAMILIAR");
            System.out.println("5. EJECUTIVO");
            System.out.println("6. SUV");
            
            System.out.print("Seleccione una opcion: ");
            int opcionAutomovil = scanner.nextInt();
            
            TipoAutomovil tipoAutomovil = TipoAutomovil.CIUDAD;
            
            switch (opcionAutomovil) {
                case 1 -> tipoAutomovil = TipoAutomovil.CIUDAD;
                case 2 -> tipoAutomovil = TipoAutomovil.SUBCOMPACTO;
                case 3 -> tipoAutomovil = TipoAutomovil.COMPACTO;
                case 4 -> tipoAutomovil = TipoAutomovil.FAMILIAR;
                case 5 -> tipoAutomovil = TipoAutomovil.EJECUTIVO;
                case 6 -> tipoAutomovil = TipoAutomovil.SUV;
            }
            
            System.out.print("Ingrese el numero de puertas: ");
            int numeroPuertas = scanner.nextInt();
            
            System.out.print("Ingrese la cantidad de asientos: ");
            int cantidadAsientos = scanner.nextInt();
            
            System.out.print("Ingrese la velocidad maxima: ");
            int velocidadMaxima = scanner.nextInt();
            
            // Mostrar colores
            System.out.println("\nColores disponibles:");
            System.out.println("1. BLANCO");
            System.out.println("2. NEGRO");
            System.out.println("3. ROJO");
            System.out.println("4. NARANJA");
            System.out.println("5. AMARILLO");
            System.out.println("6. VERDE");
            System.out.println("7. AZUL");
            System.out.println("8. VIOLETA");
            
            System.out.print("Seleccione una opcion: ");
            int opcionColor = scanner.nextInt();
            
            Color color = Color.NEGRO;
            
            switch (opcionColor) {
                case 1 -> color = Color.BLANCO;
                case 2 -> color = Color.NEGRO;
                case 3 -> color = Color.ROJO;
                case 4 -> color = Color.NARANJA;
                case 5 -> color = Color.AMARILLO;
                case 6 -> color = Color.VERDE;
                case 7 -> color = Color.AZUL;
                case 8 -> color = Color.VIOLETA;
            }
            
            // Crear objeto
            Automovil automovil = new Automovil(
                    marca,
                    modelo,
                    motor,
                    tipoCombustible,
                    tipoAutomovil,
                    numeroPuertas,
                    cantidadAsientos,
                    velocidadMaxima,
                    color
            );
            
            // Mostrar informacion
            System.out.println("\n=== INFORMACION DEL AUTOMOVIL ===");
            automovil.mostrarInformacion();
            
            // Simulacion
            System.out.println("\n=== ACELERAR ===");
            automovil.acelerar(50);
            
            System.out.println("\n=== DESACELERAR ===");
            automovil.desacelerar(20);
            
            System.out.println("\n=== FRENAR ===");
            automovil.frenar();
        }
    }
}   
