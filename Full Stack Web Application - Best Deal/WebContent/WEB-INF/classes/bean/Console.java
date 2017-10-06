package bean;

import java.util.List;

public class Console {
	String retailer;
	String name;
	String id;
	String image;
	String condition;
	String price;
	List<String> accessories;
	String discount;
	String rebate;
	String RetailerCity;
	String RetailerZip;
	String RetailerState;
	String ProductOnSale;
	String type;
	String ManufacturerName;
	String ManufacturerRebate;
	String accessory1;
	String accessory2;

	public void setAccessories(List<String> accessories) {
		this.accessories = accessories;
	}

	public Console(String name, String image, String price, String retailer, String condition, String RetailerCity,
			String RetailerZip, String type, String RetailerState, String ProductOnSale, String ManufacturerName,
			String ManufacturerRebate, String accessory1, String accessory2, String id) {
		this.name = name;
		this.image = image;
		this.price = price;
		this.retailer = retailer;
		this.condition = condition;
		this.RetailerCity = RetailerCity;
		this.type = type;
		this.RetailerZip = RetailerZip;
		this.RetailerState = RetailerState;
		this.ProductOnSale = ProductOnSale;
		this.ManufacturerName = ManufacturerName;
		this.ManufacturerRebate = ManufacturerRebate;
		this.accessory1 = accessory1;
		this.accessory2 = accessory2;
		this.id = id;
	}

	public Console() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public void setId(String id) {
		this.id = id;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public void setPrice(String elementValueRead) {
		this.price = elementValueRead;
	}

	public List<String> getAccessories() {
		return accessories;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getRebate() {
		return rebate;
	}

	public void setRebate(String rebate) {
		this.rebate = rebate;
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

	public String getRetailer() {
		return retailer;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public String getCondition() {
		return condition;
	}

	public String getPrice() {
		return price;
	}

}
