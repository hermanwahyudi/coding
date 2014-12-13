using System;

public class Latihan_5
{
	public static void Main() {
		int N = int.Parse(Console.ReadLine());
		int j = 0;
		for(int  i = 1; i <= 7; i++) {
			j = i + j;
			Console.WriteLine("{0} {1}", i, j);
		}
	}
}