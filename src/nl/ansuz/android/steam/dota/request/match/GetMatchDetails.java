package nl.ansuz.android.steam.dota.request.match;

import nl.ansuz.android.steam.dota.request.DotaRequest;
import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to retreive details of a Dota match.
 *
 * @see http://wiki.teamfortress.com/wiki/WebAPI/GetMatchDetails
 * @author Wijnand
 */
public class GetMatchDetails extends DotaRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {

		/**
		 * The match's ID.
		 */
		public final static String MATCH_ID = "match_id";

	}
	
	public final static String METHOD_NAME = "GetMatchDetails";

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
