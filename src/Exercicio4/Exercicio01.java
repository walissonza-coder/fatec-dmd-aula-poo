package Exercicio4;


import java.util.Scanner; // Importa Scanner para ler dados digitados pelo teclado.

public class Exercicio01 { // Declara a classe chamada Exercicio01.

    public static void main(String[] args) { // Método principal: o programa começa a ser executado aqui.

        Scanner sc = new Scanner(System.in); // Cria um Scanner para ler dados da entrada padrão, normalmente o teclado.

        int[] v = new int[5]; // Cria um vetor de inteiros com 5 posições, inicialmente preenchidas com zero.

        for (int i = 0; i < v.length; i++) { // Percorre as posições do vetor, de 0 até 4.
            v[i] = sc.nextInt(); // Lê um número inteiro e guarda na posição atual do vetor.
        } // Termina o laço que preenche o vetor.

        for (int i = 0; i < v.length; i++) { // Percorre novamente todas as posições do vetor.
            System.out.println(v[i]); // Exibe o valor armazenado na posição atual.
        } // Termina o laço que imprime os valores.

        sc.close(); // Fecha o Scanner depois de terminar a leitura.
    } // Termina o método main.
} // Termina a classe Exercicio01.



