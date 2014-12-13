import java.io.*;
import java.util.Stack;

public class SDA11004
{
	private BufferedReader in;
	private BufferedWriter io;
	private Stack<Character> st01;
	public SDA11004() {
		in = new BufferedReader(new InputStreamReader(System.in));
		io = new BufferedWriter(new OutputStreamWriter(System.out));
		st01 = new Stack<Character>();
	}
	public void input() {
		int N;
		String s;
		try {
			N = Integer.parseInt(in.readLine());
			while(N-- > 0) {
				s = in.readLine();
				System.out.println(solve(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String solve(String s) {
		char c;
		int res = 0;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c >= '0' && c <= '9') {
				st01.push(c);
			} else {
				int k1 = Integer.parseInt(Character.toString(st01.pop()));
				int k2 = Integer.parseInt(Character.toString(st01.pop()));
				switch(c) {
					case '+' : res = k2 + k1; break;
					case '-' : res = k2 - k1; break;
					case '*' : res = k2 * k1; break;
					case '/' : res = k2 / k1; break;
				}
				String o = Integer.toString(res);
				st01.push(o.charAt(0));
			}
		}
		return Character.toString(st01.pop());
	}
	public static void main(String[] args) {
		new SDA11004().input();
	}
}
