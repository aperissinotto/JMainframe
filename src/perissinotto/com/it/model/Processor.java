package perissinotto.com.it.model;

public class Processor {

	// COMMANDS
	private static final byte IS_TERMINAL_TYPE = (byte) 0x00;
	private static final byte SEND_TERMINAL_TYPE = (byte) 0x01;
	private static final byte TERMINAL_TYPE = (byte) 0x18;
	private static final byte EOR = (byte) 0x19;
	private static final byte TN3270E = (byte) 0x28;
	private static final byte IAC = (byte) 0xFF;
	private static final byte SE = (byte) 0xF0;
	private static final byte SB = (byte) 0xFA;
	private static final byte WILL = (byte) 0xFB;
	private static final byte WONT = (byte) 0xFC;
	private static final byte DO = (byte) 0xFD;
	
	public Processor() {
		
	}
	
	public Message ProcessMessage(Message inputMessage, TerminalIBM3270 terminal) {
		byte[] input = inputMessage.getMessageContent();
		byte[] output = new byte[32768];
		int outputLength = 0;
		for (byte cmd : input) {
			switch (cmd) {
			case DO:
				int nextCommand = outputLength + 1;
				if (input[nextCommand] == TN3270E) {
					output[outputLength] = WONT;
				} else {
					output[outputLength] = WILL;
				}
				outputLength++;
				break;
			case TN3270E:
				output[outputLength] = TN3270E;
				outputLength++;
				break;
			case TERMINAL_TYPE:
				output[outputLength] = TERMINAL_TYPE;
				outputLength++;
				break;
			case IAC:
				output[outputLength] = IAC;
				outputLength++;
				break;
			case SB:
				output[outputLength] = SB;
				outputLength++;
				break;
			case SEND_TERMINAL_TYPE:
				output[outputLength] = IS_TERMINAL_TYPE;
				outputLength++;
				for (byte terminalType : terminal.getTerminalType().getBytes()) {
					output[outputLength] = terminalType;
					outputLength++;
				}
				break;
			case SE:
				output[outputLength] = SE;
				outputLength++;
				break;
			case EOR:
				output[outputLength] = EOR;
				outputLength++;
				break;
			case WILL:
				output[outputLength] = DO;
				outputLength++;
				break;
			case IS_TERMINAL_TYPE:
				output[outputLength] = IS_TERMINAL_TYPE;
				outputLength++;
				break;
			default:
				return null;
			}
		}
		return new Message(output, outputLength);
	}
	
}