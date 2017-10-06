package parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import bean.Console;

public class SaxParser extends DefaultHandler {
	Console console;
	List<Console> consoles;
	String consoleXmlFileName;
	String elementValueRead;
	String key;
	ArrayList<String> value;
	HashMap<String, Console> products;

	public static void main(String[] args) {
		new SaxParser("/Users/Ankit/Documents/workspace/Best_Deal/WebContent/ProductCatalog.xml");

	}

	public SaxParser(String consoleXmlFileName) {
		this.consoleXmlFileName = consoleXmlFileName;
		consoles = new ArrayList<Console>();
		products = new HashMap<String, Console>();
		parseDocument();
		prettyPrint();
		// getdata();
	}

	public HashMap<String, Console> getdata(HashMap<String, Console> products2) {
		HashMap<String, Console> pro;
		pro = products2;
		return pro;
	}

	private void parseDocument() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(consoleXmlFileName, this);
		} catch (ParserConfigurationException e) {
			System.out.println("ParserConfig error");
		} catch (SAXException e) {
			System.out.println("SAXException : xml not well formed");
		} catch (IOException e) {
			System.out.println("IO error");
		}
	}

	private void prettyPrint() {

		// ArrayList<String> prd = null;
		getdata(products);
		for (Console console : products.values()) {
			System.out.println("console #" + console.getId() + ":");

			System.out.println("\t\t retailer: " + console.getRetailer());
			System.out.println("\t\t Image: " + console.getImage());
			System.out.println("\t\t name: " + console.getName());
			System.out.println("\t\t cond: " + console.getCondition());
			System.out.println("\t\t pric: " + console.getPrice());
			System.out.println("\t\t acce: " + console.getAccessories());
		}
		return;
	}

	@Override
	public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {

		if (elementName.equalsIgnoreCase("Product")) {
			console = new Console();
			console.setId(attributes.getValue("id"));
			console.setRetailer(attributes.getValue("retailer"));
		}

	}

	@Override
	public void endElement(String str1, String str2, String element) throws SAXException {

		if (element.equalsIgnoreCase("Product")) {
			// consoles.add(console);
			products.put(console.getId(), console);
			return;
		}
		if (element.equalsIgnoreCase("image")) {
			console.setImage(elementValueRead);
			return;
		}
		if (element.equalsIgnoreCase("name")) {
			console.setName(elementValueRead);
			return;
		}
		if (element.equalsIgnoreCase("condition")) {
			console.setCondition(elementValueRead);
			return;
		}
		if (element.equalsIgnoreCase("price")) {
			console.setPrice(elementValueRead);
			return;
		}
		if (element.equalsIgnoreCase("accessory")) {
			console.getAccessories().add(elementValueRead);
			return;
		}

	}

	@Override
	public void characters(char[] content, int begin, int end) throws SAXException {
		elementValueRead = new String(content, begin, end);
	}

}
