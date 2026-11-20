package ListadeExercicios05;

import java.util.Scanner;

public class Exercicio10 {
    public static boolean validarLogin(String usuario, String senha) {
        // Credenciais fixas apenas para fins didáticos.
        return usuario.equals("admin") && senha.equals("123");
    }

    public static void mostrarResultado(boolean valido) {
        if (valido) {
            System.out.println("Login realizado com sucesso.");
        } else {
            System.out.println("Usuário ou senha inválidos.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o usuário:");
        String usuario = scanner.nextLine();
        System.out.println("Digite a senha:");
        String senha = scanner.nextLine();

        mostrarResultado(validarLogin(usuario, senha));
        scanner.close();
    }
}
