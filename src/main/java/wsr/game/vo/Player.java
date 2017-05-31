package wsr.game.vo;

public class Player {

	public int id;
	public String nome;
	private PlayerKillsEntity playerKills;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PlayerKillsEntity getPlayerKills() {
		if(playerKills == null) {
			playerKills = new PlayerKillsEntity();
		}
		return playerKills;
	}

	public void setPlayerKills(PlayerKillsEntity playerKills) {
		this.playerKills = playerKills;
	}
	

}
