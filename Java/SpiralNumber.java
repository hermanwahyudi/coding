import java.io.*;

public class SpiralNumber
{
	private DataInputStream in;
	private BufferedWriter io;
	public SpiralNumber() {
		in = new DataInputStream(System.in);
		io = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void solve() {
		int t, n;
		try {
			t = Integer.parseInt(in.readLine());
			while(t-- > 0) {
				n = Integer.parseInt(in.readLine());
				io.write(((((2*n)-1)*((2*n)-1)) + n-1) + "\n");
			}
			io.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SpiralNumber().solve();
	}
}