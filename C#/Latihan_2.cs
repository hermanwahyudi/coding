using System;
using System.Collections.Generic;
using System.Collections;

class Latihan_2
{
	public static void Main() {
		ArrayList ar = new ArrayList();
		bool stop = false;
		while(!stop) {
			string str = Console.ReadLine();
			ar.Add(str);
			if(str.ToLower().Equals("y")) {
				stop = true;
			}
		}
		IEnumerator iter = ar.GetEnumerator();
		while(iter.MoveNext()) {
			Console.Write(iter.Current + " ");
		}
	}
}