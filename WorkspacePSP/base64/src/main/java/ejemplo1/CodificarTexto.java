package ejemplo1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

public class CodificarTexto {
	public static void main(String[] args) {
		importarArchivo("C:/Users/fcabrera4084/Desktop/Cosas Asignaturas/PSP/odioCristian.txt");
	}

	public static void importarArchivo(String rutaArchivo) {
		File file = new File(rutaArchivo);
		try (Scanner sc = new Scanner(file)) {
			String linea;
			String lineaCodificada = " ";
			File fileCodeado = new File("C:/Users/fcabrera4084/Desktop/Cosas Asignaturas/PSP/odioCristianCodificado.txt");
			FileWriter writer = new FileWriter(fileCodeado);
			while (sc.hasNextLine()) {
				linea = sc.nextLine();
				lineaCodificada = codificador(linea);
				System.out.println(lineaCodificada);
				writer.write(lineaCodificada);
				System.out.println("Todo ok");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String codificador(String texto) {
		byte[] encodedBytes = Base64.getEncoder().encode(texto.getBytes());
		
		String encodedString = new String(encodedBytes);
		return encodedString;
		
	}

}
