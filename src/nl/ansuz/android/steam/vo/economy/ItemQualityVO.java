package nl.ansuz.android.steam.vo.economy;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Wijnand Warren
 */
public class ItemQualityVO {

	@SerializedName("normal")
	public int normal;
	
	@SerializedName("genuine")
	public int genuine;
	
	@SerializedName("vintage")
	public int vintage;
	
	@SerializedName("unusual")
	public int unusual;
	
	@SerializedName("unique")
	public int unique;
	
	@SerializedName("community")
	public int community;
	
	@SerializedName("developer")
	public int developer;
	
	@SerializedName("selfmade")
	public int selfmade;
	
	@SerializedName("customized")
	public int customized;
	
	@SerializedName("strange")
	public int strange;
	
	@SerializedName("completed")
	public int completed;
	
	@SerializedName("haunted")
	public int haunted;
	
	@SerializedName("tournament")
	public int tournament;
	
}
