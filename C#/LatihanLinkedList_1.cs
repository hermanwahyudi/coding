using System;
using System.Collections;
using System.Collections.Generic;

class LatihanLinkedList_1
{
	public static void Main() {
		LinkedList<string> obj = new LinkedList<string>();
		obj.AddLast("Herman");
		obj.AddLast("Wahyudi");
		obj.AddFirst("Mr");
		foreach(string s in obj) {
			Console.WriteLine(s);
		}
	}
}