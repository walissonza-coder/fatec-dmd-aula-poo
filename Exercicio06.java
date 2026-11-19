import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[5];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número:");
            numeros[i] = scanner.nextInt();
        }
        System.out.println("Array na ordem inversa:");
        for (int i = numeros.length - 1; i >= 0; i--) System.out.println(numeros[i]);
        scanner.close();
    }
}
