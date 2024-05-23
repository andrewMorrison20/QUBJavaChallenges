package woofChallenge;

import java.util.Comparator;

public class CompareByHeight implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		if (o1.getHeight() > o2.getHeight()) {
			return 1;
		} else if (o2.getHeight() > o1.getHeight()) {
			return -1;
		} else

		{
			return 0;
		}
	}
}

