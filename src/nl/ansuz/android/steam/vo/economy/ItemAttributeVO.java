package nl.ansuz.android.steam.vo.economy;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Wijnand Warren
 */
public class ItemAttributeVO {

	@SerializedName("name")
	public boolean name;
	
	@SerializedName("class")
	public String className;
	
	@SerializedName("value")
	public double value;
	
}
