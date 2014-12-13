using System;

class Latihan2
{
	static void Main() {
		string input = Console.ReadLine();
		int in1 = int.Parse(input[0].ToString());
		int in2 = int.Parse(input[2].ToString());
		new Latihan2().solve(in1, in2);
	}  
	public void solve(int in1, int in2) {
		int d = 1, r = 1;
		int x = in1;
		if (in1 != in2) return;
		for(int i = 0; i < in1; i++) {
			for(int j = 0; j < in2; j++){
				if(j%2 == 0) {
					if(j == 0)
						Console.Write("{0} ", i+1);
					else {
						r=r+(1+(d-1)*2);
						Console.Write("{0} ", r);
					}
				} else {
					r=r+(1+(x-1)*2);
					Console.Write("{0} ", r);
				}
			}
			r = ++d; x--;
			Console.WriteLine();
		}
	}
		 
}