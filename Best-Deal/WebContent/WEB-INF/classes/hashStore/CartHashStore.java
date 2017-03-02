package hashStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CartHashStore {

	public static ArrayList<HashMap<String, String>> listofcart = new ArrayList<HashMap<String, String>>();
	public static ArrayList<HashMap<String, String>> displaylistofcart = new ArrayList<HashMap<String, String>>();

	public CartHashStore() {

	}

	public void setCarthash(HashMap<String, String> carthash) {

		listofcart.add(carthash);

	}

	public ArrayList<HashMap<String, String>> getCarthash() {
		return listofcart;

	}

	public void remove(String itemName) {
		Iterator<HashMap<String, String>> iterator = listofcart.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().get("name").equalsIgnoreCase(itemName)) {
				iterator.remove();
				System.out.println("List of cart removed " + listofcart);
				break;
			}
		}
	}

	public double totalprice(ArrayList<HashMap<String, String>> listofcarts) {
		double TotalPrice = 0;
		for (HashMap<String, String> item : listofcarts) {
			System.out.println("Total Price :" + listofcarts);

			System.out.println("Price is " + item.get("price").substring(1));
			TotalPrice += Double.parseDouble(item.get("price").substring(1));
			System.out.println(TotalPrice);
		}

		return TotalPrice;

	}
}
