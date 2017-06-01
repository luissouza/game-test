package wsr.game.vo;

import java.util.List;

public class GameEntity {
	
	private int kills;
	private List<Player> players;
	private List<String> killsPlayers;
	
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public List<String> getKillsPlayers() {
		return killsPlayers;
	}
	public void setKillsPlayers(List<String> killsPlayers) {
		this.killsPlayers = killsPlayers;
	}
	
	
	
	
	
}
