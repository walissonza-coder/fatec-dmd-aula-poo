package Exercicio4;

import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] m = new int[3][3];

        // Lê os valores da matriz.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o número da linha " + (i + 1)
                        + ", coluna " + (j + 1) + ": ");
                m[i][j] = sc.nextInt();
            }
        }

        // Exibe os valores organizados em linhas e colunas.
        System.out.println("\nMatriz informada:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println(); // Pula para a próxima linha da matriz.
        }

        sc.close();
    }
}





















































































