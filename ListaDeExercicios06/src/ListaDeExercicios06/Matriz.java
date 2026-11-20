package ListaDeExercicios06; 

import java.util.Arrays;
import java.util.Scanner;

public class Matriz {
    private final int linhas;
    private final int colunas;
    private final double[][] elementos;

    private static final double TOLERANCIA = 1e-9;

    // Construtor que cria uma matriz preenchida com zeros
    public Matriz(int linhas, int colunas) {
        if (linhas <= 0 || colunas <= 0) {
            throw new IllegalArgumentException(
                "A quantidade de linhas e colunas deve ser positiva."
            );
        }

        this.linhas = linhas;
        this.colunas = colunas;
        this.elementos = new double[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    // Lê o elemento na linha e coluna informadas, usando índices a partir de zero
    public double getElemento(int linha, int coluna) {
        validarPosicao(linha, coluna);
        return elementos[linha][coluna];
    }

    // Escreve um elemento na linha e coluna informadas, usando índices a partir de zero
    public void setElemento(int linha, int coluna, double valor) {
        validarPosicao(linha, coluna);
        elementos[linha][coluna] = valor;
    }

    private void validarPosicao(int linha, int coluna) {
        if (linha < 0 || linha >= linhas || coluna < 0 || coluna >= colunas) {
            throw new IndexOutOfBoundsException(
                "Índice fora dos limites da matriz."
            );
        }
    }

    // Comparação semântica: mesmas dimensões e mesmos elementos
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Matriz)) {
            return false;
        }

        Matriz outra = (Matriz) objeto;

        if (linhas != outra.linhas || colunas != outra.colunas) {
            return false;
        }

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (Double.compare(elementos[i][j], outra.elementos[i][j]) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int resultado = 31 * linhas + colunas;
        return 31 * resultado + Arrays.deepHashCode(elementos);
    }

