package ListadeExercicios05;

import java.util.Scanner;

public class Exercicio04 {
    public static double calcularMedia(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3.0;
    }

    public static String verificarSituacao(double media) {
        if (media >= 6.0) {
            return "Aprovado";
        } else if (media >= 4.0) {
            return "Recuperação";
        }
        return "Reprovado";
    }

    public static void mostrarResultado(double media, String situacao) {
        System.out.printf("Média: %.2f%n", media);
        System.out.println("Situação: " + situacao);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a nota 1:");
        double n1 = scanner.nextDouble();
        System.out.println("Digite a nota 2:");
        double n2 = scanner.nextDouble();
        System.out.println("Digite a nota 3:");
        double n3 = scanner.nextDouble();

        double media = calcularMedia(n1, n2, n3);
        mostrarResultado(media, verificarSituacao(media));
        scanner.close();
    }
}

