package ListadeExercicios05;

import java.util.Scanner;

public class Exercicio06 {
    public static void mostrarLinha(int numero, int multiplicador) {
        System.out.println(numero + " x " + multiplicador + " = " + (numero * multiplicador));
    }

    public static void exibirTabuada(int numero) {
        for (int i = 1; i <= 10; i++) {
            mostrarLinha(numero, i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número para ver a tabuada:");
        int numero = scanner.nextInt();
        exibirTabuada(numero);
        scanner.close();
    }
}

