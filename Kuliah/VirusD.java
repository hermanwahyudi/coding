import java.io.*;

public class VirusD
{
	private DataInputStream in;
	private BufferedWriter io;
	public VirusD() {
		in = new DataInputStream(System.in);
		io = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void solve() {
		int K, X, I, n, res, i = 0;
		String[] s;
		try {
			K = Integer.parseInt(in.readLine());
			while(K-- > 0) {
				s = in.readLine().split(" ");
				X = Integer.parseInt(s[0]);
				I = Integer.parseInt(s[1]);
				io.write("Sample #" + i + "\n");
				while(X-- > 0) {
					n = Integer.parseInt(in.readLine());
					res = D(n, I);
					io.write("Hari ke-" + n + ": " + res + "\n");
				}
				i++;
			}
			io.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public int D(int n, int I) {
		if(n == 1) {
			return 4*I + 3;
		} else {
			return 4*D(n-1, I) + 3;
		}
	}
	public static void main(String[] args) {
		new VirusD().solve();
	}
}