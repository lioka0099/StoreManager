package StorePackage;

public class WholeSalersOrder extends Order {

	Invoice accountantInvoice;

	public WholeSalersOrder(Customer customer, int quantity, String code, Product product, Invoice accountantInvoice) {
		super(customer, quantity, code, product);
		this.accountantInvoice = accountantInvoice;
	}

	public String toString(boolean showProfit) {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString(showProfit))
		.append(accountantInvoice.toString());
		return sb.toString();
	}

}

