package nl.ansuz.android.steam.response.user;

import com.google.gson.annotations.SerializedName;

/**
 * Response object for the ResolveVanityUrl request.
 * 
 * @see http://wiki.teamfortress.com/wiki/WebAPI/ResolveVanityURL
 * @author Wijnand
 */
public class ResolveVanityUrlResponse {

	/**
	 * The status of the request. 1 if successful, 42 if there was no match.
	 */
	@SerializedName("success")
	private int success;
	
	/**
	 * (Optional) The 64 bit Steam ID the vanity URL resolves to. Not returned on resolution failures.
	 */
	@SerializedName("steamid")
	public String steamId;
	
	/**
	 * (Optional) The message associated with the request status. Currently only used on resolution failures.
	 */
	@SerializedName("message")
	public String message;
	
	/**
	 * @return Whether or not the vanity URL was successfully resolved to a user id.
	 */
	public boolean isSucces() {
		return success == 1;
	}
	
	/**
	 * @return The 64 bit Steam ID parsed as a Long.
	 */
	public Long getSteamIdAsLong() {
		return Long.parseLong(steamId);
	}
	
}
