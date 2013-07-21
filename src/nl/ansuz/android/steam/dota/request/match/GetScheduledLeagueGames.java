package nl.ansuz.android.steam.dota.request.match;

import nl.ansuz.android.steam.dota.request.DotaRequest;
import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to get a list of scheduled league games coming up.
 *
 * @see http://wiki.teamfortress.com/wiki/WebAPI/GetScheduledLeagueGames
 * @author Wijnand
 */
public class GetScheduledLeagueGames extends DotaRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {

		/**
		 * long - (Optional) Minimum date (Unix timestamp) to get the league games for.
		 */
		public final static String MINIMUM_DATE = "date_min";

		/**
		 * long - (Optional) Maximum date (Unix timestamp) to get the league games for.
		 */
		public final static String MAXIMUM_DATE = "date_max";

	}

	public final static String METHOD_NAME = "GetScheduledLeagueGames";

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
