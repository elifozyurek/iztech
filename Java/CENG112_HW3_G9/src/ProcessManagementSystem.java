//270201059 Ceren Çaðlayan
//280201079 Elif Özyürek


public class ProcessManagementSystem {

	public static void main(String[] args) {

		System.out.println("Simulation Number: 1");
		Simulation simulation1 = new Simulation();
		simulation1.startSimulation(3);;
		
		System.out.println("Simulation Number: 2");
		Simulation simulation2 = new Simulation();
		simulation2.startSimulation(5);
		
		// Simulation2 and Simulation1 are linked
		// simulation1->simulation2
		simulation1.setSimulation(simulation2);
				
		System.out.println("Simulation Number: 3");
		Simulation simulation3 = new Simulation();
		simulation3.startSimulation(10);
		
		// Simulation2 and Simulation3 are linked
		// simulation1->simulation2->simulation3
		simulation2.setSimulation(simulation3);
		System.out.println();
		
		
		
		
	}	
}
                        