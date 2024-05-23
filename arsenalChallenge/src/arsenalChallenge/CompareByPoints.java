package arsenalChallenge;

import java.util.Comparator;

public class CompareByPoints implements Comparator<Team> {

	@Override
	public int compare(Team o1, Team o2) {
		// TODO Auto-generated method stub
		return o2.calcTotalPoints()-o1.calcTotalPoints();
	}

}
