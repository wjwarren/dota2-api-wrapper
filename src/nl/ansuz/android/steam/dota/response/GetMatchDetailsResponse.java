package nl.ansuz.android.steam.dota.response;

import nl.ansuz.android.steam.dota.vo.PlayerVO;

import com.google.gson.annotations.SerializedName;

/**
 * Response object for the GetMatchDetails request.
 * 
 * @author Wijnand
 */
public class GetMatchDetailsResponse {

	/**
	 * Type of match lobby.
	 * 
	 * @author Wijnand
	 */
	public enum LobbyType {
		HUMAN,
		CO_OP_BOT;
		
		private static final LobbyType[] typeValues = LobbyType.values();
		
		public static LobbyType fromInteger(int i) {
			return typeValues[i];
		}
	}
	
	/**
	 * Type of game mode.
	 * 
	 * @author Wijnand
	 */
	public enum GameMode {
		
	}
	
	/**
	 * The list of players that participated in this match.
	 */
	@SerializedName("players")
	public PlayerVO[] players;
	
	/**
	 * ???
	 */
	@SerializedName("season")
	public int season;
	
	/**
	 * True if radiant won, false otherwise.
	 */
	@SerializedName("radiant_win")
	public boolean radiantWin;
	
	/**
	 * Total time in seconds the match ran for.
	 */
	@SerializedName("duration")
	public int duration;
	
	/**
	 * Date in UTC seconds since Jan 1, 1970 (unix time format).
	 */
	@SerializedName("starttime")
	public int startTime;
	
	/**
	 * Numeric match ID.
	 */
	@SerializedName("match_id")
	public int matchId;
	
	/**
	 * An 11-bit unsinged int representing Radiant tower status.
	 * 
	 * @see http://dev.dota2.com/showthread.php?t=57234
	 */
	@SerializedName("tower_status_radiant")
	public int towerStatusRadiant;
	
	/**
	 * An 11-bit unsinged int representing Dire tower status
	 * 
	 * @see http://dev.dota2.com/showthread.php?t=57234
	 */
	@SerializedName("tower_status_dire")
	public int towerStatusDire;
	
	/**
	 * A 6-bit unsinged int representing Radiant barracks status
	 * 
	 * @see http://dev.dota2.com/showthread.php?t=57234
	 */
	@SerializedName("barracks_status_radiant")
	public int barracksStatusRadiant;
	
	/**
	 * A 6-bit unsinged int representing Dire barracks status
	 * 
	 * @see http://dev.dota2.com/showthread.php?t=57234
	 */
	@SerializedName("barracks_status_dire")
	public int barracksStatusDire;
	
	/**
	 * The cluster this match was played at OR where to get the replay from.
	 */
	@SerializedName("cluster")
	public int cluster;
	
	/**
	 * Time in seconds at which first blood occurred
	 */
	@SerializedName("first_blood_time")
	public int firstBloodTime;
	
	/**
	 * Unique replay salt.
	 */
	@SerializedName("replay_salt")
	public int replaySalt;
	
	/**
	 * Type of lobby (0 for human matchmaking, 1 for co-op bot).
	 */
	@SerializedName("lobby_type")
	public int lobbyType;
	
	/**
	 * Number of human players in the match.
	 */
	@SerializedName("human_players")
	public int humanPlayers;
	
	/**
	 * League this match was played in.
	 */
	@SerializedName("leagueid")
	public int leagueId;
	
	/**
	 * number of thumbs up the game has received.
	 */
	@SerializedName("positive_votes")
	public int positiveVotes;
	
	/**
	 * Number of thumbs down the game has received.
	 */
	@SerializedName("negative_votes")
	public int negativeVotes;
	
	/**
	 * The type of game that was played:
	 *  - All pick
	 *  - Single draft
	 *  - Captain's Mode
	 *  - Random Draft
	 *  - All Random
	 *  - Reverse Draft
	 *  - WTF Mode
	 *  (- Dire Tide?)
	 *  
	 * @see http://www.dota2wiki.com/wiki/Game_Modes
	 * 
	 * Need to figure out which int value represents which mode.
	 */
	@SerializedName("game_mode")
	public int gameMode;
	
}
