package ListaDeExercicios06; // Ajuste ou remova conforme o pacote do projeto

import java.util.Arrays;
import java.util.Scanner;

public class Conjunto {
    private String[] elementos;
    private int quantidade;

    public Conjunto() {
        elementos = new String[2];
        quantidade = 0;
    }

    // Adiciona o elemento se ele ainda não estiver no conjunto
    public boolean adicionar(String elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException(
                "O elemento não pode ser nulo."
            );
        }

        if (pertence(elemento)) {
            return false;
        }

        garantirCapacidade();
        elementos[quantidade] = elemento;
        quantidade++;
        return true;
    }

    // Verifica se o elemento pertence ao conjunto
    public boolean pertence(String elemento) {
        if (elemento == null) {
            return false;
        }

        for (int i = 0; i < quantidade; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }

        return false;
    }

    // Retorna um novo conjunto com os elementos dos dois conjuntos
    public Conjunto uniao(Conjunto outro) {
        verificarOutroConjunto(outro);

        Conjunto resultado = new Conjunto();

        for (int i = 0; i < quantidade; i++) {
            resultado.adicionar(elementos[i]);
        }

        for (int i = 0; i < outro.quantidade; i++) {
            resultado.adicionar(outro.elementos[i]);
        }

        return resultado;
    }

    // Retorna um novo conjunto com os elementos comuns aos dois conjuntos
    public Conjunto inter(Conjunto outro) {
        verificarOutroConjunto(outro);

        Conjunto resultado = new Conjunto();

        for (int i = 0; i < quantidade; i++) {
            if (outro.pertence(elementos[i])) {
                resultado.adicionar(elementos[i]);
            }
        }

        return resultado;
    }

    // Retorna os elementos deste conjunto que não estão no outro
    public Conjunto menos(Conjunto outro) {
        verificarOutroConjunto(outro);

        Conjunto resultado = new Conjunto();

        for (int i = 0; i < quantidade; i++) {
            if (!outro.pertence(elementos[i])) {
                resultado.adicionar(elementos[i]);
            }
        }

        return resultado;
    }

    private void garantirCapacidade() {
        if (quantidade == elementos.length) {
            elementos = Arrays.copyOf(elementos, elementos.length * 2);
        }
    }

    private void verificarOutroConjunto(Conjunto outro) {
        if (outro == null) {
            throw new IllegalArgumentException(
                "O conjunto informado não pode ser nulo."
            );
        }
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder("{");

        for (int i = 0; i < quantidade; i++) {
            if (i > 0) {
                texto.append(", ");
            }

            texto.append(elementos[i]);
        }

        texto.append("}");
        return texto.toString();
    }

    private static Conjunto lerConjunto(Scanner entrada, String nome) {
        Conjunto conjunto = new Conjunto();

        System.out.println(
            "\nDigite os elementos de " + nome
            + ". Pressione Enter sem digitar nada para terminar."
        );

        while (true) {
            System.out.print("Elemento: ");
            String elemento = entrada.nextLine().trim();

            if (elemento.isEmpty()) {
                break;
            }

            if (conjunto.adicionar(elemento)) {
                System.out.println("Elemento adicionado.");
            } else {
                System.out.println("Esse elemento já existe no conjunto.");
            }
        }

        return conjunto;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            Conjunto conjuntoA = lerConjunto(entrada, "o conjunto A");
            Conjunto conjuntoB = lerConjunto(entrada, "o conjunto B");

            System.out.println("\nConjunto A: " + conjuntoA);
            System.out.println("Conjunto B: " + conjuntoB);
            System.out.println("União: " + conjuntoA.uniao(conjuntoB));
            System.out.println("Interseção: " + conjuntoA.inter(conjuntoB));
            System.out.println("A menos B: " + conjuntoA.menos(conjuntoB));

            System.out.print(
                "\nDigite um elemento para verificar se pertence a A: "
            );
            String elemento = entrada.nextLine();

            if (conjuntoA.pertence(elemento)) {
                System.out.println("O elemento pertence a A.");
            } else {
                System.out.println("O elemento não pertence a A.");
            }
        } finally {
            entrada.close();
        }
    }
}
