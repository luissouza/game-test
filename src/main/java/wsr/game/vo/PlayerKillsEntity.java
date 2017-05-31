package wsr.game.vo;


public class PlayerKillsEntity {
	
	
	public int kill = 0;
	
	public void addKill() {
		this.kill++;
	}

	public void punish() {
		this.kill--;
	}

	public int getKill() {
		return kill;
	}

	public void setKill(int kill) {
		this.kill = kill;
	}	
	
	

}
