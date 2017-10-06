package bean;

import java.util.HashMap;

public class CartStore {

	private static CartStore instance;

	public HashMap<String, String> storeCart(bean.CartBean obj) {

		HashMap<String, String> sessionHash = new HashMap<>();

		sessionHash.put("username", obj.getUsername());
		sessionHash.put("id", obj.getId());
		sessionHash.put("name", obj.getName());
		sessionHash.put("price", obj.getPrice());
		sessionHash.put("retailer", obj.getRetailer());
		sessionHash.put("RetailerCity", obj.getRetailerCity());
		sessionHash.put("RetailerZip", obj.getRetailerZip());
		sessionHash.put("RetailerState", obj.getRetailerState());
		sessionHash.put("ProductOnSale", obj.getProductOnSale());
		sessionHash.put("ManufacturerName", obj.getManufacturerName());
		sessionHash.put("ManufacturerRebate", obj.getManufacturerRebate());
		sessionHash.put("condition", obj.getCondition());
		sessionHash.put("accessory1", obj.getAccessory1());
		sessionHash.put("accessory2", obj.getAccessory2());

		return sessionHash;
	}

	protected CartStore() {

	}

	public static CartStore getInstance() {

		if (instance == null) {
			instance = new CartStore();
		}
		return instance;
	}
}
