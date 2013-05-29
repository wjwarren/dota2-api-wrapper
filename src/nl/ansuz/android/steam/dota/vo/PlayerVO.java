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
	
	/**
	 * An 8-bit unsigned int: if the left-most bit is set, the player was on dire. 
	 * The two right-most bits represent the player slot (0-4).
	 * 
	 * - 0-4: Radiant.
	 * - 128-132: Dire.
	 */
	@SerializedName("player_slot")
	public int playerSlot;
	
	/**
	 * Numeric ID of the hero that the player used.
	 */
	@SerializedName("hero_id")
	public int heroId;
	
	/**
	 * Numeric item ID for the top-left slot.
	 */
	@SerializedName("item_0")
	public int item0;
	
	/**
	 * Numeric item ID for the top-center slot.
	 */
	@SerializedName("item_1")
	public int item1;
	
	/**
	 * Numeric item ID for the top-right slot.
	 */
	@SerializedName("item_2")
	public int item2;
	
	/**
	 * Numeric item ID for the bottom-left slot.
	 */
	@SerializedName("item_3")
	public int item3;
	
	/**
	 * Numeric item ID for the bottom-center slot.
	 */
	@SerializedName("item_4")
	public int item4;
	
	/**
	 * Numeric item ID for the bottom-center slot.
	 */
	@SerializedName("item_5")
	public int item5;
	
	/**
	 * Number of kills the player got.
	 */
	@SerializedName("kills")
	public int kills;
	
	/**
	 * Number of times the player died.
	 */
	@SerializedName("deaths")
	public int deaths;
	
	/**
	 * Number of assists the player got.
	 */
	@SerializedName("assists")
	public int assists;
	
	/**
	 * 0 if the player stayed in the match.
	 */
	@SerializedName("leaver_status")
	public int leaverStatus;
	
	/**
	 * Amount of gold the player had left at the end of the match.
	 */
	@SerializedName("gold")
	public int gold;
	
	/**
	 * Number of times a player last-hit a creep.
	 */
	@SerializedName("last_hits")
	public int lastHits;
	
	/**
	 * Number of times a player denied a creep.
	 */
	@SerializedName("denies")
	public int denies;
	
	/**
	 * Total gold per minute.
	 */
	@SerializedName("gold_per_min")
	public int goldPerMinute;
	
	/**
	 * Total experience per minute.
	 */
	@SerializedName("xp_per_min")
	public int xpPerMinute;
	
	/**
	 * Total amount of gold the player spent during the match.
	 */
	@SerializedName("gold_spent")
	public int goldSpent;
	
	/**
	 * Amount of damage the player dealt to heroes.
	 */
	@SerializedName("hero_damage")
	public int heroDamage;
	
	/**
	 * Amount of damage the player dealt to towers.
	 */
	@SerializedName("tower_damage")
	public int towerDamage;
	
	/**
	 * Amount of damage the player healed.
	 */
	@SerializedName("hero_healing")
	public int hero_healing;
	
	/**
	 * The player's level at the end of the match.
	 */
	@SerializedName("level")
	public int level;
	
	/**
	 * @return Whether or not the player was in the Radiant team.
	 */
	public boolean isRadiant() {
		return playerSlot < 5;
	}
	
	/**
	 * @return The player's KDR.
	 */
	public double getKillDeathRadio() {
		return kills / deaths;
	}
	
	/**
	 * @return Total amount of gold earned during the match.
	 */
	public int getTotalGold() {
		return goldSpent + gold;
	}

}