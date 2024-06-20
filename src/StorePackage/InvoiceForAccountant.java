package StorePackage;

public class InvoiceForAccountant extends Invoice{

	int profit;

	public InvoiceForAccountant(int transactionDetails, int costPrice) {
		super(transactionDetails);
		profit = transactionDetails - costPrice;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n==Accountant Invoice==\n")
		.append("Selling price: ").append(transactionDetails).append("₪")
		.append("\nProfit: ").append(profit).append("₪");
		return sb.toString();
	}

	
	
}
