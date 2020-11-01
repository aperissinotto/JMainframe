package perissinotto.com.it.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDateTime;

public class Connect {
	public static void main(String[] args) {
		int bytesRead;
		byte[] buffer = new byte[4096];
		try {
			// byte[] data = null;
			Socket cliente = new Socket("192.168.25.210", 23);
			InputStream inputStream = cliente.getInputStream();
			//for (int i = 0; i < 3; i++) {

				bytesRead = inputStream.read(buffer);
				// InputStream input = cliente.getInputStream();
				// InputStreamReader reader = new InputStreamReader(input);
				// int character = reader.read();
				// BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				// String line = reader.readLine();
				System.out.println(bytesRead);
				System.out.println(bytesToHex(buffer, bytesRead));
			//}
			cliente.close();
			System.out.println("Conexão encerrada");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

	public static String bytesToHex(byte[] bytes, int tam) {
		char[] hexChars = new char[tam * 2];
		for (int j = 0; j < tam; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX_ARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		return new String(hexChars);
	}
}
