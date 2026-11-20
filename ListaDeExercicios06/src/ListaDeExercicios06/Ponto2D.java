package ListaDeExercicios06; // Remova ou ajuste esta linha conforme o pacote do projeto

import java.util.Objects;
import java.util.Scanner;

public class Ponto2D {
    private double x;
    private double y;

    // Construtor padrão: cria o ponto na origem (0, 0)
    public Ponto2D() {
        this(0.0, 0.0);
    }

    // Construtor com coordenadas
    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Construtor que copia a posição de outro ponto
    public Ponto2D(Ponto2D outro) {
        this(outro.x, outro.y);
    }

    // Getters e setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Movimenta o ponto para a origem
    public void mover() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Movimenta o ponto para as coordenadas indicadas
    public void mover(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Movimenta o ponto para a posição de outro ponto
    public void mover(Ponto2D outro) {
        this.x = outro.x;
        this.y = outro.y;
    }

    // Calcula a distância até outro ponto
    public double distancia(Ponto2D outro) {
        return Math.hypot(this.x - outro.x, this.y - outro.y);
    }

    // Compara semanticamente dois pontos
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Ponto2D)) {
            return false;
        }

        Ponto2D outro = (Ponto2D) objeto;
        return Double.compare(this.x, outro.x) == 0
                && Double.compare(this.y, outro.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // Representa o ponto como texto
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Cria e devolve um novo ponto na mesma posição
    @Override
    public Ponto2D clone() {
        return new Ponto2D(this);
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a coordenada x do primeiro ponto: ");
        double x1 = entrada.nextDouble();

        System.out.print("Digite a coordenada y do primeiro ponto: ");
        double y1 = entrada.nextDouble();

        Ponto2D ponto1 = new Ponto2D(x1, y1);

        System.out.print("Digite a coordenada x do segundo ponto: ");
        double x2 = entrada.nextDouble();

        System.out.print("Digite a coordenada y do segundo ponto: ");
        double y2 = entrada.nextDouble();

        Ponto2D ponto2 = new Ponto2D(x2, y2);

        System.out.println("\nPrimeiro ponto: " + ponto1);
        System.out.println("Segundo ponto: " + ponto2);
        System.out.println("Distância entre os pontos: " + ponto1.distancia(ponto2));
        System.out.println("Os pontos são iguais? " + ponto1.equals(ponto2));

        Ponto2D copia = ponto1.clone();
        System.out.println("Cópia do primeiro ponto: " + copia);

        entrada.close();
    }
}
