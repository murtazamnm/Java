package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import serialized.SomeData;

public class ClientObj {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		var HOST = "localhost";
		var HOST = "127.0.0.1";
		var PORT = 12345;

		try (
			Socket s = new Socket(HOST, PORT);
			var oos = new ObjectOutputStream(s.getOutputStream());
			var ois = new ObjectInputStream(s.getInputStream());
		) {
			oos.writeObject(new SomeData(-2, "gfdshf", new double[] {1.0, -1.0, Math.PI}));
			oos.flush();

			var response = (SomeData)ois.readObject();
			System.out.println(response);
		}
	}
}
