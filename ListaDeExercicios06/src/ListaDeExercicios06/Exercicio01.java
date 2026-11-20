package ListaDeExercicios06; 

import java.util.Scanner;

public class Exercicio01 {
    private int valor;

    public void zerar() {
        valor = 0;
    }

    public void incrementar() {
        valor++;
    }

    public int getValor() {
        return valor;
    }

    public static void main(String[] args) {
        Exercicio01 exercicio01 = new Exercicio01();
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Contador ---");
            System.out.println("1 - Incrementar");
            System.out.println("2 - Zerar");
            System.out.println("3 - Mostrar valor");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    exercicio01.incrementar();
                    System.out.println("Contador incrementado.");
                    break;
                case 2:
                    exercicio01.zerar();
                    System.out.println("Contador zerado.");
                    break;
                case 3:
                    System.out.println("Valor atual: " + exercicio01.getValor());
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        entrada.close();
    }
}
