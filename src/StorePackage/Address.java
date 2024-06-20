package StorePackage;

public class Address {
	String country,city,street;
	int number;
	public Address(String country, String city, String street, int number) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.number = number;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n== Adress Details ==\n")
		.append("Country: ").append(country)
		.append("\nCity: ").append(city)
		.append("\nStreet: ").append(street)
		.append("\nApartment number: ").append(number).append("\n");
		
		return sb.toString();
	}
	

}
