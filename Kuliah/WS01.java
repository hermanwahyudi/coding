import java.io.*;

public class WS01
{
	private DataInputStream in;
	private BufferedWriter io;
	private int max = 0, j = 0;
	public WS01() {
		in = new DataInputStream(System.in);
		io = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void inputData() {
		int T, B, i = 0, k = 1;
		String[] ar;
		int[] data;
		try {
			T = Integer.parseInt(in.readLine());
			while(T-- > 0) {
				B = Integer.parseInt(in.readLine());
				data = new int[B];
				while(B-- > 0) {
					ar = in.readLine().split(" ");
					solve(ar, i, data);
					i++;
				}
				io.write("Toko #" + k + ": " + (j+1) + "\n");
				i = 0;
				max = 0;
				k++;
			}
			io.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void solve(String[] ar, int i, int[] data) {
		data[i] = Integer.parseInt(ar[0]) +  Integer.parseInt(ar[1]) +  Integer.parseInt(ar[2]);
		if(max < data[i]) {
			max = data[i];
			j = i;
		}
	}
	public static void main(String[] args) {
		new WS01().inputData();
	}
}