package vehiclePackage;

public class Accessory {
	int accId;
	String accName;
	Integer totalNumber;
	Integer availableNumber;
	double hourPrice;

	public Accessory(int accId, String accName, Integer totalNumber, Integer availableNumber, double hourPrice) {
		this.accId = accId;
		this.accName = accName;
		this.totalNumber = totalNumber;
		this.availableNumber = availableNumber;
		this.hourPrice = hourPrice;

	}

	public Accessory(String accName, Integer totalNumber, Integer availableNumber, double hourPrice) {

		this.accName = accName;
		this.totalNumber = totalNumber;
		this.availableNumber = availableNumber;
		this.hourPrice = hourPrice;

	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public int getAccId() {
		return accId;
	}

	public Integer getAvailableNumber() {
		return availableNumber;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccName() {
		return accName;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setAvailableNumber(Integer availableNumber) {
		this.availableNumber = availableNumber;
	}

	public void setHourPrice(double hourPrice) {
		this.hourPrice = hourPrice;
	}

	public double getHourPrice() {
		return hourPrice;
	}

}
