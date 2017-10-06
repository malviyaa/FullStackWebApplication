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
					
						<br/>
						
						<h4 align = 'center'>Reservation for Booking ID: ETBID123456789</h4>
						
						<br/>
						
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Driver Information</th>
						</tr>
						
						<tr>
							<td><label for="fname">First Name: </label></td>
							<td><label for="fname">Mohammed</label></td>
						</tr>
						<tr>
							<td><label for="fname">Last Name: </label></td>
							<td><label for="fname">Shethwala</label></td>
						</tr>
						<tr>
							<td><label for="fname">Email Id: </label></td>
							<td><label for="fname">coolmohammed09@gmail.com</label></td>
						</tr>
						<tr>
							<td><label for="fname">Phone Number: </label></td>
							<td><label for="fname">3126180721</label></td>
						</tr>
						<tr>
							<td><label for="fname">Driver's License No: </label></td>
							<td><label for="fname">JTW219839TH878</label></td>
						</tr>
						</table>
						
						<fieldset/>
			
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Billing Information</th>
						</tr>
						
						<tr>
							<td><label for="fname">Card Holders Name: </label></td>
							<td><label for="fname">Mohammed Shethwala</label></td>
						</tr>
						<tr>
							<td><label for="fname">Card Number: </label></td>
							<td><label for="fname">**** **** **** 1234</label></td>
						</tr>
						<tr>
							<td><label for="fname">Address 1: </label></td>
							<td><label for="fname">3001 S King Drive</label></td>
						</tr>
						<tr>
							<td><label for="fname">Address 2: </label></td>
							<td><label for="fname">Apt 517</label></td>
						</tr>
						<tr>
							<td><label for="fname">City: </label></td>
							<td><label for="fname">Chicago</label></td>
						</tr>
						<tr>
							<td><label for="fname">Country: </label></td>
							<td><label for="fname">USA</label></td>
						</tr>
						<tr>
							<td><label for="fname">Zip: </label></td>
							<td><label for="fname">60616</label></td>
						</tr>
						<tr>
							<td><label for="fname">Phone Number: </label></td>
							<td><label for="fname">3126180721</label></td>
						</tr>
						</table>
						
						<fieldset/>
			
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Itinerary</th>
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
							<td><label for="fname">Age: </label></td>
							<td><label for="fname">25</label></td>
						</tr>
						
						</table>
						
						<fieldset/>
						
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Vehicle</th>
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
						
						</table></td></tr>
						</td>
						</tr>
						</form>
						</table>
						
						<fieldset/>
						
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Extras</th>
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
						
						</table>
						
						<fieldset/>
						
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Total</th>
							<th align='right' colspan='3' style ="color: #fff; background-color:#2F2F2F">786.00</th>
						</tr>
						
						<tr>
							<td colspan='3'>Vehicle Rate</td>
							<td align = 'right' colspan='3'>720.00</td>
						</tr>
						<tr>
							<td colspan='3'>EasyTrip Insurance (Extras)</td>
							<td align = 'right' colspan='3'>30.00</td>
						</tr>
						<tr>
							<td colspan='3'>Car Charger (Extras)</td>
							<td align = 'right' colspan='3'>20.00</td>
						</tr>
						<tr>
							<td colspan='3'>Taxes</td>
							<td align = 'right' colspan='3'>16.00</td>
						</tr>
						
						</table>
						
						<fieldset/>
			
						<form action="Reservations.jsp" method="get">
						 <table style="margin: 0px auto;" cellpadding='1' cellspacing='1'>
							 <tr>
								<td align = 'right'>
									<input type="submit" value="Ok" ></input>
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
