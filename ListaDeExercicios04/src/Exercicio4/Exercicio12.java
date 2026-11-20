package Exercicio4;

import java.util.Scanner; // Importa a classe Scanner para ler dados digitados pelo usuário.

public class Exercicio12 { // Declara a classe chamada Exercicio12.
    public static void main(String[] args) { // Método principal: o programa começa a ser executado aqui.
        Scanner sc = new Scanner(System.in); // Cria um Scanner para ler valores pelo teclado.
        int[][] m = new int[3][3]; // Cria uma matriz de inteiros com 3 linhas e 3 colunas.
        int soma = 0; // Cria a variável soma e inicia seu valor em zero.

        // Percorre as três linhas da matriz.
        for (int i = 0; i < 3; i++) {
            // Percorre as três colunas da linha atual.
            for (int j = 0; j < 3; j++) {
                // Solicita um número e informa a linha e a coluna correspondentes.
                System.out.print("Digite o número da linha " + (i + 1)
                        + ", coluna " + (j + 1) + ": ");

                // Lê o número digitado e o armazena na posição atual da matriz.
                m[i][j] = sc.nextInt();

                // Adiciona o número lido à soma acumulada.
                soma += m[i][j];
            } // Finaliza o percurso das colunas da linha atual.
        } // Finaliza o percurso das linhas da matriz.

        // Exibe um título antes de mostrar a matriz.
        System.out.println("\nMatriz informada:");

        // Percorre novamente as três linhas para exibir a matriz.
        for (int i = 0; i < 3; i++) {
            // Percorre as três colunas da linha atual.
            for (int j = 0; j < 3; j++) {
                // Exibe o valor da posição atual, seguido de uma tabulação.
                System.out.print(m[i][j] + "\t");
            } // Finaliza a exibição das colunas da linha atual.

            // Pula para a linha seguinte da saída.
            System.out.println();
        } // Finaliza a exibição de todas as linhas da matriz.

        // Exibe a soma dos valores depois da matriz.
        System.out.println("Soma dos valores da matriz: " + soma);

        sc.close(); // Fecha o Scanner após a leitura dos dados.
    } // Finaliza o método principal.
} // Finaliza a classe Exercicio12.

