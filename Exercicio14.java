import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        int maior = 0;
        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                System.out.println("Digite o valor da posição [" + linha + "][" + coluna + "]:");
                matriz[linha][coluna] = scanner.nextInt();
                if (linha == 0 && coluna == 0) maior = matriz[linha][coluna];
                else if (matriz[linha][coluna] > maior) maior = matriz[linha][coluna];
            }
        }
        System.out.println("Maior valor da matriz: " + maior);
        scanner.close();
    }
}
