package nl.ansuz.android.steam.util;

import nl.ansuz.android.steam.SteamId;

/**
 * Tries to determine what kind of Steam ID we're dealing with, or perhaps none at all.
 * 
 * @author Wijnand
 */
public class SteamIdSolver {

	/**
	 * List of different types of Steam IDs.
	 * 
	 * @author Wijnand
	 */
	public enum IdType {
		UNKNOWN,
		TEXTUAL,
		ACCOUNT_32_BIT,
		ACCOUNT_64_BIT
	}
	
	/**
	 * Determines whether or not the passed in String represents a textual Steam ID.
	 * 
	 * @param raw The raw (input) String to analyze.
	 */
	private boolean isTextualId(String raw) {
		boolean isTextual = false;
		
		if(raw.startsWith(SteamId.TEXTUAL_PREFIX) && raw.split(SteamId.TEXTUAL_SEPARATOR).length == 2) {
			isTextual = true;
		}
		
		return isTextual;
	}
	
	/**
	 * Determines whether or not the passed in String represents a 32 bit Steam ID (a.k.a account number).
	 * 
	 * NOTE: This might resolve to true when a 64 bit ID is passed in!
	 * 
	 * @param raw The raw (input) String to analyze.
	 */
	private boolean is32BitId(String raw) {
		boolean is32Bit = false;
		int id = -1;
		
		try {
			id = Integer.parseInt(raw);
			if(id >= 0) {
				is32Bit = true;
			}
		} catch (NumberFormatException e) {
			// Nopes, not a 32 bit ID.
		}
		
		return is32Bit;
	}
	
	/**
	 * Determines whether or not the passed in String represents a 64 bit Steam ID.
	 * 
	 * @param raw The raw (input) String to analyze.
	 */
	private boolean is64BitId(String raw) {
		boolean is64Bit = false;
		long id = -1;
		
		try {
			id = Long.parseLong(raw);
			if(id > SteamId.ACCOUNT_TO_ID_OFFSET) {
				is64Bit = true;
			}
		} catch (NumberFormatException e) {
			// Nopes, not a 64 bit ID.
		}
		
		return is64Bit;
	}
	
	/**
	 * Tries to identify what Steam ID type we're dealing with.
	 *  
	 * @param raw The raw (input) String to analyze.
	 */
	public IdType getIdType(String raw) {
		IdType type = IdType.UNKNOWN;
		
		if(isTextualId(raw)) {
			type = IdType.TEXTUAL;
		} else if(is64BitId(raw)) {
			type = IdType.ACCOUNT_64_BIT;
		} else if(is32BitId(raw)) {
			type = IdType.ACCOUNT_32_BIT;
		}
		
		return type;
	}

	
}
