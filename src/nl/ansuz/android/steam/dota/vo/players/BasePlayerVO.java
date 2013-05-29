package nl.ansuz.android.steam.dota.vo.players;

import com.google.gson.annotations.SerializedName;

/**
 * Basic player details.
 *
 * @author Wijnand
 */
public class BasePlayerVO {

	/**
	 * 32 bit Steam account number.
	 */
	@SerializedName("account_id")
	public int accountId;
	
	/**
	 * Numeric ID of the hero that the player used.
	 */
	@SerializedName("hero_id")
	public int heroId;
	
}
