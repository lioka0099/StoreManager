package StorePackage;

public class Customer {
	private String customer_name, mobile;

	public Customer(String customer_name, String mobile) {
		this.customer_name = customer_name;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ").append(customer_name).append("\n")
		.append("Mobile Number: ").append(mobile).append("\n");
		return sb.toString();
	}

}
