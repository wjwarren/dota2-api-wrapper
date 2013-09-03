package nl.ansuz.android.steam.dota.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Dota 2 Hero.
 * 
 * @author Wijnand
 */
public class HeroVO {

	public static final String IMAGE_URL_PREFIX = "http://media.steampowered.com/apps/dota2/images/heroes/";

	public static final String FULL_IMAGE_URL_SUFFIX = "_full.png";
	public static final String LARGE_IMAGE_URL_SUFFIX = "_lg.png";
	public static final String SMALL_IMAGE_URL_SUFFIX = "_sb.png";
	public static final String PORTRAIT_IMAGE_URL_SUFFIX = "_vert.jpg";

	public static final String HERO_NAME_PREFIX = "npc_dota_hero_";
	public static final String HERO_NAME_PREFIX_REPLACEMENT = "";

	@SerializedName("name")
	public String name;

	@SerializedName("id")
	public int id;

	@SerializedName("localized_name")
	public String localizedName;

	/**
	 * Constructs an image URL based on the suffix.
	 *
	 * @param suffix String - The suffix to use to append to the URL.
	 * @return Hero icon URL.
	 */
	private String getImageUrl(String suffix) {
		return IMAGE_URL_PREFIX + name.replace(HERO_NAME_PREFIX, HERO_NAME_PREFIX_REPLACEMENT) + suffix;
	}

	/**
	 * @return The URL for the full sized Hero icon (256x144 px).
	 */
	public String getFullImageUrl() {
		return getImageUrl(FULL_IMAGE_URL_SUFFIX);
	}

	/**
	 * @return The URL for the large Hero icon (205x115 px).
	 */
	public String getLargeImageUrl() {
		return getImageUrl(LARGE_IMAGE_URL_SUFFIX);
	}

	/**
	 * @return The URL for the small Hero icon (59x33 px).
	 */
	public String getSmallImageUrl() {
		return getImageUrl(SMALL_IMAGE_URL_SUFFIX);
	}
	
	/**
	 * @return The URL for the portait Hero icon (235x272 px).
	 */
	public String getPortaitImageUrl() {
		return getImageUrl(PORTRAIT_IMAGE_URL_SUFFIX);
	}
}
