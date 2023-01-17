package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import serialized.SomeData;

public class ServerObj {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		var PORT = 12345;

		try (
			var ss = new ServerSocket(PORT);
		) {
			while (true) {
				talkToClient(ss);
			}
		}
	}

	private static void talkToClient(ServerSocket ss) throws IOException, ClassNotFoundException {
		try (
			Socket s = ss.accept();
			var ois = new ObjectInputStream(s.getInputStream());
			var oos = new ObjectOutputStream(s.getOutputStream());
		) {
			var someData = (SomeData)ois.readObject();
			someData.setNum(someData.getNum() + 1);
			oos.writeObject(someData);
			oos.flush();
		}
	}
}
