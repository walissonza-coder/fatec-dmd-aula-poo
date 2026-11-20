package ListaDeExercicios06; // Ajuste ou remova conforme o pacote do seu projeto

import java.util.Scanner;

public class Reta {
    private double coeficienteAngular; // a
    private double coeficienteLinear;  // b

    // Construtor com os coeficientes a e b
    public Reta(double coeficienteAngular, double coeficienteLinear) {
        this.coeficienteAngular = coeficienteAngular;
        this.coeficienteLinear = coeficienteLinear;
    }

    // Getters e setters
    public double getCoeficienteAngular() {
        return coeficienteAngular;
    }

    public void setCoeficienteAngular(double coeficienteAngular) {
        this.coeficienteAngular = coeficienteAngular;
    }

    public double getCoeficienteLinear() {
        return coeficienteLinear;
    }

    public void setCoeficienteLinear(double coeficienteLinear) {
        this.coeficienteLinear = coeficienteLinear;
    }

    // Calcula y para um valor de x usando y = ax + b
    public double calcularY(double x) {
        return coeficienteAngular * x + coeficienteLinear;
    }

    @Override
    public String toString() {
        return "y = " + coeficienteAngular + " x + " + coeficienteLinear;
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o coeficiente angular (a): ");
        double a = entrada.nextDouble();

        System.out.print("Digite o coeficiente linear (b): ");
        double b = entrada.nextDouble();

        Reta reta = new Reta(a, b);

        System.out.print("Digite um valor para x: ");
        double x = entrada.nextDouble();

        double y = reta.calcularY(x);

        System.out.println("Equação da reta: " + reta);
        System.out.println("Para x = " + x + ", y = " + y);

        entrada.close();
    }
}
