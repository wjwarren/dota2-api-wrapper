package nl.ansuz.android.steam.response.user;

import nl.ansuz.android.steam.vo.user.UserVO;

import com.google.gson.annotations.SerializedName;

/**
 * Response object for the GetPlayerSummaries request.
 * 
 * @see https://developer.valvesoftware.com/wiki/Steam_Web_API#GetPlayerSummaries_.28v0002.29
 * @author Wijnand
 */
public class GetPlayerSummariesResponse {

	/**
	 * List of players and their info.
	 */
	@SerializedName("players")
	public UserVO[] players;
	
}
