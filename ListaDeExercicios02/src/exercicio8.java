import java.util.Scanner;

public class exercicio8 {
	 public static void main(String[] args) {
	        Scanner entrada = new Scanner(System.in);

	        System.out.print("Digite o primeiro número: ");
	        int primeiro = entrada.nextInt();

	        System.out.print("Digite o segundo número: ");
	        int segundo = entrada.nextInt();

	        System.out.print("Digite o terceiro número: ");
	        int terceiro = entrada.nextInt();

	        int maior = primeiro;

	        if (segundo > maior) {
	            maior = segundo;
	        }

	        if (terceiro > maior) {
	            maior = terceiro;
	        }

	        System.out.println("O maior número é: " + maior);

	        entrada.close();
	    }
}
