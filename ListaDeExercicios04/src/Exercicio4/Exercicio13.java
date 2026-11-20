package Exercicio4;

import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] m = new int[3][3];
        int soma = 0;

        // Solicita os valores da matriz.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o valor da linha " + (i + 1)
                        + ", coluna " + (j + 1) + ": ");
                m[i][j] = sc.nextInt();
            }
        }

        // Soma os valores da diagonal principal.
        for (int i = 0; i < 3; i++) {
            soma += m[i][i];
        }

        System.out.println("Soma da diagonal principal: " + soma);

        sc.close();
    }
}
