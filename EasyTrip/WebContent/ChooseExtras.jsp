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
								<td><h4>3.Choose Extras</h4></td>
								<td><h4 style ="color: #D3D3D3">4.Review<h4></td>
								<td><h4 style ="color: #D3D3D3">5.Book<h4></td>
							 </tr>
						 </table>	 
						 
						
						 <form action="ReviewBooking.jsp" method="get">
						 <table style="margin: 0px auto;" cellpadding='1' cellspacing='1'>
							 <tr>
								<td align = 'right'>
									<input type="submit" value="Submit" ></input>
								</td>
								
							 </tr>
						 </table>	
						 </form>
						 
						<br/>
						
						
						<fieldset/>
						
						
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Insurance</th>
						</tr>
						<tr>
							<th>Add</th>
							<th>Item Description</th>
							<th>Price</th>
						</tr>
						<tr>
							<td><input type="checkbox" name="insurance" value="EasyTrip"></td>
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
						</table>
						
						<fieldset/>
						
						<table>
						<tr>
							<th colspan='3' style ="color: #fff; background-color:#2F2F2F">Accessories</th>
						</tr>
						<tr>
							<th>Add</th>
							<th>Item Description</th>
							<th>Price</th>
						</tr>
						
						<tr>
							<td><input type="checkbox" name="accessory" value="EasyTrip Car Charger"></td>
							<td>
							<table>
								<tr><td>Accessory Name: EasyTrip Car Charger</td></tr>
								<tr><td>Company: EasyTrip</td></tr>
							</table>
							
							</td>
							<td>5.50 USD Per Day</td>
						</tr>
						
						<tr>
							<td><input type="checkbox" name="accessory" value="Alkin Car Charger"></td>
							<td>
							<table>
								<tr><td>Accessory Name: Alkin Car Charger</td></tr>
								<tr><td>Company: Alkin</td></tr>
							</table>
							
							</td>
							<td>7.50 USD Per Day</td>
						</tr>
						
						</table>
						
						<fieldset/>
						
						<form action="ReviewBooking.jsp" method="get">
						 <table style="margin: 0px auto;" cellpadding='1' cellspacing='1'>
							 <tr>
								<td align = 'right'>
									<input type="submit" value="Submit" ></input>
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
