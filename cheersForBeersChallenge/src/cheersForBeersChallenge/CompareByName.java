package cheersForBeersChallenge;

import java.util.Comparator;

public class CompareByName implements Comparator<Beer>{

	@Override
	public int compare(Beer o1, Beer o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
