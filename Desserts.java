
package projectphase2;

public abstract class Desserts extends ShopItems{
                 //Attributes:
		protected String flavor;
		protected char size;
		protected int Quantity;
		
		//Constructor:
		public Desserts(int id , String flavor , char size , int Q) {
			
			super(id);
			this.flavor = flavor;
			this.size = size;
			
			Quantity = Q;
		}
		
		//Methods:
		public String toString() {
			
			return super.toString() + "Flavor : "+flavor+"\nSize : "+size+"\nQuantity : "+Quantity+"\n";
			
		}

		public String getFlavor() {
			return flavor;
		}
		
		
	
}//end class
