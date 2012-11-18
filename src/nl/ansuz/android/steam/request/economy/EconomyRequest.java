package nl.ansuz.android.steam.request.economy;

import nl.ansuz.android.steam.request.ISteamRequest;
import nl.ansuz.android.steam.request.SteamRequest;

/**
 * Base class to construct any economy related request.
 * 
 * @author Wijnand
 */
public class EconomyRequest extends SteamRequest implements ISteamRequest {

	private final static String INTERFACE_PREFIX = "IEconItems_";
	
	/**
	 * Builds the full interface name.
	 * 
	 * @param applicationId The application to use this interface for.
	 */
	protected String getInterface(int applicationId) {
		return INTERFACE_PREFIX + applicationId;
	}
	
	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + getInterface(appId);
		
		return baseUrl;
	}
	
}
