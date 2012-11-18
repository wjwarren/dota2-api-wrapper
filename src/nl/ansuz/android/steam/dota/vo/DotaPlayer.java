package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Dota player.
 * 
 * @author Wijnand
 */
public class DotaPlayer {

	/**
	 * 32 bit Steam account number.
	 */
	@SerializedName("account_id")
	public int accountId;
	
	@SerializedName("player_slot")
	public int playerSlot;
	
	@SerializedName("hero_id")
	public int heroId;

}