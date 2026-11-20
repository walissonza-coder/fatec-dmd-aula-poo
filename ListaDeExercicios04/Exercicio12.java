import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        int soma = 0;
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.println("Digite o valor da posição [" + linha + "][" + coluna + "]:");
                matriz[linha][coluna] = scanner.nextInt();
                soma += matriz[linha][coluna];
            }
        }
        System.out.println("Soma dos elementos: " + soma);
        scanner.close();
    }
}
