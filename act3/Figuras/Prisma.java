package Figuras;

public class Prisma extends FiguraGeometrica {
    private double base;
    private double ancho;
    private double altura;

    public Prisma(double base, double ancho, double altura) {
        this.base = base;
        this.ancho = ancho;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return base * ancho * altura;
    }

    public double calcularSuperficie() {
        return 2.0 * ((base * ancho) + (base * altura) + (ancho * altura));
    }
}
