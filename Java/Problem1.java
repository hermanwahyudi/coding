import java.util.*;

public class Problem1 {

	public static void main(String[] args) {
		System.out.println(new Problem1().solve());
	}
	public int solve() {
		int sum = 0;
		for(int i = 0; i < 1000; i++) {
			if(i%3 == 0 || i%5 == 0) {
				sum += i;
			}
		}
		return sum;
	}
}