import java.util.Scanner;

public class Exercicio5 {
	 public static void main(String[] args) {
	        Scanner entrada = new Scanner(System.in);

	        System.out.print("Digite um número: ");
	        int numero = entrada.nextInt();

	        if (numero >= 10 && numero <= 50) {
	            System.out.println("Está entre 10 e 50.");
	        } else {
	            System.out.println("Está fora do intervalo de 10 a 50.");
	        }

	        entrada.close();
	    }
	

}
