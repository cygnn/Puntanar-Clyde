import java.util.*;

public class RestaurantInteractive {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Menu menu = new Menu();
		int answer = 0;
		String choice = null;
		do{ 
			do{
				menu.showMenu();

				System.out.print("\nWhat would you like to order?: ");
				choice = scan.next().toLowerCase();
				if(choice.equals("c1")){
					menu.addToOrder(0);
				}
				else if(choice.equals("c2")){
					menu.addToOrder(1);
				}
				else if(choice.equals("c3")){
					menu.addToOrder(2);
				}
				else{
					System.out.println("Invalid input");
				}
			}
			while(!choice.equals("c1") && !choice.equals("c2") && !choice.equals("c3"));
			System.out.print("How many would you like?: ");
			int qty = scan.nextInt();
			menu.addQty(qty);
			
			System.out.println("Would you like add ons?\n[1] Yes\n[2] No");
			System.out.print("------>");
			int option = scan.nextInt();
			switch (option){
				case 1:
					String pick = null;
					int choose =0;
					do{
						do{
							menu.showAddOns();
							System.out.print("What would you like to add?: ");
							pick = scan.next().toLowerCase();
							if (pick.equals("r1")){
								menu.addToAddOns(0);
							}
							else if (pick.equals("r2")){
								menu.addToAddOns(1);
							}
							else{
								System.out.println("Invalid input.");
							}
						}
						while(!pick.equals("r1") && !pick.equals("r2"));
						System.out.println("How many would you like?: ");
						qty = scan.nextInt();
						menu.addQty(qty);
						System.out.println("Would you like to order more addons?\n[1] Yes\n[2] No");
						System.out.print("------>");
						choose = scan.nextInt();
					}
					while (choose != 2);
					break;
				case 2:
					break;
				default:
					System.out.println("Invalid input.");
			}
			System.out.println("Would you like to order more?\n[1] Yes\n[2] No");
			System.out.print("------>");
			answer = scan.nextInt();
		}
		while (answer != 2);
		menu.showItems();
	}
}


class Product {
	String name;
	double price;

	Product(){};
	Product(String name, double price)
	{
		this.name = name;
		this.price = price;
	}
	
}

class Menu{
	ArrayList<Integer> qtyArr = new ArrayList<>();
	ArrayList<Product> menuArr = new ArrayList<Product>();
	ArrayList<Product> addOn = new ArrayList<Product>();
	ArrayList<Product> order = new ArrayList<Product>();


	public Menu(){
		Product c1 = new Product("C1", 100.00);
		Product c2 = new Product("C2", 150.00);
		Product c3 = new Product("C3", 200.00);
		Product r1 = new Product("R1", 35.00);
		Product r2 = new Product("R2", 50.00);
		menuArr.add(c1);
		menuArr.add(c2);
		menuArr.add(c3);
		addOn.add(r1);
		addOn.add(r2);
	}

	public void showMenu(){
		System.out.println("===========MENU===========");
		for(int i = 0; i < menuArr.size(); i++){
			System.out.println(menuArr.get(i).name + "  -  PHP " + menuArr.get(i).price);
		}
	}

	public void showAddOns(){
		System.out.println("===========ADD ONS===========");
		for(int i = 0; i < addOn.size(); i++){
			System.out.println(addOn.get(i).name + "  -  PHP " + addOn.get(i).price);
		}
	}

	public void addToOrder(int index){
		String orderName;
		double orderPrice;
		for(int i =-1 ; i<menuArr.size(); i++){
			if(i==index){
				orderName = menuArr.get(i).name;
				orderPrice = menuArr.get(i).price;
				Product orderProduct = new Product(orderName, orderPrice);
				order.add(orderProduct);
			}
		}
	}
	public void addToAddOns(int index){
		String addOnsName;
		double addOnsPrice;
		for(int i = 0; i<addOn.size(); i++){
			if (i==index){
				addOnsName = addOn.get(i).name;
				addOnsPrice = addOn.get(i).price;
				Product addOnsItems = new Product(addOnsName, addOnsPrice);
				order.add(addOnsItems);
			}
		}
	}
	
	public void addQty(int qty){
		qtyArr.add(qty);
	}

	public void showItems(){
		System.out.println("=====ITEMS ORDERED=====");
		for(int i=0; i<order.size(); i++){
			System.out.println("x" + qtyArr.get(i)+ "  " +order.get(i).name +  "   " +order.get(i).price);
		}
		System.out.println("Total Price is = PHP " + calculateTotalPrice());
		System.out.printf("Total Price in USD is = $%.2f", convTotalPrice());
	}

	public double calculateTotalPrice(){
		double totalPrice=0;
		for(int i = 0; i< order.size(); i++){
			totalPrice += (order.get(i).price * qtyArr.get(i));
		}
		return totalPrice;
	}
	
	public double convTotalPrice(){
		double convTotalPrice=calculateTotalPrice()/56.85;
		return convTotalPrice;
	}
}