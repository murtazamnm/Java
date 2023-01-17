package networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		var HOST = "localhost";
		var PORT = 12345;

		try (
			Socket s = new Socket(HOST, PORT);
			var sc = new Scanner(s.getInputStream());
			var pw = new PrintWriter(s.getOutputStream());
		) {
			int waitSeconds = 1;
			Thread.sleep(1000 * waitSeconds);

			var msg = "1";
			System.out.println("Sending the message");

			pw.println("echo " + msg);
			pw.flush();

			String answer = sc.nextLine();
			System.out.println(answer);
		}
	}
}
