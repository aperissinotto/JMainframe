package perissinotto.com.it.model;

public class Mensagem {
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	
	private byte[] mensagem;
	private int tamanhoMensagem;
	
	private char[] hexChars = new char[tamanhoMensagem * 2];
	
	public Mensagem(byte[] mensagem, int tamanhoMensagem) {
		this.mensagem = mensagem;
		this.tamanhoMensagem = tamanhoMensagem;
	}

	public String paraHex() {
		for (int j = 0; j < this.tamanhoMensagem; j++) {
			int v = this.mensagem[j] & 0xFF;
			hexChars[j * 2] = HEX_ARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		return String.copyValueOf(hexChars);
	}
}
