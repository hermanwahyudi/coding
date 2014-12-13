using System;

class HelloWorld 
{
	static void Main() {
		string str = Console.ReadLine();
		int i = int.Parse(str);
		int[] arr = new int[i];
		Random rand = new Random();
		Loop1: {
			i--;
			string Prime = isPrime(arr[i]) ? " adalah bilangan Prima" : " bukan Bilangan Prima";
			Console.WriteLine(arr[i] + Prime + ", binary {0}", toBinary(arr[i]));
		}

		if(i > 0) {
			
			arr[i-1] = rand.Next(0, 100);
			goto Loop1;
		}
		string result = new HelloWorld().isPalindrome(Console.ReadLine()) ? "Palindrome" : "Not Palindrome";
		Console.WriteLine(result);

	}
	public static bool isPrime(int N) {
		if(N == 0 || N == 1) return false; 
		for(int i = 2; i < N; i++) {
			if(N%i == 0)
				return false;
		}
		return true;
	}
	public bool isPalindrome(string s) {
		int start = 0, end = s.Length-1;
		for(int i = 0; i < s.Length/2; i++) {
			if(s[start] == s[end]) {
				start++; end--;
			} else return false;
		}
		return true;
	}
	public static string toBinary(int X) {
		int sisa = 0;
		string s = "";
		if(X == 0) return "0";
		while(X > 0) {
			sisa = X%2;
			X = X/2;
			s += sisa;
		}
		return s;
	}
}