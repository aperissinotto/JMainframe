package perissinotto.com.it.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector {

	private byte[] buffer32k = new byte[32768];
	private int realBufferLength;
	private String hostMainframe;
	private int portMainframe;
	private Socket socketMainframe;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Log logger = new Log();
	

	public Connector(String hostMainframe, int portMainframe) {
		this.hostMainframe = hostMainframe;
		this.portMainframe = portMainframe;
	}

	public boolean Connect() {
		try {
			this.socketMainframe = new Socket(hostMainframe, portMainframe);
		} catch (UnknownHostException e) {
			logger.toFile(e.getMessage());
			return false;
		} catch (IOException e) {
			logger.toFile(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean Disconnect() {
		try {
			this.socketMainframe.close();
		} catch (IOException e) {
			logger.toFile(e.getMessage());
			return false;
		}
		return true;
	}

	public Message Receive(int readTimeout) {
		try {
			this.socketMainframe.setSoTimeout(readTimeout);
			this.inputStream = socketMainframe.getInputStream();
		} catch (IOException e) {
			logger.toFile(e.getMessage());
			return null;
		}
		try {
			this.realBufferLength = this.inputStream.read(this.buffer32k);
		} catch (IOException e) {
			logger.toFile(e.getMessage());
			return null;
		}
		return new Message(this.buffer32k, this.realBufferLength);
	}

	public boolean Send(Message msg) {
		try {
			this.outputStream = socketMainframe.getOutputStream();
		} catch (IOException e) {
			logger.toFile(e.getMessage());
			return false;
		}
		try {
			this.outputStream.write(msg.getMessageContent(), 0, msg.getMessageLength());
		} catch (IOException e) {
			logger.toFile(e.getMessage());
			return false;
		}
		return true;
	}

}