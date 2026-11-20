package ListaDeExercicios06; // Ajuste ou remova conforme o pacote do projeto

import java.util.Scanner;

public class Continente {
    private String nome;
    private Pais[] paises;
    private int quantidadePaises;

    private static final int MAXIMO_PAÍSES = 48;

    // Construtor que inicializa o nome do continente
    public Continente(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "O nome do continente não pode ficar vazio."
            );
        }

        this.nome = nome.trim();
        this.paises = new Pais[MAXIMO_PAÍSES];
        this.quantidadePaises = 0;
    }

    public String getNome() {
        return nome;
    }

    // Adiciona um país ao continente
    public void adicionarPais(Pais pais) {
        if (pais == null) {
            throw new IllegalArgumentException("O país não pode ser nulo.");
        }

        if (quantidadePaises >= MAXIMO_PAÍSES) {
            throw new IllegalStateException(
                "O continente já possui o máximo de 48 países."
            );
        }

        paises[quantidadePaises] = pais;
        quantidadePaises++;
    }

    // Retorna a dimensão territorial total, em km²
    public double getDimensaoTotal() {
        double total = 0;

        for (int i = 0; i < quantidadePaises; i++) {
            total += paises[i].getDimensaoKm2();
        }

        return total;
    }

    // Retorna a população total
    public long getPopulacaoTotal() {
        long total = 0;

        for (int i = 0; i < quantidadePaises; i++) {
            total += paises[i].getPopulacao();
        }

        return total;
    }

    // Retorna a densidade populacional total, em habitantes por km²
    public double getDensidadePopulacional() {
        double dimensaoTotal = getDimensaoTotal();

        if (dimensaoTotal == 0) {
            return 0;
        }

        return getPopulacaoTotal() / dimensaoTotal;
    }

    // Retorna o país com maior população; null se não houver países
    public Pais getPaisMaiorPopulacao() {
        if (quantidadePaises == 0) {
            return null;
        }

        Pais maior = paises[0];

        for (int i = 1; i < quantidadePaises; i++) {
            if (paises[i].getPopulacao() > maior.getPopulacao()) {
                maior = paises[i];
            }
        }

        return maior;
    }

    // Retorna o país com menor população; null se não houver países
    public Pais getPaisMenorPopulacao() {
        if (quantidadePaises == 0) {
            return null;
        }

        Pais menor = paises[0];

        for (int i = 1; i < quantidadePaises; i++) {
            if (paises[i].getPopulacao() < menor.getPopulacao()) {
                menor = paises[i];
            }
        }

        return menor;
    }

    // Retorna o país de maior dimensão territorial
    public Pais getPaisMaiorDimensao() {
        if (quantidadePaises == 0) {
            return null;
        }

        Pais maior = paises[0];

        for (int i = 1; i < quantidadePaises; i++) {
            if (paises[i].getDimensaoKm2() > maior.getDimensaoKm2()) {
                maior = paises[i];
            }
        }

        return maior;
    }

    // Retorna o país de menor dimensão territorial
    public Pais getPaisMenorDimensao() {
        if (quantidadePaises == 0) {
            return null;
        }

        Pais menor = paises[0];

        for (int i = 1; i < quantidadePaises; i++) {
            if (paises[i].getDimensaoKm2() < menor.getDimensaoKm2()) {
                menor = paises[i];
            }
        }

        return menor;
    }

    // Retorna a razão entre a dimensão do maior e do menor país
    public double getRazaoTerritorial() {
        Pais maior = getPaisMaiorDimensao();
        Pais menor = getPaisMenorDimensao();

        if (maior == null || menor == null || menor.getDimensaoKm2() == 0) {
            return 0;
        }

        return maior.getDimensaoKm2() / menor.getDimensaoKm2();
    }

    // Método auxiliar para ler um país pelo teclado
    private static Pais lerPais(Scanner entrada) {
        System.out.print("Código ISO (ex.: BRA): ");
        String codigoISO = entrada.nextLine();

        System.out.print("Nome do país: ");
        String nomePais = entrada.nextLine();

        System.out.print("Dimensão em km²: ");
        double dimensao = Double.parseDouble(
            entrada.nextLine().replace(',', '.')
        );

        System.out.print("População: ");
        long populacao = Long.parseLong(entrada.nextLine());

        Pais pais = new Pais(codigoISO, nomePais, dimensao);
        pais.setPopulacao(populacao);

        return pais;
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.print("Nome do continente: ");
            Continente continente = new Continente(entrada.nextLine());

            System.out.print("Quantos países deseja cadastrar (máximo 48)? ");
            int quantidade = Integer.parseInt(entrada.nextLine());

            if (quantidade < 1 || quantidade > MAXIMO_PAÍSES) {
                throw new IllegalArgumentException(
                    "Informe uma quantidade entre 1 e 48."
                );
            }

            for (int i = 0; i < quantidade; i++) {
                System.out.println("\nCadastro do país " + (i + 1) + ":");
                continente.adicionarPais(lerPais(entrada));
            }

            System.out.println("\n--- Resumo de " + continente.getNome() + " ---");
            System.out.println("Dimensão total: "
                + continente.getDimensaoTotal() + " km²");
            System.out.println("População total: "
                + continente.getPopulacaoTotal());
            System.out.println("Densidade populacional: "
                + continente.getDensidadePopulacional()
                + " habitantes/km²");

            System.out.println("Maior população: "
                + continente.getPaisMaiorPopulacao());
            System.out.println("Menor população: "
                + continente.getPaisMenorPopulacao());
            System.out.println("Maior dimensão territorial: "
                + continente.getPaisMaiorDimensao());
            System.out.println("Menor dimensão territorial: "
                + continente.getPaisMenorDimensao());
            System.out.println("Razão territorial (maior/menor): "
                + continente.getRazaoTerritorial());

        } catch (IllegalArgumentException | IllegalStateException erro) {
            System.out.println("Erro: " + erro.getMessage());
        } finally {
            entrada.close();
        }
    }
}
