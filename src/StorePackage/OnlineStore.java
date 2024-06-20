package StorePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class OnlineStore implements OrderPublisher {
	private static OnlineStore instance;
	private Set<Product> products;
	private List<Order> allOrders;
	private List<OrderSubscriber> observers = new ArrayList<>();
	private int totalProfitOfStore;

	private OnlineStore() {
		this.products = new TreeSet<Product>();
		this.allOrders = new ArrayList<Order>();
		registerDeliveryCompany(new DHL(DeliveryType.EXPRESS_SHIPPING));
		registerDeliveryCompany(new DHL(DeliveryType.STANDARD_SHIPPING));
		registerDeliveryCompany(new Fedex(DeliveryType.EXPRESS_SHIPPING));
		registerDeliveryCompany(new Fedex(DeliveryType.STANDARD_SHIPPING));
	}

	public static OnlineStore getInstance() {
		if (instance == null) {
			instance = new OnlineStore();
		}
		return instance;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public List<Order> getAllOrders() {
		return allOrders;
	}

	public void setTotalProfitForStore(int profit) {
		this.totalProfitOfStore += profit;
	}

	public int getTotalProfitOfStore() {
		return totalProfitOfStore;
	}

	public void loadProductsAndOrdersToStore() {
		int cost;
		int sell;
		int profit;

		// Products:
		Product p1 = new SoldInStore("Iphone 13 pro", "ST-123", 3000, 4500, 10);
		Product p2 = new SoldInStore("Lg Smart Tv", "ST-234", 2000, 3000, 25);
		Product p3 = new SoldInStore("Airpods Pro", "ST-567", 2500, 4000, 15);

		Product p4 = new SoldInWholesalers("Sony Wireless Noise-Canceling Headphones", "SW-123", 800, 1225, 200);
		Product p5 = new SoldInWholesalers("Drunk Elephant Organic Retinol Serum", "SW-234", 80, 140, 500);
		Product p6 = new SoldInWholesalers("Fitbit Charge 5 Fitness Tracker", "SW-453", 350, 455, 150);

		Product p7 = new SoldThroughWebsite("Starbucks Reserve Gourmet Coffee Beans", "WB-087", 100, 140, 70, 2);
		Product p8 = new SoldThroughWebsite("Corsair Platinum Mechanical Gaming Keyboard", "WB-752", 250, 530, 20, 4);
		Product p9 = new SoldThroughWebsite("Philips Remote Color Ambiance Smart LED Bulb", "WB-183", 80, 105, 17, 5);

		addNewProductToStore(p1);
		addNewProductToStore(p2);
		addNewProductToStore(p3);
		addNewProductToStore(p4);
		addNewProductToStore(p5);
		addNewProductToStore(p6);
		addNewProductToStore(p7);
		addNewProductToStore(p8);
		addNewProductToStore(p9);

		// Orders:

		// Orders for p1:
		Customer c1p1 = new Customer("Lior kapshitar", "0526325213");
		Invoice ic1p1 = new InvoiceForCustomer(p1.getSelling_price());
		Invoice ia1p1 = new InvoiceForAccountant(p1.getSelling_price(), p1.getCost_price());
		Order o1p1 = new StoreOrder(c1p1, 1, "ORD_ST_123", p1, ic1p1, ia1p1);
		addNewOrderToProduct(o1p1);
		cost = p1.getCost_price();
		sell = p1.getSelling_price();
		profit = (sell) - (cost);
		setTotalProfitForStore(profit);
		o1p1.setProfitFromOrder(profit);
		p1.setTotalProfitForProduct(profit);

		Customer c2p1 = new Customer("Almog Hevroni", "0538667915");
		Invoice ic2p1 = new InvoiceForCustomer(p1.getSelling_price() * 2);
		Invoice ia2p1 = new InvoiceForAccountant(p1.getSelling_price() * 2, p1.getCost_price() * 2);
		Order o2p1 = new StoreOrder(c2p1, 2, "ORD_ST_854", p1, ic2p1, ia2p1);
		addNewOrderToProduct(o2p1);
		profit = (sell * 2) - (cost * 2);
		setTotalProfitForStore(profit);
		o2p1.setProfitFromOrder(profit);
		p1.setTotalProfitForProduct(profit);

		Customer c3p1 = new Customer("David Cohen", "0548726540");
		Invoice ic3p1 = new InvoiceForCustomer(p1.getSelling_price());
		Invoice ia3p1 = new InvoiceForAccountant(p1.getSelling_price(), p1.getCost_price());
		Order o3p1 = new StoreOrder(c3p1, 1, "ORD_ST_872", p1, ic3p1, ia3p1);
		addNewOrderToProduct(o3p1);
		profit = (sell) - (cost);
		setTotalProfitForStore(profit);
		o3p1.setProfitFromOrder(profit);
		p1.setTotalProfitForProduct(profit);

		// Orders for p2:
		Customer c1p2 = new Customer("Eli Sheva", "0543216789");
		Invoice ic1p2 = new InvoiceForCustomer(p2.getSelling_price());
		Invoice ia1p2 = new InvoiceForAccountant(p2.getSelling_price(), p2.getCost_price());
		Order o1p2 = new StoreOrder(c1p2, 1, "ORD_ST_235", p2, ic1p2, ia1p2);
		addNewOrderToProduct(o1p2);
		cost = p2.getCost_price();
		sell = p2.getSelling_price();
		profit = (sell) - (cost);
		setTotalProfitForStore(profit);
		o1p2.setProfitFromOrder(profit);
		p2.setTotalProfitForProduct(profit);

		Customer c2p2 = new Customer("Yael Abramov", "0527648391");
		Invoice ic2p2 = new InvoiceForCustomer(p2.getSelling_price() * 3);
		Invoice ia2p2 = new InvoiceForAccountant(p2.getSelling_price() * 3, p2.getCost_price() * 3);
		Order o2p2 = new StoreOrder(c2p2, 3, "ORD_ST_764", p2, ic2p2, ia2p2);
		addNewOrderToProduct(o2p2);
		profit = (sell * 3) - (cost * 3);
		setTotalProfitForStore(profit);
		o2p2.setProfitFromOrder(profit);
		p2.setTotalProfitForProduct(profit);

		Customer c3p2 = new Customer("Ori Shavit", "0527364859");
		Invoice ic3p2 = new InvoiceForCustomer(p2.getSelling_price() * 2); // Assuming the customer buys two TVs
		Invoice ia3p2 = new InvoiceForAccountant(p2.getSelling_price() * 2, p2.getCost_price() * 2);
		Order o3p2 = new StoreOrder(c3p2, 1, "ORD_ST_456", p2, ic3p2, ia3p2);
		addNewOrderToProduct(o3p2);
		profit = (sell * 2) - (cost * 2);
		setTotalProfitForStore(profit);
		o3p2.setProfitFromOrder(profit);
		p2.setTotalProfitForProduct(profit);

		// Orders for p3:
		Customer c1p3 = new Customer("Moran Atias", "0532145879");
		Invoice ic1p3 = new InvoiceForCustomer(p3.getSelling_price());
		Invoice ia1p3 = new InvoiceForAccountant(p3.getSelling_price(), p3.getCost_price());
		Order o1p3 = new StoreOrder(c1p3, 1, "ORD_ST_987", p3, ic1p3, ia1p3);
		addNewOrderToProduct(o1p3);
		cost = p3.getCost_price();
		sell = p3.getSelling_price();
		profit = (sell) - (cost);
		setTotalProfitForStore(profit);
		o1p3.setProfitFromOrder(profit);
		p3.setTotalProfitForProduct(profit);

		Customer c2p3 = new Customer("Tomer Russo", "0526987412");
		Invoice ic2p3 = new InvoiceForCustomer(p3.getSelling_price() * 2);
		Invoice ia2p3 = new InvoiceForAccountant(p3.getSelling_price() * 2, p3.getCost_price() * 2);
		Order o2p3 = new StoreOrder(c2p3, 2, "ORD_ST_654", p3, ic2p3, ia2p3);
		addNewOrderToProduct(o2p3);
		profit = (sell * 2) - (cost * 2);
		setTotalProfitForStore(profit);
		o2p3.setProfitFromOrder(profit);
		p3.setTotalProfitForProduct(profit);

		Customer c3p3 = new Customer("Neta Lee", "0543218624");
		Invoice ic3p3 = new InvoiceForCustomer(p3.getSelling_price() * 5);
		Invoice ia3p3 = new InvoiceForAccountant(p3.getSelling_price() * 5, p3.getCost_price() * 5);
		Order o3p3 = new StoreOrder(c3p3, 5, "ORD_ST_321", p3, ic3p3, ia3p3);
		addNewOrderToProduct(o3p3);
		profit = (sell * 5) - (cost * 5);
		setTotalProfitForStore(profit);
		o3p3.setProfitFromOrder(profit);
		p3.setTotalProfitForProduct(profit);

		// Orders for p4:
		Customer c1p4 = new Customer("Noa Tubul", "0568369103");
		Invoice ia1p4 = new InvoiceForAccountant(p4.getSelling_price() * 30, p2.getCost_price() * 30);
		Order o1p4 = new WholeSalersOrder(c1p4, 30, "ORD_SW_763", p4, ia1p4);
		addNewOrderToProduct(o1p4);
		cost = p4.getCost_price();
		sell = p4.getSelling_price();
		profit = (sell * 30) - (cost * 30);
		setTotalProfitForStore(profit);
		o1p4.setProfitFromOrder(profit);
		p4.setTotalProfitForProduct(profit);

		Customer c2p4 = new Customer("Yaron Malichi", "0548326710");
		Invoice ia2p4 = new InvoiceForAccountant(p4.getSelling_price() * 20, p4.getCost_price() * 20);
		Order o2p4 = new WholeSalersOrder(c2p4, 20, "ORD_SW_864", p4, ia2p4);
		addNewOrderToProduct(o2p4);
		profit = (sell * 20) - (cost * 20);
		setTotalProfitForStore(profit);
		o2p4.setProfitFromOrder(profit);
		p4.setTotalProfitForProduct(profit);

		Customer c3p4 = new Customer("Tal Revivo", "0537216942");
		Invoice ia3p4 = new InvoiceForAccountant(p4.getSelling_price() * 25, p4.getCost_price() * 25);
		Order o3p4 = new WholeSalersOrder(c3p4, 25, "ORD_SW_965", p4, ia3p4);
		addNewOrderToProduct(o3p4);
		profit = (sell * 25) - (cost * 25);
		setTotalProfitForStore(profit);
		o3p4.setProfitFromOrder(profit);
		p4.setTotalProfitForProduct(profit);
		
		// Orders for p5:
		Customer c1p5 = new Customer("Shira Eini", "0526453987");
		Invoice ia1p5 = new InvoiceForAccountant(p5.getSelling_price() * 100, p5.getCost_price() * 100);
		Order o1p5 = new WholeSalersOrder(c1p5, 100, "ORD_SW_173", p5, ia1p5);
		addNewOrderToProduct(o1p5);
		cost = p5.getCost_price();
		sell = p5.getSelling_price();
		profit = (sell * 100) - (cost * 100);
		setTotalProfitForStore(profit);
		o1p5.setProfitFromOrder(profit);
		p5.setTotalProfitForProduct(profit);

		Customer c2p5 = new Customer("Itai Levi", "0527639482");
		Invoice ia2p5 = new InvoiceForAccountant(p5.getSelling_price() * 150, p5.getCost_price() * 150);
		Order o2p5 = new WholeSalersOrder(c2p5, 150, "ORD_SW_274", p5, ia2p5);
		addNewOrderToProduct(o2p5);
		profit = (sell * 150) - (cost * 150);
		setTotalProfitForStore(profit);
		o2p5.setProfitFromOrder(profit);
		p5.setTotalProfitForProduct(profit);

		Customer c3p5 = new Customer("Liat Nadav", "0548216973");
		Invoice ia3p5 = new InvoiceForAccountant(p5.getSelling_price() * 120, p5.getCost_price() * 120);
		Order o3p5 = new WholeSalersOrder(c3p5, 120, "ORD_SW_375", p5, ia3p5);
		addNewOrderToProduct(o3p5);
		profit = (sell * 120) - (cost * 120);
		setTotalProfitForStore(profit);
		o3p5.setProfitFromOrder(profit);
		p5.setTotalProfitForProduct(profit);

		// Orders for p6:
		Customer c1p6 = new Customer("Maor Cohen", "0548362716");
		Invoice ia1p6 = new InvoiceForAccountant(p6.getSelling_price() * 50, p6.getCost_price() * 50);
		Order o1p6 = new WholeSalersOrder(c1p6, 50, "ORD_SW_476", p6, ia1p6);
		addNewOrderToProduct(o1p6);
		cost = p6.getCost_price();
		sell = p6.getSelling_price();
		profit = (sell * 50) - (cost * 50);
		setTotalProfitForStore(profit);
		o1p6.setProfitFromOrder(profit);
		p6.setTotalProfitForProduct(profit);

		Customer c2p6 = new Customer("Aviv Alush", "0539146827");
		Invoice ia2p6 = new InvoiceForAccountant(p6.getSelling_price() * 75, p6.getCost_price() * 75);
		Order o2p6 = new WholeSalersOrder(c2p6, 75, "ORD_SW_577", p6, ia2p6);
		addNewOrderToProduct(o2p6);
		profit = (sell * 75) - (cost * 75);
		setTotalProfitForStore(profit);
		o2p6.setProfitFromOrder(profit);
		p6.setTotalProfitForProduct(profit);

		Customer c3p6 = new Customer("Rita Malki", "0528746391");
		Invoice ia3p6 = new InvoiceForAccountant(p6.getSelling_price() * 60, p6.getCost_price() * 60);
		Order o3p6 = new WholeSalersOrder(c3p6, 12, "ORD_SW_678", p6, ia3p6);
		addNewOrderToProduct(o3p6);
		profit = (sell * 60) - (cost * 60);
		setTotalProfitForStore(profit);
		o3p6.setProfitFromOrder(profit);
		p6.setTotalProfitForProduct(profit);

		// Orders for p7:
		Customer c1p7 = new Customer("Roberto Raven", "0528631063");
		Address ad1p7 = new Address("Israel", "Holon", "Hagalil", 4);
		Order o1p7 = new WebOrder(c1p7, 5, "ORD_WB_502", p7, DeliveryType.EXPRESS_SHIPPING, ad1p7);
		addNewOrderToProduct(o1p7);
		cost = p7.getCost_price();
		sell = p7.getSelling_price();
		profit = ((sell * 5) - (cost * 5)) / 4; // convert to nis
		setTotalProfitForStore(profit);
		o1p7.setProfitFromOrder(profit);
		p7.setTotalProfitForProduct(profit);

		Customer c2p7 = new Customer("Miriam Levi", "0548321760");
		Address ad2p7 = new Address("Israel", "Tel Aviv", "Dizengoff", 122);
		Order o2p7 = new WebOrder(c2p7, 10, "ORD_WB_503", p7, DeliveryType.STANDARD_SHIPPING, ad2p7);
		addNewOrderToProduct(o2p7);
		profit = ((sell * 10) - (cost * 10)) / 4;
		setTotalProfitForStore(profit);
		o2p7.setProfitFromOrder(profit);
		p7.setTotalProfitForProduct(profit);

		Customer c3p7 = new Customer("Isaac Cohen", "0539271642");
		Address ad3p7 = new Address("Israel", "Jerusalem", "King George", 19);
		Order o3p7 = new WebOrder(c3p7, 8, "ORD_WB_504", p7, DeliveryType.EXPRESS_SHIPPING, ad3p7);
		addNewOrderToProduct(o3p7);
		profit = ((sell * 8) - (cost * 8)) / 4;
		setTotalProfitForStore(profit);
		o3p7.setProfitFromOrder(profit);
		p7.setTotalProfitForProduct(profit);

		// Orders for p8:
		Customer c1p8 = new Customer("Dan Abramov", "0528637490");
		Address ad1p8 = new Address("Israel", "Herzliya", "Ben Gurion", 8);
		Order o1p8 = new WebOrder(c1p8, 3, "ORD_WB_701", p8, DeliveryType.STANDARD_SHIPPING, ad1p8);
		addNewOrderToProduct(o1p8);
		cost = p8.getCost_price();
		sell = p8.getSelling_price();
		profit = ((sell * 3) - (cost * 3)) / 4; // convert to nis
		setTotalProfitForStore(profit);
		o1p8.setProfitFromOrder(profit);
		p8.setTotalProfitForProduct(profit);

		Customer c2p8 = new Customer("Noa Kirel", "0548329112");
		Address ad2p8 = new Address("Israel", "Haifa", "Horev", 33);
		Order o2p8 = new WebOrder(c2p8, 2, "ORD_WB_702", p8, DeliveryType.EXPRESS_SHIPPING, ad2p8);
		addNewOrderToProduct(o2p8);
		profit = ((sell * 2) - (cost * 2)) / 4;
		setTotalProfitForStore(profit);
		o2p8.setProfitFromOrder(profit);
		p8.setTotalProfitForProduct(profit);

		Customer c3p8 = new Customer("Eyal Golan", "0539271583");
		Address ad3p8 = new Address("Israel", "Rishon LeZion", "Rothschild", 77);
		Order o3p8 = new WebOrder(c3p8, 5, "ORD_WB_703", p8, DeliveryType.STANDARD_SHIPPING, ad3p8);
		addNewOrderToProduct(o3p8);
		profit = ((sell * 5) - (cost * 5)) / 4;
		setTotalProfitForStore(profit);
		o3p8.setProfitFromOrder(profit);
		p8.setTotalProfitForProduct(profit);

		// Orders for p9:
		Customer c1p9 = new Customer("Sara Levi", "0528643176");
		Address ad1p9 = new Address("Israel", "Be'er Sheva", "Yehuda", 45);
		Order o1p9 = new WebOrder(c1p9, 2, "ORD_WB_801", p9, DeliveryType.EXPRESS_SHIPPING, ad1p9);
		addNewOrderToProduct(o1p9);
		cost = p9.getCost_price();
		sell = p9.getSelling_price();
		profit = ((sell * 10) - (cost * 10)) / 4; // convert to nis
		setTotalProfitForStore(profit);
		o1p9.setProfitFromOrder(profit);
		p9.setTotalProfitForProduct(profit);

		Customer c2p9 = new Customer("Omer Adam", "0548336710");
		Address ad2p9 = new Address("Israel", "Netanya", "Sokolov", 12);
		Order o2p9 = new WebOrder(c2p9, 7, "ORD_WB_802", p9, DeliveryType.STANDARD_SHIPPING, ad2p9);
		addNewOrderToProduct(o2p9);
		profit = ((sell * 7) - (cost * 7)) / 4;
		setTotalProfitForStore(profit);
		o2p9.setProfitFromOrder(profit);
		p9.setTotalProfitForProduct(profit);

		Customer c3p9 = new Customer("Gal Gadot", "0539274752");
		Address ad3p9 = new Address("Israel", "Ashdod", "HaAtzmaut", 56);
		Order o3p9 = new WebOrder(c3p9, 5, "ORD_WB_803", p9, DeliveryType.EXPRESS_SHIPPING, ad3p9);
		addNewOrderToProduct(o3p9);
		profit = ((sell * 12) - (cost * 12)) / 4;
		setTotalProfitForStore(profit);
		o3p9.setProfitFromOrder(profit);
		p9.setTotalProfitForProduct(profit);
	}

	public boolean addNewProductToStore(Product p) {
		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(p.getName())
					&& product.getClass().getSimpleName().equals(p.getClass().getSimpleName())) {
				return false; // Found a duplicate based on name and type, do not add
			}
		}
		return products.add(p);
	}

	public boolean removeProductFromStore(String code) {
		 Product p = findProductByCode(code);
		    if (p != null) {
		        // Remove orders related to the product from the allOrders list
		        for (Order order : p.getOrders()) {
		            allOrders.remove(order);
		        }
		        // Remove the product itself
		        products.remove(p);
		        totalProfitOfStore = totalProfitOfStore - p.getTotalProfitForProduct();
		        return true;
		    }
		    return false;
	}

	public Product findProductByCode(String code) {
		for (Product p : products) {
			if (p.getCode().equals(code))
				return p;
		}
		return null;
	}

	public boolean editQuantityOfProduct(String code, int newStock) {
		Product p = findProductByCode(code);
		if (p != null && newStock != 0) {
			p.setStock(newStock);
			return true;
		} else if (newStock == 0) {
			return removeProductFromStore(code);
		}
		return false;
	}

	public Order addNewOrderToProduct(Order order) {
		if (order == null)
			return null;

		if (order instanceof WebOrder) {
			double cheapestCost = Double.MAX_VALUE;
			DeliveryCompany cheapestCompany = null;
			notifyDeliveryCompanies((WebOrder) order);
			for (OrderSubscriber observer : observers) {
				DeliveryCompany company = (DeliveryCompany) observer;
				if (company.getType() == ((WebOrder) order).getDeliveryType()) {
					double cost = company.getFinalCost();
					if (cost < cheapestCost) {
						cheapestCost = cost;
						cheapestCompany = company;
					}
				}
			}
			((WebOrder) order).setDeliveryCompanyName(cheapestCompany.getClass().getSimpleName());
			((WebOrder) order).setDeliveryPrice(cheapestCost);
		}
		Product p = findProductByCode(order.getProduct().getCode());
		p.addNewOrder(order);
		p.setStock(p.getStock() - order.getQuantity());
		allOrders.add(order);
		return order;
	}

	public boolean undoLastOrder() {
		if (allOrders.isEmpty()) {
			System.out.println("No orders to undo.");
			return false;
		}
		
		// Get the last order
		Order lastOrder = allOrders.remove(allOrders.size() - 1);

		// Find the product related to the last order
		Product p = findProductByCode(lastOrder.getProduct().getCode());

		// Remove the order from the list of orders associated with the product
		p.getOrders().remove(lastOrder);

		// Increase the stock of the product by the quantity of the last order
		p.setStock(p.getStock() + lastOrder.getQuantity());
		
		//decrease the profit of the store
		 totalProfitOfStore = totalProfitOfStore - lastOrder.getProfitFromOrder();
		 
		 //decrease the total Profit For Product
		 p.setTotalProfitForProduct(p.getTotalProfitForProduct() - lastOrder.getProfitFromOrder());
		
		return true;
	}

	@Override
	public void registerDeliveryCompany(OrderSubscriber subscriber) {
		observers.add(subscriber);
	}

	@Override
	public void removeDeliveryCompany(OrderSubscriber subscriber) {
		observers.remove(subscriber);

	}

	@Override
	public void notifyDeliveryCompanies(WebOrder order) {
		for (OrderSubscriber observer : observers) {
			observer.update(order);
		}
	}

	public OnlineStoreMemento saveStateToMemento() {
		return new OnlineStoreMemento(this.products, this.observers, this.allOrders, this.totalProfitOfStore);
	}

	public void restoreStateFromMemento(OnlineStoreMemento memento) {
		this.products = memento.getProducts();
		this.observers = memento.getObservers();
		this.allOrders = memento.getAllOrders();
		this.totalProfitOfStore= memento.getTotalProfitOfStore();
		
		 // Check if there are any orders in the memento
	    if (!this.allOrders.isEmpty()) {
	        // Get the last order from the list of all orders
	        Order lastOrder = this.allOrders.get(this.allOrders.size() - 1);

	        // Find the product related to the last order
	        Product relatedProduct = findProductByCode(lastOrder.getProduct().getCode());
	        
	        if(relatedProduct.doesOrderExists(lastOrder.getCode())) {
	        	// Add the last order back to the product
	        	relatedProduct.addNewOrder(lastOrder);
	        	// Update the stock of the product
	        	relatedProduct.setStock(relatedProduct.getStock() - lastOrder.getQuantity());
	        }
	    }
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n== Total profit of the store ==\n").append(totalProfitOfStore).append('₪');
		return sb.toString();
	}

}