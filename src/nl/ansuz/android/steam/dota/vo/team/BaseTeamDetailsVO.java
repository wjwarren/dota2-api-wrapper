package nl.ansuz.android.steam.dota.vo.team;

import com.google.gson.annotations.SerializedName;

/**
 * Basic team details. Part that can be directly parsed by GSON.
 *
 * @author Wijnand
 */
public class BaseTeamDetailsVO {

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
	 * 32-bit account ID of the team's admin.
	 */
	@SerializedName("admin_account_id")
	public String adminAccountId;
	
}
