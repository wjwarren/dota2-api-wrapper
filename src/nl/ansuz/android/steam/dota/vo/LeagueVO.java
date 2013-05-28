package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * A DotA 2 league.
 *
 * @author Wijnand
 */
public class LeagueVO {

	/**
	 * The name of the league.
	 */
	@SerializedName("name")
	public String name;
	
	/**
	 * The league's unique ID.
	 */
	@SerializedName("leagueid")
	public int leagueId;
	
	/**
	 * A description of the league.
	 */
	@SerializedName("description")
	public String description;
	
	/**
	 * The league's website.
	 */
	@SerializedName("tournament_url")
	public String tournamentUrl;
}
