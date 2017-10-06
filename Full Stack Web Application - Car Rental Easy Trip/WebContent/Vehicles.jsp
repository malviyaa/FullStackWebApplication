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
					
						</br>
						
						<h4>Select Vehicle Type: </h4>
						
						<table>
						<tr>
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
						<input type="submit" value="View Vehicles" ></input>
						</td>
						</tr>
						</table>
						
						
						
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Eco-Friendly</th>
						</tr>
						
						<table style="width:100%" style="height:100%" border="1" bordercolor="#aaa" cellspacing="0" cellpadding="0">
						
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
						<tr><td colspan='2'><b>Price:</b></tr></td>
						<tr><td colspan='2'><b>80.00 USD Per Day</b></tr></td>
						<tr><td colspan='2'><b>380.00 USD Per Week</b></tr></td>
						<tr><td colspan='2'><b>160.00 USD for selected days</b></tr></td>
						
						<tr>
						<td>
						<form method = 'get' action = 'ViewReviewsVehicle.jsp'>
						<input style="padding: 2px 3px; font-size: 0.6em;" type = 'submit' name = 'View Reviews' value = 'View Reviews'>
						</form>
						</td>
						<td>
						<form method = 'get' action = 'WriteReviewVehicle.jsp'>
						<input style="padding: 2px 3px; font-size: 0.6em;" type = 'submit' name = 'Write Review' value = 'Write Review'>
						</form>
						</td>
						</tr>
						
						</table></td></tr>
						
						</tr>
						</table>
						
						<table style="width:100%" style="height:100%" border="1" bordercolor="#aaa" cellspacing="0" cellpadding="0">
						
						<tr>
						
						<td style="vertical-align: middle;" width="30%"><table><tr><td>
						<a href="ProductDetails.html"><img style="width:220px;height:128px;" style="display:block;"  src="images/Chevrolet Suburban.jpg"></a>
						</td></tr></table></td>
						
						<td width="40%"><table>
						<tr><th width="40"><strong>Chevrolet Suburban</strong></th></tr>
						<tr><td width="40">7 Passengers</td></tr>
						<tr><td width="40"><b>3 Large Bags, </b>2 Small Bags</td></tr>
						<tr><td><b>Automatic </b>Transmission</td></tr>
						<tr><td><b>25 miles/gallon </b>or better</td></tr>
						</table></td>
						
						<td width="30%"><table>
						<tr><td colspan='2'><b>Price:</b></tr></td>
						<tr><td colspan='2'><b>80.00 USD Per Day</b></tr></td>
						<tr><td colspan='2'><b>380.00 USD Per Week</b></tr></td>
						<tr><td colspan='2'><b>160.00 USD for selected days</b></tr></td>
						
						<tr>
						<td>
						<form method = 'get' action = ''>
						<input style="padding: 2px 3px; font-size: 0.6em;" type = 'submit' name = 'View Reviews' value = 'View Reviews'>
						</form>
						</td>
						<td>
						<form method = 'get' action = ''>
						<input style="padding: 2px 3px; font-size: 0.6em;" type = 'submit' name = 'Write Review' value = 'Write Review'>
						</form>
						</td>
						</tr>
						
						</table></td></tr>
						</td>
						</tr>
						
						</table>
						
						</table>
						
						
						
						
						
						
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">SUV</th>
						</tr>
						
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
						<tr><td colspan='2'><b>Price:</b></tr></td>
						<tr><td colspan='2'><b>96.00 USD Per Day</b></tr></td>
						<tr><td colspan='2'><b>450.00 USD Per Week</b></tr></td>
						<tr><td colspan='2'><b>192.00 USD for selected days</b></tr></td>
						
						<tr>
						<td>
						<form method = 'get' action = ''>
						<input style="padding: 2px 3px; font-size: 0.6em;" type = 'submit' name = 'View Reviews' value = 'View Reviews'>
						</form>
						</td>
						<td>
						<form method = 'get' action = ''>
						<input style="padding: 2px 3px; font-size: 0.6em;" type = 'submit' name = 'Write Review' value = 'Write Review'>
						</form>
						</td>
						</tr>
						
						</table></td></tr>
						</td>
						</tr>
						</table>
						
						</table>
						
						
						
						
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Full-Size SUV</th>
						</tr>
						
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
						<tr><td colspan='2'><b>Price:</b></tr></td>
						<tr><td colspan='2'><b>96.00 USD Per Day</b></tr></td>
						<tr><td colspan='2'><b>450.00 USD Per Week</b></tr></td>
						<tr><td colspan='2'><b>192.00 USD for selected days</b></tr></td>
						
						<tr>
						<td>
						<form method = 'get' action = ''>
						<input style="padding: 2px 3px; font-size: 0.6em;" type = 'submit' name = 'View Reviews' value = 'View Reviews'>
						</form>
						</td>
						<td>
						<form method = 'get' action = ''>
						<input style="padding: 2px 3px; font-size: 0.6em;" type = 'submit' name = 'Write Review' value = 'Write Review'>
						</form>
						</td>
						</tr>
						
						</table></td></tr>
						</td>
						</tr>
						</table>
						
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
