/*This is server side implementation to receive the message */

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class server{
	
	private int portNo;
	private Socket socket;
	private ServerSocket serverSocket;
	private int clientCount= 0;
	public server(){
		portNo = 25000;
	}
	
	public void startServer(){
		try{		
		serverSocket = new ServerSocket(portNo);
			while(true){
				System.out.println("Server started listening on port No "+ portNo);
				//accepts the connection request
				socket = serverSocket.accept();
				System.out.println("clientCount [ "+ clientCount++ + " ]" + "\n" + "socket " + socket );
				new serverThread(socket).start();
				System.out.println("server.java");
				
				if(2 == clientCount)
				{
					System.out.println("Two player joined now server will not accept any more connection ");
					break;
				}
			}
		}catch(Exception e){
				System.out.println(e);
		}
			
			if(2 == clientCount)
			{
				while(true){
					
				}
			}
	}
}