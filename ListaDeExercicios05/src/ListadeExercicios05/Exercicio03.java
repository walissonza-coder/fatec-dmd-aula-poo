package ListadeExercicios05;

import java.util.Scanner;

public class Exercicio03 {
    public static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }

    public static void mostrarResultado(boolean par) {
        if (par) {
            System.out.println("Número par.");
        } else {
            System.out.println("Número ímpar.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número:");
        int numero = scanner.nextInt();
        mostrarResultado(ehPar(numero));
        scanner.close();
    }
}
