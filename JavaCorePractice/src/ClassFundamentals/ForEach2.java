package ClassFundamentals;

public class ForEach2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int[][] nums = new int[3][5];
		// give numbers some values
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 5; j++)
				nums[i][j] = (i + 1) * (j + 1);
		// Use for-each for loop to display and sum the values.
		for (int[] x : nums) {
			for (int y : x) {
				System.out.println("Value is: " + y);
				sum += y;
			}
		}
		System.out.println("Summation: " + sum);
	}

}
