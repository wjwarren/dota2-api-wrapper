package nl.ansuz.android.steam.dota.response.economy;

import nl.ansuz.android.steam.dota.vo.HeroVO;

import com.google.gson.annotations.SerializedName;

/**
 * Response object for the GetHeroes request.
 *
 * @author Wijnand
 */
public class GetHeroesResponse {

	/**
	 * List of heroes.
	 * If you want to sort this list, use the {@link HeroVoComparator}.
	 */
	@SerializedName("heroes")
	public HeroVO[] heroes;

	/**
	 * Total number of heroes.
	 */
	@SerializedName("count")
	public int count;

}
