package perissinotto.com.it.model;

import java.util.Arrays;

public class Message {
	private byte[] messageContent;
	private int messageLength;
	
	public Message(byte[] messageContent, int messageLength) {
		this.messageLength = messageLength;
		this.messageContent = new byte[messageLength];
		setMessageContent(messageContent);
	}

	public byte[] getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(byte[] messageContent) {
		System.arraycopy(messageContent, 0, this.messageContent, 0, this.messageLength);
	}

	public int getMessageLength() {
		return messageLength;
	}

	public void setMessageLength(int messageLength) {
		this.messageLength = messageLength;
	}

	@Override
	public String toString() {
		return "Message [messageContent=" + Arrays.toString(messageContent) + ", messageLength=" + messageLength + "]";
	}

}
