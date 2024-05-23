package countriesOfTheWorldchallenge;

import java.util.Comparator;

public class CompareByPopulation implements Comparator<Country> {

	@Override
	public int compare(Country o1, Country o2) {
		// TODO Auto-generated method stub
		return (int)(o2.getPopulation()-o1.getPopulation());
	}

}
