package nl.ansuz.android.steam.dota.util;

/**
 * Util class to construct DotA match replay URLs.
 * 
 * @author Wijnand
 */
public class DotaReplayUrlBuilder {
	
	/**
	 * Constructs a DotA replay URL.
	 * All this data can be obtained from the GetMatchDetailsResponse class.
	 * 
	 * @param cluster The replay cluster to use.
	 * @param appId The application id.
	 * @param matchId The match id.
	 * @param replaySalt Unique replay salt.
	 */
	public String getReplayUrl(int cluster, int appId, int matchId, int replaySalt) {
		String replayUrl = "http://replay" + cluster;		
		replayUrl += ".valve.net/" + appId;
		replayUrl += "/" + matchId;
		replayUrl += "_" + replaySalt;
		replayUrl += ".dem.bz2";
		
		return replayUrl;
	}
	
	/**
	 * Constructs a DotA replay URL using the dota2 protocol.
	 * 
	 * @param matchId The match to get the replay for.
	 * @param startTime Point in time to start the replay at.
	 */
	public String getShortReplayUrl(int matchId, int startTime) {
		String replayUrl = "dota2://matchid=" + matchId;
		replayUrl += "&matchtime=" + startTime;
		
		return replayUrl;
	}
}
