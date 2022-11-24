

public class Roles<T> {
	
	
	
	public void StorageChief( int i,T newItem,IWarehouse<Bed> bedwarehouse,IWarehouse<Bookcase> bookcasewarehouse,IWarehouse<Chair> chairwarehouse,IWarehouse<Dresser> dresserwarehouse,IWarehouse<Sofa> sofawarehouse,IWarehouse<Table> tablewarehouse) {
	
		if (newItem != null) {
			
		String string = ((T) newItem).toString();		
		switch (string){
	        case "Bed": 
	            bedwarehouse.push((Bed) newItem);
	            if (bedwarehouse.getTopIndex()+1==20) {
		            ((Bed) newItem).setSuccess(false);
	            }
	            else {((Bed) newItem).setSuccess(true);}
	            
	            if (((Bed) newItem).isStored() ) {
	            	System.out.println(i+". Storage Chief storing "+string+", SUCCESS, "+string+" stored in "+ string +" warehouse");
	            }
	            else {
	            	System.out.println(i+". Storage Chief storing "+string+", FAIL, "+string+" can not be stored in "+string+" warehouse");
	            }
	            break;
	        case "Bookcase":
	            bookcasewarehouse.push((Bookcase) newItem);
	            if (bookcasewarehouse.getTopIndex()+1==20) {
		            ((Bookcase) newItem).setSuccess(false);
	            }
	            else {((Bookcase) newItem).setSuccess(true);}
	            
	            if (((Bookcase) newItem).isStored() ) {
	            	System.out.println(i+". Storage Chief storing "+string+", SUCCESS, "+string+" stored in "+ string +" warehouse");
	            }
	            else {
	            	System.out.println(i+". Storage Chief storing "+string+", FAIL, "+string+" can not be stored in "+string+" warehouse");
	            }
	            break;
	           
	        case "Chair":
	            chairwarehouse.push((Chair) newItem);
	            if (chairwarehouse.getTopIndex()+1==20) {
		            ((Chair) newItem).setSuccess(false);
	            }
	            else {((Chair) newItem).setSuccess(true);}
	            if (((Chair) newItem).isStored() ) {
	            	System.out.println(i+". Storage Chief storing "+string+", SUCCESS, "+string+" stored in "+ string +" warehouse");
	            }
	            else {
	            	System.out.println(i+". Storage Chief storing "+string+", FAIL, "+string+" can not be stored in "+string+" warehouse");
	            }
	           
	            break;
	            
	        case "Dresser":
	            dresserwarehouse.push((Dresser) newItem);
	            
	            if (dresserwarehouse.getTopIndex()+1==20) {
		            ((Dresser) newItem).setSuccess(false);
	            }
	            else {((Dresser) newItem).setSuccess(true);}
	            if (((Dresser) newItem).isStored() ) {
	            	System.out.println(i+". Storage Chief storing "+string+", SUCCESS, "+string+" stored in "+ string +" warehouse");
	            }
	            else {
	            	System.out.println(i+". Storage Chief storing "+string+", FAIL, "+string+" can not be stored in "+string+" warehouse");
	            }
	            break;
	        case "Sofa":
	            sofawarehouse.push((Sofa) newItem);
	            
	            if (sofawarehouse.getTopIndex()+1==20) {
		            ((Sofa) newItem).setSuccess(false);
	            }
	            else {((Sofa) newItem).setSuccess(true);}
	          
	            if (((Sofa) newItem).isStored() ) {
	            	System.out.println(i+". Storage Chief storing "+string+", SUCCESS, "+string+" stored in "+ string +" warehouse");
	            }
	            else {
	            	System.out.println(i+". Storage Chief storing "+string+", FAIL, "+string+" can not be stored in "+string+" warehouse");
	            }
	            break;
	            
	        case "Table":
	            tablewarehouse.push((Table) newItem);
	            if (tablewarehouse.getTopIndex()+1==20) {
		            ((Table) newItem).setSuccess(false);
	            }
	            else {((Table) newItem).setSuccess(true);}

	            if (((Table) newItem).isStored() ) {
	            	System.out.println(i+". Storage Chief storing "+string+", SUCCESS, "+string+" stored in"+ string +" warehouse");
	            }
	            else {
	            	System.out.println(i+". Storage Chief storing "+string+", FAIL, "+string+" can not be stored in "+string+" warehouse");
	            }
	            break;
	            
			}
		
		
		}
		
		else {System.out.println(i+". Storage Chief can not store any product, FAIL, factory line is empty!");}

	}

	
	

