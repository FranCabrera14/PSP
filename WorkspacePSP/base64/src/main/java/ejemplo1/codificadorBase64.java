package ejemplo1;

import java.util.Base64;
import java.util.Scanner;

public class codificadorBase64 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Dime el texto a codificar");
		
		String textoSinCodificar = scanner.nextLine();
		
		byte[] encodedBytes = Base64.getEncoder().encode(textoSinCodificar.getBytes());
		
		String encodedString = new String(encodedBytes);
		
		System.out.println("esto pone codificado " + encodedString);
		
		scanner.close();
	}
}
