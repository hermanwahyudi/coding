using System;

class Soal_A
{
	public static void Main() {
		int T = int.Parse(Console.ReadLine());
		string result = "";
		while(T-- > 0) {
			result = result + solve(Console.ReadLine()) + "\n";
		}
		Console.WriteLine(result);
	}
	public static int solve(string str) {
		int count = 0;
		string temp = "";
		bool valid = false;
		for(int i = 0; i < str.Length; i++) {
			if(i == 0) {
				temp = "" + str[i];
				count++;
			} else {
				for(int j = 0; j < temp.Length && !valid; j++) {
					if(temp[j] == str[i]) {
						valid = true;
					}
				}
				if(!valid) {
					temp = temp + str[i];
					count++;
				}
			}
		}
		return count;
	}
}