package nl.ansuz.android.steam.request.economy;

import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to retreive a player's items for a game.
 * 
 * @author Wijnand
 */
public class GetPlayerItems extends EconomyRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {
		public final static String LANGUAGE = "language";
		
		/**
		 * 64-bit Steam id.
		 */
		public final static String STEAMID = "steamid";
	}
	
	private final static String METHOD_NAME = "GetPlayerItems";
	
	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + METHOD_NAME;
		baseUrl += "/" + API_VERSION;
		baseUrl += "/";
		
		return baseUrl;
	}
}
