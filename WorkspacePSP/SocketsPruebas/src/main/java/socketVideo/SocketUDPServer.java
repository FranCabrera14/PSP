package socketVideo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class SocketUDPServer {
	public static void main(String[] args) {

		DatagramSocket socket;
		System.out.println("(Servidor) Creando socket ...");
		try {
			socket = new DatagramSocket(49171);

			System.out.println("(Servidor) Iniciando recepción  datagrama ...");
			// Vamos a meterlo aquí el datagrama
			byte[] bufferLectura = new byte[64];
			// Creación del paquete de datagrama
			DatagramPacket datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
			// Datagrama entrando
			socket.receive(datagramaEntrada);
			System.out.println("(Servidor) Mensaje recibido: " + new String(bufferLectura));

			// Datagrama saliendo
			System.out.println("(Servidor) Enviando datagrama ...");
			byte[] mensajeEnviado = new String("El mensaje enviado desde el servidor es este").getBytes();

			DatagramPacket datagramaSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length,
					datagramaEntrada.getAddress(), datagramaEntrada.getPort());
			socket.send(datagramaSalida);
			System.out.println("(Servidor) Cerrando socket ...");
			socket.close();
			System.out.println("(Servidor) Socket cerrado.");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}