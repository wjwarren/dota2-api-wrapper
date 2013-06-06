package nl.ansuz.android.steam.dota.vo;

/**
 * Representation of a DotA hero build item.
 * 
 * @author Wijnand
 */
public class BuildItemVO {

	public enum AbilityType {
		DOTA_ABILITY_TYPE_BASIC, DOTA_ABILITY_TYPE_ULTIMATE, DOTA_ABILITY_TYPE_ATTRIBUTES;
	}

	public enum AbilityBehavior {
		/**
		 * This ability can be owned by a unit but can't be casted and wont show
		 * up on the HUD.
		 */
		DOTA_ABILITY_BEHAVIOR_HIDDEN(1),
		/**
		 * Can't be casted like above but this one shows up on the ability HUD.
		 */
		DOTA_ABILITY_BEHAVIOR_PASSIVE(2),
		/**
		 * Doesn't need a target to be cast, ability fires off as soon as the
		 * button is pressed.
		 */
		DOTA_ABILITY_BEHAVIOR_NO_TARGET(4),
		/**
		 * Ability needs a target to be casted on.
		 */
		DOTA_ABILITY_BEHAVIOR_UNIT_TARGET(8),
		/**
		 * Ability can be cast anywhere the mouse cursor is. (If a unit is
		 * clicked it will just be cast where the unit was standing)
		 */
		DOTA_ABILITY_BEHAVIOR_POINT(16),
		/**
		 * This ability draws a radius where the ability will have effect. Kinda
		 * like POINT but with a an area of effect display.
		 */
		DOTA_ABILITY_BEHAVIOR_AOE(32),
		/**
		 * This ability probably can be casted or have a casting scheme but
		 * cannot be learned. (These are usually abilities that are temporary
		 * like techie's bomb detonate.)
		 */
		DOTA_ABILITY_BEHAVIOR_NOT_LEARNABLE(64),
		/**
		 * This abillity is channelled. If the user moves or is silenced the
		 * ability is interrupted.
		 */
		DOTA_ABILITY_BEHAVIOR_CHANNELLED(128),
		/**
		 * This ability is tied up to an item.
		 */
		DOTA_ABILITY_BEHAVIOR_ITEM(256),
		/**
		 * This ability can be insta-toggled.
		 */
		DOTA_ABILITY_BEHAVIOR_TOGGLE(512),
		/**
		 * This ability has a direction from the hero.
		 */
		DOTA_ABILITY_BEHAVIOR_DIRECTIONAL(1024),
		/**
		 * This ability does not interrupt other abilities.
		 */
		DOTA_ABILITY_BEHAVIOR_IMMEDIATE(2048),
		/**
		 * No idea what this one is, it isn't documented.
		 */
		DOTA_ABILITY_BEHAVIOR_ROOT_DISABLES(4096),
		/**
		 * No idea what this one is, it isn't documented.
		 */
		DOTA_ABILITY_BEHAVIOR_NOASSIST(8192),
		/**
		 * No idea what this one is, it isn't documented.
		 */
		DOTA_ABILITY_BEHAVIOR_IGNORE_CHANNEL(1<<14),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_DONT_RESUME_ATTACK(1<<15),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_DONT_RESUME_MOVEMENT(1<<16);

		public final int behaviourValue;

		AbilityBehavior(int value) {
			behaviourValue = value;
		}
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
