package nl.ansuz.android.steam.request;

import java.util.Map;

public interface ISteamRequest {

	/**
	 * Creates a Steam API request.
	 * 
	 * @param applicationId The application ID to make the request for.
	 * @param params The request specific parameters.
	 */
	String createRequestUrl(int applicationId, Map<String, String> params);
	
}
