import java.util.*;

public class DemoShop {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		//Creating a shop:
		System.out.println("Manager's Name:");
		String managerName = in.nextLine();

		System.out.println("Enter Manager's Age:");
		int age = in.nextInt();

		System.out.println("Enter Shop's Name:");
		in.nextLine();
		String shopName = in.nextLine();

		System.out.println("Enter Maximum number of Items in the Shop:");
		int size = in.nextInt();

		DessertShop shop = new DessertShop(shopName, size, managerName, age);
		
		
		int choice1;

		do {// Shop Management Menu Starts from here

			System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=- " + shop.getName() + " Shop Management Menu =-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println(">>> Please Choose from the menu <<<");
			System.out.println("1.Add a Dessert to the Shop");
			System.out.println("2.Display all Information of the Shop");
			System.out.println("3.Delete a Dessert from the Shop");
			System.out.println("4.Show Total Cost of all Items in the Shop");
			System.out.println("5.Print list of all Desserts with a specific flavor");
			System.out.println("6.Exit");
			choice1 = in.nextInt();

			switch (choice1) {

			case 1:// Add
				
				if(shop.getNumOfDesserts() == size) {
				System.out.println("\nthe Shop is full");
				break;
				}
				
				int choice2;
				
				do {
					
					if(shop.getNumOfDesserts() == size)
						
						break;
				
				System.out.println("\n>>>Choose a Dessert to be Added:<<<");
				System.out.println("1.Add a Cake");
				System.out.println("2.Add a Cookie");
				System.out.println("3.Return to menu");

				choice2 = in.nextInt();
				
				switch(choice2) {
				
				case 1://Add Cake
					
					System.out.println("\nEnter Cake's ID:");
					int id = in.nextInt();
					
					System.out.println("Enter Cake's Falvor :");
					String flavor = in.next();
					System.out.println("Enter Size (s)for Small , (m)for Medium , (L)for large:");
					char size1 = in.next().charAt(0);
					System.out.println("Enter Number of Layers of the Cake:");
					int layers = in.nextInt();
					System.out.println("Enter the Quantity:");
					int Quantity = in.nextInt();
					
					Desserts cake = new Cake(id , flavor , size1 , layers , Quantity);
					
					shop.AddDessert(cake);
					
					
					break;
					
				case 2://Add Cookie
					
					
					
					System.out.println("\nEnter Cookie's ID:");
					id = in.nextInt();
					System.out.println("Enter Cookie's Falvor :");
					flavor = in.next();
					System.out.println("Enter Size (s)for Small , (L)for large:");
					size1 = in.next().charAt(0);
					System.out.println("Enter (yes) if you want to add Chocokate Chips otherwise Enter (no):");
					String answer = in.next();
					boolean withC;
					if(answer.equalsIgnoreCase("yes"))
					 withC = true;
					else
						withC = false;
						
					System.out.println("Enter the Quantity:");
					Quantity = in.nextInt();
					
					Desserts cookie = new Cookie(id , flavor , size1 , withC , Quantity);
					
					shop.AddDessert(cookie);
					
					break;
					
				case 3:
					System.out.println("Returning...");
					break;
					
				default:
					System.out.println("\nWrong Input ! Try again\n");

				}//end switch of Add
				
				
				}while(choice2 != 3);
				
				break;

			case 3:// delete
				
				if(shop.getNumOfDesserts() == 0) {
					System.out.println("\nThe shop is empty");
					break;
				}
				
				System.out.println("Enter Item's id to be deleted:");
				int idD = in.nextInt();
				
				if(shop.DeleteDessert(idD)) 
					System.out.println("Item is succssfuly Deleted");
				else
					System.out.println("Faild to be Deleted");
				
				
				break;
				
				
			case 4://Show TotalCost
				System.out.print("\nTotal Cost :");
				System.out.println(shop.getTotalCost() + " (SAR)");
				
				
				
				
				break;
				
			case 2://Display all info
				
				
				System.out.println(shop);
				
				if(shop.getNumOfDesserts() == 0)
					System.out.println("\nThere's no Items in the Shop yet.\n");
				
				break;
				
				
			case 5://print list of flavor
				
				
				System.out.println("Enter a flavor:");
				String flavorL = in.next();
				
				
				Desserts[] sort = shop.getListFlavor(flavorL);
				
				if(sort == null) {
					System.out.println("There's no Item with "+flavorL +" flavor");
				}else
				
				for(int i = 0 ; i < sort.length ;i++) {
					if(sort[i] != null)
					System.out.println("\nDessert : " + sort[i].getClass().getName() + "\n" + sort[i]);
					
				}
				
				break;
				
			case 6:
				
				System.out.println("Quiting...");
				
				break;
				
			default:
				System.out.println("\nWrong Input ! Try again\n");
				
			}// end Switch

		} while (choice1 != 6);

	}// end main

}// end class
