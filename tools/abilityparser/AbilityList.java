package nl.ansuz.android.steam.dota.util.heroes;

import nl.ansuz.android.steam.dota.vo.heroes.AbilityVO;

/**
 * Auto-generated Hero ability list.
 *
 * This class gets generated by passing the DotA game file
 * "scripts/npc/npc_abilities.txt" that can be extracted from
 * "<path to steam>/Steam/steamapps/common/dota 2 beta/dota/pak01_dir.vpk"
 *
 * Use tools/abilityparser/AbilityParser.py to generate.
 *
 * @author Wijnand Warren
 */
public class AbilityList {

	private static final int ID_OFFSET = 5001;
	private static final int TOTAL_ABILITIES = @@injectAbilityCount@@;

	private AbilityVO[] abilities;

	/**
	 * CONSTRUCTOR
	 */
	public AbilityList() {
		init();
	}

	private void init() {
		abilities = new AbilityVO[TOTAL_ABILITIES];
		populateAbilityList();
	}

	/**
	 * Populates the abilities list.
	 */
	private void populateAbilityList() {
@@injectAbilities@@
	}

	/**
	 * Adds a new ability to the list.
	 *
	 * @param ability AbilityVO - The ability to add to the list.
	 */
	private void addAbility(AbilityVO ability) {
		int normalizedId = ability.id - ID_OFFSET;
		if (normalizedId >= 0 && normalizedId < TOTAL_ABILITIES) {
			abilities[normalizedId] = ability;
		}
	}

	/**
	 * Retrieves an ability from the list.
	 *
	 * @param id int - The unique id of the ability to retrieve.
	 * @return The ability that matches the passed in id OR null when not found.
	 */
	public AbilityVO getAbilityById(int id) {
		int normalizedId = id - ID_OFFSET;
		AbilityVO ability = null;
		if (normalizedId >= 0 && normalizedId < TOTAL_ABILITIES) {
			ability = abilities[normalizedId];
		}

		return ability;
	}

}
