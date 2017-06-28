package mypack;

/**
 * <p>Test class.</p>
 *
 * @author Rahul
 * @version $Id: $Id
 */
public class Test {

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 * @throws java.lang.Exception if any.
	 */
	public static void main(String[] args) throws Exception {
		int magic_mat[][][] = new int[][][] {
			    {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
			    {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
			    {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
			    {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, 
			    {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}}, 
			    {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}, 
			    {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}, 
			    {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
			};
			
		int A[][] = new int[][] {
			{4, 9, 2},
			{3, 5, 7},
			{8, 1, 5}
		};
			
		int min_cost = 81;
		for (int k = 0; k < 8; k++) {
			int crt_cost = 0;
		    for (int i = 0; i < 3; i++) {
		        for (int j = 0; j < 3; j++){
		        	crt_cost += diff( A[i][j], magic_mat[k][i][j] );
		        	System.out.print(String.format("%d, ", magic_mat[k][i][j]));
		        }
		            
		        System.out.print("\t");
		    }
		    if (crt_cost < min_cost)
		        min_cost = crt_cost;
		    System.out.print("\n");
		}
		System.out.print(String.format("%d", min_cost));
	}
	
	static int diff(int a, int b) {
		return a > b ? a - b : b - a;
	}
}
