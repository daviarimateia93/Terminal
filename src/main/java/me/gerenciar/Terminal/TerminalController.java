package me.gerenciar.Terminal;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/terminal")
public class TerminalController {
	
	private TerminalService terminalService;
	
	public TerminalController(TerminalService terminalService) {
		this.terminalService = terminalService;
	}
	
	@GetMapping
	Mono<String> welcome() {
		return Mono.just("Welcome to terminal, go to /terminal/execute");
	}
	
	@GetMapping("/execute")
	@PostMapping("/execute")
	String execute(@RequestParam String command) throws IOException, InterruptedException {
		return terminalService.execute(command);
	}
}
