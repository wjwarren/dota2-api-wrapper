package nl.ansuz.android.steam.dota.response.match;

import com.google.gson.annotations.SerializedName;
import nl.ansuz.android.steam.dota.response.DotaResponse;

/**
 * Response object for the GetMatchHistoryBySequenceNum request.
 *
 * @author Wijnand
 */
public class GetMatchHistoryBySequenceNumResponse extends DotaResponse {

	@SerializedName("matches")
	public GetMatchDetailsResponse[] matches;

}