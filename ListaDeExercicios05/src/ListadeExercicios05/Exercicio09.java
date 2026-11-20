package ListadeExercicios05;

import java.util.Scanner;

public class Exercicio09 {
    public static void mostrarMenu() {
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Consultar saldo");
    }

    public static double depositar(double saldo, double valor) {
        if (valor <= 0) {
            System.out.println("O depósito deve ser maior que zero.");
            return saldo;
        }
        return saldo + valor;
    }

    public static double sacar(double saldo, double valor) {
        if (valor <= 0) {
            System.out.println("O saque deve ser maior que zero.");
            return saldo;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return saldo;
        }
        return saldo - valor;
    }

    public static void consultarSaldo(double saldo) {
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 1000.00;
        mostrarMenu();
        System.out.println("Escolha: ");
        int opcao = scanner.nextInt();

        if (opcao == 1 || opcao == 2) {
            System.out.println("Digite o valor: R$ ");
            double valor = scanner.nextDouble();
            saldo = (opcao == 1) ? depositar(saldo, valor) : sacar(saldo, valor);
        } else if (opcao != 3) {
            System.out.println("Opção inválida.");
        }
        consultarSaldo(saldo);
        scanner.close();
    }
}

