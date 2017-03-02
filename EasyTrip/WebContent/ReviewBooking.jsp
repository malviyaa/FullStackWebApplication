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
								<td><h4 style ="color: #D3D3D3">2.Select Vehicle<h4></td>
								<td><h4 style ="color: #D3D3D3">3.Choose Extras<h4></td>
								<td><h4>4.Review<h4></td>
								<td><h4 style ="color: #D3D3D3">5.Book<h4></td>
							 </tr>
						 </table>	 
						 
						 <form action="Book.jsp" method="get">
						 <table style="margin: 0px auto;" cellpadding='1' cellspacing='1'>
							 <tr>
								<td align = 'right'>
									<input type="submit" value="Proceed" ></input>
								</td>
								
							 </tr>
						 </table>	
						 </form>
						 
						 <br/>

						<fieldset/>
			
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Your Itinerary</th>
						</tr>
						
						<tr>
							<td><label for="fname">Pick Up Location: </label></td>
							<td><label for="fname">Chicago O'Hare Airport</label></td>
						</tr>
						<tr>
							<td><label for="fname">Return Location: </label></td>
							<td><label for="fname">Chicago O'Hare Airport</label></td>
						</tr>
						<tr>
							<td><label for="fname">Pick Up Date: </label></td>
							<td><label for="fname">Fri, Nov 18, 2016</label></td>
						</tr>
						<tr>
							<td><label for="fname">Pick Up Time: </label></td>
							<td><label for="fname">02:00 PM</label></td>
						</tr>
						<tr>
							<td><label for="fname">Return Date: </label></td>
							<td><label for="fname">Wed, Nov 23, 2016</label></td>
						</tr>
						<tr>
							<td><label for="fname">Return Time: </label></td>
							<td><label for="fname">04:00 PM</label></td>
						</tr>
						<tr>
							<td><label for="fname">Your Age: </label></td>
							<td><label for="fname">25</label></td>
						</tr>
						<tr>
						<td colspan='3' align = 'right'>
						<form action="index.jsp" method="get">
								<input type="submit" value="Change Itinerary" ></input>
						</form>
						</td>
						</tr>
						
						</table>
						
						<fieldset/>
						
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Your Vehicle</th>
						</tr>
						<form method = 'get' action = 'VehiclesAvailable.jsp'>
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
						<tr><td align = 'right'>
						<input type = 'submit' name = 'changeVehicle' value = 'Change Vehicle'>
						
						</td></tr>
						</table></td></tr>
						</td>
						</tr>
						</form>
						</table>
						
						<fieldset/>
						
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Your Extras</th>
						</tr>
						
						<tr>
							<td>
							<table>
								<tr><td>Insurance Name: EasyTrip Insurance</td></tr>
								<tr><td>Company: EasyTrip</td></tr>
								<tr><td>Insurance Type: Full Coverage</td></tr>
								<tr><td>Cost Covered: 20000/30000</td></tr>
							</table>
							
							</td>
							<td>13.50 USD Per Day</td>
						</tr>
						
						<tr>
							<td>
							<table>
								<tr><td>Accessory Name: EasyTrip Car Charger</td></tr>
								<tr><td>Company: EasyTrip</td></tr>
							</table>
							
							</td>
							<td>5.50 USD Per Day</td>
						</tr>
						<tr>
						<td colspan='3' align = 'right'>
						<form action="ChooseExtras.jsp" method="get">
								<input type="submit" value="Change Extras" ></input>
						</form>
						</td>
						</tr>
						</table>
						
						<fieldset/>
			
						<form action="Book.jsp" method="get">
						 <table style="margin: 0px auto;" cellpadding='1' cellspacing='1'>
							 <tr>
								<td align = 'right'>
									<input type="submit" value="Proceed" ></input>
								</td>
								
							 </tr>
						 </table>	
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
