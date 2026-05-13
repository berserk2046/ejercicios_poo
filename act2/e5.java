import java.util.Scanner;

class cuenta_bancaria {
    String nombre_titular;
    String apellido_titular;
    int ncuenta;
    enum tipo { AHORROS, CORRIENTE }
    tipo tcuenta;
    float saldo = 0;
    float tasaInteresMensual;

    cuenta_bancaria(String nombre_titular, String apellido_titular, int ncuenta, tipo tcuenta, float tasaInteres) {
        this.nombre_titular = nombre_titular;
        this.apellido_titular = apellido_titular;
        this.ncuenta = ncuenta;
        this.tcuenta = tcuenta;
        this.tasaInteresMensual = tasaInteres;
    }

    void imprimir() {
        System.out.println("Nombres titular: " + nombre_titular);
        System.out.println("Apellidos titular: " + apellido_titular);
        System.out.println("Numero de cuenta: " + ncuenta);
        System.out.println("Tipo de cuenta: " + tcuenta);
        System.out.println("Saldo: $" + saldo);
        System.out.println("Tasa de interes mensual: " + tasaInteresMensual + "%");
    }

    void aplicarInteres() {
        float interes = saldo * (tasaInteresMensual / 100);
        saldo += interes;
        System.out.println("Interes aplicado: $" + interes + ". Nuevo saldo: $" + saldo);
    }

    void ver_saldo() {
        System.out.println("Saldo actual: " + saldo);
    }

    boolean consignar(int valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Se ha consignado $" + valor + ". Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("El valor debe ser mayor a 0");
            return false;
        }
    }

    boolean retirar(int valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Se ha retirado $" + valor + ". Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Fondos insuficientes o valor invalido.");
            return false;
        }
    }
}

public class e5 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        cuenta_bancaria cuenta = null;

        System.out.print("Ingrese sus nombres: ");
        String nombre = input.nextLine();
        System.out.print("Ingrese sus apellidos: ");
        String apellido = input.nextLine();
        System.out.print("Ingrese tipo de cuenta (AHORROS o CORRIENTE): ");
        String tipoStr = input.next().toUpperCase();

        if (tipoStr.equals("AHORROS")) {
            cuenta = new cuenta_bancaria(nombre, apellido, 12345678, cuenta_bancaria.tipo.AHORROS, 1.5f);
        } else if (tipoStr.equals("CORRIENTE")) {
            cuenta = new cuenta_bancaria(nombre, apellido, 12345678, cuenta_bancaria.tipo.CORRIENTE, 0.5f);
        } else {
            System.out.println("Tipo no valido. Se asignara AHORROS por defecto.");
            cuenta = new cuenta_bancaria(nombre, apellido, 12345678, cuenta_bancaria.tipo.AHORROS, 1.5f);
        }

        int eleccion;
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("(1) Consignar");
            System.out.println("(2) Retirar");
            System.out.println("(3) Aplicar Interes Mensual");
            System.out.println("(4) Informacion cuenta");
            System.out.println("(5) Salir");
            System.out.print("Elija una opcion: ");
            eleccion = input.nextInt();

            if (eleccion == 1) {
                System.out.print("Valor a consignar: ");
                cuenta.consignar(input.nextInt());
            } else if (eleccion == 2) {
                System.out.print("Valor a retirar: ");
                cuenta.retirar(input.nextInt());
            } else if (eleccion == 3) {
                cuenta.aplicarInteres();
            } else if (eleccion == 4) {
                cuenta.imprimir();
            } else if (eleccion == 5) {
                break;
            }
        }
        input.close();
    }
}
