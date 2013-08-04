package nl.ansuz.android.steam.dota.vo;

import nl.ansuz.android.steam.dota.vo.players.BasePlayerVO;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Dota player.
 * 
 * @author Wijnand
 */
public class PlayerVO extends BasePlayerVO {

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
	 * Numeric item ID for the top-left slot.
	 * Get the item details from {@link HeroBuildItemList#getItemById(int)}.
	 */
	@SerializedName("item_0")
	public int item0;
	
	/**
	 * Numeric item ID for the top-center slot.
	 * Get the item details from {@link HeroBuildItemList#getItemById(int)}.
	 */
	@SerializedName("item_1")
	public int item1;
	
	/**
	 * Numeric item ID for the top-right slot.
	 * Get the item details from {@link HeroBuildItemList#getItemById(int)}.
	 */
	@SerializedName("item_2")
	public int item2;
	
	/**
	 * Numeric item ID for the bottom-left slot.
	 * Get the item details from {@link HeroBuildItemList#getItemById(int)}.
	 */
	@SerializedName("item_3")
	public int item3;
	
	/**
	 * Numeric item ID for the bottom-center slot.
	 * Get the item details from {@link HeroBuildItemList#getItemById(int)}.
	 */
	@SerializedName("item_4")
	public int item4;
	
	/**
	 * Numeric item ID for the bottom-right slot.
	 * Get the item details from {@link HeroBuildItemList#getItemById(int)}.
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
	public int heroHealing;
	
	/**
	 * The player's level at the end of the match.
	 */
	@SerializedName("level")
	public int level;
	
	/**
	 * A list detailing a player's ability upgrades.
	 */
	@SerializedName("ability_upgrades")
	public AbilityUpgradeVO[] abilityUpgrades;
	
	/**
	 * Additional playable units owned by the player.
	 */
	@SerializedName("additional_units")
	public AdditionalUnitVO[] additionalUnits;
	
	/**
	 * @return Whether or not the player was in the Radiant team.
	 */
	public boolean isRadiant() {
		return playerSlot < 5;
	}

	/**
	 * @param radiantWin boolean - Whether or not radiant won.
	 * @return boolean - Whether or not the player was on the winning side.
	 */
	public boolean hasWon(boolean radiantWin) {
		return isRadiant() ? radiantWin : !radiantWin;
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