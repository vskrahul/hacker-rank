package mypack;

public class Test {

	public static void main(String args[]) {
		int[] arr = new int[]{1,4,8,2,10,9,8,7,6,5,4,3};

		int i = 0, j = 0;
		int length = 0;
		
		for(int x = 0; x < arr.length - 1; x++) {
			//increasing
			if(arr[x] <= arr[x + 1]) {
				//is it old increasing sequence?
				if(x > 0 && arr[x - 1] > arr[x]) {
					//no
					i = x;
				}
			}
			j = x;
			if(j - i > length)
				length = j - i;
		}
		System.out.println(length + 2);
	}
}