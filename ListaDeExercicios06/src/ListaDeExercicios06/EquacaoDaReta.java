package ListaDeExercicios06; // Ajuste ou remova conforme o pacote do projeto

import java.util.Scanner;

public class EquacaoDaReta {
    private double coeficienteAngular; // a
    private double coeficienteLinear;  // b

    private static final double TOLERANCIA = 1e-9;

    // Construtor a partir dos coeficientes da equação y = ax + b
    public EquacaoDaReta(double coeficienteAngular, double coeficienteLinear) {
        this.coeficienteAngular = coeficienteAngular;
        this.coeficienteLinear = coeficienteLinear;
    }

    // Construtor a partir de dois pontos
    public EquacaoDaReta(Ponto2D ponto1, Ponto2D ponto2) {
        double x1 = ponto1.getX();
        double y1 = ponto1.getY();
        double x2 = ponto2.getX();
        double y2 = ponto2.getY();

        if (Math.abs(x2 - x1) < TOLERANCIA) {
            throw new IllegalArgumentException(
                "Uma reta vertical não pode ser representada por y = ax + b."
            );
        }

        this.coeficienteAngular = (y2 - y1) / (x2 - x1);
        this.coeficienteLinear = y1 - this.coeficienteAngular * x1;
    }

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

    // Calcula y para um valor de x
    public double calcularY(double x) {
        return coeficienteAngular * x + coeficienteLinear;
    }

    // Verifica se um ponto pertence à reta
    public boolean contemPonto(Ponto2D ponto) {
        return Math.abs(calcularY(ponto.getX()) - ponto.getY()) < TOLERANCIA;
    }

    // Retorna o ponto de interseção ou null se as retas forem paralelas
    public Ponto2D intersecao(EquacaoDaReta outra) {
        double diferencaAngular =
            this.coeficienteAngular - outra.coeficienteAngular;

        if (Math.abs(diferencaAngular) < TOLERANCIA) {
            return null;
        }

        double x = (outra.coeficienteLinear - this.coeficienteLinear)
                 / diferencaAngular;
        double y = calcularY(x);

        return new Ponto2D(x, y);
    }

    @Override
    public String toString() {
        String sinal = coeficienteLinear < 0 ? " - " : " + ";
        return "y = " + coeficienteAngular + "x"
             + sinal + Math.abs(coeficienteLinear);
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe os coeficientes da primeira reta:");
        System.out.print("Coeficiente angular (a): ");
        double a1 = entrada.nextDouble();

        System.out.print("Coeficiente linear (b): ");
        double b1 = entrada.nextDouble();

        EquacaoDaReta reta1 = new EquacaoDaReta(a1, b1);

        System.out.println("\nInforme os coeficientes da segunda reta:");
        System.out.print("Coeficiente angular (a): ");
        double a2 = entrada.nextDouble();

        System.out.print("Coeficiente linear (b): ");
        double b2 = entrada.nextDouble();

        EquacaoDaReta reta2 = new EquacaoDaReta(a2, b2);

        System.out.println("\nPrimeira reta: " + reta1);
        System.out.println("Segunda reta: " + reta2);

        Ponto2D pontoIntersecao = reta1.intersecao(reta2);

        if (pontoIntersecao == null) {
            System.out.println("As retas são paralelas e não possuem interseção única.");
        } else {
            System.out.println("Ponto de interseção: " + pontoIntersecao);
        }

        System.out.print("\nDigite a coordenada x de um ponto: ");
        double x = entrada.nextDouble();

        System.out.print("Digite a coordenada y do ponto: ");
        double y = entrada.nextDouble();

        Ponto2D ponto = new Ponto2D(x, y);

        if (reta1.contemPonto(ponto)) {
            System.out.println("O ponto pertence à primeira reta.");
        } else {
            System.out.println("O ponto não pertence à primeira reta.");
        }

        entrada.close();
    }
}
