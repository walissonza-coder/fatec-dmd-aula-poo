package ListaDeExercicios03;

public class Exercicio04 {
    public static void main(String[] args) {
        int soma = 0;
        System.out.println("Soma de todos os numeros de 1 à 50");
        for (int i = 1; i <= 100; i++) {
            soma += i;
        }

        System.out.println("Soma: " + soma);
    }
}
