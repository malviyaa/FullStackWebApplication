<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>EasyTrip</title>


		<link rel="stylesheet" href="css/reset.css" type="text/css" />
		<link rel="stylesheet" href="css/styles.css" type="text/css" />
	
	</head>

	<body>

			<%@include file="Header.jsp"%>		
			<div >
			
				<div class="width">
					
						<table style="margin: 0px auto;" cellpadding='1' cellspacing='1'>
							 <tr>
								<td><h4 style ="color: #D3D3D3">1.Enter Booking Details</h4></td>
								<td><h4>2.Select Vehicle</h4></td>
								<td><h4 style ="color: #D3D3D3">3.Choose Extras<h4></td>
								<td><h4 style ="color: #D3D3D3">4.Review<h4></td>
								<td><h4 style ="color: #D3D3D3">5.Book<h4></td>
							 </tr>
						 </table>	 
						 
						 <form action="#" method="get">
						 <table style="margin: 0px auto;" cellpadding='1' cellspacing='1'>
							 <tr>
								<td>
									<label for="fname">Change Vehicle Type:</label>
								</td>
								<td>
									<select id="car-type" name="selectedCarType">
			
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
								</td>
								
								<td>
									<label for="fname">Sort By:</label>
								</td>
								<td>
									<select id="car-type" name="selectedCarType">
			
										<option value="price" selected="selected">
											Price
										</option>
									
										<option value="eco-friendly">
											Size
										</option>
									
										<option value="sports">
											Company
										</option>
							
										</select>
								</td>
								
								<td>
									<input type="submit" value="Search Vehicles" ></input>
								</td>
								
							 </tr>
						 </table>	
						 </form>
						 
						<br/>
						
						<h4 align = 'center' style ="color: #193a80">Available Vehicles</h4>
						
						<fieldset/>
						
						<table style="width:100%" style="height:100%" border="1" bordercolor="#aaa" cellspacing="0" cellpadding="0">
						<form method = 'get' action = 'ChooseExtras.jsp'>
						<tr>
						
						<td style="vertical-align: middle;" width="30%"><table><tr><td>
						<a href="ProductDetails.html"><img style="width:220px;height:128px;" style="display:block;"  src="images/Nissan Quest.jpg"></a>
						</td></tr></table></td>
						
						<td width="40%"><table>
						<tr><th width="40"><strong>Nissan Quest</strong></th></tr>
						<tr><td width="40">7 Passengers</td></tr>
						<tr><td width="40"><b>3 Large Bags, </b>2 Small Bags</td></tr>
						<tr><td><b>Automatic </b>Transmission</td></tr>
						<tr><td><b>25 miles/gallon </b>or better</td></tr>
						</table></td>
						
						<td width="30%"><table>
						<tr><td><b>Price:</b></tr></td>
						<tr><td><b>80.00 USD Per Day</b></tr></td>
						<tr><td><b>380.00 USD Per Week</b></tr></td>
						<tr><td><b>160.00 USD for selected days</b></tr></td>
						<tr><td>
						<input type = 'submit' name = 'selectVehicle' value = 'Select'>
						
						</form></td></tr>
						</table></td></tr>
						
						</tr>
						</table>
						
						<fieldset/>
						
						<table style="width:100%" style="height:100%" border="1" bordercolor="#aaa" cellspacing="0" cellpadding="0">
						<tr>
						
						<td style="vertical-align: middle;" width="30%"><table><tr><td>
						<a href="ProductDetails.html"><img style="width:220px;height:128px;" style="display:block;"  src="images/Toyota 4Runner.jpg"></a>
						</td></tr></table></td>
						
						<td width="40%"><table>
						<tr><th width="40"><b>Toyota 4Runner</b></th></tr>
						<tr><td width="40"><b>5 </b>Passengers</b></td></tr>
						<tr><td width="40"><b>3 Large Bags, </b>2 Small Bags</td></tr>
						<tr><td><b>Automatic </b>Transmission</td></tr>
						<tr><td><b>19 miles/gallon </b>or better</td></tr>
						</table></td>
						
						<td width="30%"><table>
						<tr><td><b>Price:</b></tr></td>
						<tr><td><b>96.00 USD Per Day</b></tr></td>
						<tr><td><b>450.00 USD Per Week</b></tr></td>
						<tr><td><b>192.00 USD for selected days</b></tr></td>
						<tr><td><form method = 'get' action = 'SelectExtras.jsp'>
						<input type = 'submit' name = 'selectVehicle' value = 'Select'>
						
						</form></td></tr>
						</table></td></tr>
						</td>
						</tr>
						</table>
						
						<fieldset/>
						
						<table style="width:100%" style="height:100%" border="1" bordercolor="#aaa" cellspacing="0" cellpadding="0">
						<tr>
						
						<td style="vertical-align: middle;" width="30%"><table><tr><td>
						<a href="ProductDetails.html"><img style="width:220px;height:128px;" style="display:block;"  src="images/Nissan Armada.jpg"></a>
						</td></tr></table></td>
						
						<td width="40%"><table>
						<tr><th width="40"><b>Nissan Armada</b></th></tr>
						<tr><td width="40"><b>5 </b>Passengers</b></td></tr>
						<tr><td width="40"><b>3 Large Bags, </b>2 Small Bags</td></tr>
						<tr><td><b>Automatic </b>Transmission</td></tr>
						<tr><td><b>19 miles/gallon </b>or better</td></tr>
						</table></td>
						
						<td width="30%"><table>
						<tr><td><b>Price:</b></tr></td>
						<tr><td><b>96.00 USD Per Day</b></tr></td>
						<tr><td><b>450.00 USD Per Week</b></tr></td>
						<tr><td><b>192.00 USD for selected days</b></tr></td>
						<tr><td><form method = 'get' action = 'SelectExtras.jsp'>
						<input type = 'submit' name = 'selectVehicle' value = 'Select'>
						
						</form></td></tr>
						</table></td></tr>
						</td>
						</tr>
						</table>
						
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
