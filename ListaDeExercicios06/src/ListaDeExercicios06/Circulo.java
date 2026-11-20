package ListaDeExercicios06; // Ajuste ou remova conforme o pacote do projeto

import java.awt.geom.Point2D;
import java.util.Scanner;

public class Circulo {
    private double raio;
    private Point2D centro;

    // Construtor que recebe o raio e um ponto para o centro
    public Circulo(double raio, Point2D centro) {
        setRaio(raio);

        if (centro == null) {
            throw new IllegalArgumentException("O centro não pode ser nulo.");
        }

        this.centro = new Point2D.Double(centro.getX(), centro.getY());
    }

    // Construtor que recebe o raio e posiciona o círculo na origem
    public Circulo(double raio) {
        this(raio, new Point2D.Double(0.0, 0.0));
    }

    // Getter e setter do raio
    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if (raio < 0) {
            throw new IllegalArgumentException("O raio não pode ser negativo.");
        }

        this.raio = raio;
    }

    // Infla o círculo pelo valor informado
    public void inflar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.");
        }

        raio += valor;
    }

    // Infla o círculo em uma unidade
    public void inflar() {
        inflar(1.0);
    }

    // Desinfla o círculo pelo valor informado
    public void desinflar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.");
        }

        if (valor > raio) {
            throw new IllegalArgumentException(
                "O raio não pode ficar negativo."
            );
        }

        raio -= valor;
    }

    // Desinfla o círculo em uma unidade
    public void desinflar() {
        desinflar(1.0);
    }

    // Move o círculo para a origem
    public void mover() {
        centro = new Point2D.Double(0.0, 0.0);
    }

    // Move o círculo para as coordenadas informadas
    public void mover(double x, double y) {
        centro = new Point2D.Double(x, y);
    }

    // Move o círculo para a posição de outro ponto
    public void mover(Point2D ponto) {
        if (ponto == null) {
            throw new IllegalArgumentException("O ponto não pode ser nulo.");
        }

        centro = new Point2D.Double(ponto.getX(), ponto.getY());
    }

    // Retorna uma cópia do centro
    public Point2D getCentro() {
        return new Point2D.Double(centro.getX(), centro.getY());
    }

    // Calcula e retorna a área do círculo
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public String toString() {
        return "Círculo com raio " + raio
             + " e centro (" + centro.getX() + ", " + centro.getY() + ")";
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.print("Digite o raio do círculo: ");
            double raio = entrada.nextDouble();

            System.out.print("Digite a coordenada x do centro: ");
            double x = entrada.nextDouble();

            System.out.print("Digite a coordenada y do centro: ");
            double y = entrada.nextDouble();

            Circulo circulo = new Circulo(
                raio,
                new Point2D.Double(x, y)
            );

            System.out.println("\n" + circulo);
            System.out.println("Área: " + circulo.calcularArea());

            System.out.print("\nQuanto deseja inflar o raio? ");
            circulo.inflar(entrada.nextDouble());
            System.out.println("Após inflar: " + circulo);
            System.out.println("Nova área: " + circulo.calcularArea());

            System.out.print("\nQuanto deseja desinflar o raio? ");
            circulo.desinflar(entrada.nextDouble());
            System.out.println("Após desinflar: " + circulo);
            System.out.println("Nova área: " + circulo.calcularArea());

            circulo.mover();
            System.out.println("\nCírculo movido para a origem: " + circulo);

        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        } finally {
            entrada.close();
        }
    }
}
