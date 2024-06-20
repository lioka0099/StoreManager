package StorePackage;

public class InvoiceForCustomer extends Invoice{
	
	private final double VAT = 0.17;
	private double VATOfProduct;
	
	public InvoiceForCustomer(int transactionDetails) {
		super(transactionDetails);
		VATOfProduct = transactionDetails * VAT;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n==Customer Invoice==").append("\n")
		.append("Price: ").append(transactionDetails).append("₪")
		.append("\nPrice including VAT: ").append(transactionDetails+VATOfProduct).append("₪").append("\n");
		return sb.toString();
	}
}
