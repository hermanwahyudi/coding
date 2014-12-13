import java.io.*;

public class NumbersNumbers
{
	private DataInputStream in;
	private BufferedWriter io;
	public NumbersNumbers() {
		in = new DataInputStream(System.in);
		io = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void input() {
		int T, n;
		try {
			T = Integer.parseInt(in.readLine());
			while(T-- > 0) {
				n = solve(Integer.parseInt(in.readLine()));
				io.write(n + "\n");
			}
			io.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int solve(int n) {
		int x = 0, pow = 5;
		while(n > 0) {
			x += (n%2)*pow;
			pow *= 5;
			n /= 2;
		}
		return x;
	}
	public static void main(String[] args) {
		new NumbersNumbers().input();
	}
}