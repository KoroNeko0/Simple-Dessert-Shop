
package projectphase2;
import java.io.*;
import java.util.Scanner;

import javax.swing.JOptionPane;
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
				SaveFile();//save in file
				JOptionPane.showMessageDialog(null, "Cookie is Added and Saved Succssefuly");
				return;
				
			} else if (d instanceof Cake) {
				itemsList[numOfDesserts++] = new Cake((Cake) d);
				SaveFile();//save in file
				JOptionPane.showMessageDialog(null, "Cake is Added and Saved Succssefuly");
				return;
			}
			
		}

		JOptionPane.showMessageDialog(null, "Faild to add the Dessert");
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
                
		for (int i = index; i < numOfDesserts; i++) {

			for (int j = i; j < numOfDesserts - 1; j++) {

				itemsList[j] = itemsList[j + 1];

			}
		} // end shifting
		
		itemsList[--numOfDesserts] = null;
		SaveFile();
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

				str += "Dessert : " + itemsList[i].getClass().getSimpleName()+ "\n" + itemsList[i].toString() + "\n";

			}
		}else
			str +="\n\nThere's no Items in the Shop yet.\n";
		
		return str;

	}
	
	public void SaveFile() {
		
		try {
		File f = new File("StoreInfo.txt");
		FileOutputStream fo = new FileOutputStream(f);
		PrintWriter pr = new PrintWriter(fo);
		
		pr.println( toString() +"\n");
		pr.println("--Total Cost : "+getTotalCost()+" (SAR)");
		
		pr.close();
		
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error While Saving the File!" , "WARNING" , JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public String LoadFile() {
		String ReadFile ="";
                
		try {
		File f = new File("StoreInfo.txt");
		FileInputStream fo = new FileInputStream(f);
		Scanner r = new Scanner(fo);
		
		while(r.hasNext()) {
			
			ReadFile += r.nextLine()+"\n";
		}
		return ReadFile;
                
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error While Saving the File!" , "WARNING" , JOptionPane.WARNING_MESSAGE);
		}
                return ReadFile;
	}
	

	public String getName() {
		return name;
	}

	public int getNumOfDesserts() {
		return numOfDesserts;
	}

}//end class
