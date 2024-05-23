package pizzaChallenge2;

public class MenItem implements IDetail {

	
private String name;
private double price;

	public MenItem(String name, double price) {
	
	this.setName(name);
	this.setPrice(price);
}

	public String getName() {
	return name;
}

public void setName(String name) throws IllegalArgumentException {
	if (name == null) {
		throw new IllegalArgumentException("NAME CANNOT BE NULL");
	} else if (name.startsWith((" "))) {
		throw new IllegalArgumentException(" NAME MUST NOT BEGIN WITH A SPACE");

	} else if (!testAlphabetic(name) && !testSpace(name)) {
		throw new IllegalArgumentException("NAME MUST BE ALPHABETIC AND SPACES ONLY");
	} else

	{
		this.name = name;
	}
}
	
	
	private boolean testSpace(String name) {
		char[] chars = name.toCharArray();		
				for(char c : chars) {
					if(c != ' ' ) {
						return false;
					}
					return true;
				}
	// TODO Auto-generated method stub
	return false;
}


public double getPrice() {
	return price;
}

public void setPrice(double price)throws IllegalArgumentException {
	
	if(price<0) {
		this.price = 0;
		throw new IllegalArgumentException(" INVALID PRICE - SET TO ZERO");
	}else {
	this.price = price;}
}

	@Override
	public void printDetails() {
		System.out.printf("\n%-18s £%-18.2f",name,price);
		
	}

	
private boolean testAlphabetic(String name) {
	boolean alphabetic= true;
	char[] chars	= name.toCharArray();
	for(char c : chars) {
		if(!Character.isAlphabetic(c))
			if(!testSpace(String.format("%s", c))){
		{alphabetic = false;
		break;}}

}
	return alphabetic;
}

public void DisplayAll() {
	System.out.printf("\n%-25s £%-25.2f",name,price);
	
	
}
}
