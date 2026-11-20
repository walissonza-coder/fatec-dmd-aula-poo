package ListadeExercicios05;

import java.util.Scanner;

public class Exercicio02 {
    public static int somar(int a, int b) {
        return a + b;
    }

    public static void mostrarResultado(int resultado) {
        System.out.println("Resultado: " + resultado);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número:");
        int n1 = scanner.nextInt();
        System.out.println("Digite o segundo número:");
        int n2 = scanner.nextInt();

        int soma = somar(n1, n2);
        mostrarResultado(soma);
        scanner.close();
    }
}