package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * DotA 2 rarity.
 *
 * @author Wijnand Warren
 */
public class RarityVO {

	/**
	 * The internal rarity name string.
	 */
	@SerializedName("name")
	public String name;

	/**
	 * The localized name of the rarity for use in name display.
	 */
	@SerializedName("localized_name")
	public String localizedName;

	/**
	 * ID of rarity, used for indexing.
	 */
	@SerializedName("id")
	public int id;

	/**
	 * Sorting and logical order of rarities, from most distributed to least.
	 */
	@SerializedName("order")
	public int order;

	/**
	 * String of the hexadecimal RGB tuple of the rarity name as it is displayed in-game.
	 */
	@SerializedName("color")
	public String color;
}
