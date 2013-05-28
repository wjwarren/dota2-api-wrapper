package nl.ansuz.android.steam.dota.response;

import nl.ansuz.android.steam.dota.vo.LeagueVO;

import com.google.gson.annotations.SerializedName;

/**
 * Response object for the GetLeagueListing request.
 *
 * @author Wijnand
 */
public class GetLeagueListingResponse {

	/**
	 * A list of leagues supported in-game via DotaTV.
	 */
	@SerializedName("leagues")
	public LeagueVO[] leagues;
	
}
