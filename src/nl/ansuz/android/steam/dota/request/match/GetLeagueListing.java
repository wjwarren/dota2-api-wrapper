package nl.ansuz.android.steam.dota.request.match;

import nl.ansuz.android.steam.dota.request.DotaRequest;
import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to get information about DotaTV-supported leagues.
 *
 * @see http://wiki.teamfortress.com/wiki/WebAPI/GetLeagueListing
 * @author Wijnand
 */
public class GetLeagueListing extends DotaRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {

		/**
		 * The ISO639-1 language code for the language all tokenized strings should be returned in.
		 *
		 * This is an optional parameter. If you omit it, all you get back in the name and description fields are the
		 * tokens used to look up the translated strings. An example: "name": "#DOTA_Item_Killing_Spree_North_America".
		 */
		public final static String LANGUAGE = "language";

	}

	public final static String METHOD_NAME = "GetLeagueListing";

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