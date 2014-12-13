import java.io.*;

public class HpBaru {
	private String[] keypad = new String[10];
	private String result = "";
	public HpBaru() {
		this.keypad[0] = " ";
		this.keypad[1] = "";
		this.keypad[2] = "abc";
		this.keypad[3] = "def";
		this.keypad[4] = "ghi";
		this.keypad[5] = "jkl";
		this.keypad[6] = "mno";
		this.keypad[7] = "pqrs";
		this.keypad[8] = "tuv";
		this.keypad[9] = "wxyz";
	}

	public void solve(String str) {
		int idx = 0, tempKey = 0;
		char[] ch = str.toCharArray();
		for(int i = 0; i < ch.length; i++) {
			for(int j = 0; j < keypad.length; j++) {
				idx = keypad[j].indexOf(ch[i]);
				if(idx != -1) {
					if(tempKey == j) result += " ";
					for(int k = 0; k <= idx; k++) {
						result += j;
					}
					tempKey = j;
				}
			}
		}
		result += "\n";
	}
	public static void main(String[] args) throws Exception {
		DataInputStream in = new DataInputStream(System.in);
		HpBaru obj = new HpBaru();
		int N = Integer.parseInt(in.readLine());
		int i = 0;
		while(i < N) {
			String str = in.readLine();
			obj.solve(str);
			i++;
		}
		System.out.print(obj.result);
	}
}
