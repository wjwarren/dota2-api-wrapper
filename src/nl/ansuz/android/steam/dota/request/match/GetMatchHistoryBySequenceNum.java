package nl.ansuz.android.steam.dota.request.match;

import nl.ansuz.android.steam.dota.request.DotaRequest;
import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to get a list of matches ordered by their sequence number.
 *
 * @see http://wiki.teamfortress.com/wiki/WebAPI/GetMatchHistoryBySequenceNum
 * @author Wijnand
 */
public class GetMatchHistoryBySequenceNum extends DotaRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {
		/**
		 * The match sequence number to start returning results from.
		 */
		public final static String START_AT_MATCH_SEQUENCE_NUMBER = "start_at_match_seq_num";

		/**
		 * The amount of matches to return.
		 */
		public final static String NUMBER_OF_MATCHES_REQUESTED = "matches_requested";
	}

	public final static String METHOD_NAME = "GetMatchHistoryBySequenceNum";

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
