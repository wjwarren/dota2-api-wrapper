package nl.ansuz.android.steam.vo.economy;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Wijnand Warren
 */
public class ParticleVO {

	@SerializedName("system")
	public String system;
	
	@SerializedName("id")
	public int id;
	
	@SerializedName("attach_to_rootbone")
	public boolean attachToRootbone;
	
	@SerializedName("name")
	public String name;
	
}
