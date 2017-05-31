package wsr.game.vo;

import java.util.List;

public class GameEntity {
	
	public int kills;
	public List<Player> players;
	public List<String> killsPlayers;
	
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public List<String> getKillsPlayers() {
		return killsPlayers;
	}
	public void setKillsPlayers(List<String> killsPlayers) {
		this.killsPlayers = killsPlayers;
	}
	
	
	
}
