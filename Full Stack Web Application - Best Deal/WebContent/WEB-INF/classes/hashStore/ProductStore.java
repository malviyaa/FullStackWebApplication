package hashStore;

import java.util.HashMap;

import bean.Console;
import parser.LaptopParser;
import parser.MobileParser;
import parser.TabletParser;
import parser.TvParser;

public class ProductStore {

	private static HashMap<String, Console> mobileHash = null;
	private static HashMap<String, Console> tvHash = null;
	private static HashMap<String, Console> laptopHash = null;
	private static HashMap<String, Console> tabletHash = null;

	private ProductStore() {

	}

	public static HashMap<String, Console> getMobileProducts(String fileName, String catagory) {
		mobileHash = bean.MySqlDataStoreUtilities.getInstance().getXmlProducts(catagory);

		if (mobileHash.isEmpty()) {

			MobileParser parser = new MobileParser(fileName);
			parser.parseDocument();
			mobileHash = parser.getData();
			for (Console console : mobileHash.values()) {

				bean.MySqlDataStoreUtilities.getInstance().insertXmlProductData(console, catagory);

			}
		}

		return mobileHash;
	}

	public static HashMap<String, Console> getLaptopProducts(String fileName, String catagory) {
		laptopHash = bean.MySqlDataStoreUtilities.getInstance().getXmlProducts(catagory);

		if (laptopHash.isEmpty()) {

			LaptopParser parser = new LaptopParser(fileName);
			parser.parseDocument();
			laptopHash = parser.getData();
			for (Console console : laptopHash.values()) {

				bean.MySqlDataStoreUtilities.getInstance().insertXmlProductData(console, catagory);

			}
		}

		return laptopHash;
	}

	// if (laptopHash == null) {
	// LaptopParser parser = new LaptopParser(fileName);
	// parser.parseDocument();
	// laptopHash = parser.getData();
	// }

	public static HashMap<String, Console> getTabletProducts(String fileName, String catagory) {
		tabletHash = bean.MySqlDataStoreUtilities.getInstance().getXmlProducts(catagory);

		if (tabletHash.isEmpty()) {

			TabletParser parser = new TabletParser(fileName);
			parser.parseDocument();
			tabletHash = parser.getData();
			for (Console console : tabletHash.values()) {

				bean.MySqlDataStoreUtilities.getInstance().insertXmlProductData(console, catagory);

			}
		}

		return tabletHash;
	}

	public static HashMap<String, Console> getTvProducts(String fileName, String catagory) {
		tvHash = bean.MySqlDataStoreUtilities.getInstance().getXmlProducts(catagory);

		if (tvHash.isEmpty()) {

			TvParser parser = new TvParser(fileName);
			parser.parseDocument();
			tvHash = parser.getData();
			for (Console console : tvHash.values()) {

				bean.MySqlDataStoreUtilities.getInstance().insertXmlProductData(console, catagory);

			}
		}

		return tvHash;
	}

}
