import java.util.*;


public class Simulation {
	
	Simulation nextSimulation;
	int waitingtime;	
	IList<Process> processList = new ProcessList<>();
	PriorityQueue<Computation> queue = new PriorityQueue<>();
	Random random = new Random();
	
	int counterHigh,counterNormal,counterLow=0;
	int counterHighTime,counterNormalTime,counterLowTime=0;
	
	public void setSimulation(Simulation simu) {
		nextSimulation=simu;}
	
	public void startSimulation(int a) {

		for(int i = 1; i<a+1 ;i++){
			String in = String.valueOf(i);
			IProcess process = new Process("P"+in,random.nextInt(3)+1);
			processList.add((Process) process);}
		
		for(int i = 0; i<a ;i++){
			queue.add(new Computation(processList.remove(0),random.nextInt(10)+1,random.nextInt(1000)+1));
		}		
		
		queue.display();
		
		Computation previousComputation = queue.dequeue();
	    String firstProcessType = previousComputation.getProcess().getType();
		int firstPriority= previousComputation.getProcess().getPriority();
		if(firstPriority==1) {counterHigh++;}
		else if(firstPriority==2) {counterNormal++;}		
		else if(firstPriority==3) {counterLow++;}
		
		/* We take one computation before the loop and assign it to a variable 
		so that we can compare it to the following computations  */


		for(int i = 2; i<a+1 ;i++) {
			Computation Computation = queue.dequeue();
			int q = Computation.getProcess().getPriority();	
			// We checked the priority of Computation that comes after the previousComputation.
			if(q==1){

				
				counterHigh+=1;
				if(previousComputation.getProcess().getType()== Computation.getProcess().getType()) {
					//if previousComputation's type is equal to Computation; 
					//we added previous one's occupation time to high's waiting time
					counterHighTime+=previousComputation.getOccupation();
				}
				counterLowTime+=previousComputation.getOccupation();
				counterNormalTime+=previousComputation.getOccupation();
				}
			
			else if(q==2){ 
				counterNormal+=1;
				if(previousComputation.getProcess().getPriority()<3) {
					// As we mentioned in line 51-52; we also looked for that situation here.
					counterNormalTime+=previousComputation.getOccupation();
				}
				counterLowTime+=previousComputation.getOccupation();
				}
			
			else if(q==3){
				counterLow+=1;
				if(previousComputation.getProcess().getType()== Computation.getProcess().getType()) {
					// As we mentioned in line 51-52; we also looked for that situation here.
					counterLowTime+=previousComputation.getOccupation();
					waitingtime+= previousComputation.getOccupation();
					continue;
				}
				counterLowTime+=previousComputation.getOccupation();}
				
			waitingtime+= previousComputation.getOccupation();
			
			
			
			//For the loop's continuation ; we assigned  Computation to previousComputation
			// And we took a new Computation from queue and assigned it to Computation :]
			previousComputation=Computation;
		}
		display(a,firstProcessType);
	}
	
	
	public void display(int a,String firstprocesstype ) {
		//    
		// We printed results  as integers or floats  by checking the remainders.
		//
		System.out.println("Total numbers of computations : "+a+"\n");		
		Float f1 =  (float) waitingtime/a;  
	    System.out.println("Total waiting time:"+waitingtime);
		if(waitingtime % a == 0 ) {
			System.out.println("Average waiting time :"+f1.intValue()+"\n");}
		else {
			System.out.println("Average waiting time:"+f1+"\n");
		}

		System.out.println("Total number of computations for High:"+counterHigh);
		System.out.println("Total number of computations for Normal:"+counterNormal);
		System.out.println("Total number of computations for Low:"+counterLow+"\n");
		
		if(counterHigh!=0) {
			if(counterHigh==1 &&  firstprocesstype == "High,") {counterHighTime=0;}
			System.out.println("Total waiting time for High:"+counterHighTime);
			Float f =  (float) counterHighTime/counterHigh;  
			if(counterHighTime % counterHigh == 0 ) {
				System.out.println("Average waiting time for High:"+f.intValue()+"\n");}
			else {
				System.out.println("Average waiting time for High:"+f+"\n");
			}
			
		}
		else {		System.out.println("Total waiting time for High:"+0);
			System.out.println("Average waiting time for High:"+0+"\n");}
		if(counterNormal!=0) {
			if(counterNormal==1 &&  firstprocesstype == "Normal,") {counterNormalTime=0;}
			System.out.println("Total waiting time for Normal:"+counterNormalTime);

			Float f =  (float) counterNormalTime/counterNormal;  
			if(counterNormalTime % counterNormal == 0 ) {
				System.out.println("Average waiting time for Normal:"+f.intValue()+"\n");}
			else {
				System.out.println("Average waiting time for Normal:"+f+"\n");
			}
		}
		else {		System.out.println("Total waiting time for Normal:"+0);
			System.out.println("Average waiting time for Normal:"+0+"\n");}
		
		if(counterLow!=0) {
			if(counterLow==1 &&  firstprocesstype == "Low,") {counterLowTime=0;}
			System.out.println("Total waiting time for Low:"+counterLowTime);

			Float f =  (float) counterLowTime/counterLow;  
			if(counterLowTime % counterLow == 0 ) {
				System.out.println("Average waiting time for Low:"+f.intValue()+"\n");}
			else {
				System.out.println("Average waiting time for Low:"+f+"\n");
			}
		}
		else {	System.out.println("Total waiting time for Low:"+0);
			System.out.println("Average waiting time for Low:"+0+"\n");}
	}}































