package perissinotto.com.it.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Conexao {
	private Socket socketMainframe;
	private InputStream inputStream;
	private OutputStream outputStream;

	private final byte[] buffer4k = new byte[4096];
	private int bytesRecebidos;

	public boolean Conecta(String hostMainframe, int portMainframe) {
		try {
			this.socketMainframe = new Socket(hostMainframe, portMainframe);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean Desconecta() {
		try {
			this.socketMainframe.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public byte[] Recebe() {
		try {
			this.inputStream = socketMainframe.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		try {
			this.bytesRecebidos = this.inputStream.read(this.buffer4k);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		byte[] bufferRecebido = new byte[this.bytesRecebidos];
	    System.arraycopy (this.buffer4k, 0, bufferRecebido, 0, bufferRecebido.length);
	    return bufferRecebido;
	}
	
	public boolean Envia(byte[] bufferEnviado) {
		try {
			this.outputStream = socketMainframe.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			this.outputStream.write(bufferEnviado);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
