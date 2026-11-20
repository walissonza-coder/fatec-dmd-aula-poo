package Exercicio4;

import java.util.Scanner; // Importa a classe Scanner para ler dados digitados pelo teclado.

public class Exercicio09 { // Declara a classe chamada Exercicio09.

    public static void main(String[] args) { // Método principal: a execução do programa começa aqui.

        Scanner sc = new Scanner(System.in); // Cria um Scanner para receber dados do teclado.
        int[] v = new int[10]; // Cria um vetor de inteiros com 10 posições, de índice 0 a 9.

        for (int i = 0; i < v.length; i++) { // Percorre todas as posições do vetor para preenchê-las.
            System.out.print("Digite o " + (i + 1) + "º número: "); // Solicita um número; i + 1 mostra a contagem de 1 a 10.
            v[i] = sc.nextInt(); // Lê o inteiro digitado e armazena na posição i do vetor.
        } // Termina o laço que lê os números.

        for (int i = 0; i < v.length - 1; i++) { // Controla as passagens do Bubble Sort; são necessárias no máximo 9.
            for (int j = 0; j < v.length - 1 - i; j++) { // Compara pares vizinhos; reduz as comparações a cada passagem.
                if (v[j] > v[j + 1]) { // Verifica se o número atual é maior que o próximo.
                    int temp = v[j]; // Guarda temporariamente o valor atual para não perdê-lo.
                    v[j] = v[j + 1]; // Coloca o próximo valor na posição atual.
                    v[j + 1] = temp; // Coloca o valor guardado na posição seguinte, concluindo a troca.
                } // Termina a condição de troca.
            } // Termina uma passagem de comparações do Bubble Sort.
        } // Termina a ordenação; o vetor fica em ordem crescente.

        System.out.println("Números em ordem crescente:"); // Exibe um título antes dos números ordenados.
        for (int i = 0; i < v.length; i++) { // Percorre todas as posições do vetor ordenado.
            System.out.println(v[i]); // Exibe o valor da posição atual.
        } // Termina o laço de impressão.

        sc.close(); // Fecha o Scanner após terminar a leitura.
    } // Termina o método main.
} // Termina a classe Exercicio09.
   