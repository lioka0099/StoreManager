package StorePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class OnlineStoreMemento {
	private Set<Product> products;
	private List<Order> allOrders;
    private List<OrderSubscriber> observers;
    private int totalProfitOfStore;

    public OnlineStoreMemento(Set<Product> products, List<OrderSubscriber> observers,  List<Order> allOrders, int totalProfitOfStore) {
        this.products = new TreeSet<>(products); // Create a new TreeSet to avoid modifying the original set
        this.observers = new ArrayList<>(observers); // Create a new ArrayList to avoid modifying the original list
        this.allOrders = new ArrayList<>(allOrders);
        this.totalProfitOfStore= totalProfitOfStore;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public List<OrderSubscriber> getObservers() {
        return observers;
    }

	public List<Order> getAllOrders() {
		return allOrders;
	}

	public int getTotalProfitOfStore() {
		return totalProfitOfStore;
	}
	
	
    
    
}
