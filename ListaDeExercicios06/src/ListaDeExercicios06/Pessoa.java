package ListaDeExercicios06; 

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Pessoa {
    private String nome;
    private Pessoa pai;
    private Pessoa mae;

    // Construtor com nome, pai e mãe
    public Pessoa(String nome, Pessoa pai, Pessoa mae) {
        definirNome(nome);
        this.pai = pai;
        this.mae = mae;
    }

    // Construtor com nome; pai e mãe ficam null
    public Pessoa(String nome) {
        this(nome, null, null);
    }

    public String getNome() {
        return nome;
    }

    public Pessoa getPai() {
        return pai;
    }

    public Pessoa getMae() {
        return mae;
    }

    private void definirNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ficar vazio.");
        }

        this.nome = nome.trim();
    }

    // Duas pessoas são iguais se têm o mesmo nome e a mesma mãe
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Pessoa)) {
            return false;
        }

        Pessoa outra = (Pessoa) objeto;

        return nome.equalsIgnoreCase(outra.nome)
                && Objects.equals(mae, outra.mae);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase(Locale.ROOT), mae);
    }

    // São irmãs se compartilham pai ou mãe.
    // Pais com nomes iguais são considerados a mesma pessoa neste exercício.
    public boolean ehIrma(Pessoa outra) {
        if (outra == null || this.equals(outra)) {
            return false;
        }

        boolean mesmoPai = pai != null
                && outra.pai != null
                && pai.getNome().equalsIgnoreCase(outra.pai.getNome());

        boolean mesmaMae = mae != null
                && outra.mae != null
                && mae.getNome().equalsIgnoreCase(outra.mae.getNome());

        return mesmoPai || mesmaMae;
    }

    // Verifica se a pessoa informada é antecessora desta pessoa
    public boolean ehAntecessora(Pessoa antecessora) {
        if (antecessora == null) {
            return false;
        }

        if ((pai != null && pai.equals(antecessora))
                || (mae != null && mae.equals(antecessora))) {
            return true;
        }

        return (pai != null && pai.ehAntecessora(antecessora))
                || (mae != null && mae.ehAntecessora(antecessora));
    }

    // Procura uma pessoa pelo nome nesta árvore genealógica
    public Pessoa buscarNaArvore(String nomeProcurado) {
        if (nome.equalsIgnoreCase(nomeProcurado)) {
            return this;
        }

        Pessoa encontrada;

        if (pai != null) {
            encontrada = pai.buscarNaArvore(nomeProcurado);
            if (encontrada != null) {
                return encontrada;
            }
        }

        if (mae != null) {
            encontrada = mae.buscarNaArvore(nomeProcurado);
            if (encontrada != null) {
                return encontrada;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return nome;
    }

    // Cria uma pessoa sem pai ou mãe informados se o nome estiver vazio
    private static Pessoa criarPessoaSeInformada(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        return new Pessoa(nome);
    }

    private static Pessoa criarPessoaComPais(
            String nome, Pessoa pai, Pessoa mae) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        return new Pessoa(nome, pai, mae);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.print("Nome da primeira pessoa: ");
            String nomePessoa = entrada.nextLine();

            System.out.print("Nome do pai (ou Enter se desconhecido): ");
            String nomePai = entrada.nextLine();

            System.out.print("Nome da mãe (ou Enter se desconhecida): ");
            String nomeMae = entrada.nextLine();

            System.out.print("Nome do avô paterno (ou Enter se desconhecido): ");
            String nomeAvoPaterno = entrada.nextLine();

            System.out.print("Nome da avó paterna (ou Enter se desconhecida): ");
            String nomeAvoPaterna = entrada.nextLine();

            System.out.print("Nome do avô materno (ou Enter se desconhecido): ");
            String nomeAvoMaterno = entrada.nextLine();

            System.out.print("Nome da avó materna (ou Enter se desconhecida): ");
            String nomeAvoMaterna = entrada.nextLine();

            Pessoa avoPaterno = criarPessoaSeInformada(nomeAvoPaterno);
            Pessoa avoPaterna = criarPessoaSeInformada(nomeAvoPaterna);
            Pessoa avoMaterno = criarPessoaSeInformada(nomeAvoMaterno);
            Pessoa avoMaterna = criarPessoaSeInformada(nomeAvoMaterna);

            Pessoa pai = criarPessoaComPais(
                    nomePai, avoPaterno, avoPaterna);

            Pessoa mae = criarPessoaComPais(
                    nomeMae, avoMaterno, avoMaterna);

            Pessoa pessoa = new Pessoa(nomePessoa, pai, mae);

            System.out.print("\nNome da segunda pessoa: ");
            String nomeOutraPessoa = entrada.nextLine();

            System.out.print(
                    "Nome do pai da segunda pessoa "
                    + "(ou Enter se desconhecido): "
            );
            String nomePaiOutra = entrada.nextLine();

            System.out.print(
                    "Nome da mãe da segunda pessoa "
                    + "(ou Enter se desconhecida): "
            );
            String nomeMaeOutra = entrada.nextLine();

            Pessoa paiOutra = criarPessoaSeInformada(nomePaiOutra);
            Pessoa maeOutra = criarPessoaSeInformada(nomeMaeOutra);

            Pessoa outraPessoa = new Pessoa(
                    nomeOutraPessoa, paiOutra, maeOutra);

            System.out.println("\n--- Resultado ---");
            System.out.println(
                    pessoa.getNome() + " e " + outraPessoa.getNome()
                    + " são irmãs? " + pessoa.ehIrma(outraPessoa)
            );

            System.out.print(
                    "\nDigite o nome de um possível antecessor da primeira pessoa: "
            );
            String nomeAntecessor = entrada.nextLine();

            Pessoa antecessor = pessoa.buscarNaArvore(nomeAntecessor);

            if (antecessor == null) {
                System.out.println(
                        "Esse nome não foi encontrado na árvore cadastrada."
                );
            } else if (pessoa.ehAntecessora(antecessor)) {
                System.out.println(
                        antecessor.getNome() + " é antecessor(a) de "
                        + pessoa.getNome() + "."
                );
            } else {
                System.out.println(
                        antecessor.getNome() + " não é antecessor(a) de "
                        + pessoa.getNome() + "."
                );
            }

        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        } finally {
            entrada.close();
        }
    }
}
