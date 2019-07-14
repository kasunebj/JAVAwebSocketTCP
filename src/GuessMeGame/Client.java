package GuessMeGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public Client() throws UnknownHostException, IOException {
		
		Socket socket = new Socket ("localhost",2040);
		System.out.println("connection created");
		
		BufferedReader in_socket = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		PrintWriter out_socket = 
				new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		Scanner scanner = new Scanner (System.in);
		String inputNumber;
		
		
		while(in_socket.readLine().startsWith("Guess")) {
			System.out.println("pls Enter the Number :");
			inputNumber = scanner.nextLine();
			out_socket.println(inputNumber);
			
		}
		
		System.out.println("yahoo nailed it.guessd perfectly");
		
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
