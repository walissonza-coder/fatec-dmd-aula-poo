import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número:");
            numeros[i] = scanner.nextInt();
        }
        System.out.println("Digite o valor X:");
        int x = scanner.nextInt();
        int ocorrencias = 0;
        for (int numero : numeros) if (numero == x) ocorrencias++;
        System.out.println("O valor " + x + " aparece " + ocorrencias + " vez(es).");
        scanner.close();
    }
}
