package Exercicio4;

import java.util.Scanner; // Importa a classe Scanner para ler dados digitados pelo teclado.

public class Exercicio08 { // Declara a classe chamada Exercicio08.

    public static void main(String[] args) { // Método principal: a execução do programa começa aqui.

        Scanner sc = new Scanner(System.in); // Cria um Scanner para receber dados do teclado.
        int[] numeros = new int[10]; // Cria um array de inteiros com 10 posições, de índice 0 a 9.

        // Lê os 10 números e armazena-os no array.
        for (int i = 0; i < numeros.length; i++) { // Percorre todas as posições do array.
            System.out.print("Digite o " + (i + 1) + "º número: "); // Solicita o número atual; i + 1 mostra a contagem de 1 a 10.
            numeros[i] = sc.nextInt(); // Lê o número digitado e armazena na posição i.
        } // Termina o laço que preenche o array.

        // Lê o valor que será procurado.
        System.out.print("Digite o valor de X: "); // Solicita o valor que será contado no array.
        int x = sc.nextInt(); // Lê o valor digitado e guarda na variável x.

        // Conta quantas vezes X aparece no array.
        int quantidade = 0; // Cria o contador de ocorrências e inicia em zero.
        for (int i = 0; i < numeros.length; i++) { // Percorre todas as posições do array.
            if (numeros[i] == x) { // Verifica se o valor atual é igual a x.
                quantidade++; // Se for igual, aumenta o contador em 1.
            } // Termina a condição if.
        } // Termina o laço que conta as ocorrências de x.

        System.out.println("O valor " + x + " aparece " + quantidade + " vez(es) no array."); // Exibe quantas vezes x apareceu.

        sc.close(); // Fecha o Scanner após terminar a leitura.
    } // Termina o método main.
} // Termina a classe Exercicio08.
