
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MySqlDataStoreUtilities;

public class DealMatchesUtilities extends HttpServlet
{


public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, java.io.IOException
{
response.setContentType("text/html");

 java.io.PrintWriter pw = response.getWriter();
 HashMap<String,bean.Console> productmap=new HashMap<String,bean.Console>();
 HashMap<String,bean.Console> selectedproducts=new HashMap<String,bean.Console>();
 String line =null;
 try
 {
 pw.print("<div id='content'>");
 pw.print("<div class='post'>");
 pw.print("<h2 class='title'>");
 pw.print("<a href='#'>Welcome to GameSpeed </a></h2>");
 pw.print("<div class='entry'>");
 pw.print("<br> <br>");
 pw.print("<h2>The world trusts us to deliver SPEEDY service for video-gaming fans</h2>");
 pw.print("<br> <br>");
 pw.print("<h1>We beat our competitors in all aspects. Price-Match Guaranteed</h2>");
 line=null;
 productmap=MySqlDataStoreUtilities.getInstance().getAllProducts();
 }
 catch(Exception e)
 {
	 
 }

 
 for(Map.Entry<String, bean.Console> entry : productmap.entrySet())
 {
	
	 if(selectedproducts.size()<2 && !selectedproducts.containsKey(entry.getKey()))
	 	{
		 	BufferedReader reader = new BufferedReader(new FileReader (new
		 								File(getServletContext().getRealPath("DealMatches.txt"))));
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
									 pw.print("<h2>"+line.substring(9,line.length()-2)+"</h2>");
									 pw.print("<br>");
									 selectedproducts.put(entry.getKey(),entry.getValue());
									 System.out.println(selectedproducts);
									 break;
									 }
		 								}while((line = reader.readLine()) != null);
		 							}
	 							}
 						}








}
}
