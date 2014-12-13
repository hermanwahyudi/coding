import java.io.*;

public class Problem3 {
	
	public static void main(String[] args) {
		DataInputStream read = new DataInputStream(System.in);

		int N = 0;
		try {	
			N = Integer.parseInt(read.readLine());
		} catch(IOException e) {
			e.printStackTrace(); 
		}
		new Problem3().bigFactorPrime(N);
	}
	public boolean isPrime(int n) {
		if(n == 0 || n == 1) return false;
		for(int i = 2; i < n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	public void bigFactorPrime(int n) {
		int[] arr = new int[n];
		int j = 0, temp = 0;;
		for(int i = 0; i < n; i++) {
			if(isPrime(i)) {
				arr[j] = i;
				j++;
			}
		}
		for(int i = 0; i < j; i++) { 
			if(n%arr[i] == 0) {
				temp = arr[i];
			}
		}
		System.out.println(temp);
	}
}