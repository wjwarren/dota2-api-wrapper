package nl.ansuz.android.steam.dota.util.gson;

import java.lang.reflect.Type;

import nl.ansuz.android.steam.dota.vo.TeamDetailsVO;
import nl.ansuz.android.steam.dota.vo.team.BaseTeamDetailsVO;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

/**
 * Custom GSON deserializer for the TeamDetailsVO, received by GetTeamInfoByTeamId API response.
 *
 * @author Wijnand
 */
public class TeamDetailsDeserializer extends DotaDeserializer implements JsonDeserializer<TeamDetailsVO> {

	private static String RATING_FIELD = "rating";
	private static String PLAYER_PREFIX = "player_";
	private static String PLAYER_SUFFIX = "_account_id";
	private static String LEAGUE_PREFIX = "league_id_";
	
	@Override
	public TeamDetailsVO deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		JsonObject jsonObject = json.getAsJsonObject();
		TeamDetailsVO result = new TeamDetailsVO();
		
		// Deserialize standard properties the easy way.
		BaseTeamDetailsVO detailsBase = context.deserialize(json, BaseTeamDetailsVO.class);
		result = copyFromTo(detailsBase, result);
		
		// Parse the rest by hand.
		// Rating.
		if (jsonObject.has(RATING_FIELD)) {
			JsonElement ratingElement = jsonObject.get(RATING_FIELD);
			if (ratingElement.isJsonPrimitive()) {
				JsonPrimitive ratingPrimitive = ratingElement.getAsJsonPrimitive();
				// Rating is sometimes "inactive".
				if (ratingPrimitive.isNumber()) {
					result.rating = ratingPrimitive.getAsInt();
				} else {
					result.rating = -1;
				}
			}
		}
		
		// Players: player_N_account_id
		int numberOfPlayers = getOccurrences(json.toString(), PLAYER_PREFIX);
		result.playerAccountIds = new int[numberOfPlayers];
		
		for (int i = 0; i < numberOfPlayers; i++) {
			String playerAccount = PLAYER_PREFIX + i + PLAYER_SUFFIX;
			if (jsonObject.has(playerAccount)) {
				JsonElement playerElement = jsonObject.get(playerAccount);
				result.playerAccountIds[i] = playerElement.getAsInt();
			}
		}
		
		// Leagues: league_id_N
		int numberOfLeagues = getOccurrences(json.toString(), LEAGUE_PREFIX);
		result.leagueIds = new int[numberOfLeagues];
		
		for (int k = 0; k < numberOfLeagues; k++) {
			String leagueId = LEAGUE_PREFIX + k;
			if (jsonObject.has(leagueId)) {
				JsonElement leagueElement = jsonObject.get(leagueId);
				result.leagueIds[k] = leagueElement.getAsInt();
			}
		}
		
		return result;
	}

	/**
	 * Finds the number of occurrences of the needle in the haystack.
	 *
	 * @param haystack String - The haystack to search through.
	 * @param needle String - The needle to find.
	 * @return int - The number of occurrences of the needle in the haystack.
	 */
	private int getOccurrences(String haystack, String needle) {
		return haystack.split(needle).length - 1;
	}


}
