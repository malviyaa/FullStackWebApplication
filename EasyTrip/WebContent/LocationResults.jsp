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
					<h4>Location Search Results</h4>
					<br/>
					
					<table style="width:100%" style="height:100%" border="1" bordercolor="#aaa" cellspacing="0" cellpadding="0">
					<form method = 'get' action = 'ViewLocation.jsp'>
					<tr>
					
					<td width="40%"><table>
					<tr><th width="40"><strong>O'Hare Airport</strong></th></tr>
					<tr><td width="40">10000 Bessie Coleman Drive</td></tr>
					<tr><td width="40">Chicago , Illinois , United States , 60666-0096 </td></tr>
					<tr><td>Phone: (773) 686-7272 </td></tr>
					<tr><td>Hours of Operation: Mon-Sun Open 24 hours </td></tr>
					<tr>
					<td rowspan = '4'>
					<input type = 'submit' name = 'viewLocation' value = 'View Location'>
					</td>
					</tr>
					</table></td>
				
					</tr>
					</form>
					</table>
					
					</br>
					
					<table style="width:100%" style="height:100%" border="1" bordercolor="#aaa" cellspacing="0" cellpadding="0">
					<form method = 'get' action = 'ChooseExtras.jsp'>
					<tr>
					
					<td width="40%"><table>
					<tr><th width="40"><strong>Midway Airport</strong></th></tr>
					<tr><td width="40">5150 West 55th Street</td></tr>
					<tr><td width="40">Chicago , Illinois , United States , 60638 </td></tr>
					<tr><td>Phone: (773) 735-7272 </td></tr>
					<tr><td>Hours of Operation: Mon-Sun 6:00AM-1:30AM </tr>
					<tr>
					<td rowspan = '4'>
					<input type = 'submit' name = 'viewLocation' value = 'View Location'>
					</td>
					</tr>
					</table></td>
					
					</tr>
					</td>
					</tr>
					</form>
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
