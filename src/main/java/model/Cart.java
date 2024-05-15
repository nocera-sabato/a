package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<game> products;
	
	public Cart() {
		products = new ArrayList<game>();
	}
	
	public void addProduct(game product) {
		products.add(product);
	}
	public int getQuantity() {
		return products.size();
	}
	
	public void deleteProduct(game product) {
		for(game prod : products) {
			if(prod.getName().compareTo(product.getName())==0) {
				products.remove(prod);
				break;
			}
		}
 	}
	
	public List<game> getProducts() {
		return  products;
	}
	
	public int size() {
		return  products.size();
	}
}
