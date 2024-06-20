package StorePackage;

public class SoldThroughWebsite extends Product{
	private double productWeight;
	private final static int USD = 4;
	@SuppressWarnings("unused")
	private String destCountry;
	
	public SoldThroughWebsite(String product_name, String code, int cost_price, int selling_price, int stock, double productWeight) {
		super(product_name, code, cost_price/USD, selling_price/USD, stock);
		this.productWeight = productWeight;
	}

	public double getProductWeight() {
		return productWeight;
	}

	public void setDestCountry(String destCountry) {
		this.destCountry = destCountry;
	}
	
	
}

