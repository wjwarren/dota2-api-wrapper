package nl.ansuz.android.steam.dota.response;

import com.google.gson.annotations.SerializedName;

/**
 * Response object for the GetMatchHistoryBySequenceNum request.
 *
 * @author Wijnand
 */
public class GetMatchHistoryBySequenceNumResponse extends DotaResponse {

	@SerializedName("matches")
	public GetMatchDetailsResponse[] matches;

}