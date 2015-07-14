/*This implements the server threads for handling the more then one clients */

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class serverThread extends Thread{
	
	protected Socket serverSocket;
	private int clientCount;
	
	public serverThread(Socket clientSocket){
		this.serverSocket = clientSocket;
		clientCount = 0;
	}
	
	public void run(){
		//open the input stream to read data written into the socket by client
		String clientMsg;
		try{
			System.out.println("Thread Run");
			InputStream inStream = serverSocket.getInputStream();
			InputStreamReader inStreamReader = new InputStreamReader(inStream);
			BufferedReader bufferReader = new BufferedReader(inStreamReader);
			System.out.println("stream created");
			
			//reading the message 
			clientMsg = bufferReader.readLine();
			
			System.out.println("Message received from client -> " + clientMsg);
			clientCount = clientCount + 1;
			serverSocket.close();
			System.out.println("Socket Close ");
		}catch(Exception e){
			System.out.println("Error : " + e);
		}

	}
}