import java.util.Scanner;

public class exercicio2 {
	 public static void main(String[] args) {
	        Scanner entrada = new Scanner(System.in);

	        System.out.print("Digite um número inteiro: ");
	        int numero = entrada.nextInt();

	        if (numero % 2 == 0) {
	            System.out.println("Par");
	        } else {
	            System.out.println("Ímpar");
	        }

	        entrada.close();
	    }

}
