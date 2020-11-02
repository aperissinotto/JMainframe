package perissinotto.com.it.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Conexao {
	private String hostMainframe;			// IP ou DNS do Mainframe
	private int portMainframe;				// Port do Mainframe
	private Socket socketMainframe;			
	private InputStream inputStream;
	private OutputStream outputStream;

	private final byte[] buffer4k = new byte[4096];
	
	private int quantidadeBytesRecebidos;
	private byte[] mensagemRecebida;
	
	public Conexao(String hostMainframe, int portMainframe) {
		this.hostMainframe = hostMainframe;
		this.portMainframe = portMainframe;
	}

	public boolean Conecta() {
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

	public boolean Recebe() {
		try {
			this.inputStream = socketMainframe.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			this.quantidadeBytesRecebidos = this.inputStream.read(this.buffer4k);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		this.mensagemRecebida = new byte[this.quantidadeBytesRecebidos];
	    System.arraycopy (this.buffer4k, 0, this.mensagemRecebida, 0, this.mensagemRecebida.length);
	    return true;
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

	public int getQuantidadeBytesRecebidos() {
		return quantidadeBytesRecebidos;
	}

	public byte[] getMensagemRecebida() {
		return mensagemRecebida;
	}

}
