package nl.ansuz.android.steam.dota.vo.match;

import nl.ansuz.android.steam.dota.util.DotaBuildingStatus.DotaTower;
import nl.ansuz.android.steam.dota.vo.TeamVO;
import nl.ansuz.android.steam.dota.vo.players.LiveLeaguePlayerVO;

import com.google.gson.annotations.SerializedName;

public class LiveLeagueMatchVO {

	/**
	 * The list of players within a game.
	 */
	@SerializedName("players")
	public LiveLeaguePlayerVO[] players;
	
	/**
	 * Information about the team playing as Radiant for this match.
	 */
	@SerializedName("radiant_team")
	public TeamVO radiantTeam;
	
	
	/**
	 * Information about the team playing as Dire for this match.
	 */
	@SerializedName("dire_team")
	public TeamVO direTeam;
	
	/**
	 * Unique ID for the matches lobby.
	 */
	@SerializedName("lobby_id")
	public long lobbyId;
	
	/**
	 * Number of spectators at time of query.
	 */
	@SerializedName("spectators")
	public int spectators;
	
	/**
	 * The matches tower status is given as a 32-bit unsigned integer, with the rightmost 22 bits dictating tower state.
	 * The higher bits (leftmost) dictate the Dire team's tower status, and the lower bits (rightmost) dictate the
	 * Radiant team's tower status; within each 11bit segment, each bit represents an individual tower.
	 */
	@SerializedName("tower_state")
	public int towerState;
	
	/**
	 * Unique ID for the league of the match being played. A list of league IDs can be found via the GetLeagueListing
	 * method.
	 */
	@SerializedName("league_id")
	public int leagueId;
	
	/**
	 * @return Radiant's tower state to be used in conjunction with {@link DotaBuildingStatus#isTowerUp(int, DotaTower)}.
	 */
	public int getRadiantTowerState() {
		int radiantMask = Integer.parseInt("00000000000000000000011111111111", 2);
		return towerState & radiantMask;
	}
	
	/**
	 * @return Dire's tower state to be used in conjunction with {@link DotaBuildingStatus#isTowerUp(int, DotaTower)}.
	 */
	public int getDireTowerState() {
		int direMask = Integer.parseInt("00000000001111111111100000000000", 2);
		int direStatus = towerState & direMask;
		return direStatus >> 11;
	}
}
