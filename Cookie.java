
package projectphase2;

public class Cookie extends Desserts{
    // Attributes:
	private boolean withChocoChips;

	// Constructor:
	public Cookie(int id, String flavor, char size, boolean wChoco , int Q) {

		super(id, flavor, size , Q);
		withChocoChips = wChoco;

	}
	
	public Cookie( Cookie obj) { //Copy Constructor
		
		super (obj.id , obj.flavor , obj.size , obj.Quantity);
		withChocoChips = obj.withChocoChips;
	}

	// Methods:
	public double calculateCost() { 
			
		double cost = 0;
		

		switch(size) {

		case 'S':
		case 's': //small size
			
			cost += 15 * Quantity;
			if(withChocoChips)
				cost += 5;
			
			break;

		case 'l':
		case 'L': // large size
			
			cost += 30 * Quantity;
			if(withChocoChips)
				cost += 5;
		
		
		
		}
		
		return cost;
		
	}
	
	public String toString() {
	
		
		return super.toString() + "Cookie's ingredients Cost : "+ calculateCost()+" (SAR)\n";
		
	}
	
	
}//end class
