
import java.util.ArrayList;
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
	String ManufacturerName;
	String ManufacturerRebate;
	

	

	public void setAccessories(List<String> accessories) {
		this.accessories = accessories;
	}

	public Console() {
		accessories = new ArrayList<String>();
	}

	void setId(String id) {
		this.id = id;
	}

	void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	void setImage(String image) {
		this.image = image;
	}

	void setCondition(String condition) {
		this.condition = condition;
	}

	void setPrice(String elementValueRead) {
		this.price = elementValueRead;
	}

	List<String> getAccessories() {
		return accessories;
	}

	void setName(String name) {
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
