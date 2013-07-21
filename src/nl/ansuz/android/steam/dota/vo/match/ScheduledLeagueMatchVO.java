package nl.ansuz.android.steam.dota.vo.match;

import com.google.gson.annotations.SerializedName;
import nl.ansuz.android.steam.dota.vo.TeamVO;

/**
 * Simple representation of a scheduled league match.
 *
 * @author Wijnand
 */
public class ScheduledLeagueMatchVO {

	/**
	 * Unique ID for the league of the match being played.<br/>
	 * A list of league IDs can be found via the {@link GetLeagueListing} method.
	 */
	@SerializedName("league_id")
	public int leagueId;

	/**
	 * Unique ID of the scheduled match.
	 */
	@SerializedName("game_id")
	public int matchId;

	/**
	 * List of participating teams, empty if not known.
	 */
	@SerializedName("teams")
	public TeamVO[] teamList;

	/**
	 * The start time for this match, Unix timestamp.
	 */
	@SerializedName("starttime")
	public long startTime;

	/**
	 * Description of the match.
	 */
	@SerializedName("comment")
	public String description;

	/**
	 * Whether this is a final match or not.
	 */
	@SerializedName("final")
	public boolean finalMatch;

}
