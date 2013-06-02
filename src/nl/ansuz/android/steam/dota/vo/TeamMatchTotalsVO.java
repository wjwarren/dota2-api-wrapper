package nl.ansuz.android.steam.dota.vo;

/**
 * Match totals for Radiant/Dire.
 *
 * @author Wijnand
 */
public class TeamMatchTotalsVO {

	/**
	 * The total gold earned by the team.
	 * NOTE: This is an estimation and might be slightly off compared to the actual number.
	 */
	public int totalGold;

	/**
	 * The total XP earned by the team.
	 * NOTE: This is an estimation and might be slightly off compared to the actual number.
	 */
	public int totalXp;

	/**
	 * The total kills by the team.
	 */
	public int totalKills;

	/**
	 * The total deaths by the team.
	 */
	public int totalDeaths;

	/**
	 * The total assists by the team.
	 */
	public int totalAssists;

	/**
	 * CONSTRUCTOR
	 */
	public TeamMatchTotalsVO() {
		init();
	}

	/**
	 * Initializes this class.
	 */
	private void init() {
		totalGold = -1;
		totalXp = -1;
		totalKills = -1;
		totalDeaths = -1;
		totalAssists = -1;
	}
}