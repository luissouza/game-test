package wsr.game.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameEntityJSON {
	
	
	private int total_kills;
	private List<String> players;
	private Map<String, Integer> kills = new HashMap<>();
	
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
