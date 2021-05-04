package spring.integration.dls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ApplicationTest {

	public static void main(String[] args) {
		new ApplicationTest().doAction();
	}

	
	public void doAction() {
		try (Socket socket = new Socket("localhost", 1010);
				OutputStream output = socket.getOutputStream();
				InputStream input = socket.getInputStream();
				PrintWriter writer = new PrintWriter(output, true);
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));) {
			
			writer.println("1010testtest하이");
			String line = reader.readLine();
			System.out.println("receive msg : " + line);
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O error: " + ex.getMessage());
		}
	}
}
