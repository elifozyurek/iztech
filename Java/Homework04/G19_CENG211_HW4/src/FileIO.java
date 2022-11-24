import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

	private ArrayList<Rental> individualList = new ArrayList<>();
	private ArrayList<Rental> commercialList = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public <T> void read() throws FileNotFoundException {
		
		Scanner keyboardScanner = new Scanner(new File("HW4_Rentals.csv"));
		String line;
	
		while (keyboardScanner.hasNextLine()) {

			line = keyboardScanner.nextLine();
			String[] data = line.split(",");
			if(data.length<=1) continue;
			String customerType = data[0];
							
				try {
					if(customerType.equals("Individual")) {
						
						T id = (T) data[1];
						char[] chars = id.toString().toCharArray();
						boolean isMember = (chars[0] == 'M') ?  true: false;
						
						for (int i = 0; i<chars.length;i++) {
							if(isMember) {
								if(i==0) continue;
								if(  !(  chars.length==12 && Character.isDigit(chars[i])  ) )   {
									throw new IndividualIdNotValidException();
								}
							}
							else {
								if(  !(  chars.length==11 && Character.isDigit(chars[i])  ) )   {
									throw new IndividualIdNotValidException();
								}
							}	
						}
						
						//after checking id validation, we can finally create our objects.
						ICustomer customer=null;
						if(isMember) {
							customer = new IndividualCustomer<String>((String) id, isMember);
						}
						else {
							long newId = Long.parseLong(data[1]);
							customer = new IndividualCustomer<Long>((long) newId, isMember);
						}
						
						Rental individalRental = new IndividualRental(data[3],
								Integer.parseInt(data[4]), Double.parseDouble(data[5]), 
								Integer.parseInt(data[2]), customer);
						
						individualList.add(individalRental);
					
					}
					
					else {
						String id = data[1]; 
						if(id.length()!=8) throw new CommerciallIdNotValidException(); 
						char[] chars = id.toString().toCharArray();
						
						for (int i = 0; i<chars.length;i++) {
							if(i==0) {
								if( !(Character.isLetter(chars[0])) ) {
									
									throw new CommerciallIdNotValidException(); 
								}
							}
							else {
								if( !(Character.isDigit(chars[i])) ) {
									
									throw new CommerciallIdNotValidException();
								}
							}		
							
						}
						
						
						ICustomer customer = new CommercialCustomer(id);
						Rental comRental = new CommercialRental(
								data[3], Integer.parseInt(data[4]), Double.parseDouble(data[5]),
								Integer.parseInt(data[2]), customer);
						
						commercialList.add(comRental);
						
					}

				}

				catch (IndividualIdNotValidException e) {
					System.out.println(e.getMessage());
				}
				catch (CommerciallIdNotValidException e) {
					System.out.println(e.getMessage());
				}

			}
		
	
	}
	
	public ArrayList<Rental> getCommercialList() {
		return commercialList;
	}
	
	public ArrayList<Rental> getIndividualList() {
		return individualList;
	}
	
}
