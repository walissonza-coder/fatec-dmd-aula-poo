

import java.util.Scanner;

public class ExercicioJogoDaVelha {
    private static final Scanner SC = new Scanner(System.in);
    private static final char[][] tabuleiro = new char[3][3];

    public static void main(String[] args) {
        inicializarTabuleiro();
        char jogadorAtual = 'X';
        boolean houveVencedor = false;

        while (!houveVencedor && !tabuleiroCompleto()) {
            exibirTabuleiro();
            realizarJogada(jogadorAtual);

            if (verificarVitoria(jogadorAtual)) {
                houveVencedor = true;
            } else {
                jogadorAtual = trocarJogador(jogadorAtual);
            }
        }

        exibirTabuleiro();
        if (houveVencedor) {
            System.out.println("O jogador " + jogadorAtual + " venceu!");
        } else {
            System.out.println("A partida terminou empatada!");
        }
        SC.close();
    }

    private static void inicializarTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = ' ';
            }
        }
    }

    private static void exibirTabuleiro() {
        System.out.println("\n    1   2   3");
        System.out.println("  +---+---+---+");
        for (int linha = 0; linha < 3; linha++) {
            System.out.print((linha + 1) + " | ");
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + " | ");
            }
            System.out.println("\n  +---+---+---+");
        }
        System.out.println();
    }

    private static void realizarJogada(char jogador) {
        while (true) {
            int linha = lerInteiro("Jogador " + jogador + ", informe a linha (1 a 3): ");
            int coluna = lerInteiro("Jogador " + jogador + ", informe a coluna (1 a 3): ");

            if (!posicaoValida(linha, coluna)) {
                System.out.println("Posição inválida. Informe números entre 1 e 3.");
            } else if (tabuleiro[linha - 1][coluna - 1] != ' ') {
                System.out.println("Essa posição já está ocupada. Escolha outra posição.");
            } else {
                tabuleiro[linha - 1][coluna - 1] = jogador;
                return;
            }
        }
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = SC.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private static boolean posicaoValida(int linha, int coluna) {
        return linha >= 1 && linha <= 3 && coluna >= 1 && coluna <= 3;
    }

    private static boolean verificarVitoria(char jogador) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) {
                return true;
            }
        }

        boolean diagonalPrincipal = tabuleiro[0][0] == jogador
                && tabuleiro[1][1] == jogador
                && tabuleiro[2][2] == jogador;
        boolean diagonalSecundaria = tabuleiro[0][2] == jogador
                && tabuleiro[1][1] == jogador
                && tabuleiro[2][0] == jogador;

        return diagonalPrincipal || diagonalSecundaria;
    }

    private static boolean tabuleiroCompleto() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static char trocarJogador(char jogadorAtual) {
        return jogadorAtual == 'X' ? 'O' : 'X';
    }
}
