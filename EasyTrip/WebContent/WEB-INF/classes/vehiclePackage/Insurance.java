package vehiclePackage;

public class Insurance {

	int insurancePolicyNumber;
	String insuranceName;
	String insuranceType;
	Double costCovered;
	String insuranceCompany;
	Double insurancePrice;

	public Insurance(String insuranceName, String insuranceType, Double costCovered, String insuranceCompany,
			Double insurancePrice) {
		super();

		this.insuranceName = insuranceName;
		this.insuranceType = insuranceType;
		this.costCovered = costCovered;
		this.insuranceCompany = insuranceCompany;
		this.insurancePrice = insurancePrice;
	}

	public Insurance(int insurancePolicyNumber, String insuranceName, String insuranceType, double costCovered,
			String insuranceCompany, double insurancePrice) {
		this.insurancePolicyNumber = insurancePolicyNumber;
		this.insuranceName = insuranceName;
		this.insuranceType = insuranceType;
		this.costCovered = costCovered;
		this.insuranceCompany = insuranceCompany;
		this.insurancePrice = insurancePrice;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public Double getCostCovered() {
		return costCovered;
	}

	public void setCostCovered(Double costCovered) {
		this.costCovered = costCovered;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public Double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(Double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public int getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	public void setInsurancePolicyNumber(int insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

}
