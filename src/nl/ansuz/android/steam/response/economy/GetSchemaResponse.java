package nl.ansuz.android.steam.response.economy;

import nl.ansuz.android.steam.vo.economy.ItemOriginNamesVO;
import nl.ansuz.android.steam.vo.economy.ItemQualityNamesVO;
import nl.ansuz.android.steam.vo.economy.ItemQualityVO;
import nl.ansuz.android.steam.vo.economy.ItemSetVO;
import nl.ansuz.android.steam.vo.economy.ItemVO;
import nl.ansuz.android.steam.vo.economy.ParticleVO;
import nl.ansuz.android.steam.vo.economy.SchemaAttributeVO;

import com.google.gson.annotations.SerializedName;

/**
 * Response object for the GetSchema request.
 * 
 * @see http://wiki.teamfortress.com/wiki/WebAPI/GetSchema
 * @author Wijnand Warren
 */
public class GetSchemaResponse {

	/**
	 * The status of the request, should always be 1.
	 */
	@SerializedName("status")
	public int status;
	
	/**
	 * A string containing the URL to the full item schema as used by the game.
	 */
	@SerializedName("items_game_url")
	public int itemsGameUrl;
	
	/**
	 * An object containing the numeric values corresponding to each "quality" 
	 * an item can have.
	 */
	@SerializedName("qualities")
	public ItemQualityVO qualities;
	
	/**
	 * If the language argument is specified this object is included in the 
	 * output. It includes the translations of the internal quality names to the
	 * specified language.
	 */
	@SerializedName("qualityNames")
	public ItemQualityNamesVO qualityNames;
	
	/**
	 * A list of objects describing an item's origin.
	 */
	@SerializedName("originNames")
	public ItemOriginNamesVO[] originNames;
	
	/**
	 * A list of item objects.
	 */
	@SerializedName("items")
	public ItemVO[] items;
	
	/**
	 * An object containing an array of attributes.
	 */
	@SerializedName("attributes")
	public SchemaAttributeVO[] attributes;
	
	/**
	 * A list of objects containing item set definitions.
	 */
	@SerializedName("item_sets")
	public ItemSetVO[] itemSets;
	
	/**
	 * An object containing a list of objects that describe the defined particle
	 * effects.
	 */
	@SerializedName("attribute_controlled_attached_particles")
	public ParticleVO[] attributeControlledAttachedParticles;
	
}