	public boolean Customer(int i,T newItem,IWarehouse<Bed> bedwarehouse,IWarehouse<Bookcase> bookcasewarehouse,IWarehouse<Chair> chairwarehouse,IWarehouse<Dresser> dresserwarehouse,IWarehouse<Sofa> sofawarehouse,IWarehouse<Table> tablewarehouse) {
		String string = ((T) newItem).toString();
		Object item = new  Object();
			
		switch (string){
        case "Bed": 
            item = bedwarehouse.pop();
            if(item != null) {((Bed) newItem).setSuccess(true);}
            else {((Bed) newItem).setSuccess(false);}

            if (((Bed) newItem).isSold() ) {
           
            	System.out.println(i+". Customer buying "+ string+", SUCCESS, customer bought "+string);
            }
            else {System.out.println(i+". Customer buying "+ string+", FAIL, "+string +" warehouse empty");}
            break;
            
        case "Bookcase":
            item = bookcasewarehouse.pop();
            if(item != null) {((Bookcase) newItem).setSuccess(true);}
            else {((Bookcase) newItem).setSuccess(false);}
            if (((Bookcase) newItem).isSold() ) {
          
            	System.out.println(i+". Customer buying "+ string+", SUCCESS, customer bought "+string);
            }
            else {
            	System.out.println(i+". Customer buying "+ string+", FAIL, "+string +" warehouse empty");
            }
            break;
           
            
        case "Chair":
            item = chairwarehouse.pop();
            if(item != null) {((Chair) newItem).setSuccess(true);}
            else {((Chair) newItem).setSuccess(false);}
            if (((Chair) newItem).isSold() ) {
            
            	System.out.println(i+". Customer buying "+ string+", SUCCESS, customer bought "+string);
            }
            else {
            	System.out.println(i+". Customer buying  "+ string+", FAIL, "+string +" warehouse empty");
            }
            break;

          
            
        case "Dresser":
            item = dresserwarehouse.pop();
            if(item != null) {((Dresser) newItem).setSuccess(true);}
            else {((Dresser) newItem).setSuccess(false);}

            if (((Dresser) newItem).isSold() ) {
            
            	System.out.println(i+". Customer buying "+ string+", SUCCESS, customer bought "+string);
            }
            else {
            	System.out.println(i+". Customer buying "+ string+", FAIL, "+string +" warehouse empty");
            }
            break;
            
        case "Sofa":
            item = sofawarehouse.pop();
            if(item != null) {((Sofa) newItem).setSuccess(true);}
            else {((Sofa) newItem).setSuccess(false);}
            if (((Sofa) newItem).isSold() ) {
            
            	System.out.println(i+". Customer buying "+ string+", SUCCESS, customer bought "+string);
            }
            else {
            	System.out.println(i+". Customer buying "+ string+", FAIL, "+string +" warehouse empty");
            }
            break;
            
        case "Table":
            item = tablewarehouse.pop();
            if(item != null) {((Table) newItem).setSuccess(true);}
            else {((Table) newItem).setSuccess(false);}
            if (((Table) newItem).isSold() ) {
            	
            	System.out.println(i+". Customer buying "+ string+", SUCCESS, customer bought "+string);
            }
            else {
            	System.out.println(i+". Customer buying "+ string+", FAIL, "+string +" warehouse empty");
            }
            break;
            
    }
		return true;

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void MarketingAnalyst(int i,T newProduct,IFactory<T> factory) {
		String name = newProduct.toString();
		boolean control = factory.enqueue(newProduct);
		switch (name) {
		case "Bed": 
			((Bed) newProduct).setSuccess(control);
            if (((Bed) newProduct).isManufactured() ) {
            	System.out.println(i+". Marketing Analyst requesting "+ name+", SUCCESS, "+ name+ " manufactured");
            }
            else {
            	System.out.println(i+". Marketing Analyst requesting "+ name+" ,FAIL, can not be manufacture "+ name+ " so sorry");
            }
            break;
            
		case "Bookcase": 
			((Bookcase) newProduct).setSuccess(control);
            if (((Bookcase) newProduct).isManufactured() ) {
            	System.out.println(i+". Marketing Analyst requesting "+ name+", SUCCESS, "+ name+ " manufactured");
            }
            else {
            	System.out.println(i+". Marketing Analyst requesting "+ name+", FAIL, can not be manufacture "+ name+ " so sorry");
            }
            break;
		case "Chair": 
			((Chair) newProduct).setSuccess(control);
            if (((Chair) newProduct).isManufactured() ) {
            	System.out.println(i+". Marketing Analyst requesting "+ name+", SUCCESS, "+ name+ " manufactured");
            }
            else {
            	System.out.println(i+". Marketing Analyst requesting "+ name+", FAIL, can not manufacture "+ name+ " so sorry");
            }
            break;
		case "Dresser": 
			((Dresser) newProduct).setSuccess(control);
            if (((Dresser) newProduct).isManufactured() ) {
            	System.out.println(i+". Marketing Analyst requesting "+ name+", SUCCESS, "+ name+ " manufactured");
            }
            else {
            	System.out.println(i+". Marketing Analyst requesting "+ name+", FAIL, can not manufacture "+ name+ " so sorry");
            }
            break;
		case "Table": 
			((Table) newProduct).setSuccess(control);
            if (((Table) newProduct).isManufactured() ) {
            	System.out.println(i+". Marketing Analyst requesting "+ name+", SUCCESS, "+ name+ " manufactured");
            }
            else {
            	System.out.println(i+". Marketing Analyst requesting "+ name+", FAIL, can not manufacture "+ name+ " so sorry");
            }
            break;
		case "Sofa": 
			((Sofa) newProduct).setSuccess(control);
	        if (((Sofa) newProduct).isManufactured() ) {
	        	System.out.println(i+". Marketing Analyst requesting "+ name+", SUCCESS, "+ name+ " manufactured");
	        }
	        else {
	        	System.out.println(i+". Marketing Analyst requesting "+ name+", FAIL, can not manufacture "+ name+ " so sorry");
	        }
        	break;
	}
	}
}


