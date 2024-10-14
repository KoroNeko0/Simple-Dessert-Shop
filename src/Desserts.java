
public abstract class Desserts extends ShopItems{
	
	//Attributes:
		protected String flavor;
		protected char size;
		protected int Quantity;
		
		//Constructor:
		public Desserts(int id , String flavor , char size , int Q) {
			
			super(id);
			this.flavor = flavor;
			if(size == 's' || size == 'S' || size == 'm' || size == 'M'|| size == 'l' || size =='L')
				this.size = size;			
			else
				this.size = 's';
			
			Quantity = Q;
		}
		
		//Methods:
		public String toString() {
			
			return super.toString() + "Flavor : "+flavor+"\nSize : "+size+"\n";
			
		}

		public String getFlavor() {
			return flavor;
		}
		
		
	
}//end class
