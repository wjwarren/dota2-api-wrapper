package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Dota match.
 * 
 * @author Wijnand
 */
public class MatchVO {

	/**
	 * The unique ID of the match.
	 */
	@SerializedName("match_id")
	public long matchId;

	/**
	 * A 'sequence number', representing the order in which matches were recorded.
	 */
	@SerializedName("match_seq_num")
	public long matchSequenceNumber;

	/**
	 * Unix timestamp of when the match began.
	 */
	@SerializedName("start_time")
	public int startTime;

	/**
	 * @see GetMatchDetailsResponse.LobbyType
	 */
	@SerializedName("lobby_type")
	public int lobbyType;

	/**
	 * The list of players within the match.
	 */
	@SerializedName("players")
	public PlayerVO[] players;

}
