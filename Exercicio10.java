import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        int[] unicos = new int[10];
        int quantidadeUnicos = 0;
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º número:");
            numeros[i] = scanner.nextInt();
        }
        for (int numero : numeros) {
            boolean jaExiste = false;
            for (int i = 0; i < quantidadeUnicos; i++) {
                if (unicos[i] == numero) jaExiste = true;
            }
            if (!jaExiste) unicos[quantidadeUnicos++] = numero;
        }
        System.out.println("Valores únicos:");
        for (int i = 0; i < quantidadeUnicos; i++) System.out.println(unicos[i]);
        scanner.close();
    }
}
