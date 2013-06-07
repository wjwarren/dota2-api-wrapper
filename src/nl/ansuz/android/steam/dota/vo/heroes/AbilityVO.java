package nl.ansuz.android.steam.dota.vo.heroes;

/**
 * DotA hero ability.
 * Default values are based on ability with ID 0 in "npc_abilities.txt".
 *
 * @author Wijnand
 */
public class AbilityVO {

	public enum Type {
		DOTA_ABILITY_TYPE_BASIC,
		DOTA_ABILITY_TYPE_ULTIMATE,
		DOTA_ABILITY_TYPE_ATTRIBUTES;
	}

	public enum Behavior {
		/**
		 * No behaviour.
		 */
		DOTA_ABILITY_BEHAVIOR_NONE(0),
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
		DOTA_ABILITY_BEHAVIOR_DONT_RESUME_MOVEMENT(1<<16),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_IGNORE_PSEUDO_QUEUE(1<<17),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_AUTOCAST(1<<18),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_ATTACK(1<<19),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_AURA(1<<20),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_IGNORE_BACKSWING(1<<21),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_NORMAL_WHEN_STOLEN(1<<22),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_DONT_ALERT_TARGET(1<<22),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_RUNE_TARGET(1<<23),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_UNRESTRICTED(1<<24),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_TYPE_ULTIMATE(1<<25),
		/**
		 * Undocumented.
		 */
		DOTA_ABILITY_BEHAVIOR_DONT_CANCEL_MOVEMENT(1<<26);

		public final int behaviourValue;

		Behavior(int value) {
			behaviourValue = value;
		}
	}

	private final static String IMAGE_URL_PREFIX = "http://media.steampowered.com/apps/dota2/images/abilities/";
	private final static String IMAGE_URL_SUFFIX = "_hp1.png";

	// General
	public int id;
	public String name;
	public String nameToken;
	public Type type;
	public int behavior;
	public int onCastbar;
	public int onLearnbar;

	// Stats
	public int[] castRange;
	public int castRangeBuffer;
	public double[] castPoint;
	public double[] channelTime;
	public double[] cooldown;
	public double[] duration;
	public String sharedCooldown;
	public double[] damage;
	public int[] manaCost;
	public double modifierSupportValue;
	public int modifierSupportBonus;

	public AbilityVO(int id, String name, String nameToken, Type type, int behavior, int onCastbar, int onLearnbar,
					int[] castRange, int castRangeBuffer, double[] castPoint, double[] channelTime, double[] cooldown,
					double[] duration, String sharedCooldown, double[] damage, int[] manaCost,
					double modifierSupportValue, int modifierSupportBonus) {

		init();

		// General
		this.id = id;
		this.name = name;
		this.nameToken = nameToken;
		if (type != null) {
			this.type = type;
		}
		this.behavior = behavior;
		if (onCastbar > 0) {
			this.onCastbar = onCastbar;
		}
		if (onLearnbar > 0) {
			this.onLearnbar = onLearnbar;
		}

		// Stats
		if (castRange != null) {
			this.castRange = castRange;
		}
		if (castRangeBuffer > 0) {
			this.castRangeBuffer = castRangeBuffer;
		}
		if (castPoint != null) {
			this.castPoint = castPoint;
		}
		if (channelTime != null) {
			this.channelTime = channelTime;
		}
		if (cooldown != null) {
			this.cooldown = cooldown;
		}
		if (duration != null) {
			this.duration = duration;
		}
		this.sharedCooldown = sharedCooldown;
		if (damage != null) {
			this.damage = damage;
		}
		if (manaCost != null) {
			this.manaCost = manaCost;
		}
		if (modifierSupportValue > -1) {
			this.modifierSupportValue = modifierSupportValue;
		}
		if (modifierSupportBonus > -1) {
			this.modifierSupportBonus = modifierSupportBonus;
		}
	}

	/**
	 * Initializes this class.
	 */
	private void init() {
		// General
		id = 0;
		name = "base";
		nameToken = "";
		type = Type.DOTA_ABILITY_TYPE_BASIC;
		behavior = Behavior.DOTA_ABILITY_BEHAVIOR_NONE.behaviourValue;
		onCastbar = 1;
		onLearnbar = 1;

		// Stats
		castRange = new int[]{0};
		castRangeBuffer = 250;
		castPoint = new double[]{0.0, 0.0, 0.0, 0.0};
		channelTime = new double[]{0.0, 0.0, 0.0, 0.0};
		cooldown = new double[]{0.0, 0.0, 0.0, 0.0};
		duration = new double[]{0.0, 0.0, 0.0, 0.0};
		sharedCooldown = "";
		damage = new double[]{0, 0, 0, 0};
		manaCost = new int[]{0, 0, 0, 0};
		modifierSupportValue = 1.0;
		modifierSupportBonus = 0;
	}

	/**
	 * Creates a URL to download the item image from.
	 */
	public String getImageUrl() {
		return IMAGE_URL_PREFIX + nameToken + IMAGE_URL_SUFFIX;
	}

}
