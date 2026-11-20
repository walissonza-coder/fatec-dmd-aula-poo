package ListaDeExercicios06; // Ajuste ou remova conforme o pacote do projeto

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Pais {
    private String codigoISO;
    private String nome;
    private long populacao;
    private double dimensaoKm2;

    private final Pais[] paisesLimitrofes = new Pais[40];
    private int quantidadeLimitrofes;

    // Construtor: inicializa o código ISO, o nome e a dimensão
    public Pais(String codigoISO, String nome, double dimensaoKm2) {
        setCodigoISO(codigoISO);
        setNome(nome);
        setDimensaoKm2(dimensaoKm2);
        this.populacao = 0;
        this.quantidadeLimitrofes = 0;
    }

    // Getters e setters
    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        if (codigoISO == null || codigoISO.trim().length() != 3) {
            throw new IllegalArgumentException(
                "O código ISO deve conter três letras."
            );
        }

        this.codigoISO = codigoISO.trim().toUpperCase(Locale.ROOT);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ficar vazio.");
        }

        this.nome = nome.trim();
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        if (populacao < 0) {
            throw new IllegalArgumentException(
                "A população não pode ser negativa."
            );
        }

        this.populacao = populacao;
    }

    public double getDimensaoKm2() {
        return dimensaoKm2;
    }

    public void setDimensaoKm2(double dimensaoKm2) {
        if (dimensaoKm2 <= 0) {
            throw new IllegalArgumentException(
                "A dimensão deve ser maior que zero."
            );
        }

        this.dimensaoKm2 = dimensaoKm2;
    }

    // Adiciona um país à lista de vizinhos
    public void adicionarPaisLimitrofe(Pais pais) {
        if (pais == null) {
            throw new IllegalArgumentException("O país não pode ser nulo.");
        }

        if (this.equals(pais)) {
            throw new IllegalArgumentException(
                "Um país não pode fazer fronteira consigo mesmo."
            );
        }

        if (ehLimitrofe(pais)) {
            return; // Evita adicionar o mesmo vizinho duas vezes
        }

        if (quantidadeLimitrofes == paisesLimitrofes.length) {
            throw new IllegalStateException(
                "O país já possui 40 vizinhos cadastrados."
            );
        }

        paisesLimitrofes[quantidadeLimitrofes] = pais;
        quantidadeLimitrofes++;
    }

    // Verifica se outro país está na lista de vizinhos
    public boolean ehLimitrofe(Pais outroPais) {
        if (outroPais == null) {
            return false;
        }

        for (int i = 0; i < quantidadeLimitrofes; i++) {
            if (paisesLimitrofes[i].equals(outroPais)) {
                return true;
            }
        }

        return false;
    }

    // Retorna a densidade populacional em habitantes por km²
    public double calcularDensidadePopulacional() {
        return populacao / dimensaoKm2;
    }

    // Retorna um array com os vizinhos comuns entre este país e outro
    public Pais[] paisesVizinhosComuns(Pais outroPais) {
        if (outroPais == null) {
            return new Pais[0];
        }

        Pais[] comuns = new Pais[40];
        int quantidadeComuns = 0;

        for (int i = 0; i < quantidadeLimitrofes; i++) {
            Pais vizinho = paisesLimitrofes[i];

            if (outroPais.ehLimitrofe(vizinho)) {
                comuns[quantidadeComuns] = vizinho;
                quantidadeComuns++;
            }
        }

        return Arrays.copyOf(comuns, quantidadeComuns);
    }

    // Dois países são iguais quando têm o mesmo código ISO
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Pais)) {
            return false;
        }

        Pais outroPais = (Pais) objeto;
        return codigoISO.equals(outroPais.codigoISO);
    }

    @Override
    public int hashCode() {
        return codigoISO.hashCode();
    }

    @Override
    public String toString() {
        return nome + " (" + codigoISO + ")";
    }

    // Lê os dados de um país pelo teclado
    private static Pais lerPais(Scanner entrada) {
        System.out.print("Código ISO de três letras: ");
        String codigo = entrada.nextLine();

        System.out.print("Nome do país: ");
        String nome = entrada.nextLine();

        System.out.print("Dimensão em km²: ");
        double dimensao = Double.parseDouble(
            entrada.nextLine().replace(',', '.')
        );

        System.out.print("População: ");
        long populacao = Long.parseLong(entrada.nextLine());

        Pais pais = new Pais(codigo, nome, dimensao);
        pais.setPopulacao(populacao);

        return pais;
    }

    // Lê e cadastra os países limítrofes
    private static void lerPaisesLimitrofes(Scanner entrada, Pais pais) {
        System.out.print(
            "Quantos países limítrofes deseja cadastrar para "
            + pais.getNome() + "? "
        );

        int quantidade = Integer.parseInt(entrada.nextLine());

        if (quantidade < 0 || quantidade > 40) {
            throw new IllegalArgumentException(
                "A quantidade deve estar entre 0 e 40."
            );
        }

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nDados do país vizinho " + (i + 1) + ":");
            pais.adicionarPaisLimitrofe(lerPais(entrada));
        }
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("Cadastro do primeiro país!");
            Pais pais1 = lerPais(entrada);

            System.out.println("\nCadastro do segundo país!");
            Pais pais2 = lerPais(entrada);

            System.out.println("\nVizinhos do primeiro país!");
            lerPaisesLimitrofes(entrada, pais1);

            System.out.println("\nVizinhos do segundo país!");
            lerPaisesLimitrofes(entrada, pais2);

            System.out.println("\nDensidade de " + pais1.getNome() + ": "
                + pais1.calcularDensidadePopulacional()
                + " habitantes/km²");

            System.out.println("Densidade de " + pais2.getNome() + ": "
                + pais2.calcularDensidadePopulacional()
                + " habitantes/km²");

            Pais[] comuns = pais1.paisesVizinhosComuns(pais2);

            System.out.println("\nPaíses limítrofes de ambos:");
            if (comuns.length == 0) {
                System.out.println("Não há vizinhos comuns.");
            } else {
                for (Pais pais : comuns) {
                    System.out.println("- " + pais);
                }
            }
        } catch (IllegalArgumentException | IllegalStateException erro) {
            System.out.println("Erro: " + erro.getMessage());
        } finally {
            entrada.close();
        }
    }
}
