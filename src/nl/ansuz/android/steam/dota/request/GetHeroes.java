package nl.ansuz.android.steam.dota.request;

import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to retreive an up to date Dota hero list.
 * 
 * @author Wijnand
 */
public class GetHeroes extends DotaRequest implements ISteamRequest {
	
	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {
		public final static String LANGUAGE = "language";
	}
	
	private final static String METHOD_NAME = "GetHeroes";
	private final static String INTERFACE_PREFIX = "IEconDOTA2_";
	
	@Override
	protected String getInterface(int applicationId) {
		return INTERFACE_PREFIX + applicationId;
	}
	
	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + METHOD_NAME;
		baseUrl += "/" + API_VERSION_ONE;
		baseUrl += "/";
		
		return baseUrl;
	}
	
}
