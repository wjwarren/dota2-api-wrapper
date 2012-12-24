package nl.ansuz.android.steam.request.user;

import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the URL to retrieve a user's (or multiple users') Steam 
 * details. 
 * 
 * @author Wijnand
 */
public class GetPlayerSummaries extends UserRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {
		/**
		 * Comma-delimited list of 64 bit Steam IDs to return profile 
		 * information for. Up to 100 Steam IDs can be requested.
		 */
		public final static String STEAM_IDS = "steamids";
	}
	
	private final static String METHOD_NAME = "GetPlayerSummaries";
	
	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + METHOD_NAME;
		baseUrl += "/" + API_VERSION_TWO;
		baseUrl += "/";
		
		return baseUrl;
	}
}
