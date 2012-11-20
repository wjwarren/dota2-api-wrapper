package nl.ansuz.android.steam.dota.util;

/**
 * Util class to check DotA match building status.
 * 
 * @author Wijnand
 */
public class DotaBuildingStatus {

	/**
	 * DotA towers and their numeric representations.
	 * 
	 * @author Wijnand
	 */
	public enum DotaTower {
	    TIER_1_BOTTOM (1),
	    TIER_2_BOTTOM (2),
	    TIER_3_BOTTOM (4),
	    TIER_1_MIDDLE (8),
	    TIER_2_MIDDLE (16),
	    TIER_3_MIDDLE (32),
	    TIER_1_TOP (64),
	    TIER_2_TOP (128),
	    TIER_3_TOP (256),
	    ANCIENT_BOTTOM (512),
	    ANCIENT_TOP (1024);
	    
	    private final int towerValue;
	    
	    DotaTower(int value) {
	    	towerValue = value;
	    }
	}
	
	/**
	 * DotA barracks and their numeric representations.
	 * 
	 * @author Wijnand
	 */
	public enum DotaBarracks {
	    MELEE_BOTTOM (1),
	    RANGED_BOTTOM (2),
	    MELEE_MIDDLE (4),
	    RANGED_MIDDLE (8),
	    MELEE_TOP (16),
	    RANGED_TOP (32);
	    
	    private final int barracksValue;
	    
	    DotaBarracks(int value) {
	    	barracksValue = value;
	    }
	}
	
	/**
	 * Determines whether or not a tower in a base is still up.
	 * 
	 * @param towerStatus The tower status as received in the 
	 * 	GetMatchDetailsResponse class.
	 * @param tower The tower to check.
	 */
	public Boolean isTowerUp(int towerStatus, DotaTower tower) {
		return (towerStatus & tower.towerValue) == tower.towerValue;
	}
	
	/**
	 * Determines whether or not a barracks in a base is still up.
	 * 
	 * @param towerStatus The barracks status as received in the 
	 * 	GetMatchDetailsResponse class.
	 * @param tower The barracks to check.
	 */
	public Boolean isBarracksUp(int barracksStatus, DotaBarracks barracks) {
		return (barracksStatus & barracks.barracksValue) == barracks.barracksValue;
	}
}
