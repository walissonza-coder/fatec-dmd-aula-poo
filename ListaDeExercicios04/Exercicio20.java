import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.println("Digite o valor da posição [" + linha + "][" + coluna + "]:");
                matriz[linha][coluna] = scanner.nextInt();
            }
        }
        for (int linha = 0; linha < 3; linha++) {
            int somaLinha = 0;
            for (int coluna = 0; coluna < 3; coluna++) somaLinha += matriz[linha][coluna];
            System.out.println("Soma da linha " + (linha + 1) + ": " + somaLinha);
        }
        for (int coluna = 0; coluna < 3; coluna++) {
            int somaColuna = 0;
            for (int linha = 0; linha < 3; linha++) somaColuna += matriz[linha][coluna];
            System.out.println("Soma da coluna " + (coluna + 1) + ": " + somaColuna);
        }
        scanner.close();
    }
}
