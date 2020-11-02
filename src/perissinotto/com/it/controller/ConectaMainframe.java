package perissinotto.com.it.controller;

import perissinotto.com.it.model.Connector;
import perissinotto.com.it.model.Converter;
import perissinotto.com.it.model.Message;
import perissinotto.com.it.model.Processor;

public class ConectaMainframe {
	
	public static void main(String[] args) {
		Converter conversor = new Converter();
		Processor processador = new Processor();
		Connector conexaoMainframe = new Connector("192.168.25.210", 23);
		
		if (conexaoMainframe.Connect()) {
			Message msg = conexaoMainframe.Receive();
			if (msg != null) {
				System.out.println(conversor.toHexString(msg.getMessageContent(), 0, msg.getMessageLength()));
				processador.ProcessCommand(msg.getMessageContent());
			}
			
		}
	}
}
