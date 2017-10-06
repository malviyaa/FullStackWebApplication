<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>EasyTrip</title>


		<link rel="stylesheet" href="css/reset.css" type="text/css" />
		<link rel="stylesheet" href="css/styles-admin.css" type="text/css" />
	
	</head>

	<body>

			<%@include file="AdminHeader.jsp"%>		
			<div >
			
				<div class="width">
					<br/>
					<table>
					<tr>
					<td><h4 align = 'center'>Search: </h4></td>
					<td><input type="TEXT" size="15" name="customerSearchQuery"></input></td>
					<td><h3 align = 'center'>Reservations List</h3></td>
					<td>
						<h4 align = 'center'>Sort by: </h4>
					</td>
					<td>
						<select id="car-type" name="selectedCarType">
			
							<option value="emailId" selected="selected">
								Email ID
							</option>
						
							<option value="firstName">
								Location ID
							</option>
						
							<option value="lastName">
								Car Type
							</option>
							
							<option value="lastName">
								Booking ID
							</option>
							
							<option value="lastName">
								Pickup Date
							</option>
							
							<option value="lastName">
								Return Date
							</option>
			
						</select>
					</td>
					
					<td><input style="padding: 4px 7px; font-size: 0.9em;" type="submit" value="Submit" ></input></td>
					
					</tr>
					</table>
					
					<br/>
					
					<table>
						<tr>
							<th style ="color: #fff; background-color:#2F2F2F">Booking ID</th>
							<th style ="color: #fff; background-color:#2F2F2F">Email Id</th>
							<th style ="color: #fff; background-color:#2F2F2F">Location ID</th>
							<th style ="color: #fff; background-color:#2F2F2F">VIN</th>
							<th style ="color: #fff; background-color:#2F2F2F">Type</th>
							<th style ="color: #fff; background-color:#2F2F2F">Pickup Date</th>
							<th style ="color: #fff; background-color:#2F2F2F">Return Date</th>
							<th style ="color: #fff; background-color:#2F2F2F">View</th>
							<th style ="color: #fff; background-color:#2F2F2F">Modify</th>
							<th style ="color: #fff; background-color:#2F2F2F">Cancel</th>
						</tr>
						
						<tr>
							<td><label for="fname">ETBID123456789</label></td>
							<td><label for="fname">mshethwa@hawk.iit.edu</label></td>
							<td><label for="fname">Chicago1</label></td>
							<td><label for="fname">ABC1234HG78J</label></td>
							<td><label for="fname">Sedan</label></td>
							<td><label for="fname">11/16/2016</label></td>
							
							<td><label for="fname">11/23/2016</label></td>
							
							<form action='ViewReservationAdmin.jsp' method='get'>
							<td><input type="submit" value="View" ></input></td>
							</form>
							<form action='ModifyReservationAdmin.jsp' method='get'>
							<td><input type="submit" value="Modify" ></input></td>
							</form>
							<form action='' method='get'>
							<td><input type="submit" value="Cancel" ></input></td>
							</form>
						</tr>
						
						<!--
						This other rows are just for template purpose.
						-->
						<form action='' method='get'>
						<tr>
							<td><label for="fname">ETBID123456755</label></td>
							<td><label for="fname">bsharma@hawk.iit.edu</label></td>
							<td><label for="fname">Chicago2</label></td>
							<td><label for="fname">ABC1234HG78J</label></td>
							<td><label for="fname">Sedan</label></td>
							<td><label for="fname">11/18/2016</label></td>
							
							<td><label for="fname">11/21/2016</label></td>
							
							<td><input type="submit" value="View" ></input></td>
							<td><input type="submit" value="Modify" ></input></td>
							<td><input type="submit" value="Cancel" ></input></td>
						</tr>
						</form>
						
						</table>
						
						
						
						 
					 </br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
						
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
