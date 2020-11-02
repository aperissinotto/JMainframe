package perissinotto.com.it.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector {
	private final byte[] buffer32k = new byte[32768];

	private int realBufferLength;

	private String hostMainframe;
	private int portMainframe;
	private Socket socketMainframe;
	private InputStream inputStream;
	private OutputStream outputStream;

	public Connector(String hostMainframe, int portMainframe) {
		this.hostMainframe = hostMainframe;
		this.portMainframe = portMainframe;
	}

	public boolean Connect() {
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

	public boolean Disconnect() {
		try {
			this.socketMainframe.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Message Receive() {
		try {
			this.inputStream = socketMainframe.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		try {
			this.realBufferLength = this.inputStream.read(this.buffer32k);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return new Message(this.buffer32k, this.realBufferLength);
	}

	public boolean Send(Message msg) {
		try {
			this.outputStream = socketMainframe.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		try {
			this.outputStream.write(buffer32k);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}