package nl.ansuz.android.steam.request.user;

import nl.ansuz.android.steam.request.ISteamRequest;
import nl.ansuz.android.steam.request.SteamRequest;

/**
 * Base class to construct any user related request.
 * 
 * @author Wijnand
 */
public class UserRequest extends SteamRequest implements ISteamRequest {

	private final static String INTERFACE_NAME = "ISteamUser";
	
	/**
	 * Builds the full interface name.
	 * 
	 * @param applicationId The application to use this interface for.
	 */
	protected String getInterface(int applicationId) {
		return INTERFACE_NAME;
	}
	
	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + getInterface(appId);
		
		return baseUrl;
	}
	
}
