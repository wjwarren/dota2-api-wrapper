package nl.ansuz.android.steam.dota.request.match;

import nl.ansuz.android.steam.dota.request.DotaRequest;
import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to get stats about a particular player within a tournament.
 *
 * @see http://wiki.teamfortress.com/wiki/WebAPI/GetTournamentPlayerStats
 * @author Wijnand
 */
public class GetTournamentPlayerStats extends DotaRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {

		/**
		 * String - 32-bit account ID.
		 */
		public final static String ACCOUNT_ID = "account_id";

		/**
		 * String - (Optional) A list of league IDs can be found via the {@link GetLeagueListing} method.
		 */
		public final static String LEAGUE_ID = "league_id";

		/**
		 * String - (Optional) A list of hero IDs can be found via the {@link GetHeroes} method.
		 */
		public final static String HERO_ID = "hero_id";

		/**
		 * String - (Optional) Only return stats between this time frame (parameter format not yet known).
		 */
		public final static String TIME_FRAME = "time_frame";

	}

	public final static String METHOD_NAME = "GetTournamentPlayerStats";

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
