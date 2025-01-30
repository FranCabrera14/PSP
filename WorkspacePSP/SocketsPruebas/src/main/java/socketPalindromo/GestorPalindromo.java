package socketPalindromo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GestorPalindromo extends Thread{

	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;
	
	public GestorPalindromo(Socket socket) throws IOException {
		this.socket = socket;
		is = socket.getInputStream();
		os = socket.getOutputStream();
		pw = new PrintWriter(os,true);
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
	}


	
	
	
	
}















//SOCKETSERVER
//
//en socketServer creo un private de Serversocket y uno de puerto
//
//luego creo un constructor que recibe un integer puerto e inicializo el serversocket de dentro con el puerto que recibe el constructor de la clase socketServer
//despues en el constructor pongo mensajito de abriendo conexion y en un while true inicializo un socket diciendo que es igual al private de serverSocket.accept
//tras eso pongo otro syso de conexion establecida. despues instancio un gestor al que le paso el socket y le hago un .start
//
//ahora creo un main  con un try catch que coge el ioexception e inicializo el constructor pasandole mi puerto 8081 o el que sea.
//
//SOCKETCLIENT
//
//creo los privates de socket, inputstream, outputsream, inputstreamreader, bufferReader , printWriter, el addres y el puerto.
//
//creo un constructor con puerto y address
//
//hago metodo start() que lanza el ioException que empieza con el syso diciendo que esta abriendo la conexion, luego inicializo el socket poniendole el addres y el puerto,
//is le digo que es = al socket.getinput, lo mismo con el os, el printwriter lo inicializo mandandole el os y un true, luego inicializo el isr mandandole el is, y el bf
//mandandole el isr. despuies pongo syso de conexion establecida.
//
//hago metodo stop() que lanza ioException ponemos syso de cerrando conexion y cerramos todo. ponemos syso de conexion cerrada.
//
//hago metodo main con try catch donde inicializo el socketclient dandole de addres el localhost y el puerto que yo tenga
//creamos scaner, y strings vacios de palabraEnviada y respuesta.
//hacemos start del cliente.
//en un while true hacemos la lógica del cliente que empieza con un syso para pedir una palabra
//la palabra vacia = a lo que se pone en el scaner y mandamos con el cliente.Printer la palabra y hacemos syso de la palabra que hemos enviado
//la respuesta vacia = a la linea que lee el bf y hacemos syso de la respuesta 
//si la respuesta = finalizado entonces hacemos un stop y un break 
//
//GESTOR
//
//esta clase extiende de thread le creamos los atributos de socket is,os,pw,isr y br
//creamos constructor que reciba el socket
//implementamos run y dentro hacemos un try catch donde abrimos el is,os, pw, isr y br
//creamos los strings vacios de datoRecibido, datoEnviar y palabraInvertida
//creamos un while true donde definimos a datoRecibido como el readline de br y hacemos un syso de lo que hemos recibido
//ponemos en "" la palabra invertida y hacemos un foreach de datorecibido.split por "" o lo que sea que haya que splitearlo
//ahora la palabraInvertida = a el string del foreach + palabraInvertida
//hacemos if si datoRecibido = finalizado y hacemos que datoEnviar = Finalizado
//un else if si datoRecibido = a palabraInvertida y hacemos que datoEnviar = que si es un palindromo
//un else donde ponemos que la palabra no es un palindromo
//
//despues hacemos un syso del gestor del datoEnviar y un pwprint del datoEnviar
//
//condicinal si el datoEnviar = Finalizado
//ponemos un return
//
//creamos otro try catch cerrando todo."
