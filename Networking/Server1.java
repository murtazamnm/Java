package networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
	public static void main(String[] args) throws IOException {
		var PORT = 12345;

		try (
			var ss = new ServerSocket(PORT);
		) {
			while (true) {
				talkToClient(ss);
			}
		}
	}

	private static void talkToClient(ServerSocket ss) throws IOException {
		try (
			Socket s = ss.accept();
			var sc = new Scanner(s.getInputStream());
			var pw = new PrintWriter(s.getOutputStream());
		) {
			// echo server
			String line = sc.nextLine();
			pw.println(line);
//			pw.flush();
		}
	}
}
