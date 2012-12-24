package nl.ansuz.android.steam.request.economy;

import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to retreive a game's economy schema.
 * 
 * @author Wijnand
 */
public class GetSchema extends EconomyRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {
		public final static String LANGUAGE = "language";
	}
	
	private final static String METHOD_NAME = "GetSchema";
	
	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + METHOD_NAME;
		baseUrl += "/" + API_VERSION_ONE;
		baseUrl += "/";
		
		return baseUrl;
	}

}
