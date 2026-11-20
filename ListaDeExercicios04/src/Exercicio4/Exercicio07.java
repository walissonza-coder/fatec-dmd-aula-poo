package Exercicio4;

import java.util.Scanner; // Importa Scanner para ler dados digitados pelo teclado.

public class Exercicio07 { // Declara a classe chamada Exercicio07.

    public static void main(String[] args) { // Método principal: a execução do programa começa aqui.

        Scanner sc = new Scanner(System.in); // Cria um Scanner para receber dados do teclado.
        int[] v = new int[10]; // Cria um vetor de inteiros com 10 posições, de índice 0 a 9.
        boolean achou = false; // Indica se o número procurado foi encontrado; começa como false.

        for (int i = 0; i < v.length; i++) { // Percorre todas as posições do vetor.
            System.out.print("Digite o " + (i + 1) + "º número do vetor: "); // Solicita o número atual; i + 1 exibe a contagem de 1 a 10.
            v[i] = sc.nextInt(); // Lê o número digitado e guarda na posição i do vetor.
        } // Termina o laço que preenche o vetor.

        System.out.print("Digite o número que deseja procurar: "); // Solicita o valor que será buscado.
        int x = sc.nextInt(); // Lê o número procurado e guarda na variável x.

        for (int i = 0; i < v.length; i++) { // Percorre o vetor para comparar cada valor com x.
            if (v[i] == x) { // Verifica se o valor da posição atual é igual ao número procurado.
                achou = true; // Registra que o número foi encontrado.
            } // Termina a condição if.
        } // Termina o laço de busca.

        System.out.println(achou ? "Número encontrado." : "Número não encontrado."); // Exibe a mensagem correspondente ao resultado da busca.

        sc.close(); // Fecha o Scanner após terminar a leitura.
    } // Termina o método main.
} // Termina a classe Exercicio07.


