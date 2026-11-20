import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[8];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número:");
            numeros[i] = scanner.nextInt();
        }
        int maior = numeros[0];
        int menor = numeros[0];
        for (int numero : numeros) {
            if (numero > maior) maior = numero;
            if (numero < menor) menor = numero;
        }
        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);
        scanner.close();
    }
}
