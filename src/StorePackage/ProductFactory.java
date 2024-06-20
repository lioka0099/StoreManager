package StorePackage;

import java.util.Scanner;

public class ProductFactory {
	
	public Product createProduct(ProductType type, String code, String product_name, int cost_price, int selling_price, int stock) {
		switch(type.name()) {
		case "SoldInStore":
			return new SoldInStore(product_name,code,cost_price,selling_price,stock);
		case "SoldInWholesalers":
			return new SoldInWholesalers(product_name, code, cost_price, selling_price, stock);
		case "SoldThroughWebsite":
			return createSoldThroughWebsiteProduct(product_name, code, cost_price, selling_price, stock);
		default:
			return null;
		}
	}
	
	private Product createSoldThroughWebsiteProduct(String product_name, String code, int cost_price, int selling_price, int stock) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("What is the weight of the product?");
		double weight = s.nextDouble();
		return new SoldThroughWebsite(product_name, code, cost_price, selling_price,stock,weight);
	}
}

