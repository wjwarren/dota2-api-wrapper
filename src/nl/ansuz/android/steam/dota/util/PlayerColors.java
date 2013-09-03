package nl.ansuz.android.steam.dota.util;

import android.content.Context;
import nl.ansuz.android.steam.R;

/**
 * Utility class to look up player colours as seen in the HUD in-game.
 *
 * @author Wijnand
 */
public class PlayerColors {

	/**
	 * @param slot int - The player slot to look up the color for.
	 * @param context {@link Context} - {@link Context} to use to retrieve resources.
	 * @return int - The color (as seen on the HUD in-game) for the player in the passed in slot.
	 */
	public static int getColorByPlayerSlot(int slot, Context context) {
		int colorId;

		switch (slot) {
			// Radiant
			case 0:
				colorId = R.color.radiant_blue;
				break;
			case 1:
				colorId = R.color.radiant_teal;
				break;
			case 2:
				colorId = R.color.radiant_purple;
				break;
			case 3:
				colorId = R.color.radiant_yellow;
				break;
			case 4:
				colorId = R.color.radiant_orange;
				break;
			// Dire
			case 128:
				colorId = R.color.dire_pink;
				break;
			case 129:
				colorId = R.color.dire_pus_yellow;
				break;
			case 130:
				colorId = R.color.dire_light_blue;
				break;
			case 131:
				colorId = R.color.dire_green;
				break;
			case 132:
				colorId = R.color.dire_brown;
				break;
			default:
				colorId = -1;
				break;
		}

		int color = 0;
		if (colorId > 0) {
			color = context.getResources().getColor(colorId);
		}

		return color;
	}

}
