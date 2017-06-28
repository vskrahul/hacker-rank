/**
 * 
 */
package com.vsk.rahul.amzon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>IsolatedCustomers class.</p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class IsolatedCustomers {
	
	static int countExclusiveCustomers(List<CustomerPurchase> customerPurchases) {
		
		Map<String, Product> map = new HashMap<String, Product>();
		for (CustomerPurchase cp : customerPurchases) {
			Product p = map.get(cp.getCustomerId());
			if (Objects.isNull(p)) {
				map.put(cp.getCustomerId(), new Product(cp.getProductCategory(), 1));
			} else {
				if (p.p.equals(cp.getProductCategory()) && p.isolated) {
					p.c += 1;
				} else {
					// different product .. not isolcated customer
					p.isolated = false;
				}
			}
		}

		Map<String, Integer> count = new HashMap<String, Integer>();
		for (Map.Entry<String, Product> e : map.entrySet()) {
			Product p = e.getValue();
			if (p.isolated) {
				int c = count.get(p.p);
				if (Objects.isNull(c)) {
					count.put(p.p, p.c);
				} else {
					count.put(p.p, c + p.c);
				}
			}
		}
		int max = 0;
		for (Map.Entry<String, Integer> e : count.entrySet()) {
			if (e.getValue() > max) {
				max = e.getValue();
			}
		}
		return max;

	}

	static class Product {

		String p = "";

		int c = 0;

		boolean isolated = true;

		Product(String p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	class CustomerPurchase {

		String getCustomerId() {
			return "";
		}

		String getProductCategory() {
			return "";
		}
	}
}
