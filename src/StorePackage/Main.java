package StorePackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		OnlineStoreStateManager storeManager = new OnlineStoreStateManager();
		OnlineStore store = OnlineStore.getInstance();
		UserIO userIO = UserIO.getInstance();
		Scanner s = new Scanner(System.in);
		boolean exit = false;
		do {
			System.out.println("==== Menu ====");
			System.out.println("(4.1): 1) Load products to store.");
			System.out.println("(4.2): 2) Add new Products.");
			System.out.println("(4.3): 3) Remove a Product.");
			System.out.println("(4.4): 4) Edit the stock of a Product.");
			System.out.println("(4.5): 5) Add an Order to a Product.");
			System.out.println("(4.6): 6) Undo the latest Order.");
			System.out.println("(4.7): 7) Print all details about a specific Product.");
			System.out.println("(4.8): 8) Print all the products in store with details.");
			System.out.println("(4.9): 9) Print all the orders details of a specific product.");
			System.out.println("(4.10): 10) Save currect state of the store.");
			System.out.println("(4.10): 11) Restore previous state of the store.");
			System.out.println("12) Exit.");
			
			String input = s.nextLine();

			int choice = Integer.parseInt(input);

			switch (choice) {
			case 1:
				// auto loading
				store.loadProductsAndOrdersToStore();
				System.out.println("Loading done successfully.");
				break;
				
			case 2:
				//Add new product to stock with unique code
				if(store.addNewProductToStore(userIO.getNewProductDetails(store)))
					System.out.println("Product added successfully");
				else 
					System.out.println("Product already exists");
				
				break;
				
			case 3:
				//Remove product from stock by code
				if(store.getProducts().size() != 0) {
				System.out.println(userIO.printAllProductsInStore(store.getProducts(), false));
				if(store.removeProductFromStore(userIO.getCodeOfProduct("")))
					System.out.println("Product removed successfully");
				else 
					System.out.println("Product doesn't exist");
				} else
					System.out.println("No products yet, add products first.");
				break;
				
			case 4:
				//Edit quantity of a product in stock.
				if(store.getProducts().size() != 0) {
					System.out.println(userIO.printAllProductsInStore(store.getProducts(), false));
					String code = userIO.getCodeOfProduct("");
					int quantity = userIO.getNewQuantity();
					if(store.editQuantityOfProduct(code, quantity))
						System.out.println("Stock added successfully.");
					else System.out.println("Product doesn't exist.");
				} else
					System.out.println("No products yet, add products first.");
				break;
				
			case 5:
				//Add new order
				if(store.getProducts().size() != 0) {
					Order o = store.addNewOrderToProduct(userIO.getNewOrderDetails(store.getProducts()));
					if(o != null) {
						System.out.println("Order added successfully.");
					} else {
						System.out.println("Something went wrong, order wasn't added.");
					}
				} else {
					System.out.println("No products yet, add products first.");
				}
				break;
				
			case 6:
				// undo latest order
				if(store.undoLastOrder())
					 System.out.println("The order successfully cancelled");
				else
					System.out.println("Failed to undo order: no orders to cancel.");
				break;
				
			case 7:
				// print product with details
				userIO.printAllDetailsOfASpecificProduct(store.getProducts());
				break;
				
			case 8:
				//Print all products with order details.
				System.out.println(userIO.printAllProductsInStore(store.getProducts(), true));
				break;
				
			case 9:
				// print all orders of a specific product.
				userIO.printOrdersOfSpecificProduct(store.getProducts());
				break;
				
			case 10:
				// save current state of store.
				storeManager.saveState(store);
                System.out.println("Current state of the store saved.");
				break;
				
			case 11:
				// restore previous state of the store
				storeManager.restoreState(store);
                System.out.println("Store state restored successfully.");
                break;
				
			case 12:
				System.out.println("Bye Bye!");
				exit = true;
				break;
				
			default:
				System.out.println("Wrong choise! Try again!");
				break;
			}

		} while (!exit);
		
		s.close();

	}

}
