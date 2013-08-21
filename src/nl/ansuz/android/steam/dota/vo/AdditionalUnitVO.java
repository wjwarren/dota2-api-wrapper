package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Additional playable unit.
 *
 * @author Wijnand
 */
public class AdditionalUnitVO {

	/**
	 * The name of the unit.
	 */
	@SerializedName("unitname")
	public String unitName;

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
}
