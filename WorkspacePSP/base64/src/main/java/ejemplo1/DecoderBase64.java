package ejemplo1;

import java.util.Base64;
import java.util.Scanner;

public class DecoderBase64 {
	public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
		
		System.out.println("Dime el texto a codificar");
		
		String textoCodificado = scanner.nextLine();
		
		byte [] decodedBytes = Base64.getDecoder().decode(textoCodificado);
		
		String decodedString = new String(decodedBytes);
		
		System.out.println("El resultado es " + decodedString);
		
		scanner.close();
	}
}
