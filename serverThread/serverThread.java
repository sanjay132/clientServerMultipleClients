/*This implements the server threads for handling the more then one clients */

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class serverThread extends server{
	
	protected Socket serverSocket;
	
	public serverThread(Socket socket){
		this.serverSocket = socket;
	}
	
	public void run(){
		
	}
}