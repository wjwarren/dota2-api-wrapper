package nl.ansuz.android.steam.dota.vo;

import nl.ansuz.android.steam.dota.vo.team.BaseTeamDetailsVO;

import com.google.gson.annotations.SerializedName;

/**
 * DotA 2 league team details.
 * NOTE: Use the {@link TeamDetailsDeserializer} to deserialize the API response.
 * 
 * @author Wijnand
 */
public class TeamDetailsVO extends BaseTeamDetailsVO {
	
	/**
	 * The team's rating.
	 */
	@SerializedName("rating")
	public int rating;
	
	/**
	 * 32-bit account ID. Where N is incremental from 0 for every player on the team.
	 * player_N_account_id
	 */
	public int[] playerAccountIds;
	
	/**
	 * Leagues this team is participating in?
	 * league_id_N
	 */
	public int[] leagueIds;
	
	/**
	 * @return Whether or not this team has a sponsor.
	 */
	public boolean hasSponsor() {
		return logoSponsor > 0;
	}
}
