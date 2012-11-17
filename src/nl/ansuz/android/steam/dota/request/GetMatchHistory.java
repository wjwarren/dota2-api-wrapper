package nl.ansuz.android.steam.dota.request;

import java.util.Map;

import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to retreive Dota match history.
 * 
 * @author Wijnand
 */
public class GetMatchHistory extends DotaRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {
		
		/**
		 * Search matches with a player name, exact match only.
		 */
		public final static String PLAYER_NAME = "player_name";
		
		/**
		 * Search for matches with a specific hero being played.
		 */
		public final static String HERO_ID = "hero_id";
		
		/**
		 * 0 for any, 1 for normal, 2 for high, 3 for very high skill.
		 */
		public final static String SKILL = "skill";
		
		/**
		 * Date in UTC seconds since Jan 1, 1970 (unix time format).
		 */
		public final static String DATE_MIN = "date_min";
		
		/**
		 * Date in UTC seconds since Jan 1, 1970 (unix time format).
		 */
		public final static String DATE_MAX = "date_max";
		
		/**
		 * Steam account id (this is not SteamID, its only the account number portion).
		 */
		public final static String ACCOUNT_ID = "account_id";
		
		/**
		 * Matches for a particular league.
		 */
		public final static String LEAGUE_ID = "league_id";
		
		/**
		 * Start the search at the indicated match id, descending.
		 */
		public final static String START_AT_MATCH_ID = "start_at_match_id";
		
		/**
		 * Defaults is 25 matches, this can limit to less.
		 */
		public final static String MATCHES_REQUESTED = "matches_requested";

	}
	
	private final static String METHOD_NAME = "GetMatchHistory";
	
	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + METHOD_NAME;
		baseUrl += "/" + API_VERSION;
		baseUrl += "/";
		
		return baseUrl;
	}

	@Override
	public String createRequestUrl(int applicationId, Map<String, String> params) {
		return serializeURL(getBaseUrl(applicationId), params);
	}
	
}
