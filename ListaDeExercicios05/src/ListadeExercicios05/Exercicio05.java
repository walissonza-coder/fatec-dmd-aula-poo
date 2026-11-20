package ListadeExercicios05;

import java.util.Scanner;

public class Exercicio05 {
    public static void mostrarMenu() {
        System.out.println("1 - Somar");
        System.out.println("2 - Subtrair");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
    }

    public static double somar(double a, double b) { return a + b; }
    public static double subtrair(double a, double b) { return a - b; }
    public static double multiplicar(double a, double b) { return a * b; }

    public static double dividir(double a, double b) {
        if (b == 0) throw new ArithmeticException("Não é possível dividir por zero.");
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mostrarMenu();
        System.out.println("Escolha uma opção:");
        int opcao = scanner.nextInt();

        if (opcao < 1 || opcao > 4) {
            System.out.println("Opção inválida.");
        } else {
            System.out.println("Digite o primeiro número:");
            double n1 = scanner.nextDouble();
            System.out.println("Digite o segundo número:");
            double n2 = scanner.nextDouble();
            double resultado;

            switch (opcao) {
                case 1: resultado = somar(n1, n2); break;
                case 2: resultado = subtrair(n1, n2); break;
                case 3: resultado = multiplicar(n1, n2); break;
                case 4:
                    if (n2 == 0) {
                        System.out.println("Erro: divisão por zero.");
                        scanner.close();
                        return;
                    }
                    resultado = dividir(n1, n2);
                    break;
                default: scanner.close(); return;
            }
            System.out.println("Resultado: " + resultado);
        }
        scanner.close();
    }
}

