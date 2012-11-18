package nl.ansuz.android.steam.dota.response;

import nl.ansuz.android.steam.dota.vo.MatchVO;

import com.google.gson.annotations.SerializedName;

/**
 * Response object for the GetMatchHistory request.
 * 
 * @author Wijnand
 */
public class GetMatchHistoryResponse {

	@SerializedName("status")
	public int status;
	
	@SerializedName("num_results")
	public int numberOfResults;
	
	@SerializedName("total_results")
	public int totalResults;
	
	@SerializedName("results_remaining")
	public int resultsRemaining;
	
	@SerializedName("matches")
	public MatchVO[] matches;
	
}
