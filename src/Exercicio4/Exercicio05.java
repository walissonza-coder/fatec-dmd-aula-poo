
package Exercicio4;

import java.util.Scanner; // Importa a classe Scanner para ler dados digitados pelo teclado.

public class Exercicio05 { // Declara a classe chamada Exercicio05.

    public static void main(String[] args) { // Método principal: a execução do programa começa aqui.

        Scanner sc = new Scanner(System.in); // Cria um Scanner para receber dados do teclado.
        int pares = 0; // Cria um contador de números pares e inicia seu valor em zero.

        for (int i = 0; i < 10; i++) { // Repete o bloco 10 vezes; i varia de 0 até 9.
            System.out.print("Digite o " + (i + 1) + "º número: "); // Solicita o próximo número; i + 1 mostra a contagem de 1 a 10.
            int n = sc.nextInt(); // Lê o número inteiro digitado e guarda seu valor em n.

            if (n % 2 == 0) { // Verifica se o resto da divisão de n por 2 é zero, ou seja, se n é par.
                pares++; // Se n for par, aumenta o contador em 1.
            } // Termina o bloco da condição if.
        } // Termina o laço que solicita e verifica os 10 números.

        System.out.println("Quantidade de números pares: " + pares); // Exibe quantos números pares foram digitados.

        sc.close(); // Fecha o Scanner após terminar a leitura.
    } // Termina o método main.
} // Termina a classe Exercicio05.

