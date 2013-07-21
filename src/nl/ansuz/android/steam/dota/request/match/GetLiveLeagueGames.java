package nl.ansuz.android.steam.dota.request.match;

import nl.ansuz.android.steam.dota.request.DotaRequest;
import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to get a list of league games in-progress.
 *
 * @see http://wiki.teamfortress.com/wiki/WebAPI/GetLiveLeagueGames
 * @author Wijnand
 */
public class GetLiveLeagueGames extends DotaRequest implements ISteamRequest {

	public final static String METHOD_NAME = "GetLiveLeagueGames";

	/** {@inheritDoc} */
	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + METHOD_NAME;
		baseUrl += "/" + API_VERSION_ONE;
		baseUrl += "/";

		return baseUrl;
	}

}
