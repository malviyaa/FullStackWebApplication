<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>EasyTrip</title>


		<link rel="stylesheet" href="css/reset.css" type="text/css" />
		<link rel="stylesheet" href="css/styles.css" type="text/css" />
		<link rel="stylesheet" href="css/jquery-ui.css" type="text/css" />
		<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />

		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script>
		$(
			function()
			{
				$( "#pickupdate, #returndate" ).datepicker();
			}
		);
		</script>

	</head>

	<body>
	
			<%@include file="Header.jsp"%>
			<div class="intro">

				<div class="width">

						<h2 style ="color: #193a80">Choose Luxury Choose EasyTrip</h2>

						<form action="VehiclesAvailable.jsp" method="post">
							 <div align="left" style = "border-radius: 5px; background-color:#DC6A50;width: 50%;padding: 0px">
								 <table style="margin: 0px auto;" cellpadding='2' cellspacing='1'>
										 <h3 align='center' style ="color: #FFFFFF">Enter Booking Details</h3>
										 <tr><td>
										 <label for="fname">Pickup Location</label>
										 <input type="TEXT" size="15" name="pickUpLocation"></input>
										 </td>
										 <td>
										 <label for="fname">Return Location</label>
										 <input type="TEXT" size="15" name="returnLocation"></input>
										 </td></tr>

										 <tr>
										 <td>
										 <label for="fname">Pickup Date</label>
										 <input type="TEXT" size="15" name="pickUpDate" id='pickupdate'></input>
										 </td>

										 <td>
										 <label for="fname">Pickup Time</label>
										 <select name="pickUpTime">
										 <option value="00:00" selected="selected">12:00 Midnight</option><option value="00:30">12:30 AM</option><option value="01:00">01:00 AM</option><option value="01:30">01:30 AM</option><option value="02:00">02:00 AM</option><option value="02:30">02:30 AM</option><option value="03:00">03:00 AM</option><option value="03:30">03:30 AM</option><option value="04:00">04:00 AM</option><option value="04:30">04:30 AM</option><option value="05:00">05:00 AM</option><option value="05:30">05:30 AM</option><option value="06:00">06:00 AM</option><option value="06:30">06:30 AM</option><option value="07:00">07:00 AM</option><option value="07:30">07:30 AM</option><option value="08:00">08:00 AM</option><option value="08:30">08:30 AM</option><option value="09:00">09:00 AM</option><option value="09:30">09:30 AM</option><option value="10:00">10:00 AM</option><option value="10:30">10:30 AM</option><option value="11:00">11:00 AM</option><option value="11:30">11:30 AM</option><option value="12:00">12:00 Noon</option><option value="12:30">12:30 PM</option><option value="13:00">01:00 PM</option><option value="13:30">01:30 PM</option><option value="14:00">02:00 PM</option><option value="14:30">02:30 PM</option><option value="15:00">03:00 PM</option><option value="15:30">03:30 PM</option><option value="16:00">04:00 PM</option><option value="16:30">04:30 PM</option><option value="17:00">05:00 PM</option><option value="17:30">05:30 PM</option><option value="18:00">06:00 PM</option><option value="18:30">06:30 PM</option><option value="19:00">07:00 PM</option><option value="19:30">07:30 PM</option><option value="20:00">08:00 PM</option><option value="20:30">08:30 PM</option><option value="21:00">09:00 PM</option><option value="21:30">09:30 PM</option><option value="22:00">10:00 PM</option><option value="22:30">10:30 PM</option><option value="23:00">11:00 PM</option><option value="23:30">11:30 PM</option>
										 </select>
										 </td>
										 </tr>

										 <tr>
										 <td>
										 <label for="fname">Return Date</label>
										 <input type="TEXT" size="15" name="returnDate" id='pickupdate'></input>
										 </td>

										 <td>
										 <label for="fname">Return Time</label>
										 <select name="returnTime">
										 <option value="00:00" selected="selected">12:00 Midnight</option><option value="00:30">12:30 AM</option><option value="01:00">01:00 AM</option><option value="01:30">01:30 AM</option><option value="02:00">02:00 AM</option><option value="02:30">02:30 AM</option><option value="03:00">03:00 AM</option><option value="03:30">03:30 AM</option><option value="04:00">04:00 AM</option><option value="04:30">04:30 AM</option><option value="05:00">05:00 AM</option><option value="05:30">05:30 AM</option><option value="06:00">06:00 AM</option><option value="06:30">06:30 AM</option><option value="07:00">07:00 AM</option><option value="07:30">07:30 AM</option><option value="08:00">08:00 AM</option><option value="08:30">08:30 AM</option><option value="09:00">09:00 AM</option><option value="09:30">09:30 AM</option><option value="10:00">10:00 AM</option><option value="10:30">10:30 AM</option><option value="11:00">11:00 AM</option><option value="11:30">11:30 AM</option><option value="12:00">12:00 Noon</option><option value="12:30">12:30 PM</option><option value="13:00">01:00 PM</option><option value="13:30">01:30 PM</option><option value="14:00">02:00 PM</option><option value="14:30">02:30 PM</option><option value="15:00">03:00 PM</option><option value="15:30">03:30 PM</option><option value="16:00">04:00 PM</option><option value="16:30">04:30 PM</option><option value="17:00">05:00 PM</option><option value="17:30">05:30 PM</option><option value="18:00">06:00 PM</option><option value="18:30">06:30 PM</option><option value="19:00">07:00 PM</option><option value="19:30">07:30 PM</option><option value="20:00">08:00 PM</option><option value="20:30">08:30 PM</option><option value="21:00">09:00 PM</option><option value="21:30">09:30 PM</option><option value="22:00">10:00 PM</option><option value="22:30">10:30 PM</option><option value="23:00">11:00 PM</option><option value="23:30">11:30 PM</option>
										 </select>
										 </td>
										 </tr>

										 <tr><td>
										 <label for="fname">Select Age</label>
										 <select name="customerAge">

												<option value="25" selected="selected">
													25+
												</option>

												<option value="23">
													23-24
												</option>

												<option value="20">
													20-22
												</option>

												<option value="18">
													18-19
												</option>

										</select>
										 </td>

										 <td>
										 <label for="fname">Vehicle Type</label>
										 <select name="vehicleType">


													<option value="all" selected="selected">
														All Types
													</option>

													<option value="eco-friendly">
														Eco-Friendly
													</option>

													<option value="sports">
														Sports
													</option>

													<option value="compact">
														Compact
													</option>

													<option value="fullSize">
														Fullsize
													</option>

													<option value="luxury">
														Luxury
													</option>

													<option value="suv">
														SUV
													</option>

													<option value="fullSizeSUV">
														Full-Size SUV
													</option>

													<option value="minivan">
														Minivan
													</option>

													<option value="convertible">
														Convertible
													</option>

										</select>
										 </td></tr>

										 <tr><td>
										 <input type="submit" value="Search" ></input>
										</td></tr>
								 </table>
							 </div>
						</form>

				</div>

			</div>

			<section id="body">

				<aside id="sidebar" class="column-left">
				</aside>

				<div class="clear"></div>

			</section>

	   <%@include file="Footer.jsp"%>

	</body>

</html>
