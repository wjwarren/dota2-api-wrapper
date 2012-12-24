package nl.ansuz.android.steam.vo.user;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Steam user
 * 
 * @author Wijnand
 */
public class UserVO {

	/**
	 * Valid user states.
	 * 
	 * If the player's profile is private, this will always be "0", except if 
	 * the user has set his status to looking to trade or looking to play, 
	 * because a bug makes those status appear even if the profile is private.
	 * 
	 * @author Wijnand
	 */
	public enum PersonaState {
		OFFLINE,
		ONLINE,
		BUSY,
		AWAY,
		SNOOZE,
		LOOKING_TO_TRADE,
		LOOKING_TO_PLAY;
	}
	
	/**
	 * Community visibility states.
	 * 
	 * @author Wijnand
	 */
	public enum CommunityState {
		PRIVATE,
		FRIENDS_ONLY,
		FRIENDS_OF_FRIENDS,
		USERS_ONLY,
		PUBLIC
	}
	
	// ======================
	// PUBLIC USER DATA
	// ======================
	
	/**
	 * 64bit SteamID of the user.
	 */
	@SerializedName("steamid")
	public String steamId;
	
	/**
	 * The player's persona name (display name).
	 */
	@SerializedName("personaname")
	public String personaName;
	
	/**
	 * The full URL of the player's Steam Community profile.
	 */
	@SerializedName("profileurl")
	public String profileUrl;
	
	/**
	 * The full URL of the player's 32x32px avatar. If the user hasn't 
	 * configured an avatar, this will be the default ? avatar.
	 */
	@SerializedName("avatar")
	public String avatar;
	
	/**
	 * The full URL of the player's 64x64px avatar. If the user hasn't 
	 * configured an avatar, this will be the default ? avatar.
	 */
	@SerializedName("avatarmedium")
	public String avatarMedium;
	
	/**
	 * The full URL of the player's 184x184px avatar. If the user hasn't 
	 * configured an avatar, this will be the default ? avatar.
	 */
	@SerializedName("avatarfull")
	public String avatarFull;
	
	/**
	 * The user's current status.
	 */
	@SerializedName("personastate")
	public PersonaState personaState;
	
	/**
	 * The effective visibility state from the account making the request to the
	 * account being viewed given the requesting account's relationship to the
	 * viewed account.
	 */
	@SerializedName("communityvisibilitystate")
	public CommunityState communityVisibilityState;
	
	/**
	 * If set, indicates the user has a community profile configured (will be 
	 * set to "1").
	 */
	@SerializedName("profilestate")
	public int profileState;
	
	/**
	 * The last time the user was online, in unix time.
	 */
	@SerializedName("lastlogoff")
	public int lastLogOff;
	
	/**
	 * If set, indicates the profile allows public comments.
	 */
	@SerializedName("commentpermission")
	public int commentPermission;
	
	// ======================
	// PRIVATE USER DATA
	// ======================
	
	/**
	 * The player's "Real Name", if they have set it.
	 */
	@SerializedName("realname")
	public String realName;
	
	/**
	 * The player's primary group, as configured in their Steam Community 
	 * profile.
	 */
	@SerializedName("primaryclanid")
	public String primaryClanId;
	
	/**
	 * The time the player's account was created.
	 */
	@SerializedName("timecreated")
	public int timeCreated;
	
	/**
	 * If the user is currently in-game, this value will be returned and set to 
	 * the "gameid" of that game.
	 */
	@SerializedName("gameid")
	public int gameId;
	
	/**
	 * The ip and port of the game server the user is currently playing on, if 
	 * they are playing on-line in a game using Steam matchmaking. Otherwise 
	 * will be set to "0.0.0.0:0".
	 */
	@SerializedName("gameserverip")
	public String gameServerIp;
	
	/**
	 * If the user is currently in-game, this will be the name of the game they 
	 * are playing. This may be the name of a non-Steam game shortcut.
	 */
	@SerializedName("gameextrainfo")
	public String gameExtraInfo;
	
	/**
	 * If set on the user's Steam Community profile, the user's country of 
	 * residence, 2-character ISO country code.
	 */
	@SerializedName("loccountrycode")
	public String locationCountryCode;
	
	/**
	 * If set on the user's Steam Community profile, the user's state of 
	 * residence.
	 */
	@SerializedName("locstatecode")
	public String locationStateCode;
	
	/**
	 * An internal code indicating the user's city of residence. A future update
	 * will provide this data in a more useful way.
	 */
	@SerializedName("loccityid")
	public int locationCityId;
	
}
