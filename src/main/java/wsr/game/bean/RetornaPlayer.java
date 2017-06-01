package wsr.game.bean;

import java.util.List;

import wsr.game.vo.Player;

public class RetornaPlayer {
	
	private Player player;
	
	public Player montaObjetoPlayer(String linha) {
		if (linha.length() > 0) {
			player = new Player();
			player.setId(Integer.parseInt(linha.substring(linha.indexOf("Changed:"), linha.indexOf("n\\")).trim().replace("Changed: ", "")));
			player.setNome(linha.substring(linha.indexOf("n\\") + 2, linha.indexOf("\\t\\")));
		}
		return player;
	}

	public boolean verificaExistenciaPlayer(List<Player> players, Player player) {
		boolean existe = false;
		for (Player p : players) {
			if ((player.id == p.id) && (player.nome.equals(p.nome))) {
				existe = true;
			}
		}
		return existe;
	}
}
