
public class Cake extends Desserts{
	

	// Attributes:
	private int numOfLayers;


	// Constructor:
	public Cake(int id, String flavor, char size, int numL , int Q) {

		super(id, flavor, size , Q);

		
		if(numL > 0)
			numOfLayers = numL;
		else
			numOfLayers = 1;
	}

	public Cake(Cake obj) { // Copy Constructor

		super(obj.id, obj.flavor, obj.size , obj.Quantity);
		numOfLayers = obj.numOfLayers;
	}

	// Methods:
	public double calculateCost() {

		double cost = 0;

		switch (size) {

		case 's':
		case 'S':// small size
			
			cost += (30 * numOfLayers* Quantity);
			
			break;

		case 'm':
		case 'M':// medium size
			cost += (40 * numOfLayers* Quantity);

			break;

		case 'l':
		case 'L':// large size
			cost += (50 * numOfLayers*Quantity);
			

		}
		
		return cost;
	}

	public String toString() {

		return super.toString()+"Number of Cake Layers : " + numOfLayers + "\nCake's ingredients Cost : " + calculateCost() + " (SAR)\n";

	}

	
}//end class
