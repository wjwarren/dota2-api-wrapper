package nl.ansuz.android.steam.vo.remotestorage;

import com.google.gson.annotations.SerializedName;

/**
 * Steam remote storage (UGC) file details.
 *
 * @author Wijnand Warren
 */
public class UgcFileDetailsVO {

	/**
	 * Path to the file along with its name.
	 */
	@SerializedName("filename")
	public String fileName;

	/**
	 * URL to the file.
	 */
	@SerializedName("url")
	public String url;

	/**
	 * Size of the file.
	 */
	@SerializedName("size")
	public int size;
}
