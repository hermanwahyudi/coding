import java.io.*;

public class CountMax
{
	private DataInputStream in;
	public CountMax() {
		in = new DataInputStream(System.in);
	}
	public void input() {
		int T;
		int[] data;
		String[] s;
		try {
			T = Integer.parseInt(in.readLine());
			while(T-- > 0) {
				data = new int[Integer.parseInt(in.readLine())];
				s = in.readLine().split(" ");
				for(int i = 0; i < data.length; i++) {
					data[i] = Integer.parseInt(s[i]);
				}
				solve(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void solve(int[] data) {
		int max = 0, temp, res = 0;
		int[] count = new int[data.length];
		for(int i = 0; i < data.length; i++) {
			temp = data[i];
			for(int j = 0; j < data.length; j++) {
				if(temp == data[j]) {
					count[i]++;
				}
			}
			if(max < count[i]) {
				max = count[i];
				res = data[i];
			} else if(max == count[i]){
				if(data[i] < res) {
					max = count[i];
					res = data[i];
				}
			}
		}
		System.out.println(res + " " + max);
	}
	public static void main(String[] args) {
		new CountMax().input();
	}
}