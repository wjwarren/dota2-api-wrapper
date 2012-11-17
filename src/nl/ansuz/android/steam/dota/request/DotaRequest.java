package nl.ansuz.android.steam.dota.request;

import nl.ansuz.android.steam.request.ISteamRequest;
import nl.ansuz.android.steam.request.SteamRequest;

/**
 * Abstract class to help creating Dota API requests.
 * 
 * @author Wijnand
 * @see http://dev.dota2.com/showthread.php?t=47115
 */
public abstract class DotaRequest extends SteamRequest implements ISteamRequest {

	/**
	 * Simple list of the different Dota application IDs.
	 * 
	 * @author Wijnand
	 */
	public class ApplicationID {
		public final static int BETA = 205790;
		public final static int LIVE = 570;
	}
	
	protected final static String INTERFACE_PREFIX = "IDOTA2Match_";
	
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
		String baseUrl = super.getBaseUrl(0);
		baseUrl += "/" + getInterface(appId);
		
		return baseUrl;
	}
	
}
