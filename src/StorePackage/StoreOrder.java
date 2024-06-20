package StorePackage;

public class StoreOrder extends Order {

	Invoice customerInvoice, accountantInvoice;
	
	public StoreOrder(Customer customer, int quantity, String code, Product product,Invoice customerInvoice, Invoice accountantInvoice) {
		super(customer, quantity, code, product);
		this.customerInvoice = customerInvoice;
		this.accountantInvoice = accountantInvoice;
	}

	
	public String toString(boolean showProfit) {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString(showProfit))
		.append(customerInvoice.toString())
		.append(accountantInvoice.toString());
		return sb.toString();
	}

	
}
