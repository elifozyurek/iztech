import java.io.*;
import java.util.Scanner;


public class FileIO {
	public static InventoryBag<Item> readInventory() throws FileNotFoundException {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		InventoryBag<Item> inventoryBag = new InventoryBag();
		try {

			File myObj = new File("inventory.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] words = data.split(",");
				String item_name = words[0];
				String item_compartment = words[1];
                int item_weight=Integer.parseInt(words[2]);
                Item item = new Item(item_name, item_compartment,item_weight);
				inventoryBag.add(item);
				
			}
			myReader.close();
		} catch (Exception e) {
			System.out.println("An error occured.");
		}
		return (InventoryBag<Item>) inventoryBag;

		
		

	}
	
}