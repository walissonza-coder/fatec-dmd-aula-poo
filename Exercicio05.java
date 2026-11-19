import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        int quantidadePares = 0;
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número:");
            numeros[i] = scanner.nextInt();
            if (numeros[i] % 2 == 0) quantidadePares++;
        }
        System.out.println("Quantidade de números pares: " + quantidadePares);
        scanner.close();
    }
}
