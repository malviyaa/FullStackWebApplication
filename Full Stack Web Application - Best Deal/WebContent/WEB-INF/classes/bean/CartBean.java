package bean;

public class CartBean {
	String username;
	String id;
	String name;
	String price;
	String retailer;
	String RetailerCity;
	String RetailerZip;
	String RetailerState;
	String ProductOnSale;
	String ManufacturerName;
	String ManufacturerRebate;
	String condition;
	String accessory1;
	String accessory2;

	public CartBean(String username, String id, String name, String price, String retailer, String RetailerCity,
			String RetailerZip, String RetailerState, String ProductOnSale, String ManufacturerName,
			String ManufacturerRebate, String condition, String accessory1, String accessory2) {

		System.out.println("Cartbean constructor");
		this.username = username;
		this.id = id;
		this.name = name;
		this.price = price;
		this.retailer = retailer;
		this.RetailerCity = RetailerCity;
		this.RetailerState = RetailerState;
		this.RetailerZip = RetailerZip;
		this.ProductOnSale = ProductOnSale;
		this.ManufacturerName = ManufacturerName;
		this.ManufacturerRebate = ManufacturerRebate;
		this.condition = condition;
		this.accessory1 = accessory1;
		this.accessory2 = accessory2;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRetailer() {
		return retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public String getRetailerCity() {
		return RetailerCity;
	}

	public void setRetailerCity(String retailerCity) {
		RetailerCity = retailerCity;
	}

	public String getRetailerZip() {
		return RetailerZip;
	}

	public void setRetailerZip(String retailerZip) {
		RetailerZip = retailerZip;
	}

	public String getRetailerState() {
		return RetailerState;
	}

	public void setRetailerState(String retailerState) {
		RetailerState = retailerState;
	}

	public String getProductOnSale() {
		return ProductOnSale;
	}

	public void setProductOnSale(String productOnSale) {
		ProductOnSale = productOnSale;
	}

	public String getManufacturerName() {
		return ManufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		ManufacturerName = manufacturerName;
	}

	public String getManufacturerRebate() {
		return ManufacturerRebate;
	}

	public void setManufacturerRebate(String manufacturerRebate) {
		ManufacturerRebate = manufacturerRebate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getAccessory1() {
		return accessory1;
	}

	public void setAccessory1(String accessory1) {
		this.accessory1 = accessory1;
	}

	public String getAccessory2() {
		return accessory2;
	}

	public void setAccessory2(String accessory2) {
		this.accessory2 = accessory2;
	}

}
