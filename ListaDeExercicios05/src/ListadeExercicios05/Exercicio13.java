package ListadeExercicios05;

import java.util.Scanner;

public class Exercicio13 {
    public static void mostrarStatus(String nome, int vida) {
        System.out.println("Personagem: " + nome + " | Vida: " + vida + "/100");
    }

    public static int atacar() {
        return 10;
    }

    public static int receberDano(int vida, int dano) {
        return Math.max(0, vida - dano);
    }

    public static int curar(int vida) {
        return Math.min(100, vida + 15);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do personagem:");
        String nome = scanner.nextLine();
        int vida = 100;
        mostrarStatus(nome, vida);

        int dano = atacar();
        System.out.println("O personagem recebe " + dano + " de dano.");
        vida = receberDano(vida, dano);
        mostrarStatus(nome, vida);

        vida = curar(vida);
        System.out.println("Após a cura:");
        mostrarStatus(nome, vida);
        scanner.close();
    }
}
