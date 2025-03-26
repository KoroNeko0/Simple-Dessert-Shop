
package projectphase2;

public class Manager {
        
         //Attributes:
	private String name;
	private int years;
	
	//Constructor:
	public Manager(String name , int years) {
		
		this.name = name;
		this.years = years;
		
	}
	
	public String toString() {
		
		return "Shop's Manager Name : "+name +"\nAge : "+years+" years\n\n";
	}
	
    
    
}//end class
