package pizzaChallenge2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {


	public static void main(String[] args) {
List<String> order1File,order2File,order3File;
List<MenItem>allOrders1,allOrders2,allOrders3;
		// TODO Auto-generated method stub
//MenItem item1 = new MenItem("Burger",7.60);
//item1.DisplayAll();
//MenItem pizza1 = new Pizza(8);
//pizza1.DisplayAll();
//pizza1.printDetails();

order1File= readfile("OrderList-1-BasicOnly.csv");
order2File= readfile("OrderList-2-PizzasOnly.csv");
order3File = readfile("OrderList-3-Full.csv");

//System.out.println(order1File.size());
allOrders1 = processOrders(order1File);
allOrders2 = processOrders(order2File);
allOrders3 = processOrders(order3File);

printReceipt(allOrders1,"Order 1");
printReceipt(allOrders2, "Order 2");
printReceipt(allOrders3, "Order 3");

veggiePizzas(allOrders3);

	}

	

	private static void printReceipt(List<MenItem> allOrders1, String orderNumber) {
		double total=0;
		System.out.println();
		System.out.println("Printing "+ orderNumber);
		System.out.println();
		System.out.println("-----------------");
		System.out.println("ORDER DETAILS");
		System.out.println("-----------------");
		for(MenItem item : allOrders1) {
			
			total+= item.getPrice();	
			
			item.printDetails();
		}
		System.out.println();
		System.out.println("-----------------");
		System.out.println("Total cost : £"+ String.format("%.2f",total));
		System.out.println("-----------------");
	}

	private static List<MenItem> processOrders(List<String> order1) {
		// TODO Auto-generated method stub
		ArrayList<MenItem> allOrders = new ArrayList<MenItem>();
		for(String line : order1) {
			String [] parts = line.split(",");
			String name = parts[0];
			double price = Double.parseDouble(parts[1]);
			
			try {
				if(name.equalsIgnoreCase("Pizza")) {
					List<Topping> allToppings = new ArrayList<Topping>();
					for(int i =2; i<parts.length;i++) {
						if(!parts[i].equals(" ")) {
						allToppings.add(Topping.valueOf(parts[i].toUpperCase()));}
						
					}MenItem pizza = new Pizza((int)price, allToppings);
						allOrders.add(pizza);}
					else {
						MenItem item = new MenItem(name, price);
						allOrders.add(item);
						
					
				}
			}catch(Exception e) {}
		}return allOrders;
		
	}

	private static List<String> readfile(String fileName) {
		// TODO Auto-generated method stub
      List<String> allLines = new ArrayList<String>();
		try {

			File myFile = new File(fileName);
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			if(line.contains("Name,Price/Size,Toppings (if any) in remaining columns")) {
				line=br.readLine();
				}
			
			while(line!=null) {
			allLines.add(line);
			line=br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allLines;}

	

	
	public static void veggiePizzas(List<MenItem> allorders) {
		List<Pizza> veggiePizzas = new ArrayList<Pizza>();
		for (MenItem item : allorders) {
			if (item instanceof Pizza) {
				Pizza pizza = (Pizza) item;
				if (pizza.getExtraToppings().contains(Topping.BEEF) || pizza.getExtraToppings().contains(Topping.HAM)
						|| pizza.getExtraToppings().contains(Topping.CHICKEN)) {
					System.out.println("Not veggie");
				} else {
					veggiePizzas.add(pizza);
				}

			}

		}
		System.out.printf("%d Vegetarian Pizza's in this List : they are as below : ", veggiePizzas.size());
		for (Pizza p : veggiePizzas) {
			p.printDetails();
		}
	}
}
