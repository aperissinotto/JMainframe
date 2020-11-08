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

	public void ProcessCommand(byte[] input) {
		for (byte cmd : input) {
			switch (cmd) {
			case DEVICE_TYPE:
				System.out.println("Recebi um comando DEVICE_TYPE");
				break;
			case SEND:
				System.out.println("Recebi um comando SEND");
				break;
			case TN3270E:
				System.out.println("Recebi um comando TN3270E");
				break;
			case SE:
				System.out.println("Recebi um comando SE");
				break;
			case NOP:
				System.out.println("Recebi um comando NOP");
				break;
			case DATA_MARK:
				System.out.println("Recebi um comando DATA_MARK");
				break;
			case BREAK:
				System.out.println("Recebi um comando BREAK");
				break;
			case IP:
				System.out.println("Recebi um comando IP");
				break;
			case AO:
				System.out.println("Recebi um comando AO");
				break;
			case AYT:
				System.out.println("Recebi um comando AYT");
				break;
			case EC:
				System.out.println("Recebi um comando EC");
				break;
			case EL:
				System.out.println("Recebi um comando EL");
				break;
			case GA:
				System.out.println("Recebi um comando GA");
				break;
			case SB:
				System.out.println("Recebi um comando SB");
				break;
			case WILL:
				System.out.println("Recebi um comando WILL");
				break;
			case WONT:
				System.out.println("Recebi um comando WONT");
				break;
			case DO:
				System.out.println("Recebi um comando DO");
				break;
			case DONT:
				System.out.println("Recebi um comando DONT");
				break;
			case IAC:
				System.out.println("Recebi um comando IAC");
				break;
			default:
				System.out.println("Recebi um comando desconhecido");
			}
		}
	}
}