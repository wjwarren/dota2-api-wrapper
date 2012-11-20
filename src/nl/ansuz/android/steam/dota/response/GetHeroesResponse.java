package nl.ansuz.android.steam.dota.response;

import nl.ansuz.android.steam.dota.vo.HeroVO;

import com.google.gson.annotations.SerializedName;

/**
 * Response object for the GetHeroes request.
 * 
 * @author Wijnand
 */
public class GetHeroesResponse {

	@SerializedName("heroes")
	public HeroVO[] heroes;
	
	@SerializedName("count")
	public int count;
	
}
