package GuessMeGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	public Server() throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(2040);
		System.out.println("port 2040is openened");
		
		Socket socket = serverSocket.accept();
		System.out.println("client :" + socket.getInetAddress());
		
		BufferedReader in_socket = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = 
				new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		
		String guessedNumber;
	
		int randomnumber = (int)(Math.random()*10+1);
		System.out.println(randomnumber);
		 
		
		do {
			out_socket.println("Guess the number[1:10] :");
			guessedNumber =  in_socket.readLine();
			
		}while(!(Integer.parseInt(guessedNumber) == randomnumber));
		
		out_socket.println("correctly guessed :");

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
