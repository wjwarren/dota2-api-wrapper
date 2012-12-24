package nl.ansuz.android.steam.request.user;

import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the URL to retrieve a player's Steam id based on the 
 * vanity URL.
 * 
 * @see http://wiki.teamfortress.com/wiki/WebAPI/ResolveVanityURL
 * @author Wijnand
 */
public class ResolveVanityUrl extends UserRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {
		/**
		 * The vanity URL part of a user's Steam profile URL. This is the 
		 * basename of http://steamcommunity.com/id/ URLs.
		 */
		public final static String VANITY_URL = "vanityurl";
	}
	
	private final static String METHOD_NAME = "ResolveVanityUrl";
	
	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + METHOD_NAME;
		baseUrl += "/" + API_VERSION_ONE;
		baseUrl += "/";
		
		return baseUrl;
	}
	
}
