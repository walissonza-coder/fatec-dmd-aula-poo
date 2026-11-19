import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        int quantidadePares = 0;
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.println("Digite o valor da posição [" + linha + "][" + coluna + "]:");
                matriz[linha][coluna] = scanner.nextInt();
                if (matriz[linha][coluna] % 2 == 0) quantidadePares++;
            }
        }
        System.out.println("Quantidade de números pares: " + quantidadePares);
        scanner.close();
    }
}
