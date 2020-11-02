package perissinotto.com.it.model;

public class Converter {
	private StringBuilder output = new StringBuilder();

	public String toHexString(byte[] input, int offset, int length) {
		for (int pointer = offset; pointer < length; pointer++) {
			output.append(String.format("%02X ", (input[pointer] & 0xFF)));
		}

		if (output.length() > 0) {
			output.deleteCharAt(output.length() - 1);
		}

		return output.toString();
	}

}
