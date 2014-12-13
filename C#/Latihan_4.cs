using System;

public class Latihan_4
{
	public static void Main() {
		string input = Console.ReadLine();
		string str = "";
		for(int i = input.Length - 1; i >= 0; i--) {
			str += input[i];
		}
		Console.WriteLine(str);
	}
}