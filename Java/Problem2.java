public class Problem2 {
	public static void main(String[] args) {
		System.out.println(new Problem2().solve());
	}
	public int solve() {
		int num1 = 0, num2 = 1;
		int temp = 0, sum = 0;
		for(int i = 0; i < 6; i++) {
			temp = num1 + num2;
			if(temp%2 == 0) sum += temp;

			num1 = num2;
			num2 = temp;
		}
		return sum;
	}
}