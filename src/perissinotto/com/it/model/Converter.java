package perissinotto.com.it.model;

public class Converter {
	
	public Converter() {
		
	}

	public String toHexString(byte[] input, int offset, int length) {
		StringBuilder output = new StringBuilder();
		for (int pointer = offset; pointer < length; pointer++) {
			output.append(String.format("%02X ", (input[pointer] & 0xFF)));
		}

		if (output.length() > 0) {
			output.deleteCharAt(output.length() - 1);
		}

		return output.toString();
	}
	
	public byte[] toBytesString(String input, int offset, int length) {
		input.charAt(0);
		return null;
	}

}
