package perissinotto.com.it.controller;

import perissinotto.com.it.model.Connector;
import perissinotto.com.it.model.Converter;
import perissinotto.com.it.model.Message;
import perissinotto.com.it.model.Processor;

public class ConectaMainframe2 {
	
	public static void main(String[] args) {
		Converter conversor = new Converter();
		Processor processador = new Processor();
		Connector conexaoMainframe = new Connector("159.8.102.103", 23);
		
		if (conexaoMainframe.Connect()) {
			Message msgrec1 = conexaoMainframe.Receive(30000);
			if (msgrec1 != null) {
				System.out.println(conversor.toHexString(msgrec1.getMessageContent(), 0, msgrec1.getMessageLength()));
				processador.ProcessMessage(msgrec1);
			}
			
			byte[] bufaux = new byte[3];
			bufaux[0] = (byte) 0xFF; 
			bufaux[1] = (byte) 0xFB; 
			bufaux[2] = (byte) 0x28; 
			Message msgsnd1 = new Message(bufaux, bufaux.length);
			conexaoMainframe.Send(msgsnd1);
			
			Message msgrec2 = conexaoMainframe.Receive(30000);
			if (msgrec2 != null) {
				System.out.println(conversor.toHexString(msgrec2.getMessageContent(), 0, msgrec2.getMessageLength()));
				processador.ProcessMessage(msgrec2);
			}
						
			byte[] bufaux3 = new byte[19];
			bufaux3[0] = (byte) 0xFF; 
			bufaux3[1] = (byte) 0xFA; 
			bufaux3[2] = (byte) 0x28;
			bufaux3[3] = (byte) 0x02;
			bufaux3[4] = (byte) 0x07;
			bufaux3[5] = (byte) 0x49;
			bufaux3[6] = (byte) 0x42;
			bufaux3[7] = (byte) 0x4D;
			bufaux3[8] = (byte) 0x2D;
			bufaux3[9] = (byte) 0x33;
			bufaux3[10] = (byte) 0x32;
			bufaux3[11] = (byte) 0x37;
			bufaux3[12] = (byte) 0x38;
			bufaux3[13] = (byte) 0x2D;
			bufaux3[14] = (byte) 0x32;
			bufaux3[15] = (byte) 0x2D;
			bufaux3[15] = (byte) 0x45;
			bufaux3[16] = (byte) 0xFF;
			bufaux3[17] = (byte) 0xF0;
			Message msgsnd3 = new Message(bufaux3, bufaux3.length);
			conexaoMainframe.Send(msgsnd3);
			
			Message msgrec4 = conexaoMainframe.Receive(30000);
			if (msgrec4 != null) {
				System.out.println(conversor.toHexString(msgrec4.getMessageContent(), 0, msgrec4.getMessageLength()));
				processador.ProcessMessage(msgrec4);
			}
			
			byte[] bufaux4 = new byte[3];
			bufaux4[0] = (byte) 0xFF; 
			bufaux4[1] = (byte) 0xFB; 
			bufaux4[2] = (byte) 0x19; 
			Message msgsnd4 = new Message(bufaux4, bufaux4.length);
			conexaoMainframe.Send(msgsnd4);
			
			Message msgrec5 = conexaoMainframe.Receive(30000);
			if (msgrec5 != null) {
				System.out.println(conversor.toHexString(msgrec5.getMessageContent(), 0, msgrec5.getMessageLength()));
				processador.ProcessMessage(msgrec5);
			}
			
			Message msgrec6 = conexaoMainframe.Receive(30000);
			if (msgrec6 != null) {
				System.out.println(conversor.toHexString(msgrec6.getMessageContent(), 0, msgrec6.getMessageLength()));
				processador.ProcessMessage(msgrec6);
			}
			
			byte[] bufaux5 = new byte[3];
			bufaux5[0] = (byte) 0xFF; 
			bufaux5[1] = (byte) 0xFD; 
			bufaux5[2] = (byte) 0x19; 
			Message msgsnd5 = new Message(bufaux5, bufaux5.length);
			conexaoMainframe.Send(msgsnd5);
			
			byte[] bufaux6 = new byte[6];
			bufaux6[0] = (byte) 0xFF; 
			bufaux6[1] = (byte) 0xFB; 
			bufaux6[2] = (byte) 0x00; 
			bufaux6[3] = (byte) 0xFF; 
			bufaux6[4] = (byte) 0xFD; 
			bufaux6[5] = (byte) 0x00;
			Message msgsnd6 = new Message(bufaux6, bufaux6.length);
			conexaoMainframe.Send(msgsnd6);

			Message msgrec7 = conexaoMainframe.Receive(30000);
			if (msgrec7 != null) {
				System.out.println(conversor.toHexString(msgrec7.getMessageContent(), 0, msgrec7.getMessageLength()));
				processador.ProcessMessage(msgrec7);
			}
		}
	}
}
