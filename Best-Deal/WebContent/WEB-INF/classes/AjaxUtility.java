
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import bean.MySqlDataStoreUtilities;

public class AjaxUtility {

	HashMap<String, bean.Console> data = new HashMap<String, bean.Console>();

	// ArrayList<ProductAttributes> pa = new ArrayList<ProductAttributes>();

	public StringBuffer readdata(String searchId) {
		StringBuffer sb = new StringBuffer();
		data = MySqlDataStoreUtilities.getInstance().getAllProducts();

		Iterator it = data.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pi = (Map.Entry) it.next();
			bean.Console p = (bean.Console) pi.getValue();
			System.out.println("Print product" + p);
			if (p.getName().toLowerCase().startsWith(searchId)) {
				sb.append("<product>");
				sb.append("<id>" + p.getId() + "</id>");

				sb.append("<productName>" + p.getName() + "</productName>");
				sb.append("</product>");
			}
		}
		System.out.println("=======" + sb.toString());
		return sb;
	}

}