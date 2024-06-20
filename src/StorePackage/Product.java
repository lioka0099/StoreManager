package StorePackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Product implements Comparable<Product>{

	private String product_name, code;
	private int cost_price, selling_price;
	private int stock;
	private List<Order> orders;
	private int totalProfitForProduct;

	public Product(String product_name, String code, int cost_price, int selling_price, int stock) {
		super();
		this.product_name = product_name;
		this.code = code;
		this.cost_price = cost_price;
		this.selling_price = selling_price;
		this.stock = stock;
		this.orders = new ArrayList<Order>();
	}

	public String getCode() {
		return code;
	}
	
	public String getName() {
		return product_name;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void setTotalProfitForProduct(int totalProfitForProduct) {
		this.totalProfitForProduct += totalProfitForProduct;
	}

	public int getStock() {
		return stock;
	}

	public int getCost_price() {
		return cost_price;
	}

	public int getSelling_price() {
		return selling_price;
	}

	public int getTotalProfitForProduct() {
		return totalProfitForProduct;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void addNewOrder(Order order) {
			orders.add(order);
	}
	
	public boolean doesOrderExists(String code) {
		Iterator<Order> orderIterator = orders.iterator();
		while(orderIterator.hasNext()) {
			Order o = orderIterator.next();
			if(o.getCode().compareTo(code) == 0) {
				//order exists
				return false;
			}
		}
		//order doesn't exist.
		return true;
	}
	
	public String toString(boolean printOrderDetails,char USDorNIS) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n====Product details====\n").append("Name: ").append(product_name).append("\nCode: ").append(code)
				.append("\nPrice: ").append(selling_price).append(USDorNIS).append("\nQuantity in stock: ").append(stock)
				;

		if (printOrderDetails) {
			sb.append("\nCost: ").append(cost_price).append(USDorNIS);
			if(orders.isEmpty())
				sb.append("\nNo orders for this product yet.\n");
			else {
			sb.append("\n===Orders for the product===\n");
			Iterator<Order> orderIterator = orders.iterator();
			while (orderIterator.hasNext()) {
				Order o = orderIterator.next();
				sb.append(o.toString(true));
			}
//			sb.append("\nTotal profit for this product: ").append(totalProfitForProduct).append('₪');
		}
		}

		return sb.toString();
	}


	  @Override
      public int compareTo(Product other) {
          // Compare by code
          int codeComparison = this.code.compareToIgnoreCase(other.code);
              return codeComparison;
      }

}
