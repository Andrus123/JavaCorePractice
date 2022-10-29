package Interfaces;

// An interface that contains constants.
interface IConst {
	int MIN = 0;
	int MAX = 10;
	String ERRORMSG = "Boundary Error";
}

class IConstD implements IConst {
	public static void main(String[] args) {
		int[] nums = new int[MAX];

		for (int i = 0; i < nums.length; i++) {
			if (i >= MAX)
				System.out.println(ERRORMSG);
			else {
				nums[i] = i;
				System.out.print(nums[i] + " ");
			}
		}
	}

}
