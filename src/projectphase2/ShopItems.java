
package projectphase2;

public abstract class ShopItems {
    	//Attributes:
		protected int id;
		
		//Constructor:
		public ShopItems(int id) {
			
			this.id = id;
		}
		//Methods:
		public abstract double calculateCost();
		
		public String toString() {
			
			return "item's ID : "+id+"\n";
			
		}
		public int getId() {
			return id;
		}
}//end class
