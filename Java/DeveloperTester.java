import java.io.*;

public class DeveloperTester
{
	private DataInputStream in;
	private BufferedWriter io;
	public DeveloperTester() {
		in = new DataInputStream(System.in);
		io = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void inputData() {
		int N;
		String str;
		try {
			N = Integer.parseInt(in.readLine());
			while(N-- > 0) {
				str = solve(in.readLine());
				io.write(str);
			}
			io.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String solve(String s) {
		int k = 0, i = 0;
		if(s.length()%2 == 1) {
			return "NO\n";
		} else {
			while(i < s.length()) {
				if(s.charAt(i) == 'T') {
					k++;
				} else {
					k--;
				}
				if(k < 0) {
					return "NO\n";
				}
				i++;
			}
		}
		return (k == 0) ? "YES\n" : "NO\n";
	}
	public static void main(String[] args)  {
		DeveloperTester o = new DeveloperTester();
		o.inputData();
	}
}