package mypack;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * <p>
 * Test class.
 * </p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class Test {

	static Set<Integer> set = new HashSet<>();

	static void f(Set<Integer> set, int i, int n, int v, int a, int b) {
		if(i == n)
			set.add(v);
		else {
			f(set, i + 1, n, v + a, a, b);
			f(set, i + 1, n, v + b, a, b);
		}
	}
	
	public static void main(String[] args) {
		f(set, 1, 4, 0, 10, 100);
		set.clear();
		set.stream().sorted().forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.print(String.format("%d ", t));
			};
		});
	}

}