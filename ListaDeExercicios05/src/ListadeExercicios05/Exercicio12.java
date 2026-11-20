
package ListadeExercicios05;

import java.util.Random;
import java.util.Scanner;

public class Exercicio12 {
    public static void mostrarMenu() {
        System.out.println("1 - Pedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tesoura");
    }

    public static int jogadaComputador() {
        return new Random().nextInt(3) + 1;
    }

    public static String nomeJogada(int jogada) {
        switch (jogada) {
            case 1: return "Pedra";
            case 2: return "Papel";
            case 3: return "Tesoura";
            default: return "Inválida";
        }
    }

    public static String verificarVencedor(int jogador, int computador) {
        if (jogador == computador) return "Empate";
        if ((jogador == 1 && computador == 3)
                || (jogador == 2 && computador == 1)
                || (jogador == 3 && computador == 2)) {
            return "Jogador venceu";
        }
        return "Computador venceu";
    }

    public static void mostrarResultado(int jogador, int computador, String resultado) {
        System.out.println("Jogador: " + nomeJogada(jogador));
        System.out.println("Computador: " + nomeJogada(computador));
        System.out.println("Resultado: " + resultado);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mostrarMenu();
        System.out.println("Escolha sua jogada (1, 2 ou 3):");
        int jogador = scanner.nextInt();
        while (jogador < 1 || jogador > 3) {
            System.out.println("Opção inválida. Escolha 1, 2 ou 3:");
            jogador = scanner.nextInt();
        }
        int computador = jogadaComputador();
        mostrarResultado(jogador, computador, verificarVencedor(jogador, computador));
        scanner.close();
    }
}
