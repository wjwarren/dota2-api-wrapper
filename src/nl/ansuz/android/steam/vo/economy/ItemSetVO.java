package nl.ansuz.android.steam.vo.economy;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Wijnand Warren
 */
public class ItemSetVO {

	@SerializedName("item_set")
	public String itemSetId;
	
	@SerializedName("name")
	public String name;
	
	/**
	 * String Array of ItemVO.name.
	 */
	@SerializedName("items")
	public String[] items;
	
}
