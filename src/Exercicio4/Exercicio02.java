package Exercicio4;

import java.util.Scanner; // Importa a classe Scanner para ler dados digitados pelo teclado.

public class Exercicio02 { // Declara a classe chamada Exercicio02.

    public static void main(String[] args) { // Método principal: a execução do programa começa aqui.

        Scanner sc = new Scanner(System.in); // Cria um Scanner para ler dados do teclado.
        int soma = 0; // Cria a variável soma e inicia o total em zero.

        for (int i = 0; i < 10; i++) { // Repete o bloco 10 vezes; i vai de 0 até 9.
            System.out.print("Digite o " + (i + 1) + "º número: "); // Pede o próximo número.
                                                                      // i + 1 mostra a contagem de 1 a 10.
            soma += sc.nextInt(); // Lê o número digitado e adiciona seu valor à soma.
                                  // Equivale a: soma = soma + sc.nextInt().
        } // Termina o laço que solicita e soma os 10 números.

        System.out.println("A soma dos números é: " + soma); // Exibe a soma calculada.

        sc.close(); // Fecha o Scanner após terminar a leitura.
    } // Termina o método main.
} // Termina a classe Exercicio02.


