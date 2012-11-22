package nl.ansuz.android.steam.vo.economy;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Wijnand Warren
 */
public class SchemaAttributeVO {

	@SerializedName("name")
	public String name;
	
	@SerializedName("defindex")
	public int defindex;
	
	@SerializedName("attribute_class")
	public String attributeClass;
	
	@SerializedName("min_value")
	public double minValue;
	
	@SerializedName("max_value")
	public double maxValue;
	
	@SerializedName("description_string")
	public String descriptionString;
	
	@SerializedName("description_format")
	public String descriptionFormat;
	
	@SerializedName("effect_type")
	public String effectType;
	
	@SerializedName("hidden")
	public boolean hidden;
	
	@SerializedName("stored_as_integer")
	public boolean storedAsInteger;
}