    // Retorna uma nova matriz transposta
    public Matriz transposta() {
        Matriz resultado = new Matriz(colunas, linhas);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                resultado.elementos[j][i] = elementos[i][j];
            }
        }

        return resultado;
    }

    // Retorna uma nova matriz com todos os sinais trocados
    public Matriz oposta() {
        Matriz resultado = new Matriz(linhas, colunas);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                resultado.elementos[i][j] = -elementos[i][j];
            }
        }

        return resultado;
    }

    // Retorna uma nova matriz nula com as mesmas dimensões
    public Matriz matrizNula() {
        return new Matriz(linhas, colunas);
    }

    // Verifica se todos os elementos são zero
    public boolean ehNula() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (Math.abs(elementos[i][j]) >= TOLERANCIA) {
                    return false;
                }
            }
        }

        return true;
    }

    // Verifica se a matriz é identidade
    public boolean ehIdentidade() {
        if (linhas != colunas) {
            return false;
        }

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                double esperado = (i == j) ? 1.0 : 0.0;

                if (Math.abs(elementos[i][j] - esperado) >= TOLERANCIA) {
                    return false;
                }
            }
        }

        return true;
    }

    // Verifica se todos os elementos fora da diagonal principal são zero
    public boolean ehDiagonal() {
        if (linhas != colunas) {
            return false;
        }

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (i != j && Math.abs(elementos[i][j]) >= TOLERANCIA) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
     * Implementa o critério fornecido no enunciado:
     * matriz diagonal com todos os elementos da diagonal iguais.
     *
     * Esse tipo de matriz é geralmente chamado de matriz escalar;
     * não é a definição matemática usual de matriz singular.
     */
    public boolean ehSingular() {
        if (!ehDiagonal()) {
            return false;
        }

        double valorDiagonal = elementos[0][0];

        for (int i = 1; i < linhas; i++) {
            if (Math.abs(elementos[i][i] - valorDiagonal) >= TOLERANCIA) {
                return false;
            }
        }

        return true;
    }

    // Verifica se a matriz é igual à sua transposta
    public boolean ehSimetrica() {
        if (linhas != colunas) {
            return false;
        }

        for (int i = 0; i < linhas; i++) {
            for (int j = i + 1; j < colunas; j++) {
                if (Math.abs(elementos[i][j] - elementos[j][i])
                        >= TOLERANCIA) {
                    return false;
                }
            }
        }

        return true;
    }

    // Verifica se a oposta da matriz é igual à sua transposta
    public boolean ehAntissimetrica() {
        if (linhas != colunas) {
            return false;
        }

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (Math.abs(elementos[i][j] + elementos[j][i])
                        >= TOLERANCIA) {
                    return false;
                }
            }
        }

        return true;
    }

    // Soma outra matriz a esta; as dimensões devem ser iguais
    public void somar(Matriz outra) {
        validarMesmasDimensoes(outra);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                elementos[i][j] += outra.elementos[i][j];
            }
        }
    }

    // Subtrai outra matriz desta; as dimensões devem ser iguais
    public void subtrair(Matriz outra) {
        validarMesmasDimensoes(outra);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                elementos[i][j] -= outra.elementos[i][j];
            }
        }
    }

    // Multiplica esta matriz por outra; o resultado substitui esta matriz
    public void multiplicar(Matriz outra) {
        if (outra == null) {
            throw new IllegalArgumentException(
                "A outra matriz não pode ser nula."
            );
        }

        if (colunas != outra.linhas) {
            throw new IllegalArgumentException(
                "Para multiplicar, o número de colunas da primeira matriz "
                + "deve ser igual ao número de linhas da segunda."
            );
        }

        double[][] resultado = new double[linhas][outra.colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < outra.colunas; j++) {
                for (int k = 0; k < colunas; k++) {
                    resultado[i][j] += elementos[i][k] * outra.elementos[k][j];
                }
            }
        }

        /*
         * Como a matriz atual possui dimensões fixas, o resultado só pode
         * ser armazenado nela se mantiver as mesmas dimensões.
         */
        if (linhas != linhas || outra.colunas != colunas) {
            throw new IllegalArgumentException(
                "Este objeto não pode receber o resultado da multiplicação "
                + "porque as dimensões resultantes são diferentes das atuais."
            );
        }

        for (int i = 0; i < linhas; i++) {
            System.arraycopy(resultado[i], 0, elementos[i], 0, colunas);
        }
    }

    // Retorna uma cópia independente da matriz
    public Matriz copia() {
        Matriz copia = new Matriz(linhas, colunas);

        for (int i = 0; i < linhas; i++) {
            System.arraycopy(elementos[i], 0, copia.elementos[i], 0, colunas);
        }

        return copia;
    }

    private void validarMesmasDimensoes(Matriz outra) {
        if (outra == null) {
            throw new IllegalArgumentException(
                "A outra matriz não pode ser nula."
            );
        }

        if (linhas != outra.linhas || colunas != outra.colunas) {
            throw new IllegalArgumentException(
                "As matrizes devem ter as mesmas dimensões."
            );
        }
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();

        for (int i = 0; i < linhas; i++) {
            texto.append("[ ");

            for (int j = 0; j < colunas; j++) {
                texto.append(elementos[i][j]);

                if (j < colunas - 1) {
                    texto.append(", ");
                }
            }

            texto.append(" ]");

            if (i < linhas - 1) {
                texto.append(System.lineSeparator());
            }
        }

        return texto.toString();
    }

    private static Matriz lerMatriz(Scanner entrada, String nome) {
        System.out.println("\nDigite as dimensões da matriz " + nome + ":");
        System.out.print("Número de linhas: ");
        int linhas = entrada.nextInt();

        System.out.print("Número de colunas: ");
        int colunas = entrada.nextInt();

        Matriz matriz = new Matriz(linhas, colunas);

        System.out.println("Digite os elementos da matriz " + nome + ":");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz.setElemento(i, j, entrada.nextDouble());
            }
        }

        return matriz;
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            Matriz matrizA = lerMatriz(entrada, "A");
            Matriz matrizB = lerMatriz(entrada, "B");

            System.out.println("\nMatriz A:");
            System.out.println(matrizA);

            System.out.println("\nTransposta de A:");
            System.out.println(matrizA.transposta());

            System.out.println("\nOposta de A:");
            System.out.println(matrizA.oposta());

            System.out.println("\nCópia de A igual a A? "
                    + matrizA.equals(matrizA.copia()));
            System.out.println("A é nula? " + matrizA.ehNula());
            System.out.println("A é identidade? " + matrizA.ehIdentidade());
            System.out.println("A é diagonal? " + matrizA.ehDiagonal());
            System.out.println("A atende ao critério de singular do enunciado? "
                    + matrizA.ehSingular());
            System.out.println("A é simétrica? " + matrizA.ehSimetrica());
            System.out.println("A é antissimétrica? "
                    + matrizA.ehAntissimetrica());

            Matriz nula = matrizA.matrizNula();
            System.out.println("\nMatriz nula com as dimensões de A:");
            System.out.println(nula);

            if (matrizA.linhas == matrizB.linhas
                    && matrizA.colunas == matrizB.colunas) {
                Matriz soma = matrizA.copia();
                soma.somar(matrizB);
                System.out.println("\nA + B:");
                System.out.println(soma);

                Matriz diferenca = matrizA.copia();
                diferenca.subtrair(matrizB);
                System.out.println("\nA - B:");
                System.out.println(diferenca);
            } else {
                System.out.println(
                    "\nSoma e subtração não feitas: as dimensões de A e B "
                    + "são diferentes."
                );
            }

            if (matrizA.colunas == matrizB.linhas
                    && matrizA.linhas == matrizB.colunas) {
                Matriz produto = matrizA.copia();
                produto.multiplicar(matrizB);
                System.out.println("\nA * B:");
                System.out.println(produto);
            } else {
                System.out.println(
                    "\nMultiplicação não feita: além de serem compatíveis "
                    + "(colunas de A = linhas de B), o resultado precisa "
                    + "ter as mesmas dimensões de A para ser armazenado "
                    + "neste objeto."
                );
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException erro) {
            System.out.println("Erro: " + erro.getMessage());
        } finally {
            entrada.close();
        }
    }
}
