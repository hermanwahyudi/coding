import java.io.*;
import java.util.*;

public class DiscTask
{
	public DataInputStream in;
	public ArrayList<String> data = new ArrayList<String>();
	public int k = 0;
	public DiscTask() {
		in = new DataInputStream(System.in);
	}
	public void inputData() {
		String str;
		boolean stop = false;
		try {
			while(!stop) {
				str = in.readLine();
				if(str.equals("#")) {
					stop = true;
				} else {
					data.add(str);
					k++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getMaxLength() {
		int max = 0;
		for(int i = 0; i < data.size(); i++) {
			if(max < data.get(i).length()) {
				max = data.get(i).length();
			}
		}
		return (max > 36) ? 36 : max;
	}
	public void solve() throws IOException {
		int x = 0, N = getMaxLength();
		addSpace(N);
		for(int j = 0; j < 2*k+1; j++) {
			System.out.print("-");
		}
		System.out.println();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2*k+1; j++) {
				if(j%2 == 0) {
					System.out.print("|");
				} else {
					System.out.print(data.get(x).charAt(i));
					x++;
				}
			}
			System.out.println();
			x = 0;
		}
		for(int j = 0; j < 2*k+1; j++) {
			System.out.print("-");
		}
	}
	public void addSpace(int N) {
		String s = "";
		for(int i = 0; i < data.size(); i++) {
			int q = data.get(i).length();
			if(N > q) {
				for(int j = q; j < N; j++) {
					s += " ";
				}
				data.set(i, data.get(i) + s);
			}
			s = "";
		}
	}
	public static void main(String[] args) {
		DiscTask o = new DiscTask();
		o.inputData();
		try {
			o.solve();
		} catch(Exception e) { }
	}
}