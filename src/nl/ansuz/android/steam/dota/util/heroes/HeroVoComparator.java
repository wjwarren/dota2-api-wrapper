package nl.ansuz.android.steam.dota.util.heroes;

import nl.ansuz.android.steam.dota.vo.HeroVO;

import java.util.Comparator;

/**
 * Comparator to sort a {@link HeroVO} Array by {@link HeroVO#id}.
 *
 * @author Wijnand
 */
public class HeroVoComparator implements Comparator<HeroVO> {

	/** {@inheritDoc} */
	@Override
	public int compare(HeroVO left, HeroVO right) {
		int result = 0;

		if (left.id > right.id) {
			result = 1;
		} else if (left.id < right.id) {
			result = -1;
		}

		return result;
	}
}
