package cheersForBeersChallenge;

import java.util.Comparator;

public class CompareByPercentage implements Comparator< Beer> {

	@Override
	public int compare(Beer o1, Beer o2) {
		// TODO Auto-generated method stub
		return Double.compare(o1.getPercentage(),(Double)o2.getPercentage());
	}

}
