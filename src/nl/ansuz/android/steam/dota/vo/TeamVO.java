package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * DotA 2 league team. (During a match.)
 * 
 * @author Wijnand
 */
public class TeamVO {

	/**
	 * The team's name.
	 */
	@SerializedName("team_name")
	public String teamName;
	
	/**
	 * The team's unique ID.
	 */
	@SerializedName("team_id")
	public int teamId;
	
	/**
	 * The UGC id for the team logo. You can resolve this with the GetUGCFileDetails method.
	 */
	@SerializedName("team_logo")
	public long teamLogo;
	
	/**
	 * Whether the players for this team are all team members.
	 */
	@SerializedName("complete")
	public boolean complete;
	
}
