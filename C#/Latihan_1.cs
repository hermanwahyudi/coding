using System;

class Latihan_1
{
	static int flag = 0;
	public Latihan_1() {
		Console.WriteLine("Herman");
	}
	static void Main() {
		Latihan_1 obj = new Latihan_1();
		
		int entry = int.Parse(Console.ReadLine());
		func(entry);
		
		Test_1 o = new Test_1(entry);
		Console.WriteLine();
		o.getValue();
		
	}
	static void func(int N) {
		int count = 1; int x = 1;
		for(int i = 1; i <= N; i++) {
			if(x == 2 || x == 6) {
				if(flag == 0) {
					Console.Write("a ");
					flag = (x == 6) ? 1 : 0;
				} else if(flag == 1) {
					Console.Write("b ");
					flag = (x == 6) ? 0 : 1;
				}
				x = (x == 6) ? 0 : x;
			} else {
				Console.Write("{0} ", count);
				count++;
			}
			x++;
		}		
	}	
}
class Test_1
{
	int N;
	public Test_1(int N) {
		this.N = N;
	}
	public void getValue() {
		Console.Write(N);
	}
}