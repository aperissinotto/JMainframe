package perissinotto.com.it.controller;

import perissinotto.com.it.model.Connector;
import perissinotto.com.it.model.Converter;
import perissinotto.com.it.model.Log;
import perissinotto.com.it.model.Message;
import perissinotto.com.it.model.Processor;

public class ConectaMainframe {
	
	public static void main(String[] args) {
		Converter conversor = new Converter();
		Processor processador = new Processor();
		Connector conexaoMainframe = new Connector("159.8.102.103", 23);
		Log geraLog = new Log();
		
		if (conexaoMainframe.Connect()) {
			Message msgrec1 = conexaoMainframe.Receive(30000);
			if (msgrec1 != null) {
				System.out.println("RECEIVE: " + conversor.toHexString(msgrec1.getMessageContent(), 0, msgrec1.getMessageLength()));
				//processador.ProcessCommand(msgrec1.getMessageContent());
			}
			
			byte[] bufaux = new byte[3];
			bufaux[0] = (byte) 0xFF; 
			bufaux[1] = (byte) 0xFC; 
			bufaux[2] = (byte) 0x28; 
			Message msgsnd1 = new Message(bufaux, bufaux.length);
			System.out.println("SEND: " + conversor.toHexString(msgsnd1.getMessageContent(), 0, msgsnd1.getMessageLength()));
			conexaoMainframe.Send(msgsnd1);
			
			Message msgrec2 = conexaoMainframe.Receive(30000);
			if (msgrec2 != null) {
				System.out.println("RECEIVE: " + conversor.toHexString(msgrec2.getMessageContent(), 0, msgrec2.getMessageLength()));
				//processador.ProcessCommand(msgrec2.getMessageContent());
			}
			
			byte[] bufaux2 = new byte[3];
			bufaux2[0] = (byte) 0xFF; 
			bufaux2[1] = (byte) 0xFB; 
			bufaux2[2] = (byte) 0x18; 
			Message msgsnd2 = new Message(bufaux2, bufaux2.length);
			System.out.println("SEND: " + conversor.toHexString(msgsnd2.getMessageContent(), 0, msgsnd2.getMessageLength()));
			conexaoMainframe.Send(msgsnd2);
			
			Message msgrec3 = conexaoMainframe.Receive(30000);
			if (msgrec3 != null) {
				System.out.println("RECEIVE: " + conversor.toHexString(msgrec3.getMessageContent(), 0, msgrec3.getMessageLength()));
				//processador.ProcessCommand(msgrec3.getMessageContent());
			}
			
			byte[] bufaux3 = new byte[18];
			bufaux3[0] = (byte) 0xFF; 
			bufaux3[1] = (byte) 0xFA; 
			bufaux3[2] = (byte) 0x18;
			bufaux3[3] = (byte) 0x00;
			bufaux3[4] = (byte) 0x49;
			bufaux3[5] = (byte) 0x42;
			bufaux3[6] = (byte) 0x4D;
			bufaux3[7] = (byte) 0x2D;
			bufaux3[8] = (byte) 0x33;
			bufaux3[9] = (byte) 0x32;
			bufaux3[10] = (byte) 0x37;
			bufaux3[11] = (byte) 0x38;
			bufaux3[12] = (byte) 0x2D;
			bufaux3[13] = (byte) 0x32;
			bufaux3[14] = (byte) 0x2D;
			bufaux3[15] = (byte) 0x45;
			bufaux3[16] = (byte) 0xFF;
			bufaux3[17] = (byte) 0xF0;
			Message msgsnd3 = new Message(bufaux3, bufaux3.length);
			System.out.println("SEND: " + conversor.toHexString(msgsnd3.getMessageContent(), 0, msgsnd3.getMessageLength()));
			conexaoMainframe.Send(msgsnd3);
			
			Message msgrec4 = conexaoMainframe.Receive(30000);
			if (msgrec4 != null) {
				System.out.println("RECEIVE: " + conversor.toHexString(msgrec4.getMessageContent(), 0, msgrec4.getMessageLength()));
				//processador.ProcessCommand(msgrec4.getMessageContent());
			}
			
			byte[] bufaux4 = new byte[3];
			bufaux4[0] = (byte) 0xFF; 
			bufaux4[1] = (byte) 0xFB; 
			bufaux4[2] = (byte) 0x19; 
			Message msgsnd4 = new Message(bufaux4, bufaux4.length);
			System.out.println("SEND: " + conversor.toHexString(msgsnd4.getMessageContent(), 0, msgsnd4.getMessageLength()));
			conexaoMainframe.Send(msgsnd4);
			
			Message msgrec5 = conexaoMainframe.Receive(30000);
			if (msgrec5 != null) {
				System.out.println("RECEIVE: " + conversor.toHexString(msgrec5.getMessageContent(), 0, msgrec5.getMessageLength()));
				//processador.ProcessCommand(msgrec5.getMessageContent());
			}
			
			Message msgrec6 = conexaoMainframe.Receive(30000);
			if (msgrec6 != null) {
				System.out.println("RECEIVE: " + conversor.toHexString(msgrec6.getMessageContent(), 0, msgrec6.getMessageLength()));
				//processador.ProcessCommand(msgrec6.getMessageContent());
			}
			
			byte[] bufaux5 = new byte[3];
			bufaux5[0] = (byte) 0xFF; 
			bufaux5[1] = (byte) 0xFD; 
			bufaux5[2] = (byte) 0x19; 
			Message msgsnd5 = new Message(bufaux5, bufaux5.length);
			System.out.println("SEND: " + conversor.toHexString(msgsnd5.getMessageContent(), 0, msgsnd5.getMessageLength()));
			conexaoMainframe.Send(msgsnd5);
			
			byte[] bufaux6 = new byte[6];
			bufaux6[0] = (byte) 0xFF; 
			bufaux6[1] = (byte) 0xFB; 
			bufaux6[2] = (byte) 0x00; 
			bufaux6[3] = (byte) 0xFF; 
			bufaux6[4] = (byte) 0xFD; 
			bufaux6[5] = (byte) 0x00;
			Message msgsnd6 = new Message(bufaux6, bufaux6.length);
			System.out.println("SEND: " + conversor.toHexString(msgsnd6.getMessageContent(), 0, msgsnd6.getMessageLength()));
			conexaoMainframe.Send(msgsnd6);

			Message msgrec7 = conexaoMainframe.Receive(30000);
			if (msgrec7 != null) {
				System.out.println("RECEIVE: " + conversor.toHexString(msgrec7.getMessageContent(), 0, msgrec7.getMessageLength()));
				//processador.ProcessCommand(msgrec7.getMessageContent());
			}
		}
	}
}
