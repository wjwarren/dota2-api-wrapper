package nl.ansuz.android.steam.dota.vo.players;

import com.google.gson.annotations.SerializedName;

/**
 * Basic player details.
 *
 * @author Wijnand
 */
public class BasePlayerVO {

	/**
	 * 32 bit Steam account number.<br/>
	 * NOTE: This will be set to -1 for users who don't share their DotA 2 history!
	 */
	@SerializedName("account_id")
	public int accountId;
	
	/**
	 * Numeric ID of the hero that the player used.
	 */
	@SerializedName("hero_id")
	public int heroId;

	/**
	 * @return boolean - Whether or not this is an anonymous player.
	 */
	public boolean isAnonymous() {
		return accountId < 0;
	}
}
