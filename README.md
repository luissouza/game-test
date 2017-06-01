# Quake Log Parser - Teste
Solução em JAVA para o parser do Quake Log.
Para a construção da API de consumo, foi utilizado SprinMVC e SpringBoot.


### Para abrir e executar o projeto siga os passos:
- 1 - Importe o projeto MAVEN no eclipse.
- 2 - Antes de executar,  verifique o caminho do arquivo 'game.log' na classe GameBean.java.
- 3 - Localize a classe Main.java, clique com o botão direito em 'Run as' e sem seguida clique em 'Java Application'.
- 4 - O resultado do parser irá aparecer no console, e deverá ser parecido com o código JSON abaixo:

```java
{
  "game_3": {
    "total_kills": 1,
    "players": [
      "Dono da Bola",
      "Mocinha",
      "Isgalamido",
      "Zeh"
    ],
    "kills": {
      "Dono da Bola": -1,
      "Mocinha": -1,
      "Isgalamido": 1,
      "Zeh": -2
    }
  }
}
```


- 5 - Para visualizar o resultado através da API de consulta, acesse o navegador ou alguma ferramenta para consumo de APIs como é o caso do PostMan, informando o link "http://localhost:8080/games". (Caso a porta 8080 já esteja sendo utilizada em seu computador, acesse o arquivo application.properties que está localizado na pasta src/main/properties e altere a porta padrão.



### Informações sobre o arquivo 'game.log':

- 1 - O jogo é iniciado através da palavra 'InitGame', exemplo:
```java
   20:37 InitGame: \sv_floodProtect\
```
- 2 - Os usuários são localizados apartir da palavra 'ClientUserinfoChanged', exemplo:
```java
   ClientUserinfoChanged: 2 n\Isgalamido\t\
```
- 3 - As mortes são localizadas apartir da palavra 'Kill', exemplo:
```java
   20:54 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT
   ou
   4:08 Kill: 4 3 7: Zeh killed Isgalamido by MOD_ROCKET_SPLASH
 ```  
- 4 - Em cada 'Kill' existe o id do jogador que matou, do jogador que morreu e do tipo de morte, exemplo:
```java
   Kill: 1022 2 22
   ou
   Kill: 4 3 7
```

### Passos para a leitura do arquivo:

- 1 - Localize onde o jogo inicia e onde ele finaliza.
- 2 - Localize os usuários de cada jogo.
- 3 - Localize as mortes de cada usuário em cada jogo.
- 4 - Caso a linha onde se identifica a morte esteja com a palavra 'world' o usuário deverá perder uma kill.


