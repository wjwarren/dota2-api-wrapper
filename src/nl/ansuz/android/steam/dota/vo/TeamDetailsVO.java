package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * DotA 2 league team details.
 * 
 * @author Wijnand
 */
public class TeamDetailsVO {
	
	/**
	 * The team's unique ID.
	 */
	@SerializedName("team_id")
	public int teamId;
	
	/**
	 * The team's name.
	 */
	@SerializedName("name")
	public String name;
	
	/**
	 * The team's tag.
	 */
	@SerializedName("tag")
	public String tag;
	
	/**
	 * Unix timestamp of when the team was created.
	 */
	@SerializedName("time_created")
	public int timeCreated;
	
	/**
	 * The team's rating.
	 * 
	 * TODO: Custom parser! Rating is sometimes "inactive".
	 */
	@SerializedName("rating")
	public int rating;
	
	/**
	 * The UGC id for the team logo. You can resolve this with the GetUGCFileDetails method.
	 */
	@SerializedName("logo")
	public long logo;
	
	/**
	 * The UGC id for the team sponsor logo. You can resolve this with the GetUGCFileDetails method.
	 */
	@SerializedName("logo_sponsor")
	public long logoSponsor;
	
	/**
	 * The team's ISO 3166-1 country-code.
	 */
	@SerializedName("country_code")
	public String countryCode;
	
	/**
	 * The URL the team provided upon creation.
	 */
	@SerializedName("url")
	public String url;
	
	/**
	 * Amount of matches played with the current roster
	 */
	@SerializedName("games_played_with_current_roster")
	public int gamesPlayed;
	
	/**
	 * 32-bit account ID. Where N is incremental from 0 for every player on the team.
	 * player_N_account_id
	 * 
	 * TODO: Parse this using a custom Gson Deserializer.
	 */
	public int[] playerAccountIds;
	
	/**
	 * 32-bit account ID of the team's admin.
	 */
	@SerializedName("admin_account_id")
	public String adminAccountId;
	
	/**
	 * Leagues this team is participating in?
	 * league_id_N
	 * 
	 * TODO: Parse this using a custom Gson Deserializer.
	 */
	public int[] leagueIds;
	
	/**
	 * @return Whether or not this team has a sponsor.
	 */
	public boolean hasSponsor() {
		return logoSponsor > 0;
	}
}
