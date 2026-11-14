import java.util.Scanner;

public class exercicio4 {
	
	 public static void main(String[] args) {
	        Scanner entrada = new Scanner(System.in);

	        System.out.print("Digite o primeiro número: ");
	        int primeiro = entrada.nextInt();

	        System.out.print("Digite o segundo número: ");
	        int segundo = entrada.nextInt();

	        if (primeiro > segundo) {
	            System.out.println("O maior número é: " + primeiro);
	        } else if (segundo > primeiro) {
	            System.out.println("O maior número é: " + segundo);
	        } else {
	            System.out.println("Os dois números são iguais.");
	        }

	        entrada.close();
	    }
}
