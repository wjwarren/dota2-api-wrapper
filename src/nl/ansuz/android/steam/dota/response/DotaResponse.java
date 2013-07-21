package nl.ansuz.android.steam.dota.response;

import com.google.gson.annotations.SerializedName;

/**
 * Basic DotA API response.
 *
 * @author Wijnand
 */
public class DotaResponse {

	/**
	 * 1 - Success<br/>
	 * 
	 * 8 - 'matches_requested' must be greater than 0. OR<br/>
	 * 8 - 'teams_requested' must be greater than 0. OR<br/>
	 * 8 - Only supports tournament 65006 (The International). (For {@link GetTournamentPlayerStats}.)<br/>
	 * 
	 * 15 - Cannot get match history for a user that hasn't allowed it.
	 */
	@SerializedName("status")
	public int status;
	
	/**
	 * A message explaining the status, should status not be 1.
	 */
	@SerializedName("statusDetail")
	public String statusDetail;

}