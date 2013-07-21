package nl.ansuz.android.steam.dota.request.economy;

import nl.ansuz.android.steam.dota.request.DotaRequest;
import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to retrieve the Dota 2 item rarity list.
 *
 * @see http://wiki.teamfortress.com/wiki/WebAPI/GetRarities
 * @author Wijnand Warren
 */
public class GetRarities extends DotaRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {
		/**
		 * The language to provide rarity names in.
		 */
		public final static String LANGUAGE = "language";
	}

	private final static String METHOD_NAME = "GetRarities";
	private final static String INTERFACE_PREFIX = "IEconDOTA2_";

	@Override
	protected String getInterface(int applicationId) {
		return INTERFACE_PREFIX + applicationId;
	}

	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + METHOD_NAME;
		baseUrl += "/" + API_VERSION_ONE;
		baseUrl += "/";

		return baseUrl;
	}
}