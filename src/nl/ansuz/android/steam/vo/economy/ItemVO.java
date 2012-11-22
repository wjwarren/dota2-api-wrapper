package nl.ansuz.android.steam.vo.economy;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Steam Economy item.
 * 
 * @author Wijnand Warren
 */
public class ItemVO {

	@SerializedName("name")
	public String name;
	
	@SerializedName("defindex")
	public int defindex;
	
	@SerializedName("item_class")
	public String itemClass;
	
	@SerializedName("item_type_name")
	public String itemTypeName;
	
	@SerializedName("item_name")
	public String itemName;
	
	@SerializedName("proper_name")
	public boolean properName;
	
	/**
	 * Match this with ItemQualityVO and ItemQualityNamesVO.
	 * TODO: Create a util to map int to String?
	 */
	@SerializedName("item_quality")
	public int itemQuality;
	
	@SerializedName("image_inventory")
	public String imageInventory;
	
	@SerializedName("min_ilevel")
	public int minILevel;
	
	@SerializedName("max_ilevel")
	public int maxILevel;
	
	@SerializedName("image_url")
	public String imageUrl;
	
	@SerializedName("image_url_large")
	public String imageUrlLarge;
	
	@SerializedName("capabilities")
	public ItemCapabilitiesVO capabilities;
	
	@SerializedName("tool")
	public ItemToolVO tool;
	
	@SerializedName("attributes")
	public ItemAttributeVO[] attributes;
	
}
