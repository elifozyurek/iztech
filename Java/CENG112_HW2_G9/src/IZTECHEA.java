// Ceren Çaðlayan 270201059
// Elif Özyürek 280201079

import java.util.Random;
import java.util.Scanner;

public class IZTECHEA { 
	
	public static void main(String[] args) {
		IProduct bed = new Bed("Bed");
		IProduct sofa = new Sofa("Sofa");
		IProduct chair = new Chair("Chair");
		IProduct dresser = new Dresser("Dresser");
		IProduct table = new Table("Table");
		IProduct bookcase = new Bookcase("Bookcase");

		IWarehouse<Bed> bedwarehouse = new Warehouse<>(); 		
		IWarehouse<Chair> chairwarehouse = new Warehouse<>();
		IWarehouse<Dresser> dresserwarehouse = new Warehouse<>();
		IWarehouse<Sofa> sofawarehouse = new Warehouse<>();
		IWarehouse<Table> tablewarehouse = new Warehouse<>();
		IWarehouse<Bookcase> bookcasewarehouse = new Warehouse<>();		
		
		Roles<Object> role  = new Roles<>();
		
		IFactory<Object> factory = new Factory<>();

		Scanner scanner = new Scanner(System.in);
		

		System.out.println("Enter the number of random request cycles:");
		
		int input = scanner.nextInt();
		for(int i=1;i<input+1;i++) {
			Object[] products = {bed,bookcase,sofa,chair,dresser,table};
			Random random = new Random();
			int number1 = random.nextInt(6);
			Object product = products[number1];	
			int number2 = random.nextInt(3);
			switch (number2) {
				case 0:
					role.MarketingAnalyst(i,product, factory);
					break;
				case 1:
					Object product1 = factory.getFront();
					factory.dequeue();
					role.StorageChief(i,product1, bedwarehouse, bookcasewarehouse, chairwarehouse, dresserwarehouse, sofawarehouse, tablewarehouse);
					break;
				case 2 :
					role.Customer(i,product, bedwarehouse, bookcasewarehouse, chairwarehouse, dresserwarehouse, sofawarehouse, tablewarehouse);
					break;}}
		
		System.out.println("\nREPORT:\n");
		factory.display();
		
		System.out.println("\nAmount of Bed in Bed Warehouse:"+bedwarehouse.getTopIndex());
		System.out.println("Amount of Bookcase in Bookcase Warehouse:"+bookcasewarehouse.getTopIndex());
		System.out.println("Amount of Chair in Chair Warehouse:"+chairwarehouse.getTopIndex());
		System.out.println("Amount of Dresser in Dresser Warehouse:"+dresserwarehouse.getTopIndex());
		System.out.println("Amount of Sofa in Sofa Warehouse:"+sofawarehouse.getTopIndex());
		System.out.println("Amount of Table in Table Warehouse:"+tablewarehouse.getTopIndex());
		
		System.out.println("\nAmount of Bed Sold:"+bedwarehouse.getSoldCount());
		System.out.println("Amount of Bookcase Sold:"+bookcasewarehouse.getSoldCount());
		System.out.println("Amount of Chair Sold:"+chairwarehouse.getSoldCount());
		System.out.println("Amount of Dresser Sold:"+dresserwarehouse.getSoldCount());
		System.out.println("Amount of Sofa Sold:"+sofawarehouse.getSoldCount());
		System.out.println("Amount of Table Sold:"+tablewarehouse.getSoldCount());		
		scanner.close();
	} 
}