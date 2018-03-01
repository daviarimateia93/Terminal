package me.gerenciar.Terminal;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {
	
	public String execute(String command) throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec(command);
		process.waitFor();
		
		InputStream inputStream = process.getInputStream();
		
		return IOUtils.toString(inputStream, "UTF-8");
	}
}
