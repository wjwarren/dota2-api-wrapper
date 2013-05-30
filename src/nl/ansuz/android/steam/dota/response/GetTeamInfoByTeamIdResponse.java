package nl.ansuz.android.steam.dota.response;

import nl.ansuz.android.steam.dota.vo.TeamDetailsVO;

import com.google.gson.annotations.SerializedName;

public class GetTeamInfoByTeamIdResponse extends DotaResponse {

	/**
	 * A list of leagues supported in-game via DotaTV.
	 */
	@SerializedName("teams")
	public TeamDetailsVO[] teams;
	
}
