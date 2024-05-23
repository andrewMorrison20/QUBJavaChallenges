package challenge;

import java.util.Comparator;

public class CompareByIntelligence implements Comparator< TopTrumpCard> {

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		// TODO Auto-generated method stub
		return o2.getIntelligence()-o1.getIntelligence();
	}

}
