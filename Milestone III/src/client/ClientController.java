package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.WindowConstants;

/**
 * The client controller for the registration app on port 9090. Creates the views 
 * for the GUIController then creates a GUIController. Can send and recieve strings
 * 
 * @author Dylan Rae and Tyler Sawatzky
 * @version 1.0
 * @since April 19, 2020
 */
public class ClientController {

	/**
	 * A printwriter to act as the socketout for the client.
	 */
	private PrintWriter socketOut;
	
	/**
	 * A socket to connect to server.
	 */
	private Socket aSocket;
	
	/**
	 * A bufferedreader to act as the socketIn for the client.
	 */
	private BufferedReader socketIn;
	
	/**
	 * The host for the client to connect to. Change to IP 
	 * address server is hosted on for testing the deployment 
	 * functionality.
	 */
	private static final String host = "localhost";
	

	/**
	 * A constructor for the client controller. Initializes sockets and creates the GUIController.
	 * @param serverName Name of server to connect to
	 * @param portNumber Port to connect client to
	 */
	public ClientController (String serverName, int portNumber) {
		try {
			//Set up sockets
			aSocket = new Socket(serverName, portNumber);
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);
			
			//set up GUI
			GUIController GUI = new GUIController(this);
			
			
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}
	
	/**
	 * Sends a string through socketOut to server
	 * @param s the String to send
	 */
	public void sendCommand(String s) {
		socketOut.println(s);
		socketOut.flush();
		//System.out.println("Sent: "+ s + " to server");
	}
	
	/**
	 * Recieves the string being sent from server in socketIn.
	 * Replaces null characters with new lines.
	 * @return The String received with new lines replaced
	 */
	public String receiveCommand() {
		String data = "";
		try {
			data = socketIn.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(data.contains("\0")) {
			data = data.replace("\0", "\n");
		}
		//System.out.println("Received : " + data + " from server");
		return data;
	}
	
	/**
	 * Closes the socket connections for the client.
	 */
	public void close() {
		try {
			aSocket.close();
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main function for client.
	 * @param args
	 */
	public static void main(String[] args) {
		
		ClientController client = new ClientController(host, 9090);
		
		//ClientController client = new ClientController("127.0.0.1", 9090);
		//ClientController client = new ClientController("96.51.158.129", 9090);
	}
	
}
