package woofChallenge;

import java.util.Comparator;

public class CompareByWeight implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		if (o1.getWeight() > o2.getWeight()) {
			return 1;
		} else if (o2.getWeight() > o1.getWeight()) {
			return -1;
		} else

		{
			return 0;
		}
	
	}
	

}
