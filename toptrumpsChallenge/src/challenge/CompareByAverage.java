package challenge;

import java.util.Comparator;

public class CompareByAverage implements Comparator< TopTrumpCard> {

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		// TODO Auto-generated method stub

		if (o1.getAverage() > o2.getAverage()) {
			return 1;
		} else if (o2.getAverage() > o1.getAverage()) {
			return -1;

		} else {
			return 0;
		}
	}
	

}
