package perissinotto.com.it.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TerminalIBM3270 implements Terminal {
	private Log logger = new Log();

	private InputStream inputStream;
	private OutputStream outputStream;
	private Socket terminalSocket;
	private String ipServer;
	private String fileLog;

	private String terminalType;
	private int lines;
	private int coluns;
	private byte[] terminalBuffer;
	private int realBufferLength;
	private int portServer;
	private int readTimeout;
	private boolean connected = false;

	public TerminalIBM3270(String terminalType, String ipServer, int portServer, int lines, int coluns, String fileLog,
			int readTimeout) {
		this.terminalType = terminalType;
		this.lines = lines;
		this.coluns = coluns;
		this.ipServer = ipServer;
		this.portServer = portServer;
		this.fileLog = fileLog;
		this.terminalBuffer = new byte[lines * coluns];
		this.readTimeout = readTimeout;
	}

	@Override
	public void Connect() throws TerminalAlreadyConnected {
		if (!connected) {
			try {
				this.terminalSocket = new Socket(this.ipServer, this.portServer);
				this.connected = true;
			} catch (UnknownHostException e) {
				logger.toFile("Fail to connect: " + e.getMessage(), this.fileLog);
				this.connected = false;
			} catch (IOException e) {
				logger.toFile("Fail to connect: " + e.getMessage(), this.fileLog);
				this.connected = false;
			}
		} else {
			throw new TerminalAlreadyConnected("This terminal is already connected!");
		}
	}

	@Override
	public void Disconnect() throws TerminalNotConnected {
		if (connected) {
			try {
				this.terminalSocket.close();
			} catch (IOException e) {
				logger.toFile("Fail to disconnect: " + e.getMessage(), this.fileLog);
			}
		} else {
			throw new TerminalNotConnected("This terminal is not connected!");
		}
	}

	@Override
	public void Send(Message message) throws TerminalNotConnected {
		if (connected) {
			try {
				this.outputStream = terminalSocket.getOutputStream();
				this.outputStream.write(message.getMessageContent(), 0, message.getMessageLength());
			} catch (IOException e) {
				logger.toFile("Fail to send: " + e.getMessage(), this.fileLog);
			}
		} else {
			throw new TerminalNotConnected("This terminal is not connected!");
		}
	}

	@Override
	public Message Receive() throws TerminalNotConnected {
		if (connected) {
			try {
				this.terminalSocket.setSoTimeout(this.readTimeout);
				this.inputStream = terminalSocket.getInputStream();
				this.realBufferLength = this.inputStream.read(this.terminalBuffer);
				return new Message(this.terminalBuffer, this.realBufferLength);
			} catch (IOException e) {
				logger.toFile("Fail to receive: " + e.getMessage(), this.fileLog);
				return null;
			}
		} else {
			throw new TerminalNotConnected("This terminal is not connected!");
		}
	}

	public String getTerminalType() {
		return this.terminalType;
	}

	public boolean isConnected() {
		return this.connected;
	}

	public byte[] getLastBuffer() {
		return this.terminalBuffer;
	}

	@SuppressWarnings("unused")
	public void clearBuffer() {
		for (byte buffer : this.terminalBuffer) {
			buffer = (byte) 0x00;
		}
	}

	@Override
	public String toString() {
		return "TerminalIBM3270 [Terminal Type=" + this.terminalType + ", Server IP=" + this.ipServer + ", Server Port="
				+ this.portServer + ", File LOG=" + this.fileLog + ", Number of Lines=" + lines + ", Number of Coluns="
				+ coluns + ", Read Timeout=" + readTimeout + ", Is Connected=" + connected + "]";
	}

}
