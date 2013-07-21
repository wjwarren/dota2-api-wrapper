package nl.ansuz.android.steam.dota.request.match;

import nl.ansuz.android.steam.dota.request.DotaRequest;
import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to get a list of all the teams set up in-game.
 *
 * @see http://wiki.teamfortress.com/wiki/WebAPI/GetTeamInfoByTeamID
 * @author Wijnand
 */
public class GetTeamInfoByTeamId extends DotaRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {

		/**
		 * The team id to start returning results from.
		 */
		public final static String START_AT_TEAM_ID = "start_at_team_id";

		/**
		 * The amount of teams to return.
		 */
		public final static String NUMBER_OF_TEAMS_REQUESTED = "teams_requested";
	}

	public final static String METHOD_NAME = "GetTeamInfoByTeamID";

	/** {@inheritDoc} */
	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + METHOD_NAME;
		baseUrl += "/" + API_VERSION_ONE;
		baseUrl += "/";

		return baseUrl;
	}

}
