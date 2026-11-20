import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[6];
        int soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número:");
            numeros[i] = scanner.nextInt();
            soma += numeros[i];
        }
        double media = (double) soma / numeros.length;
        System.out.printf("Média: %.2f%n", media);
        scanner.close();
    }
}
