
/* Client side implementation to send simple message to server */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.InetAddress;
import java.lang.*;
import java.io.*;

public class client{
	
	private Socket clientSocket;
	private int portNo;
	private String hostName;
	private InetAddress address;
	
	public client(){
		hostName = "localhost";
		portNo = 25000;
		clientSocket = null;
		
		System.out.println("Client Initialized ");
	}

	public int startClient(){
		
		String serverMsg;
		try{
			if(hostName.length() != 0){
				address = InetAddress.getByName(hostName);
				clientSocket = new Socket(address, portNo);
				
				System.out.println("Client socket created ");
				if(null != clientSocket){
					//taking the instance to output stream
					OutputStream outStream = clientSocket.getOutputStream();
					OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream);
					BufferedWriter bufferWriter = new BufferedWriter(outStreamWriter);
					
					System.out.println("stream created ");
					//creating client message
					serverMsg = "HelloServer";
					//serverMsg = "HelloServer";
					
					//sending the message to server
					bufferWriter.write(serverMsg);
					System.out.println("Message Written to server " + serverMsg);
					bufferWriter.flush();
				}
				
			}else{
				System.out.println("host name is null");
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		finally{
			try{
				clientSocket.close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
		return 0;
	}
}