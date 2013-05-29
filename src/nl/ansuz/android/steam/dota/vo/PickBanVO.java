package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * A pick or ban from Captain's Mode.
 *
 * @author Wijnand
 */
public class PickBanVO {

	/**
	 * DotA team.
	 *
	 * @author Wijnand
	 */
	public enum Team {
		RADIANT,
		DIRE,
		BROADCASTER,
		UNASSIGNED;
		
		private static final Team[] teamValues = Team.values();
		
		public static Team fromInteger(int i) {
			return teamValues[i];
		}
	}
	
	/**
	 * Whether this entry is a pick (true) or a ban (false).
	 */
	@SerializedName("is_pick")
	public boolean isPick;
	
	/**
	 * The hero's unique ID. A list of hero IDs can be found via the GetHeroes method.
	 */
	@SerializedName("hero_id")
	public int heroId;
	
	/**
	 * The team who chose the pick or ban; 0 for Radiant, 1 for Dire.
	 */
	@SerializedName("team")
	public int team;
	
	/**
	 * The order of which the picks and bans were selected; 0-19.
	 */
	@SerializedName("order")
	public int order;
	
	/**
	 * @return Whether or not the team is Radiant.
	 */
	public boolean isRadiant() {
		return team == Team.RADIANT.ordinal();
	}
	
}
