using System;
using System.Collections;
using System.Collections.Generic;

public class Latihan_6
{
	public static void Main() {
		ArrayList ob = new ArrayList();
		ob.Add("Herman");
		ob.Add("Wahyudi");
		foreach(string s in ob) {
			Console.WriteLine(s);
		}
	}
}