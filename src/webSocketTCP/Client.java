package webSocketTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public Client() throws UnknownHostException, IOException {
		
		Socket socket = new Socket ("localhost",2030);
		System.out.println("connection created");
		
		BufferedReader in_socket = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		PrintWriter out_socket = 
				new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		
		String msg = in_socket.readLine();
		System.out.println(msg);
		out_socket.println("thanks");
		
		socket.close();
		System.out.println("connection terminated");
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		try {
			new Client();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
