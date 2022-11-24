import java.io.FileNotFoundException;
import java.io.ObjectInputFilter;
import java.util.*;
@SuppressWarnings("unused")
public class ShoppingApp {

	public static void main(String[] args) throws FileNotFoundException {
		//We created our bags which's implemented our interface named Ibag<>.
		
		Ibag<Item> inventory=FileIO.readInventory();
		Ibag<Item> meat = new MeatsCompartment<>();		
		Ibag<Item> snack = new SnacksCompartment<>();
		Ibag<Item> basket = new ShoppingBasket<>();
		Ibag<Item> veg_fru = new VegetablesFruitsCompartment<>();
		Ibag<Item> beverages= new BevaragesCompartment<>();
		
	String menu1 = """
			Please Enter The Options:
			1-Go to shopping
			2-See the status of the fridge
			3-Exit

			""";
	
	String menu2 ="""
			Please Enter The Options:
			1-Add an item to the basket
			2-See the basket
			3-Finish shopping
			4-Display inventory
			""";
	
	Scanner scan = new Scanner(System.in);
	boolean app = true;
	System.out.println("Welcome to The Shopping App!\n");

	while (app){
		while (true) {
			System.out.println(menu1);
			String input = scan.next();
			if ("1".equals(input)){
				break;

			}
			else if("2".equals(input)) {
				String fridge= "Remaining capacities of each compartments:";
				System.out.println(fridge);
				meat.displayItems();
				snack.displayItems();
				veg_fru.displayItems();
				beverages.displayItems();
				System.out.println("\n");				
			}
			else if("3".equals(input)) {
				app=false;
				break;}
		}
	
		
		if (!app){continue;}	
		while(app && true) {
			if (basket.isFull()) {
				System.out.println("The basket is full now, time to go <3 \n");
				System.out.println("Fridge compartments are being filled <3333 \n");				
				break;
			}
				System.out.println(menu2);
				String input1 = scan.next();
				if (input1.equals("1")){
					String add_menu	= "Please select an item:\n[1]tomato\n[2]potato\n[3]onion\n[4]banana\n[5]strawberry\n[6]chicken\n[7]beef\n[8]fish\n[9]coffee\n[10]coke\n[11]juice\n[12]chocolate\n[13]cake\n[14]nuts";
					System.out.println(add_menu);
				    int input_add = scan.nextInt();
					Item item = (Item) inventory.removeByIndex(input_add-1);
					boolean mevzu = inventory.transferTo(basket, item);
				
				
				}
				else if(input1.equals("2")) {
					basket.displayItems();
				}
				else if(input1.equals("3")) {
					break;
				}
				
				else if(input1.equals("4")) {
					inventory.displayItems();
					} 	
				
		}
		int num = basket.getNumberofitems();
		for(int i=0;i<num;i++) {
			Item fridgeItem = (Item)basket.removeByIndex(i);
			System.out.println(fridgeItem+" is taken from the basket...");
			if (!fridgeItem.equals(null)){
				String fridgeItemcopartmentString = fridgeItem.getCompartment();
				if (fridgeItemcopartmentString.equals("vegetables and fruits")){
					veg_fru.add(fridgeItem);}
				else if (fridgeItemcopartmentString.equals("meats")){
					meat.add(fridgeItem);}
				else if (fridgeItemcopartmentString.equals("beverages")){
					beverages.add(fridgeItem);}
				else if (fridgeItemcopartmentString.equals("snacks")){
					snack.add(fridgeItem);
				}
				}
			}
		}
	scan.close();
	}
	
}

	