package Exercicio4;

import java.util.Scanner; // Importa a classe Scanner para ler dados digitados pelo teclado.

public class Exercicio04 { // Declara a classe chamada Exercicio04.

    public static void main(String[] args) { // Método principal: a execução do programa começa aqui.

        Scanner sc = new Scanner(System.in); // Cria um Scanner para receber dados do teclado.
        double soma = 0; // Cria a variável que acumulará os números; começa em zero.

        for (int i = 0; i < 6; i++) { // Repete o bloco 6 vezes, com i variando de 0 a 5.
            System.out.print("Digite o " + (i + 1) + "º número: "); // Pede o número atual; i + 1 mostra a contagem de 1 a 6.
            soma += sc.nextDouble(); // Lê um número decimal e adiciona seu valor à soma.
                                     // Equivale a: soma = soma + sc.nextDouble().
        } // Termina o laço que solicita e soma os 6 números.

        double media = soma / 6; // Calcula a média dividindo a soma por 6.
        System.out.println("Média: " + media); // Exibe a média calculada.

        sc.close(); // Fecha o Scanner após terminar a leitura.
    } // Termina o método main.
} // Termina a classe Exercicio04.
