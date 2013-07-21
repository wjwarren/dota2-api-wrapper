package nl.ansuz.android.steam.dota.response.match;

import nl.ansuz.android.steam.dota.response.DotaResponse;
import nl.ansuz.android.steam.dota.vo.TeamDetailsVO;

import com.google.gson.annotations.SerializedName;

/**
 * Response object for the GetTeamInfoByTeamId API request.
 *
 * @author Wijnand
 */
public class GetTeamInfoByTeamIdResponse extends DotaResponse {

	/**
	 * A list of leagues supported in-game via DotaTV.
	 */
	@SerializedName("teams")
	public TeamDetailsVO[] teams;
	
}
