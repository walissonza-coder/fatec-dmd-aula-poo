package Exercicio4;

import java.util.Scanner; // Importa a classe Scanner para ler dados digitados pelo teclado.

public class Exercicio03 { // Declara a classe chamada Exercicio03.

    public static void main(String[] args) { // Método principal: a execução do programa começa aqui.

        Scanner sc = new Scanner(System.in); // Cria um Scanner para receber dados do teclado.

        int[] v = new int[8]; // Cria um vetor de inteiros com 8 posições, numeradas de 0 a 7.

        for (int i = 0; i < v.length; i++) { // Percorre todas as posições do vetor.
            System.out.print("Digite o " + (i + 1) + "º número: "); // Solicita o número atual; i + 1 mostra a contagem de 1 a 8.
            v[i] = sc.nextInt(); // Lê o número digitado e armazena na posição i do vetor.
        } // Termina o laço que lê os 8 números.

        int maior = v[0]; // Assume que o primeiro número do vetor é o maior até o momento.
        int menor = v[0]; // Assume que o primeiro número do vetor é o menor até o momento.

        for (int i = 1; i < v.length; i++) { // Percorre o vetor a partir da segunda posição, pois a primeira já foi considerada.
            if (v[i] > maior) maior = v[i]; // Se o número atual for maior que maior, atualiza maior.
            if (v[i] < menor) menor = v[i]; // Se o número atual for menor que menor, atualiza menor.
        } // Termina o laço que procura o maior e o menor número.

        System.out.println("Maior: " + maior); // Exibe o maior número encontrado.
        System.out.println("Menor: " + menor); // Exibe o menor número encontrado.

        sc.close(); // Fecha o Scanner após terminar a leitura.
    } // Termina o método main.
} // Termina a classe Exercicio03.
