package hashStore;

import java.util.HashMap;

public class AccountStore {
	private static AccountStore store = null;
	private static HashMap<String, HashMap<String, String>> usernameKey = new HashMap<String, HashMap<String, String>>();
	static HashMap<String, String> usernameValue = new HashMap<String, String>();
	String username;

	public AccountStore() {

	}

	public static AccountStore getInstance() {

		usernameValue.put("address", "3021 South Michigan");
		usernameValue.put("password", "admin");
		usernameValue.put("name", "Ankit");
		usernameValue.put("occupation", "Saler");
		usernameValue.put("type", "Admin");
		usernameKey.put("admin", usernameValue);

		// usernameKey.put(username, value)
		if (store == null) {
			store = new AccountStore();
		}
		return store;
	}

	public AccountStore(String username, String password, String name, String address, String occupation, String type) {

		System.out.println("typr id " + type);
		usernameValue.put("address", address);
		usernameValue.put("password", password);
		usernameValue.put("name", name);
		usernameValue.put("phone", occupation);
		usernameValue.put("type", type);
		usernameKey.put(username, usernameValue);
		setusername(username);
		System.out.println(usernameKey);

	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getusername() {

		return username;
	}

	public HashMap<String, String> getUserDetails(String username) {

		HashMap<String, String> hm = usernameKey.get(username);

		System.out.println(hm);

		return usernameKey.get(username);
	}
}
