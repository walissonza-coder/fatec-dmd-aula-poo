package Exercicio4;

import java.util.Scanner; // Importa a classe Scanner para ler dados digitados pelo teclado.

public class Exercicio06 { // Declara a classe chamada Exercicio06.

    public static void main(String[] args) { // Método principal: a execução do programa começa aqui.

        Scanner sc = new Scanner(System.in); // Cria um Scanner para receber dados do teclado.
        int[] v = new int[5]; // Cria um vetor de inteiros com 5 posições, de índice 0 a 4.

        for (int i = 0; i < v.length; i++) { // Percorre o vetor da primeira à última posição.
            System.out.print("Digite o " + (i + 1) + "º número: "); // Solicita o número atual; i + 1 mostra a contagem de 1 a 5.
            v[i] = sc.nextInt(); // Lê o número digitado e o guarda na posição i do vetor.
        } // Termina o laço que preenche o vetor.

        System.out.println("Números na ordem inversa:"); // Informa que os números serão exibidos de trás para frente.

        for (int i = v.length - 1; i >= 0; i--) { // Percorre o vetor do último índice até o índice 0.
            System.out.println(v[i]); // Exibe o valor armazenado na posição atual.
        } // Termina o laço que imprime os valores na ordem inversa.

        sc.close(); // Fecha o Scanner após terminar a leitura.
    } // Termina o método main.
} // Termina a classe Exercicio06.

