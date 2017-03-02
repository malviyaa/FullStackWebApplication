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
					<table>
					<tr>
					
					<td><h4 align = 'center'>Vehicle Reviews for Nissan Quest</h4></td>
					<td>
						<h4 align = 'center'>Sort by: </h4>
					</td>
					<td>
						<select id="car-type" name="selectedCarType">
			
							<option value="emailId" selected="selected">
								Rating
							</option>
						
							<option value="firstName">
								Location
							</option>
						
							<option value="lastName">
								Zip
							</option>
							
							<option value="lastName">
								City
							</option>
							
							<option value="lastName">
								State
							</option>
							
							<option value="lastName">
								Country
							</option>
			
						</select>
					</td>
					
					<td><input style="padding: 4px 7px; font-size: 0.9em;" type="submit" value="Submit" ></input></td>
					
					</tr>
					</table>
					
					<br/>
					
					<table>
						<tr>
							<th style ="color: #fff; background-color:#2F2F2F">No</th>
							<th style ="color: #fff; background-color:#2F2F2F">Customer</th>
							<th style ="color: #fff; background-color:#2F2F2F">Rating</th>
							<th style ="color: #fff; background-color:#2F2F2F">Location</th>
							<th style ="color: #fff; background-color:#2F2F2F">Zip</th>
							<th style ="color: #fff; background-color:#2F2F2F">City</th>
							<th style ="color: #fff; background-color:#2F2F2F">State</th>
							<th style ="color: #fff; background-color:#2F2F2F">Country</th>
							<th style ="color: #fff; background-color:#2F2F2F">Review</th>
							
						</tr>
						
						<tr>
							<td><label for="fname">1</label></td>
							<td><label for="fname">mshethwa@hawk.iit.edu</label></td>
							<td><label for="fname">5</label></td>
							<td><label for="fname">O'Hare Airport</label></td>
							<td><label for="fname">60054</label></td>
							<td><label for="fname">Chicago</label></td>
							<td><label for="fname">IL</label></td>
							<td><label for="fname">USA</label></td>
							<td><label for="fname">Nice Product so very very nice</label></td>
							
							
							
						</tr>
						
						<!--
						This other rows are just for template purpose.
						-->
						
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
