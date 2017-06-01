package wsr.game.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import wsr.game.types.StringsGame;
import wsr.game.vo.GameEntity;
import wsr.game.vo.GameEntityJSON;
import wsr.game.vo.Player;

public class GameBean {

	private ArrayList<String> linhas;
	private List<Player> players;
	private List<GameEntity> listGames = new ArrayList<GameEntity>();
	private List<GameEntityJSON> listGamesJSON = new ArrayList<GameEntityJSON>();
	private GameEntity game;
	private VerificaStrings verificaStrings = new VerificaStrings();
	private RetornaPlayer retornaPlayer = new RetornaPlayer();
	private Map<String, GameEntityJSON> mapJson = new HashMap<>();

	/**
	 * Metodo responsavel por abrir o arquivo games.log
	 * @throws IOException
	 */
	public void abreArquivoLog() throws IOException {
		File file = new File("//home//luisgustavo//temp//game.log");
		//File file = new File("c://temp//game.log");
		getLinhasArquivo(file);
	}
	
	/**
	 * Metodo responsavel por ler o arquivo games.log, iterar as linhas do arquivo e jogar para uma ArrayList.
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public ArrayList<String> getLinhasArquivo(File file) throws FileNotFoundException, IOException {
		try (BufferedReader leitor = new BufferedReader(new FileReader(file))) {
			linhas = new ArrayList<>();
			String linha = "";
			while ((linha = leitor.readLine()) != null) {
				linhas.add(linha.trim());
			}
		}
		return linhas;
	}

	/**
	 * Metodo que determina quando um novo jogo começa e finaliza.
	 * @param numeroJogo
	 */
	public void novoGame(int numeroJogo) {
		game = new GameEntity();
		game.setKills(0);
		players = new ArrayList<Player>();
	}
	
	/**
	 * Metodo responsavel por iterar sobre a ArrayList de linhas.
	 * Executa outros Metodos durante a iteracao, para iniciar um novo jogo, pegar os players e definir as mortes para cada usuario.
	 */
	public void separarGames() {
		int i = 1;
		for (String linha : linhas) {
			if (this.verificaStrings.verifica(linha, StringsGame.INIT_GAME)) {
				novoGame(i);
				listGames.add(game);
				this.verificaStrings.setTotalKills(0);
				i++;
			}

			if (this.verificaStrings.verifica(linha, StringsGame.CLIENT_USER_INFO_CHANGED)) {
				Player player = new Player();
				player = this.retornaPlayer.montaObjetoPlayer(linha);
				if (!this.retornaPlayer.verificaExistenciaPlayer(players, player)) {
					players.add(player);
				}
				game.setPlayers(players);
			}

			if (this.verificaStrings.verifica(linha, StringsGame.KILL)) {
				this.verificaStrings.verificaKillsPorPlayer(linha, players);
				this.game.setKills(this.verificaStrings.getTotalKills());
			}
		}
		
		montaJSON(listGames);
	}
	
	public void montaJSON(List<GameEntity> listGames) {
		int x = 1;
		for (GameEntity g : listGames) {
			String gameNumber = "game_" + x++;
			GameEntityJSON gameJSON = new GameEntityJSON();
			gameJSON.setTotal_kills(g.getKills());

			int i = 0;
			for (Player p : g.getPlayers()) {
				gameJSON.getPlayers().add(g.getPlayers().get(i).getNome());
				gameJSON.getKills().put(g.getPlayers().get(i).getNome(), g.getPlayers().get(i).getPlayerKills().getKill());
				i++;
			}
			listGamesJSON.add(gameJSON);
			mapJson.put(gameNumber, gameJSON);
			
			Gson gson = new Gson();
		    JsonElement element = gson.toJsonTree(gameJSON);
		    JsonObject object = new JsonObject();
		    object.add(gameNumber, element);
		    
		    Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
		    System.out.println(gsonBuilder.toJson(object));
		
		}
	}

	public List<GameEntityJSON> getListGamesJSON() {
		return listGamesJSON;
	}

	public void setListGamesJSON(List<GameEntityJSON> listGamesJSON) {
		this.listGamesJSON = listGamesJSON;
	}

	public Map<String, GameEntityJSON> getMapJson() {
		return mapJson;
	}

	public void setMapJson(Map<String, GameEntityJSON> mapJson) {
		this.mapJson = mapJson;
	}

}
