package vehiclePackage;

public class VehicleInfo {
	String vehicleId;
	String vehicleMilage;
	int vehiclePassenger;
	int vehicleSLuggage;
	int vehicleLLuggage;
	String vehicleTransmission;
	String vehicleImage;
	String vehicleMake;
	String vehicleModel;

	double vehiclePrice;

	public VehicleInfo(String vehicleId, double vehiclePrice, String vehicleMilage, int vehiclePassenger,
			int vehicleSLuggage, int vehicleLLuggage, String vehicleTransmission, String vehicleImage,
			String vehicleMake, String vehicleModel) {
		this.vehicleId = vehicleId;
		this.vehiclePrice = vehiclePrice;
		this.vehicleMilage = vehicleMilage;
		this.vehiclePassenger = vehiclePassenger;
		this.vehicleSLuggage = vehicleSLuggage;
		this.vehicleLLuggage = vehicleLLuggage;
		this.vehicleTransmission = vehicleTransmission;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;

	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleMilage(String vehicleMilage) {
		this.vehicleMilage = vehicleMilage;
	}

	public String getVehicleMilage() {
		return vehicleMilage;
	}

	public void setVehiclePassenger(int vehiclePassenger) {
		this.vehiclePassenger = vehiclePassenger;
	}

	public int getVehiclePassenger() {
		return vehiclePassenger;
	}

	public void setVehicleSLuggage(int vehicleSLuggage) {
		this.vehicleSLuggage = vehicleSLuggage;
	}

	public int getVehicleSLuggage() {
		return vehicleSLuggage;
	}

	public void setVehiclePrice(double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public double getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehicleLLuggage(String location_id) {
		this.vehicleLLuggage = vehicleLLuggage;
	}

	public int getVehicleLLuggage() {
		return vehicleLLuggage;
	}

	public void setVehicleTransmission(String location_id) {
		this.vehicleTransmission = vehicleTransmission;
	}

	public String getVehicleTransmission() {
		return vehicleTransmission;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleImage() {
		return vehicleImage;
	}

	public void setVehicleImage(String vehicleImage) {
		this.vehicleImage = vehicleImage;
	}

}
