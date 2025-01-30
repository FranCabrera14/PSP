package sockets01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SoccketServerNumerico {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private Integer port;

	public SoccketServerNumerico(Integer port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}

	public void start() throws IOException {
		System.out.println("[Servidor] Esperando conexión...");
		socket = serverSocket.accept();
		System.out.println("[Servidor] Conexión establecida.");
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}

	public void stop() throws IOException {
		System.out.println("[Servidor] Cerrando conexión...");
		is.close();
		os.close();
		socket.close();
		serverSocket.close();
		System.out.println("[Servidor] Conexión cerrada.");
	}

	public static void main(String[] args) {
		SoccketServerNumerico server;
		try {
			server = new SoccketServerNumerico(8081);
			server.start();
			
			while (true) {
				Integer datoLeido = server.is.read();
				System.out.println("[Server] Dato recibido: " + datoLeido);
				Integer datoDevuelto = datoLeido + 1;
				server.os.write(datoDevuelto);
				System.out.println("[Server] Dato devuelto: " + datoDevuelto);
				if (datoLeido == -1) {
					break;
				}
			}

			server.stop();
		} catch (IOException e) {
			System.out.println("Ha habido algún problema en la conexión con el servidor");
		}
	}

}
