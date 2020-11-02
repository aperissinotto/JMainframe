package perissinotto.com.it.controller;

import perissinotto.com.it.model.Connector;
import perissinotto.com.it.model.Converter;
import perissinotto.com.it.model.Message;

public class ConectaMainframe {
	
	public static void main(String[] args) {
		Converter conversor = new Converter();
		Connector conexaoMainframe = new Connector("192.168.25.210", 23);
		
		if (conexaoMainframe.Connect()) {
			Message msg = conexaoMainframe.Receive();
			if (msg != null) {
				System.out.println(conversor.toHex(msg.getMessageContent(),msg.getMessageLength()));
			}
		}
	}
}
