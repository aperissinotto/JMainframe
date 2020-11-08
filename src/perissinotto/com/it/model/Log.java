package perissinotto.com.it.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Log {
	
		private LocalDateTime logDateTime = null;
		
		public void toFile(String logInfo) {
			try {
				FileWriter fw = new FileWriter("log.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				this.logDateTime = LocalDateTime.now();
				bw.write(this.logDateTime.toString() + " - " + logInfo + System.lineSeparator());
				bw.close();
			} catch (IOException e) {
				System.out.println("Log fail:" + e.getMessage());
			}
		}
		
		public void toSysout(String logInfo) {
			this.logDateTime = LocalDateTime.now();
			System.out.println(this.logDateTime.toString() + " - " + logInfo + System.lineSeparator());
		}

}
