package nl.ansuz.android.steam.response.remotestorage;

import com.google.gson.annotations.SerializedName;
import nl.ansuz.android.steam.vo.ResponseStatusVO;
import nl.ansuz.android.steam.vo.remotestorage.UgcFileDetailsVO;

/**
 * Response object for the GetUGCFileDetails request.
 *
 * @author Wijnand Warren
 */
public class GetUGCFileDetailsResponse {

	/**
	 * File details.
	 */
	@SerializedName("data")
	public UgcFileDetailsVO data;

	/**
	 * Object returned on non-HTTP errors.
	 */
	@SerializedName("status")
	public ResponseStatusVO status;

}
