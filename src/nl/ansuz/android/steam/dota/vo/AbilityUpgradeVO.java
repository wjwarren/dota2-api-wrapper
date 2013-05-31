package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Ability upgrade details.
 *
 * @author Wijnand
 */
public class AbilityUpgradeVO {

	/**
	 * ID of the ability upgraded.
	 * TODO: How does this translate to a human-readable ability?
	 */
	@SerializedName("ability")
	public int ability;
	
	/**
	 * Time since match start that the ability was upgraded.
	 */
	@SerializedName("time")
	public int time;
	
	/**
	 * The level of the player at time of upgrading.
	 */
	@SerializedName("level")
	public int level;
}
