package nl.ansuz.android.steam.dota.response;

import nl.ansuz.android.steam.dota.util.DotaBuildingStatus.DotaTower;
import nl.ansuz.android.steam.dota.vo.PickBanVO;
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
	 * The docs seem to be completely off here. What is listed on the site below, doesn't match with what I've seen in 
	 * testing.
	 * Correct order is listed on: 
	 * https://bitbucket.org/VoiDeD/steamre/src/0152b728b88103ceb8afdaa8b157927135451d8d/Resources/Protobufs/dota/dota_gcmessages.proto
	 * (DOTA_GameMode).
	 * 
	 * @see http://wiki.teamfortress.com/wiki/WebAPI/GetMatchDetails
	 * @author Wijnand
	 */
	public enum GameMode {
		UNKNOWN,
		ALL_PICK, // 1 - verified
		CAPTAINS_MODE,
		RANDOM_DRAFT, // 3 - verified
		SINGLE_DRAFT, // 4 - verified
		ALL_RANDOM, // 5 - verified
		INTRO,
		DIRETIDE, // = Halloween
		REVERSE_CAPTAINS_MODE,
		THE_GREEVILING, // = Xmas
		TUTORIAL,
		MID_ONLY,
		LEAST_PLAYED,
		NEW_PLAYER_POOL;

		private static final GameMode[] gameModeValues = GameMode.values();

		public static GameMode fromInteger(int i) {
			if(i < 1 || i > gameModeValues.length - 1) {
				i = 0;
			}
			return gameModeValues[i];
		}
	}

	private static final int ONE_MINUTE = 60;
	
	private int totalGoldRadiant = -1;
	private int totalGoldDire = -1;
	private int totalXpRadiant = -1;
	private int totalXpDire = -1;
	
	/**
	 * The list of players that participated in this match.
	 */
	@SerializedName("players")
	public PlayerVO[] players;
	
	/**
	 * The season the game was played in.
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
	 * A "sequence number", representing the order in which matches were recorded.
	 */
	@SerializedName("match_seq_num")
	public long matchSequenceNumber;
	
	/**
	 * An 11-bit unsinged int representing Radiant tower status.
	 * Use in conjunction with {@link DotaBuildingStatus#isTowerUp(int, DotaTower)} to determine if the tower is still
	 * up.
	 * 
	 * @see http://dev.dota2.com/showthread.php?t=57234
	 */
	@SerializedName("tower_status_radiant")
	public int towerStatusRadiant;
	
	/**
	 * An 11-bit unsinged int representing Dire tower status.
	 * Use in conjunction with {@link DotaBuildingStatus#isTowerUp(int, DotaTower)} to determine if the tower is still
	 * up.
	 * 
	 * @see http://dev.dota2.com/showthread.php?t=57234
	 */
	@SerializedName("tower_status_dire")
	public int towerStatusDire;
	
	/**
	 * A 6-bit unsinged int representing Radiant barracks status
	 * Use in conjunction with {@link DotaBuildingStatus#isTowerUp(int, DotaBarracks)} to determine if the barracks are
	 * still up.
	 * 
	 * @see http://dev.dota2.com/showthread.php?t=57234
	 */
	@SerializedName("barracks_status_radiant")
	public int barracksStatusRadiant;
	
	/**
	 * A 6-bit unsinged int representing Dire barracks status
	 * Use in conjunction with {@link DotaBuildingStatus#isTowerUp(int, DotaBarracks)} to determine if the barracks are
	 * still up.
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
	 * The type of game that was played.
	 */
	@SerializedName("game_mode")
	public int gameMode;
	
	/**
	 * A list of the picks and bans in the match, if the game mode is Captains Mode.
	 */
	@SerializedName("picks_bans")
	public PickBanVO[] picksBans;
	
	/**
	 * Calculates the total Gold and XP earned by Radiant and Dire.
	 */
	private void calculateTotals() {
		// Only calculate total when we haven't done so yet.
		if (totalGoldRadiant < 0) {
			totalGoldRadiant = 0;
			totalGoldDire = 0;
			totalXpRadiant = 0;
			totalXpDire = 0;
			
			for (PlayerVO player : players) {
				if (player.isRadiant()) {
					totalGoldRadiant += player.getTotalGold();
					totalXpRadiant += player.xpPerMinute * duration / ONE_MINUTE;
				} else {
					totalGoldDire += player.getTotalGold();
					totalXpDire += player.xpPerMinute * duration / ONE_MINUTE;
				}
			}
		}
	}
	
	/**
	 * NOTE: This is an estimation and might be slightly off compared to the actual number.
	 * @return The total gold earned by the Radiant team.
	 */
	public int getTotalGoldRadiant() {
		calculateTotals();
		return totalGoldRadiant;
	}
	
	/**
	 * NOTE: This is an estimation and might be slightly off compared to the actual number.
	 * @return The total gold earned by the Dire team.
	 */
	public int getTotalGoldDire() {
		calculateTotals();
		return totalGoldDire;
	}
	
	/**
	 * NOTE: This is an estimation and might be slightly off compared to the actual number.
	 * @return The total XP earned by the Radiant team.
	 */
	public int getTotalXpRadiant() {
		calculateTotals();
		return totalXpRadiant;
	}
	
	/**
	 * NOTE: This is an estimation and might be slightly off compared to the actual number.
	 * @return The total XP earned by the Dire team.
	 */
	public int getTotalXpDire() {
		calculateTotals();
		return totalXpDire;
	}
	
}
