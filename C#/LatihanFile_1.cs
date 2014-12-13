using System;
using System.IO;

class LatihanFile_1
{
	static string str = @"D:\File.txt";
	static string s = "";
	public static void Main() {
		StreamReader rw = new StreamReader(str);
		while(rw.Peek() != -1) {
			s += rw.ReadLine();
		}
		rw.Close();
		Console.WriteLine(s);
		
	}
}