package challenge;

import java.util.Comparator;

public class CompareByBio implements Comparator<TopTrumpCard> {

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		// TODO Auto-generated method stub
		return o2.getBio().length()-o1.getBio().length();
	}

}
