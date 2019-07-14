package webSocketTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public Server() throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(2030);
		System.out.println("port 2030is openened");
		
		Socket socket = serverSocket.accept();
		System.out.println("client :" + socket.getInetAddress());
		
		BufferedReader in_socket = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = 
				new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		out_socket.println("welcome");

		String message = in_socket.readLine();
		System.out.println("inComming msg:"+ message);
		
		socket.close();
		System.out.println("connection terminated");	
		
	}
	
	public static void main(String[] args) {
		 
		try {
			new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
