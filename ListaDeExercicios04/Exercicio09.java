import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número:");
            numeros[i] = scanner.nextInt();
        }
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temporario = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temporario;
                }
            }
        }
        System.out.println("Números em ordem crescente:");
        for (int numero : numeros) System.out.println(numero);
        scanner.close();
    }
}
