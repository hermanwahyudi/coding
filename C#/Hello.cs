using System;

class Hello
{
	static void Main() {
		int x = int.Parse(Console.ReadLine());
		int y = int.Parse(Console.ReadLine());
		
		if(func1(x, y)) {
			Console.WriteLine("Oke");
		} else Console.WriteLine("Gagal");
		func2(x);
	}
	static bool func1(int x, int y) {
		bool valid = false;
		if(x == y) valid = true;
		return valid;
	}
	static void func2(int x) {
		string[] str1 = {"f1", "f2", "f3", "f4"};
		string result = string.Join(",", str1);
		string[] str2 = result.Split(',');
		Array.Reverse(str2);
		for(int i = 0; i < str2.Length; i++) {
			Console.WriteLine(str2[i]);
		}
	}
}