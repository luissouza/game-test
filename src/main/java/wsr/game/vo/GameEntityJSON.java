package wsr.game.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameEntityJSON {
	
	public transient int game;
	public int total_kills;
	public List<String> players;

	Map<String, Integer> kills = new HashMap<>();
	
	
	public int getGame() {
		return game;
	}
	public void setGame(int game) {
		this.game = game;
	}
	public int getTotal_kills() {
		return total_kills;
	}
	public void setTotal_kills(int total_kills) {
		this.total_kills = total_kills;
	}
	public List<String> getPlayers() {
		if(players == null) {
			players = new ArrayList<String>();
		}
		return players;
	}
	public void setPlayers(List<String> players) {
		this.players = players;
	}
	public Map<String, Integer> getKills() {
		return kills;
	}
	public void setKills(Map<String, Integer> kills) {
		this.kills = kills;
	}
	
}
