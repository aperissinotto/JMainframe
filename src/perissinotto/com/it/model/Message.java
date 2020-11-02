package perissinotto.com.it.model;

public class Message {

	private byte[] messageContent;
	private int messageLength;

	public Message(byte[] messageContent, int messageLength) {
		this.messageLength = messageLength;
		this.messageContent = new byte[messageLength];
		System.arraycopy(messageContent, 0, this.messageContent, 0, messageLength);
	}

	public byte[] getMessageContent() {
		return messageContent;
	}

	public int getMessageLength() {
		return messageLength;
	}

}
