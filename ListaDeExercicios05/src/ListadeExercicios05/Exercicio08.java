package ListadeExercicios05;

import java.util.Scanner;

public class Exercicio08 {
    public static void mostrarResumo(String nome, int idade, String cidade) {
        System.out.println("\n--- Resumo ---");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Cidade: " + cidade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite sua idade:");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite sua cidade:");
        String cidade = scanner.nextLine();

        mostrarResumo(nome, idade, cidade);
        scanner.close();
    }
}

