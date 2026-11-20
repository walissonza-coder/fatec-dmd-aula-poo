import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        boolean identidade = true;
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.println("Digite o valor da posição [" + linha + "][" + coluna + "]:");
                matriz[linha][coluna] = scanner.nextInt();
                int esperado = (linha == coluna) ? 1 : 0;
                if (matriz[linha][coluna] != esperado) identidade = false;
            }
        }
        if (identidade) System.out.println("A matriz é identidade.");
        else System.out.println("A matriz não é identidade.");
        scanner.close();
    }
}
