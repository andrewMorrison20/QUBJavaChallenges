package challenge;

import java.util.Comparator;

public class CompareBySpeed implements Comparator<TopTrumpCard> {

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		// TODO Auto-generated method stub
		return o2.getSpeed()-o1.getSpeed();
	}

}
