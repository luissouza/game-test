package wsr.game.controller;

import java.io.IOException;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import wsr.game.bean.GameBean;
import wsr.game.vo.GameEntityJSON;

@RestController
public class GameController {
	
	@RequestMapping("/games")
	@ResponseBody
	public ResponseEntity<Map<String, GameEntityJSON>> findByAll() {
		
		GameBean game = new GameBean();
		
		try {
			game.abreArquivoLog();
			game.separarGames();    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			header.set("type", "games");
				
			return new ResponseEntity<Map<String, GameEntityJSON>>(game.getMapJson(), header, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}