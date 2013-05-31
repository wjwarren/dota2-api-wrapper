package nl.ansuz.android.steam.request.remotestorage;

import nl.ansuz.android.steam.request.ISteamRequest;
import nl.ansuz.android.steam.request.SteamRequest;

/**
 * UGC file size, local filename, and URL.
 *
 * @author Wijnand Warren
 */
public class GetUGCFileDetails extends SteamRequest implements ISteamRequest {

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {
		/**
		 * (Optional) If specified, only returns details if the file is owned by the SteamID specified.
		 */
		public final static String STEAM_ID = "steamid";

		/**
		 * ID of UGC file to get info for.
		 */
		public final static String UGC_ID = "ugcid";

		/**
		 * Application ID of product.
		 */
		public final static String APP_ID = "appid";
	}

	private final static String METHOD_NAME = "GetUGCFileDetails";
	private final static String INTERFACE_PREFIX = "ISteamRemoteStorage";

	protected String getInterface(int applicationId) {
		return INTERFACE_PREFIX;
	}

	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + getInterface(appId);
		baseUrl += "/" + METHOD_NAME;
		baseUrl += "/" + API_VERSION_ONE;
		baseUrl += "/";

		return baseUrl;
	}
}