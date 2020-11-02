package perissinotto.com.it.controller;

import perissinotto.com.it.model.Conexao;
import perissinotto.com.it.model.Mensagem;

public class ConectaMainframe {
	
	public static void main(String[] args) {
		Conexao conexaoMainframe = new Conexao("192.168.25.210", 23);
		
		
		if(conexaoMainframe.Conecta()) {
			if(conexaoMainframe.Recebe()) {
				Mensagem msg = new Mensagem(conexaoMainframe.getMensagemRecebida(), conexaoMainframe.getQuantidadeBytesRecebidos());
				System.out.println(msg.paraHex());
			}
		}
	}
}
