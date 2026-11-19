import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.println("Digite o valor da posição [" + linha + "][" + coluna + "]:");
                matriz[linha][coluna] = scanner.nextInt();
            }
        }
        System.out.println("Digite o número escalar:");
        int escalar = scanner.nextInt();
        System.out.println("Matriz multiplicada por " + escalar + ":");
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print((matriz[linha][coluna] * escalar) + "\t");
            }
            System.out.println();
        }
        scanner.close();
    }
}
