package nl.ansuz.android.steam.vo.economy;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Wijnand Warren
 */
public class ItemCapabilitiesVO {

	@SerializedName("can_craft_mark")
	public boolean canCraftMark;
	
	@SerializedName("can_be_restored")
	public boolean canBeRestored;
	
	@SerializedName("strange_parts")
	public boolean strangeParts;
	
	@SerializedName("paintable_unusual")
	public boolean paintableUnusual;
	
}
