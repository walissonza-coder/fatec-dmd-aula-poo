package Exercicio4;

import java.util.Scanner; // Importa a classe Scanner para ler dados digitados pelo usuário.

public class Exercicio10 { // Declara a classe chamada Exercicio10.
    public static void main(String[] args) { // Ponto de entrada: o programa começa a executar aqui.
        Scanner sc = new Scanner(System.in); // Cria um Scanner para ler dados do teclado.
        int[] v = new int[10]; // Cria um array de inteiros com espaço para 10 números.

        // Percorre todas as posições do array para pedir os números.
        for (int i = 0; i < v.length; i++) {
            // Mostra qual número o usuário deve digitar.
            System.out.print("Digite o " + (i + 1) + "º número: ");

            // Lê o número digitado e guarda na posição atual do array.
            v[i] = sc.nextInt();
        }

        // Mostra um título antes de exibir os números sem repetição.
        System.out.println("Números sem repetição:");

        // Percorre cada posição do array para verificar se o valor já apareceu.
        for (int i = 0; i < v.length; i++) {
            // Começa supondo que o valor atual ainda não apareceu antes.
            boolean repetido = false;

            // Verifica as posições anteriores à posição atual.
            for (int j = 0; j < i; j++) {
                // Se encontrar o mesmo valor antes, marca como repetido.
                if (v[i] == v[j]) {
                    repetido = true;
                }
            }

            // Se o valor não apareceu antes, ele é exibido.
            if (!repetido) {
                System.out.println(v[i]);
            }
        }

        sc.close(); // Fecha o Scanner após terminar de ler os dados.
    }
}

