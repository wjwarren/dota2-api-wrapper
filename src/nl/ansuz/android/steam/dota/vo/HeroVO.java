package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Dota player.
 * 
 * @author Wijnand
 */
public class HeroVO {

	@SerializedName("name")
	public String name;
	
	@SerializedName("id")
	public int id;
	
	@SerializedName("localized_name")
	public String localizedName;
	
}
