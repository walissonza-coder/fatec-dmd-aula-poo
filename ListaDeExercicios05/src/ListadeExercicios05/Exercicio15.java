package ListadeExercicios05;

import java.util.Random;
import java.util.Scanner;

public class Exercicio15 {
    public static void iniciarJogo() {
        System.out.println("=== JOGO DE BATALHA ===");
        System.out.println("Derrote o monstro para vencer.");
    }

    public static void mostrarMenu() {
        System.out.println("1 - Atacar");
        System.out.println("2 - Curar");
        System.out.println("3 - Ver status");
    }

    public static int atacar() {
        return new Random().nextInt(16) + 5;
    }

    public static int receberDano() {
        return new Random().nextInt(11) + 5;
    }

    public static int curar(int vida) {
        return Math.min(100, vida + 15);
    }

    public static void mostrarStatus(int vidaJogador, int vidaMonstro) {
        System.out.println("Vida do jogador: " + vidaJogador);
        System.out.println("Vida do monstro: " + vidaMonstro);
    }

    public static boolean verificarVitoria(int vidaMonstro) {
        return vidaMonstro <= 0;
    }

    public static boolean verificarDerrota(int vidaJogador) {
        return vidaJogador <= 0;
    }

    public static void encerrarJogo(boolean venceu) {
        System.out.println(venceu ? "Você venceu!" : "Você perdeu!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vidaJogador = 100;
        int vidaMonstro = 80;
        iniciarJogo();

        while (!verificarVitoria(vidaMonstro) && !verificarDerrota(vidaJogador)) {
            mostrarStatus(vidaJogador, vidaMonstro);
            mostrarMenu();
            System.out.println("Escolha uma opção:");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                int danoJogador = atacar();
                vidaMonstro = Math.max(0, vidaMonstro - danoJogador);
                System.out.println("Você causou " + danoJogador + " de dano.");
            } else if (opcao == 2) {
                vidaJogador = curar(vidaJogador);
                System.out.println("Você recuperou vida.");
            } else if (opcao == 3) {
                continue;
            } else {
                System.out.println("Opção inválida.");
                continue;
            }

            if (!verificarVitoria(vidaMonstro)) {
                int danoMonstro = receberDano();
                vidaJogador = Math.max(0, vidaJogador - danoMonstro);
                System.out.println("O monstro causou " + danoMonstro + " de dano.");
            }
        }
        encerrarJogo(verificarVitoria(vidaMonstro));
        scanner.close();
    }
}
