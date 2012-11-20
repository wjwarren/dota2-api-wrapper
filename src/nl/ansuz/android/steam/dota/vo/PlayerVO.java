package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Dota player.
 * 
 * @author Wijnand
 */
public class PlayerVO {

	/**
	 * 32 bit Steam account number.
	 */
	@SerializedName("account_id")
	public int accountId;
	
	@SerializedName("player_slot")
	public int playerSlot;
	
	@SerializedName("hero_id")
	public int heroId;
	
	@SerializedName("item_0")
	public int item0;
	
	@SerializedName("item_1")
	public int item1;
	
	@SerializedName("item_2")
	public int item2;
	
	@SerializedName("item_3")
	public int item3;
	
	@SerializedName("item_4")
	public int item4;
	
	@SerializedName("item_5")
	public int item5;
	
	@SerializedName("kills")
	public int kills;
	
	@SerializedName("deaths")
	public int deaths;
	
	@SerializedName("assists")
	public int assists;
	
	@SerializedName("leaver_status")
	public int leaverStatus;
	
	@SerializedName("gold")
	public int gold;
	
	@SerializedName("last_hits")
	public int lastHits;
	
	@SerializedName("denies")
	public int denies;
	
	@SerializedName("gold_per_min")
	public int goldPerMinute;
	
	@SerializedName("xp_per_min")
	public int xpPerMinute;
	
	@SerializedName("gold_spent")
	public int goldSpent;
	
	@SerializedName("hero_damage")
	public int heroDamage;
	
	@SerializedName("tower_damage")
	public int towerDamage;
	
	@SerializedName("hero_healing")
	public int hero_healing;
	
	@SerializedName("level")
	public int level;

}