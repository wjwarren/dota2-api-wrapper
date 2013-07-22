package nl.ansuz.android.steam.dota.response.match;

import com.google.gson.annotations.SerializedName;
import nl.ansuz.android.steam.dota.response.DotaResponse;

/**
 * Response object for the GetTournamentPlayerStats API request.
 *
 * @author Wijnand
 */
public class GetTournamentPlayerStatsResponse extends DotaResponse {

	/**
	 * Number of matches returned.
	 */
	@SerializedName("num_results")
	public int numberOfResults;

	/**
	 * An array of matches.
	 * (Object structure not yet known.)
	 */
	@SerializedName("matches")
	public String[] matches;

	/**
	 * Total wins.
	 */
	@SerializedName("wins")
	public int winsTotal;

	/**
	 * Total losses.
	 */
	@SerializedName("losses")
	public int lossesTotal;

	/**
	 * Total kills.
	 */
	@SerializedName("kills")
	public int killsTotal;

	/**
	 * Total deaths.
	 */
	@SerializedName("deaths")
	public int deathsTotal;

	/**
	 * Total assists.
	 */
	@SerializedName("assists")
	public int assistsTotal;

	/**
	 * Average number of kills per match.
	 */
	@SerializedName("kills_average")
	public double killsAverage;

	/**
	 * Average number of deaths per match.
	 */
	@SerializedName("deaths_average")
	public double deathsAverage;

	/**
	 * Average number of deaths per match.
	 */
	@SerializedName("assists_average")
	public double assistsAverage;

	/**
	 * Average gold per minute.
	 */
	@SerializedName("gpm_average")
	public double goldPerMinuteAverage;

	/**
	 * Average XP per minute.
	 */
	@SerializedName("xpm_average")
	public double experiencePerMinuteAverage;

	/**
	 * Best total kills in a match.
	 */
	@SerializedName("best_kills")
	public int killTotalBest;

	/**
	 * Which Hero the player was playing when they achieved {@link #killTotalBest}.
	 * A list of hero IDs can be found via the {@link GetHeroes} method.
	 */
	@SerializedName("best_kills_heroid")
	public int killTotalBestHero;

	/**
	 * Best gold per minute in a match.
	 */
	@SerializedName("best_gpm")
	public int goldPerMinuteBest;

	/**
	 * Which Hero the player was playing when they achieved {@link #goldPerMinuteBest}.
	 * A list of hero IDs can be found via the {@link GetHeroes} method.
	 */
	@SerializedName("best_gpm_heroid")
	public int goldPerMinuteBestHero;

	/**
	 * An array of heroes played.
	 * (Object structure not yet known.)
	 */
	@SerializedName("heroes_played")
	public String[] heroesPlayed;

}
