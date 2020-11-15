package perissinotto.com.it.model;

public class Processor {

	// TN3270E COMMAND PROTOCOL
	private static final byte TN3270E = (byte) 0x28;
	private static final byte ASSOCIATE = (byte) 0x00;
	private static final byte CONNECT = (byte) 0x01;
	private static final byte DEVICE_TYPE = (byte) 0x02;
	private static final byte FUNCTIONS = (byte) 0x03;
	private static final byte IS = (byte) 0x04;
	private static final byte REASON = (byte) 0x05;
	private static final byte REJECT = (byte) 0x06;
	private static final byte REQUEST = (byte) 0x07;
	private static final byte SEND = (byte) 0x08;
	
	// FUNCTIONS NAMES
	private static final byte BIND_IMAGE = (byte) 0x00;
	private static final byte DATA_STREAM_CTL = (byte) 0x01;
	private static final byte RESPONSES = (byte) 0x02;
	private static final byte SCS_CTL_CODES = (byte) 0x03;
	private static final byte SYSREQ = (byte) 0x04;
	
	// REASON CODE TN3270E ERROR
	private static final byte CONN_PARTNER = (byte) 0x00;
	private static final byte DEVICE_IN_USE = (byte) 0x01;
	private static final byte INV_ASSOCIATE = (byte) 0x02;
	private static final byte INV_DEVICE_NAME = (byte) 0x03;
	private static final byte INV_DEVICE_TYPE = (byte) 0x04;
	private static final byte TYPE_NAME_ERROR = (byte) 0x05;
	private static final byte UNKNOWN_ERROR = (byte) 0x06;
	private static final byte UNSUPPORTED_REQ = (byte) 0x07;
	
	// TELNET COMMAND PROTOCOL
	private static final byte IAC = (byte) 0xFF;
	private static final byte SE = (byte) 0xF0;
	private static final byte NOP = (byte) 0xF1;
	private static final byte DATA_MARK = (byte) 0xF2;
	private static final byte BREAK = (byte) 0xF3;
	private static final byte IP = (byte) 0xF4;
	private static final byte AO = (byte) 0xF5;
	private static final byte AYT = (byte) 0xF6;
	private static final byte EC = (byte) 0xF7;
	private static final byte EL = (byte) 0xF8;
	private static final byte GA = (byte) 0xF9;
	private static final byte SB = (byte) 0xFA;
	private static final byte WILL = (byte) 0xFB;
	private static final byte WONT = (byte) 0xFC;
	private static final byte DO = (byte) 0xFD;
	private static final byte DONT = (byte) 0xFE;
	private static final byte TERMINAL_TYPE = (byte) 0x18;
	private static final byte EOR = (byte) 0x19;
	private static final byte BINARY = (byte) 0x00;

	public Message ProcessMessage(Message inputMessage) {
		byte[] input = inputMessage.getMessageContent();
		byte[] output = new byte[32768];
		int outputLength = 0;
		for (byte cmd : input) {
			switch (cmd) {
			case DO:
				output[outputLength] = WILL;
				outputLength++;
				break;
			case IAC:
				output[outputLength] = IAC;
				outputLength++;
				break;
			default:
				return null;
			}
		}
		return new Message(output, outputLength);
	}
	
	public String ReturnStringTelnetComandProtocol(byte command) {
		switch (command) {
		case BINARY:
			return "BINARY";
		case TERMINAL_TYPE:
			return "TERMINAL_TYPE";
		case EOR:
			return "EOR";
		default:
			return null;
		}
	}
}