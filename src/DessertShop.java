
public class DessertShop {

	// Attributes:
	private String name;
	private int numOfDesserts;
	private ShopItems[] itemsList;
	private Manager ManagerInfo;

	// Constructor:
	public DessertShop(String shopName, int size, String managerName, int years) {

		name = shopName;
		itemsList = new ShopItems[size];
		numOfDesserts = 0;
		ManagerInfo = new Manager(managerName, years);
	}

	// Methods:

	public void AddDessert(Desserts d) {
		boolean isIdExist = true;
		
		for(int i = 0 ; i < numOfDesserts ; i++) {
			if(itemsList[i].getId() == d.getId()) {
				isIdExist = false;
			}
		}
		
		
		if (numOfDesserts < itemsList.length && isIdExist) {

			if (d instanceof Cookie) {
				itemsList[numOfDesserts++] = new Cookie((Cookie) d);
				System.out.println("Cookie is Added Succssefuly");
				return;
			} else if (d instanceof Cake) {
				itemsList[numOfDesserts++] = new Cake((Cake) d);
				System.out.println("Cake is Added Succssefuly");
				return;
			}

		}

		System.out.println("Faild to Add the Dessert");
	}

	public double getTotalCost() {

		double total = 0;

		for (int i = 0; i < numOfDesserts; i++) {

			total += itemsList[i].calculateCost();

		}
		return total;
	}

	public boolean DeleteDessert(int id) {

		int index = SearchItem(id);

		if (index == -1)
			return false;

		// shifting part(Items has been found):

		for (int i = 0; i < numOfDesserts; i++) {

			for (int j = i; j < numOfDesserts - 1; j++) {

				itemsList[j] = itemsList[j + 1];

			}
		} // end shifting
		itemsList[--numOfDesserts] = null;
		return true;

	}

	public int SearchItem(int id) {

		for (int i = 0; i < numOfDesserts; i++) {

			if (itemsList[i].getId() == id)
				return i;// item has been found

		}

		return -1; // Item is not found
	}

	public Desserts[] getListFlavor(String flavor) {

		Desserts[] fList = new Desserts[numOfDesserts];
		
		int j = 0;
		
		for (int i = 0; i < numOfDesserts; i++) {

			if (((Desserts) itemsList[i]).getFlavor().equalsIgnoreCase(flavor))
				fList[j++] = (Desserts) itemsList[i];
		}
		
		if(j == 0)
			return null;
		else
		return fList;
	}

	public String toString() {

		String str = "\n===================== Shop's Information =====================\n--Shop's Name: " + name + "\n";
		str += "--Manager's Info:\n" + ManagerInfo.toString();

		str += "--Shop Item's Infomation:\nTotal Number Of Desserts : " + numOfDesserts;

		if (numOfDesserts >= 1) {
			str += "\n\n>> All Desserts List <<\n";
			for (int i = 0; i < numOfDesserts; i++) {

				str += "Dessert : " + itemsList[i].getClass().getName() + "\n" + itemsList[i].toString() + "\n";

			}
		}
		return str;

	}

	public String getName() {
		return name;
	}

	public int getNumOfDesserts() {
		return numOfDesserts;
	}

}
