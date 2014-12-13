import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		DataInputStream in = new DataInputStream(System.in);
		String str = in.readLine();
		int[] arr = {4, 6, 3, 9, 1, 10};
		arr = sorted(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(isPalindrome(str));
		System.out.println(getReverse(str));
		System.out.println(isPrime(67));
	}
	public static boolean isPalindrome(String str) {
		int len = str.length();
		int i = 0;
		int start = 0, end = len-1;
		while(i < len/2) {
			if(str.charAt(start) == str.charAt(end)) {
				start++; end--;
			} else return false;
			i++;
		}
		return true;
	}
	public static String getReverse(String str) {
		char[] ch = str.toCharArray();
		str = "";
		for(int i = ch.length-1; i >= 0; i--) {
			str += ch[i];
		}
		return str;
	}
	public static boolean isPrime(int N) {
		for(int i = 2; i < N; i++)
			if(N%i == 0) return false;
		return true;
	}
	public static boolean search(int[] arr) {
		int search = 9;
		return false;
	}
	public static int[] sorted(int[] arr) {
	  boolean swapped = true;
	  int j = 0;
	  int tmp;
	  while (swapped) {
		swapped = false;
		j++;
		for (int i = 0; i < arr.length - j; i++) {
		  if (arr[i] > arr[i + 1]) {
			tmp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = tmp;
			swapped = true;
		  }
		}
	  }
		return arr;
	}

}