package nl.ansuz.android.steam.request;

import java.util.Map;

/**
 * Abstract class to help creating Steam API requests.
 * 
 * @author Wijnand
 */
public abstract class SteamRequest implements ISteamRequest {

	public final static String API_BASE_PATH = "https://api.steampowered.com";
	public final static String API_VERSION = "v1";
	
	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {
		public final static String API_KEY = "key";
	}
	
	/**
	 * Constructs the base url path for this request.
	 * 
	 * @param appId The Steam application id to use.
	 */
	protected String getBaseUrl(int appId) {
		return API_BASE_PATH;
	}
	
	/**
	 * Serializes a URL with the parameters.
	 * 
	 * @param url The URL to add the parameters to.
	 * @param params The parameters to add.
	 */
	protected String serializeURL(String url, Map<String, String> params) {
		url += "?";
		url += serializeParams(params);
				
		return url;
	}
	
	/**
	 * Serializes the passed in parameters Map.
	 * 
	 * @param params The parameters to serialize.
	 */
	protected String serializeParams(Map<String, String> params) {
		String parameters = "";
		
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				parameters += "&" + key + "=" + params.get(key);
			}

			// Remove extra ampersand from front
			parameters = parameters.substring(1);
		}
		
		return parameters;
	}
	
	@Override
	public String createRequestUrl(int applicationId, Map<String, String> params) {
		return serializeURL(getBaseUrl(applicationId), params);
	}
	
}
