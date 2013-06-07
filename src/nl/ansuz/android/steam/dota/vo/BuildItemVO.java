package nl.ansuz.android.steam.dota.vo;

import nl.ansuz.android.steam.dota.vo.heroes.AbilityVO;

/**
 * Representation of a DotA hero build item.
 * 
 * @author Wijnand
 */
public class BuildItemVO {

	/**
	 * Undocumented
	 */
	public enum Shareability {
		ITEM_NOT_SHAREABLE;
	}

	// General
	/**
	 * unique ID number for this item.
	 */
	public int id;
	/**
	 * Translated name of the ability, i.e. "Blink dagger".
	 */
	public String abilityName;
	/**
	 * Translation token for the ability name, i.e. "item_blink".
	 */
	public String abilityNameToken;
	public int abilityBehavior;

	// Stats
	public int[] abilityCastRange;
	public double abilityCastPoint;
	public double[] abilityCooldown;
	public int[] abilityManaCost;

	// Item Info
	public int itemCost;
	public String[] itemShopTags;
	public String itemQuality;
	public boolean sideShop;
	public String[] invalidHeroes;

	public BuildItemVO(int id, String abilityName, String abilityNameToken, 
			int abilityBehavior, int[] abilityCastRange,
			double abilityCastPoint, double[] abilityCooldown,
			int[] abilityManaCost, int itemCost, String[] itemShopTags,
			String itemQuality, boolean sideShop, String[] invalidHeroes) {

		this.id = id;
		this.abilityName = abilityName;
		this.abilityNameToken = abilityNameToken;
		this.abilityBehavior = abilityBehavior;

		this.abilityCastRange = abilityCastRange;
		this.abilityCastPoint = abilityCastPoint;
		this.abilityCooldown = abilityCooldown;
		this.abilityManaCost = abilityManaCost;

		this.itemCost = itemCost;
		this.itemShopTags = itemShopTags;
		this.itemQuality = itemQuality;
		this.sideShop = sideShop;
		this.invalidHeroes = invalidHeroes;
	}

	/**
	 * Creates a URL to download the item image from.
	 */
	public String getImageUrl() {
		return "http://media.steampowered.com/apps/dota2/images/items/"
				+ abilityName.replace("item_", "") + "_lg.png";
	}
}
