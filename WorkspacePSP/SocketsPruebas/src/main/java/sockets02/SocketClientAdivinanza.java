package sockets02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class SocketClientAdivinanza {

	private String direccion;
	private Socket socket;
	private Integer port;
	private InputStream is;
	private OutputStream os;
	
	public SocketClientAdivinanza(String direccion, Integer port){
		this.direccion = direccion;
		this.port = port;
		
	}
	
	public void start() throws UnknownHostException, IOException {
		System.out.println("[Client] Trying to connect...");
		socket = new Socket(direccion, port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
		System.out.println("[Client] Connected Succesfully");
	}
	
	public void stop() throws IOException {
		System.out.println("[Client] Closing the conecction with " + direccion + " with the port " + port);
		os.close();
		is.close();
		socket.close();
		System.out.println("[Client] Connection closed");
		
		
	}
	public static void main(String[] args) {
		SocketClientAdivinanza client = new  SocketClientAdivinanza("localhost" , 8081);
		try {
			Random r = new Random();
			client.start();
			
			while(true) {
				int writtenData = r.nextInt(50)+1;
				client.os.write(writtenData);
				System.out.printf("[Client] Sent %d a %s:%n", writtenData, client.port, client.direccion);
				int readData = client.is.read();
				if (writtenData == readData) {
					System.out.println("[Client] Yiiipiiiii I've won");
					break;
				}
			}
			client.stop();
		} catch (Exception e) {
			System.err.println("Something didnt work as expected" + e );
			
		}
	}
	
}
