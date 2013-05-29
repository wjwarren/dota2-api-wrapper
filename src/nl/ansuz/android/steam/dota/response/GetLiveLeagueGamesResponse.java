package nl.ansuz.android.steam.dota.response;

import nl.ansuz.android.steam.dota.vo.match.LiveLeagueMatchVO;

import com.google.gson.annotations.SerializedName;

/**
 * Response object for the GetLiveLeagueGames request.
 *
 * @author Wijnand
 */
public class GetLiveLeagueGamesResponse {

	/**
	 * A list of games in-progress.
	 */
	@SerializedName("games")
	public LiveLeagueMatchVO[] games;
	
}
