import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

	@SuppressWarnings({ "resource", "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) throws IOException {
	
		File file = new File("CENG112_HW4.csv");
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
	
		String satir = reader.readLine();
		satir = reader.readLine();
		BinarySearchTree<Node<Food>> aBinarySearchTree = new BinarySearchTree<>();
		BinarySearchTree<Node<Food>> bBinarySearchTree = new BinarySearchTree<>();
		BinarySearchTree<Node<Restaurant>> cBinarySearchTree = new BinarySearchTree<>();
		BinarySearchTree<Node<Restaurant>> dBinarySearchTree = new BinarySearchTree<>();
		while (satir!=null) {

		String[] itemArray = satir.split(",");
		Restaurant mamahane = new Restaurant(itemArray[3],Double.valueOf(itemArray[4]),itemArray[5],Integer.valueOf(itemArray[6]));
		Restaurant mamahane3 = new Restaurant(itemArray[3],Double.valueOf(itemArray[4]),itemArray[5],Integer.valueOf(itemArray[6]));
		Orderable mama = new Food(itemArray[0],Double.valueOf(itemArray[1]),Integer.valueOf(itemArray[2]),mamahane);
		Orderable mama1 = new Food(itemArray[0],Double.valueOf(itemArray[1]),Integer.valueOf(itemArray[2]),mamahane);
		Node<Food> kOkNode = new Node(mama,((Food) mama).priceString());
		Node<Food> kOkNode1 = new Node(mama,((Food) mama).stockString());
		Node<Restaurant> kOkNode2 = new Node(mamahane,((Restaurant)mamahane).deliveryTimeString());
		Node<Restaurant> kOOkNode3 = new Node(mamahane,((Restaurant)mamahane).ratingString());


		aBinarySearchTree.add(kOkNode);
		bBinarySearchTree.add(kOkNode1);
		cBinarySearchTree.add(kOkNode2);
		dBinarySearchTree.add(kOOkNode3);
		satir = reader.readLine();	
		
		
		}
		System.out.println("--------------1--------------");
		dBinarySearchTree.InOrderTraversalDescending();
		System.out.println("");

		System.out.println("--------------2--------------");
	    aBinarySearchTree.InOrderTraversalAscenging();
		System.out.println("");

		System.out.println("--------------3--------------");
		cBinarySearchTree.getMinimal();
		System.out.println("");

		System.out.println("--------------4--------------");
		bBinarySearchTree.getMinimal();
		System.out.println("");

		System.out.println("--------------5--------------");
		Iterator<Node<Food>> foodIteratorMain = new OurIterator<>(aBinarySearchTree.getRootNode());
		while (foodIteratorMain.hasNext()) {
			Node<Food> temporaryFood = foodIteratorMain.next();
			if ((temporaryFood.middle.getPrice() > 80)){
				 aBinarySearchTree.remove(temporaryFood);
			}		}
		aBinarySearchTree.showRemoval();
		System.out.println("");

		System.out.println("--------------6--------------");
		Iterator<Node<Restaurant>> restaurantIteratorMain = new OurIterator<>(dBinarySearchTree.getRootNode());
		while (restaurantIteratorMain.hasNext()) {
			Node<Restaurant> temporaryResraurant = restaurantIteratorMain.next();
			if ((temporaryResraurant.middle.getRating() < 8)){
				dBinarySearchTree.remove(temporaryResraurant);
			}		}
		dBinarySearchTree.showRemoval1();
		System.out.println("");

		System.out.println("--------------7--------------");
		Iterator<Node<Food>> foodIteratorMain1 = new OurIterator<>(aBinarySearchTree.getRootNode());
		while (foodIteratorMain1.hasNext()) {
			foodIteratorMain1.next().middle.updatePrice(20);

		}
		System.out.println("Prices in FoodBSTs are updated.");
		System.out.println("");

		System.out.println("--------------8--------------");
		Iterator<Node<Food>> foodIteratorMain2 = new OurIterator<>(aBinarySearchTree.getRootNode());
		while (foodIteratorMain2.hasNext()) {
			foodIteratorMain2.next().middle.updateStock(50);
			
		}
		System.out.println("Stocks in FoodBSTs are updated.");
		System.out.println("");

		System.out.println("--------------9--------------");

		dBinarySearchTree.InOrderTraversalDescending();
		System.out.println("");


		System.out.println("--------------10--------------");
	    aBinarySearchTree.InOrderTraversalAscenging();

		System.out.println("");

		
		reader.close();
		
		
	}}


