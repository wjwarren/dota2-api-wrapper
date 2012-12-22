package nl.ansuz.android.steam.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * Provides some utilities from GSON.
 * 
 * @author Wijnand
 */
public class GsonUtil {

	/**
	 * Strips the "result" Object that surrounds all Dota Steam API JSON 
	 * responses.
	 * 
	 * @param json The Steam JSON response to strip.
	 * @return A JsonElement that can be used to deserialize the Steam API 
	 * 	response.
	 */
	protected JsonElement getStrippedResult(String json, String elementName) {
		Gson gson = new Gson();	
		JsonElement rawMatchHistoryResponse = gson.fromJson(json, JsonElement.class);
		JsonElement result = rawMatchHistoryResponse.getAsJsonObject().get(elementName);
		gson = null;
		
		return result;
	}
	
	/**
	 * Strips the "result" Object that surrounds all Dota Steam API JSON 
	 * responses.
	 * 
	 * @see getStrippedResult(String json, String elementName).
	 * @param json The Steam JSON response to strip.
	 */
	public JsonElement getStrippedDotaResult(String json) {
		return getStrippedResult(json, "result");
	}
	
	/**
	 * Strips the "response" Object that surrounds all generic Steam API JSON 
	 * responses.
	 * 
	 * @see getStrippedResult(String json, String elementName).
	 * @param json The Steam JSON response to strip.
	 */
	public JsonElement getStrippedSteamResult(String json) {
		return getStrippedResult(json, "response");
	}
	
}
