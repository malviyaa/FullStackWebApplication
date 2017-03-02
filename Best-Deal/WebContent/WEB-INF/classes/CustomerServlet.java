import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MySqlDataStoreUtilities;

public class CustomerServlet extends HttpServlet  {

	ServletContext context = null;

	public void init(ServletConfig config) {
		context = config.getServletContext();
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
		 response.setContentType("text/html");
			HttpSession session = request.getSession();

			String username = (String) session.getAttribute("username");
			String type = (String) session.getAttribute("type");
			String url;
			if (username != null) {
				url = "/Best-Deal/usercart";

			} else {
				url = "/Best-Deal/cart";
			}
			
			 HashMap<String,bean.Console> productmap=new HashMap<String,bean.Console>();
			 HashMap<String,bean.Console> selectedproducts=new HashMap<String,bean.Console>();
			 String line =null;
			 productmap=MySqlDataStoreUtilities.getInstance().getAllProducts();
			 
			
			 
			 java.io.PrintWriter pw = response.getWriter();
			
			
			Utilities utility = new Utilities(pw);
			String basePath = context.getRealPath("") + "/";
			utility.printHeader(basePath + "Header.html", request.getSession());

			utility.printHtml(basePath + "LeftNavigationBar.html");
			 pw.print("<h2 class='title'>");
			 pw.print("<a href='#'>Welcome to Best Deal </a></h2>");
			 pw.print("<h1>We beat our competitors in all aspects. Price-Match Guaranteed</h2>");
			
			 for(Map.Entry<String, bean.Console> entry : productmap.entrySet())
			 {
				
				 if(selectedproducts.size()<2 && !selectedproducts.containsKey(entry.getKey()))
				 	{
					 	BufferedReader reader = new BufferedReader(new FileReader (new
					 								File(basePath+"DealMatches.txt")));
					 	line=reader.readLine();
					 	
					 	if(line==null)
					 		{ 
					 		pw.print("<h2 align='center'>No Offers Found</h2>");
					 		break;
					 		}
					 			else
					 				{
					 					do
					 						{
					 				
					 								
												 if(line.contains(entry.getKey()))
												 {
													 
														String link= line.substring(line.indexOf("https://"),line.length()-2);
														
														pw.print("<script type='text/javascript'>");
														pw.print(" setInterval(function(){");
														pw.print("$('blink').each(function(){");
														pw.print(" $(this).css('visibility' , $(this).css('visibility') === 'hidden' ? '' : 'hidden')");
														pw.print("    });");
														
														pw.print("    }, 10);'");
														pw.print("</script>");
														pw.print("<h5>"+line.substring(9,line.length()-2)+"</h5>");
														 pw.print("<blink>");
												 pw.print("<a href='"+link+"'>"+link+"</a>");
												 pw.print("</blink>");
											
												 pw.print("<br>");
												 selectedproducts.put(entry.getKey(),entry.getValue());
												 System.out.println(selectedproducts);
												 break;
												 }
					 								}while((line = reader.readLine()) != null);
					 							}
				 							}
			 						}

			 for(Map.Entry<String, bean.Console> entry : selectedproducts.entrySet())
			 {
			
			 String id= entry.getKey();
			 pw.println("<body>");
				pw.println("<form action=" + url + " method='get'>");
				pw.println("<h3>Name: " + selectedproducts.get(id).getName() + "</h3>");
				if (username != null) {
					pw.println("<input type='hidden' name='username' value='" + username + "'/>");
				}
				pw.println("<input type='hidden' name='id' value='" + selectedproducts.get(id).getName() + "' />");
				pw.println("<input type='hidden' name='price' value='" + selectedproducts.get(id).getPrice() + "' />");
				// pw.println("<input type='hidden' name='Category' value='"
				// +selectedproducts.get(id). + "' />");
				// pw.println("<input type='hidden' name='name' value='" + name + "'
				// />");
				pw.println("<input type='hidden' name='retailer' value='" + selectedproducts.get(id).getRetailer() + "' />");
				pw.println(
						"<input type='hidden' name='RetailerCity' value='" + selectedproducts.get(id).getRetailerCity() + "' />");
				pw.println("<input type='hidden' name='RetailerZip' value='" + selectedproducts.get(id).getRetailerZip() + "' />");
				pw.println(
						"<input type='hidden' name='RetailerState' value='" + selectedproducts.get(id).getRetailerState() + "' />");
				pw.println(
						"<input type='hidden' name='ProductOnSale' value='" + selectedproducts.get(id).getProductOnSale() + "' />");
				pw.println("<input type='hidden' name='ManufacturerName' value='" + selectedproducts.get(id).getName() + "' />");
				pw.println("<input type='hidden' name='ManufacturerRebate' value='"
						+ selectedproducts.get(id).getManufacturerRebate() + "' />");
				pw.println("<input type='hidden' name='condition' value='" + selectedproducts.get(id).getCondition() + "' />");
				// pw.println("<input type='hidden' name='accessory1' value='" +
				// Accessory.get(0) + "' />");
				// pw.println("<input type='hidden' name='accessory2' value='" +
				// Accessory.get(1) + "' />");

				pw.println("<img src='"+selectedproducts.get(id).getImage()+"' \"alt=\"Mountain View\" style=\"width:204px;height:228px;\">");
				pw.println("<input type='submit' value='Add to Cart' />");

				pw.println("<h5> Price:" + selectedproducts.get(id).getPrice() + "<h5>");
				pw.println("<h6>Retailer: " + selectedproducts.get(id).getRetailer() + "<h6>");
				pw.println("<h6>Condition: " + selectedproducts.get(id).getCondition() + "<h6>");
				// pw.println("<h6> Accessory1:" + Accessory.get(0) + "<h6>");
				// pw.println("<h6> Accessory2:" + Accessory.get(1) + "<h6>");
				pw.println("</form>");

				if (username != null && type.equals("customer")) {
					
					pw.println("<form action='/Best-Deal/review' method='get'>");
					pw.println("<input type='hidden' name='id' value='" + selectedproducts.get(id).getName() + "' />");
					pw.println("<input type='hidden' name='price' value='" + selectedproducts.get(id).getPrice() + "' />");
					// pw.println("<input type='hidden' name='Category' value='"
					// +selectedproducts.get(id). + "' />");
					// pw.println("<input type='hidden' name='name' value='" + name +
					// "' />");
					pw.println("<input type='hidden' name='retailer' value='" + selectedproducts.get(id).getRetailer() + "' />");
					pw.println("<input type='hidden' name='RetailerCity' value='" + selectedproducts.get(id).getRetailerCity()
							+ "' />");
					pw.println(
							"<input type='hidden' name='RetailerZip' value='" + selectedproducts.get(id).getRetailerZip() + "' />");
					pw.println("<input type='hidden' name='RetailerState' value='" + selectedproducts.get(id).getRetailerState()
							+ "' />");
					pw.println("<input type='hidden' name='ProductOnSale' value='" + selectedproducts.get(id).getProductOnSale()
							+ "' />");
					pw.println(
							"<input type='hidden' name='ManufacturerName' value='" + selectedproducts.get(id).getName() + "' />");
					pw.println("<input type='hidden' name='ManufacturerRebate' value='"
							+ selectedproducts.get(id).getManufacturerRebate() + "' />");
					pw.println("<input type='hidden' name='condition' value='" + selectedproducts.get(id).getCondition() + "' />");
					// pw.println("<input type='hidden' name='accessory1' value='"
					// + Accessory.get(0) + "' />");
					// pw.println("<input type='hidden' name='accessory2' value='"
					// + Accessory.get(1) + "' />");
					pw.println("<input type='submit' value='Review' />");
					pw.println("</form>");

				}

				if (username != null && type.equals("admin")) {
					pw.println("<input type='hidden' name='id' value='" + selectedproducts.get(id).getName() + "' />");
					pw.println("<input type='hidden' name='price' value='" + selectedproducts.get(id).getPrice() + "' />");
					// pw.println("<input type='hidden' name='Category' value='"
					// +selectedproducts.get(id). + "' />");
					// pw.println("<input type='hidden' name='name' value='" + name +
					// "' />");
					pw.println("<input type='hidden' name='retailer' value='" + selectedproducts.get(id).getRetailer() + "' />");
					pw.println("<input type='hidden' name='RetailerCity' value='" + selectedproducts.get(id).getRetailerCity()
							+ "' />");
					pw.println(
							"<input type='hidden' name='RetailerZip' value='" + selectedproducts.get(id).getRetailerZip() + "' />");
					pw.println("<input type='hidden' name='RetailerState' value='" + selectedproducts.get(id).getRetailerState()
							+ "' />");
					pw.println("<input type='hidden' name='ProductOnSale' value='" + selectedproducts.get(id).getProductOnSale()
							+ "' />");
					pw.println(
							"<input type='hidden' name='ManufacturerName' value='" + selectedproducts.get(id).getName() + "' />");
					pw.println("<input type='hidden' name='ManufacturerRebate' value='"
							+ selectedproducts.get(id).getManufacturerRebate() + "' />");
					pw.println("<input type='hidden' name='condition' value='" + selectedproducts.get(id).getCondition() + "' />");
					// pw.println("<input type='hidden' name='accessory1' value='"
					// + Accessory.get(0) + "' />");
					// pw.println("<input type='hidden' name='accessory2' value='"
					// + Accessory.get(1) + "' />");
					pw.println("<input type='submit' value='Update Cart' />");
					pw.println("</form>");

					pw.println("<form action='/Best-Deal/adminchange' method='post'>");
					pw.println("<input type='hidden' name='id' value='" + selectedproducts.get(id).getName() + "' />");
					pw.println("<input type='hidden' name='price' value='" + selectedproducts.get(id).getPrice() + "' />");
					// pw.println("<input type='hidden' name='Category' value='"
					// +selectedproducts.get(id). + "' />");
					// pw.println("<input type='hidden' name='name' value='" + name +
					// "' />");
					pw.println("<input type='hidden' name='retailer' value='" + selectedproducts.get(id).getRetailer() + "' />");
					pw.println("<input type='hidden' name='RetailerCity' value='" + selectedproducts.get(id).getRetailerCity()
							+ "' />");
					pw.println(
							"<input type='hidden' name='RetailerZip' value='" + selectedproducts.get(id).getRetailerZip() + "' />");
					pw.println("<input type='hidden' name='RetailerState' value='" + selectedproducts.get(id).getRetailerState()
							+ "' />");
					pw.println("<input type='hidden' name='ProductOnSale' value='" + selectedproducts.get(id).getProductOnSale()
							+ "' />");
					pw.println(
							"<input type='hidden' name='ManufacturerName' value='" + selectedproducts.get(id).getName() + "' />");
					pw.println("<input type='hidden' name='ManufacturerRebate' value='"
							+ selectedproducts.get(id).getManufacturerRebate() + "' />");
					pw.println("<input type='hidden' name='condition' value='" + selectedproducts.get(id).getCondition() + "' />");
					// pw.println("<input type='hidden' name='accessory1' value='"
					// + Accessory.get(0) + "' />");
					// pw.println("<input type='hidden' name='accessory2' value='"
					// + Accessory.get(1) + "' />");
					pw.println("<input type='submit' value='Delete Product' />");
					pw.println("</form>");

					pw.println("<form action='/Best-Deal/AddProduct' method='post'>");

					pw.println("<input type='submit' value='Add Product' />");
					pw.println("</form>");
				}
				pw.println("<h3> </h3>");
				pw.println("</body>");
				pw.println("</html>");
			 
			 
			 }
			 
			 

			utility.printHtml(basePath + "Content.html");

			 utility.printHtml(basePath + "Footer.html");



			

	} 

}
