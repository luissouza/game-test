package wsr.game.bean;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import wsr.game.types.StringsGame;
import wsr.game.vo.Player;

public class VerificaStrings {

	private int totalKills = 0;

	public boolean verifica(String linha, String valor) {
		switch (valor) {
		case StringsGame.INIT_GAME:
			if (this.match(StringsGame.INIT_GAME, linha).matches()) {
				return true;
			} else {
				return false;
			}
		case StringsGame.KILL:
			if (this.match(StringsGame.KILL, linha).matches() == true) {
				return true;
			} else {
				return false;
			}
		case StringsGame.CLIENT_USER_INFO_CHANGED:
			if (linha.length() > 46) {
				if (this.match(StringsGame.CLIENT_USER_INFO_CHANGED, linha).matches()) {
					return true;
				} else {
					return false;
				}
			}
		default:
			return false;

		}
	}

	public Matcher match(String valor, String linha) {
		Pattern pattern = Pattern.compile(".*" + valor + ".*");
		Matcher matcher = pattern.matcher(linha.trim());
		return matcher;
	}

	public void verificaKillsPorPlayer(String linha, List<Player> players) {

		final Matcher linhaKill = Pattern.compile("([0-9]*[0-9]:[0-5][0-9])" + "\\s(" + StringsGame.KILL + ":)(.*?)").matcher(linha);
		linhaKill.matches();
		final String kill = linhaKill.group(3).trim();
		final Matcher matcher = Pattern.compile("([0-9]*)\\s([0-9]*)\\s([0-9]*)(.*)").matcher(kill);
		if (!matcher.matches()) {
			return;
		}

		 String idPlayerKiller = matcher.group(1);
		 String idPlayerKilled = matcher.group(2);
		 String nomePlayerKilled = linha.substring(linha.indexOf("killed"), linha.indexOf("by")).trim().replaceAll("killed ", "");
		 String nomePlayerKiller = kill.substring(kill.indexOf(": "), kill.indexOf("killed")).trim().replaceAll(": ", "");

		for (Player p : players) {
			if (Integer.parseInt(idPlayerKiller) == 1022) {
				if (p.getId() == Integer.parseInt(idPlayerKilled)) {
					if(p.getNome().equals(nomePlayerKilled)) {
						p.getPlayerKills().punish();
					}
				}
			} else {
				if ((p.getId() == Integer.parseInt(idPlayerKiller)) && (p.getId() == Integer.parseInt(idPlayerKilled))) {

				} else {
					if (p.getId() == Integer.parseInt(idPlayerKiller)) {
						if(p.getNome().equals(nomePlayerKiller)) {
							p.getPlayerKills().addKill();
							somaMortes(1);
						}
					}
				}
			}
		}
	}

	public void somaMortes(int valor) {
		totalKills += valor;
	}

	public int getTotalKills() {
		return totalKills;
	}

	public void setTotalKills(int totalKills) {
		this.totalKills = totalKills;
	}
}
