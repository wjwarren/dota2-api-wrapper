package nl.ansuz.android.steam;

/**
 * Representation of a Steam ID.
 * 
 * @author Wijnand
 * @see https://developer.valvesoftware.com/wiki/SteamID
 */
public class SteamId {

	/**
	 * There are 8 universes of Steam accounts.
	 * 
	 * @author Wijnand
	 */
	public enum Universe {
		INDIVIDUAL_OR_UNSPECIFIED,
		PUBLIC,
		BETA,
		INTERNAL,
		DEV,
		RC;
		
		private static final Universe[] universeValues = Universe.values();
		
		public static Universe fromInteger(int i) {
			return universeValues[i];
		}
	}
	
	/**
	 * There are ten known account types for a Steam account, of which only 3 
	 * can be created today.
	 * 
	 * @author Wijnand
	 */
	public enum AccountType {
		INVALID,
		INDIVIDUAL,
		MULTISEAT,
		GAME_SERVER,
		ANON_GAME_SERVER,
		PENDING,
		CONTENT_SERVER,
		CLAN,
		CHAT,
		P2P_SUPER_SEEDER,
		ANONUSER;
		
		private static final AccountType[] typeValues = AccountType.values();
		
		public static AccountType fromInteger(int i) {
			return typeValues[i];
		}
	}
	
	public final static String TEXTUAL_PREFIX = "STEAM_";
	public final static String TEXTUAL_SEPARATOR = ":";
	public final static long ACCOUNT_TO_ID_OFFSET = 76561197960265728L;
		
	private String textualId;
	private long id64Bits;
	
	private int accountNumber;
	private int accountInstance;
	private AccountType accountType;
	private Universe accountUniverse;
	
	/**
	 * SteamIDs follow a fairly simple format when represented textually: 
	 * "STEAM_X:Y:Z", where X, Y and Z are integers. In select cases 
	 * "STEAM_ID_PENDING" or "UNKNOWN" are used (see the section 'Types of Steam 
	 * Accounts' for more details).
	 * 
	 * X represents the "Universe" the steam account belongs to.
	 * Y is part of the ID number for the account. Y is either 0 or 1.
	 * Z is the ID number for the account (the "account number").
	 * 
	 * @param textualId The textual Steam ID to parse.
	 */
	public SteamId(String textualId) {
		this.textualId = textualId;
		
		accountUniverse = getUniverseFromTextual(textualId);
		accountNumber = getAccountFromTextual(textualId);
		id64Bits = accountNumber + ACCOUNT_TO_ID_OFFSET;
		
		// Assumptions:
		accountInstance = 1;
		accountType = AccountType.INDIVIDUAL;
	}
	
	/**
	 * When represented internally in computer programs the X, Y and Z 
	 * components (see the section titled 'As Represented Textually') are all 
	 * packed into a 64-bit data structure.
	 * 
	 * The low 32 bits represents the ID number for the account (the "account 
	 * 	number").
	 * The next 20 bits represents the instance of the account. It is usually 
	 * 	set to 1 for user accounts.
	 * The next 4 bits represents the type of account.
	 * The next 8 bits represents the "Universe" the steam account belongs to.
	 * 
	 * @param id64Bits The 64 bit Steam ID to parse.
	 */
	public SteamId(long id64Bits) {
		this.id64Bits = id64Bits;
		
		accountNumber = (int) (id64Bits & 0xffffffff);
		accountInstance = (int) ((id64Bits >> 32) & 0xfffff);
		accountType = AccountType.fromInteger((int) ((id64Bits >> 52) & 0xf));
		accountUniverse = Universe.fromInteger((int) (id64Bits >> 56));
		
		textualId = createTextualId();
	}
	
	/**
	 * Very loose way to generate a full Steam ID, uses a lot of assumptions.
	 * 
	 * @param accountNumber The Stream account number to use.
	 */
	public SteamId(int accountNumber) {
		this.accountNumber = accountNumber;
		
		// This is an educated guess, as found on:
		// http://dev.dota2.com/showthread.php?t=47115
		this.id64Bits = accountNumber + ACCOUNT_TO_ID_OFFSET;
		
		// Using assumed instance, type and universe.
		accountInstance = 1;
		accountType = AccountType.INDIVIDUAL;
		accountUniverse = Universe.PUBLIC;
		
		textualId = createTextualId();
	}

	/**
	 * Creates a textual Steam ID.
	 */
	private String createTextualId() {
		String textId = TEXTUAL_PREFIX;
		textId += accountUniverse.ordinal() + TEXTUAL_SEPARATOR;
		textId += accountNumber % 2 + TEXTUAL_SEPARATOR;
		textId += accountNumber / 2;
		
		return textId;
	}

	/**
	 * Extracts the "Universe" from the textual Steam ID.
	 * 
	 * @param textualId The Steam ID to parse.
	 */
	private Universe getUniverseFromTextual(String textualId) {
		int universeOffset = TEXTUAL_PREFIX.length();
		String universeString = textualId.substring(universeOffset, universeOffset + 1);
		Universe universe = Universe.fromInteger(Integer.parseInt(universeString));
		
		return universe;
	}

	/**
	 * Extracts the account number from the textual Steam ID.
	 * 
	 * @param textualId The Steam ID to parse.
	 */
	private int getAccountFromTextual(String textualId) {
		int account = 0;
		String[] splitted = textualId.split(TEXTUAL_SEPARATOR);
		int toAdd = Integer.parseInt(splitted[1]);
		int halfAccount = Integer.parseInt(splitted[2]);
		
		account = halfAccount * 2 + toAdd;
		
		return account;
	}
	
	/**
	 * @return the textualId
	 */
	public String getTextualId() {
		return textualId;
	}

	/**
	 * @return the id64Bits
	 */
	public long getId64Bits() {
		return id64Bits;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the accountInstance
	 */
	public int getAccountInstance() {
		return accountInstance;
	}

	/**
	 * @return the accountType
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * @return the accountUniverse
	 */
	public Universe getAccountUniverse() {
		return accountUniverse;
	}
}
