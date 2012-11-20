package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Dota match.
 * 
 * @author Wijnand
 */
public class MatchVO {
	
	@SerializedName("match_id")
	public int matchId;
	
	@SerializedName("start_time")
	public int startTime;
	
	@SerializedName("lobby_type")
	public int lobbyType;
	
	@SerializedName("players")
	public PlayerVO[] players;
}
