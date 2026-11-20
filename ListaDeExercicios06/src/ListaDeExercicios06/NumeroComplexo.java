package ListaDeExercicios06;

import java.util.Objects;
import java.util.Scanner;

public class NumeroComplexo {
    private double parteReal;
    private double parteImaginaria;

    // Construtor
    public NumeroComplexo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    // Getters e setters
    public double getParteReal() {
        return parteReal;
    }

    public void setParteReal(double parteReal) {
        this.parteReal = parteReal;
    }

    public double getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    // Soma outro número complexo a este objeto
    public void somar(NumeroComplexo outro) {
        this.parteReal += outro.parteReal;
        this.parteImaginaria += outro.parteImaginaria;
    }

    // Subtrai outro número complexo deste objeto
    public void subtrair(NumeroComplexo outro) {
        this.parteReal -= outro.parteReal;
        this.parteImaginaria -= outro.parteImaginaria;
    }

    // Multiplica este número complexo por outro
    public void multiplicar(NumeroComplexo outro) {
        double real = this.parteReal * outro.parteReal
                    - this.parteImaginaria * outro.parteImaginaria;

        double imaginaria = this.parteReal * outro.parteImaginaria
                          + this.parteImaginaria * outro.parteReal;

        this.parteReal = real;
        this.parteImaginaria = imaginaria;
    }

    // Divide este número complexo por outro
    public void dividir(NumeroComplexo outro) {
        double denominador = outro.parteReal * outro.parteReal
                           + outro.parteImaginaria * outro.parteImaginaria;

        if (denominador == 0.0) {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }

        double real = (this.parteReal * outro.parteReal
                     + this.parteImaginaria * outro.parteImaginaria)
                     / denominador;

        double imaginaria = (this.parteImaginaria * outro.parteReal
                           - this.parteReal * outro.parteImaginaria)
                           / denominador;

        this.parteReal = real;
        this.parteImaginaria = imaginaria;
    }

    // Retorna o módulo do número complexo
    public double modulo() {
        return Math.hypot(parteReal, parteImaginaria);
    }

    // Compara semanticamente dois números complexos
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof NumeroComplexo)) {
            return false;
        }

        NumeroComplexo outro = (NumeroComplexo) objeto;

        return Double.compare(parteReal, outro.parteReal) == 0
            && Double.compare(parteImaginaria, outro.parteImaginaria) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parteReal, parteImaginaria);
    }

    // Retorna o número no formato a + bi ou a - bi
    @Override
    public String toString() {
        if (parteImaginaria < 0) {
            return parteReal + " - " + Math.abs(parteImaginaria) + "i";
        }

        return parteReal + " + " + parteImaginaria + "i";
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a parte real do primeiro número: ");
        double real1 = entrada.nextDouble();

        System.out.print("Digite a parte imaginária do primeiro número: ");
        double imaginaria1 = entrada.nextDouble();

        System.out.print("Digite a parte real do segundo número: ");
        double real2 = entrada.nextDouble();

        System.out.print("Digite a parte imaginária do segundo número: ");
        double imaginaria2 = entrada.nextDouble();

        NumeroComplexo primeiro = new NumeroComplexo(real1, imaginaria1);
        NumeroComplexo segundo = new NumeroComplexo(real2, imaginaria2);

        System.out.println("\nPrimeiro número: " + primeiro);
        System.out.println("Segundo número: " + segundo);

        // Cada operação usa uma cópia para preservar os valores originais
        NumeroComplexo resultadoSoma =
                new NumeroComplexo(real1, imaginaria1);
        resultadoSoma.somar(segundo);
        System.out.println("Soma: " + resultadoSoma);

        NumeroComplexo resultadoSubtracao =
                new NumeroComplexo(real1, imaginaria1);
        resultadoSubtracao.subtrair(segundo);
        System.out.println("Subtração: " + resultadoSubtracao);

        NumeroComplexo resultadoMultiplicacao =
                new NumeroComplexo(real1, imaginaria1);
        resultadoMultiplicacao.multiplicar(segundo);
        System.out.println("Multiplicação: " + resultadoMultiplicacao);

        try {
            NumeroComplexo resultadoDivisao =
                    new NumeroComplexo(real1, imaginaria1);
            resultadoDivisao.dividir(segundo);
            System.out.println("Divisão: " + resultadoDivisao);
        } catch (ArithmeticException erro) {
            System.out.println("Divisão: " + erro.getMessage());
        }

        System.out.println("Módulo do primeiro número: " + primeiro.modulo());
        System.out.println("Os números são iguais? " + primeiro.equals(segundo));

        entrada.close();
    }
}
