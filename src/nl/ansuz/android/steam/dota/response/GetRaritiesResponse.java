package nl.ansuz.android.steam.dota.response;

import com.google.gson.annotations.SerializedName;
import nl.ansuz.android.steam.dota.vo.RarityVO;

/**
 * Response object for the GetRarities request.
 *
 * @author Wijnand Warren
 */
public class GetRaritiesResponse {

	/**
	 * Possible number of rarities. This number appears to be currently (as of 2012-08-19) incorrect and off by one.
	 */
	@SerializedName("count")
	public int count;

	/**
	 * List of rarity objects.
	 */
	@SerializedName("rarities")
	public RarityVO[] rarities;
}