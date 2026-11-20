package ListadeExercicios05;

import java.util.Scanner;

public class Exercicio14 {
    public static void mostrarMenu() {
        System.out.println("\n1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Consultar saldo");
        System.out.println("0 - Encerrar");
    }

    public static double depositar(double saldo, double valor) {
        if (valor <= 0) {
            System.out.println("O valor do depósito deve ser maior que zero.");
            return saldo;
        }
        return saldo + valor;
    }

    public static double sacar(double saldo, double valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser maior que zero.");
            return saldo;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return saldo;
        }
        return saldo - valor;
    }

    public static void consultarSaldo(double saldo) {
        System.out.printf("Saldo: R$ %.2f%n", saldo);
    }

    public static void encerrarSistema() {
        System.out.println("Sistema encerrado.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 1000.00;
        int opcao;
        do {
            mostrarMenu();
            System.out.println("Escolha uma opção:");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor do depósito:");
                    saldo = depositar(saldo, scanner.nextDouble());
                    break;
                case 2:
                    System.out.println("Digite o valor do saque:");
                    saldo = sacar(saldo, scanner.nextDouble());
                    break;
                case 3: consultarSaldo(saldo); break;
                case 0: encerrarSistema(); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
