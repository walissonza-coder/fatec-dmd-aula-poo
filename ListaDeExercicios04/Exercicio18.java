import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrizA = new int[3][3];
        int[][] matrizB = new int[3][3];
        int[][] resultado = new int[3][3];

        System.out.println("Digite os valores da primeira matriz:");
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.println("Valor da posição [" + linha + "][" + coluna + "]:");
                matrizA[linha][coluna] = scanner.nextInt();
            }
        }
        System.out.println("Digite os valores da segunda matriz:");
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.println("Valor da posição [" + linha + "][" + coluna + "]:");
                matrizB[linha][coluna] = scanner.nextInt();
                resultado[linha][coluna] = matrizA[linha][coluna] + matrizB[linha][coluna];
            }
        }
        System.out.println("Matriz soma:");
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) System.out.print(resultado[linha][coluna] + "\t");
            System.out.println();
        }
        scanner.close();
    }
}
