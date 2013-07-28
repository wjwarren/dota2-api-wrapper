package nl.ansuz.android.steam.dota.util.matches;

import nl.ansuz.android.steam.dota.vo.MatchVO;

import java.util.Comparator;

/**
 * Comparator to sort a {@link MatchVO} Array by {@link MatchVO#startTime} descending.
 *
 * @author Wijnand
 */
public class MatchVoComparator implements Comparator<MatchVO> {

	/** {@inheritDoc} */
	@Override
	public int compare(MatchVO left, MatchVO right) {
		int result = 0;

		if (left.startTime > right.startTime) {
			result = -1;
		} else if (left.startTime < right.startTime) {
			result = 1;
		}

		return result;
	}
}
