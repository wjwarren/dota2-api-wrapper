package nl.ansuz.android.steam.dota.vo.players;

import nl.ansuz.android.steam.dota.vo.PickBanVO;

import com.google.gson.annotations.SerializedName;

/**
 * Player in a live league match.
 *
 * @author Wijnand
 */
public class LiveLeaguePlayerVO extends BasePlayerVO {
	
	/**
	 * The player's display name.
	 */
	@SerializedName("name")
	public String name;
	
	/**
	 * What team the player is currently playing as.
	 * 
	 * 0 - Radiant
	 * 1 - Dire
	 * 2 - Broadcaster
	 * 4 - Unassigned
	 */
	@SerializedName("team")
	public int team;
	
	/**
	 * @return The enumeration value of the team.
	 */
	public PickBanVO.Team getTeam() {
		return PickBanVO.Team.fromInteger(team);
	}
	
}
