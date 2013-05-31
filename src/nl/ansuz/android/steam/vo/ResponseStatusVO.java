package nl.ansuz.android.steam.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Steam response status.
 *
 * @author Wijnand Warren
 */
public class ResponseStatusVO {

	/**
	 * Integer identifying error that occurred.
	 *
	 * 9 - The file with the given ID was not found.
	 */
	@SerializedName("code")
	public int code;

}