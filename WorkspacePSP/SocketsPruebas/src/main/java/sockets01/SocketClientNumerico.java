package sockets01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class SocketClientNumerico {
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	private String direccion;
	private Integer port;
	
	//necesitamos hacer una peticion al server socket
	public SocketClientNumerico(String direccion, Integer port) {
		
		this.direccion = direccion;
		this.port = port;
	}
	
	public void Start() throws UnknownHostException, IOException {
		System.out.println("[Cliente] Lanzando peticion al server...");
		socket = new Socket(direccion, port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
		System.out.println("[Cliente] Petición aceptada.");
	}
	
	public void Stop() throws IOException {
		System.out.printf("[Cliente] Cerrando la conexión con %s:%d...", direccion, port);
		is.close();
		os.close();
		socket.close();
		System.out.println("[Cliente] Conexión cerrada.");
	}
	
	public static void main(String[] args) {
		SocketClientNumerico client = new SocketClientNumerico("localhost", 8081);
		
		try {
			client.Start();
			for (int i = 0; i < 255; i++) {
				Integer datoAenviar = i;
				client.os.write(datoAenviar);
				System.out.printf("[Cliente] Enviado %d a %s:%n", datoAenviar, client.port, client.direccion);
				Integer datoRecibido = client.is.read();
				System.out.printf("[Cliente] Recibido  %d de %s:%n", datoRecibido, client.port, client.direccion);
				
			}
			client.Stop();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
