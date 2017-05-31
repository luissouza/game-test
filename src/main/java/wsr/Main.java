package wsr;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import wsr.game.bean.GameBean;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		
		GameBean game = new GameBean();
		
		try {
			game.abreArquivoLog();
			game.separarGames();    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}