package ListadeExercicios05;

import java.util.Random;
import java.util.Scanner;

public class Exercicio11 {
    public static int sortearNumero() {
        return new Random().nextInt(100) + 1;
    }

    public static boolean verificarAcerto(int palpite, int numeroSecreto) {
        return palpite == numeroSecreto;
    }

    public static void mostrarDica(int palpite, int numeroSecreto) {
        if (palpite < numeroSecreto) {
            System.out.println("Tente um número maior.");
        } else {
            System.out.println("Tente um número menor.");
        }
    }

    public static void mostrarVitoria(int tentativas) {
        System.out.println("Parabéns! Você acertou em " + tentativas + " tentativa(s).");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroSecreto = sortearNumero();
        int tentativas = 0;
        boolean acertou = false;

        while (!acertou) {
            System.out.println("Digite seu palpite (1 a 100, ou 0 para sair):");
            int palpite = scanner.nextInt();
            if (palpite == 0) {
                System.out.println("Jogo encerrado. O número era " + numeroSecreto + ".");
                break;
            }
            if (palpite < 1 || palpite > 100) {
                System.out.println("Digite um número entre 1 e 100.");
                continue;
            }
            tentativas++;
            acertou = verificarAcerto(palpite, numeroSecreto);
            if (acertou) {
                mostrarVitoria(tentativas);
            } else {
                mostrarDica(palpite, numeroSecreto);
            }
        }
        scanner.close();
    }
}
