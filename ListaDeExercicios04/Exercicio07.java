import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número:");
            numeros[i] = scanner.nextInt();
        }
        System.out.println("Digite o valor X que deseja buscar:");
        int x = scanner.nextInt();
        boolean encontrado = false;
        for (int numero : numeros) if (numero == x) encontrado = true;
        if (encontrado) System.out.println("O valor está presente no array.");
        else System.out.println("O valor não está presente no array.");
        scanner.close();
    }
}
