package nl.ansuz.android.steam.dota.response.match;

import com.google.gson.annotations.SerializedName;
import nl.ansuz.android.steam.dota.vo.match.ScheduledLeagueMatchVO;

/**
 * Response object for the GetScheduledLeagueGames API request.
 *
 * @author Wijnand
 */
public class GetScheduledLeagueGamesResponse {

	@SerializedName("games")
	public ScheduledLeagueMatchVO[] games;

}
