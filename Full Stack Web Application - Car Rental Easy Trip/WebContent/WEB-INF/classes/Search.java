import java.util.Date;
public class Search{
  String pickUPLocation;
  String returnLocation;
  java.util.Date pickUpDate;
  java.util.Date returnDate;
  java.sql.Timestamp pickUpTime;
  java.sql.Timestamp returnTime;
  Integer customerAge;
  String vehicleType;

public Search(String pickUPLocation,String returnLocation,java.util.Date pickUpDate,java.util.Date returnDate,java.sql.Timestamp pickUpTime,java.sql.Timestamp returnTime,Integer customerAge,String vehicleType)
{
    this.pickUPLocation = pickUPLocation;
    this.returnLocation = returnLocation;
    this.pickUpDate = pickUpDate;
    this.returnDate = returnDate;
    this.pickUpTime = pickUpTime;
    this.returnTime = returnTime;
    this.customerAge = customerAge;
    this.vehicleType = vehicleType;

}

public String getPickUPLocation(){ return pickUPLocation;}
public String getReturnLocation() { return returnLocation;}
public java.util.Date getPickUpDate(){return pickUpDate;}
public java.util.Date getReturnDate(){return returnDate;}
public java.sql.Timestamp getPickUpTime(){return pickUpTime;}
public java.sql.Timestamp getReturnTime(){return returnTime;}
public Integer getCustomerAge(){return customerAge;}
public String getVehicleType(){return vehicleType;}


}
