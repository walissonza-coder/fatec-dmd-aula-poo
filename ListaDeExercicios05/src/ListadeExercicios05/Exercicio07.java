package ListadeExercicios05;

public class Exercicio07 {
    public static void mostrarNumeros() {
        for (int i = 1; i <= 100; i++) System.out.println(i);
    }

    public static void mostrarPares() {
        for (int i = 2; i <= 100; i += 2) System.out.println(i);
    }

    public static void mostrarImpares() {
        for (int i = 1; i <= 100; i += 2) System.out.println(i);
    }

    public static void main(String[] args) {
        System.out.println("Todos os números:");
        mostrarNumeros();
        System.out.println("Números pares:");
        mostrarPares();
        System.out.println("Números ímpares:");
        mostrarImpares();
    }
}
