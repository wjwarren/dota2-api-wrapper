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
	 * Strips the "result" Object that surrounds all Steam API JSON responses.
	 * 
	 * @param json The Steam JSON response to strip.
	 * @return A JsonElement that can be used to deserialize the Steam API response.
	 */
	public JsonElement getStrippedResult(String json) {
		Gson gson = new Gson();	
		JsonElement rawMatchHistoryResponse = gson.fromJson(json, JsonElement.class);
		JsonElement result = rawMatchHistoryResponse.getAsJsonObject().get("result");
		gson = null;
		
		return result;
	}
	
}
