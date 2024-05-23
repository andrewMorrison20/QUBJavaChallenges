package pizzaChallenge2;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Pizza extends MenItem {


	private int size;
	private Set<Topping> extraToppings = new TreeSet<Topping>();
		 
    public Pizza(int size) {
    	super("Pizza",size);
    	this.setSize(size);
    }
    
    public Pizza(int size, List<Topping> allToppings) {
    	super("Pizza",size);
    	this.setSize(size);
    	this.setExtraToppings(allToppings);
    	calcPrice();
    }
    
    
    
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Set<Topping> getExtraToppings() {
		return extraToppings;
	}
//resets the full toppings and replaces with new list everytime it is called
	
	
	public void setExtraToppings(List<Topping> extraToppings) {
		this.extraToppings.clear();
		if(extraToppings==null) {
			System.out.println("No toppings added");
		}
		this.extraToppings.addAll(extraToppings);
		calcPrice();
	}
	
	public void addTopping(Topping topping) {
		if(extraToppings.contains(topping)) {
			System.out.println("Topping already added - can only have 1 of each extra topping");
		}else {
		extraToppings.add(topping);
		}
		calcPrice();
	}
	
	public void removeTopping(Topping topping) {
		if(extraToppings.contains(topping)) {
			System.out.println( "Removing topping:  " + topping);
		}else {System.out.println("Topping not found");}
		calcPrice();
	}

	private void calcPrice() {
		// TODO Auto-generated method stub
	
		this.setPrice((size) + (0.5 * extraToppings.size()));
	
	}

@Override
public void printDetails() {
	

	if(extraToppings.size()==0) {
		System.out.println();
		//System.out.println("Plain Pizza");
		System.out.printf("\n%-10s(%d)   £%-15.2f","Plain Pizza",size,getPrice());
	}else {
		System.out.println();
	System.out.printf("\n%-10s(%d)   £%-15.2f","Custom Pizza",size,getPrice());
System.out.println("\n  with toppings: ");
	for(Topping topping : extraToppings) {
		System.out.println("* "+topping);
	}
	
}
	
}}
