package perissinotto.com.it.controller;

public class TestesGerais {
	public static void main(String[] args) {
		String terminalType = "IBM-3278-2-E";
		byte[] teste = terminalType.getBytes();
		byte[] teste2 = new byte[teste.length];
		
		for (byte cmd : teste) {
			System.out.println(Integer.toHexString(cmd));
			System.out.println(Byte.parseByte(Integer.toHexString(cmd)));
		}		
		

		
	}
}