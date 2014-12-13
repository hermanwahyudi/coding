import java.io.*;

public class Spoon
{
	private BufferedReader in;
	private BufferedWriter io;
	public Spoon() {
		in = new BufferedReader(new InputStreamReader(System.in));
		io = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void input() {
		int T, R, C;
		String[] sp, data;
		String str;
		try {
			T = Integer.parseInt(in.readLine());
			while(T-- > 0) {
				sp = in.readLine().split(" ");
				R = Integer.parseInt(sp[0]);
				C = Integer.parseInt(sp[1]);
				if(R < 5 && C < 5) {
					System.out.println("There is indeed no spoon!\n");
				} else {
					int idx = 0;
					data = new String[R];
					int count = R;
					while(count-- > 0) {
						data[idx] = in.readLine();
						idx++;
					}
					solve(data, C);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void solve(String[] data, int C) throws IOException {
		if(data.length < 5) {
			exploreRow(data);
		} else if(C < 5) {
			exploreColumn(data, C);
		} else {
			if(exploreColumn(data, C) == true) return;
			else {
				exploreRow(data);
			}
		}
	}
	public boolean exploreRow(String[] data) throws IOException {
		String s, temp;
		int len;
		boolean notSpoon = true;
		for(int i = 0; i < data.length; i++) {
			s = data[i];
			len = (s.length()/5 + s.length()%5);
			for(int j = 0; j < len; j++) {
				temp = s.substring(j, j+5).toLowerCase();
				if(temp.equals("spoon")) {
					System.out.println("There is a spoon!");
					notSpoon = false;
					return true;
				}
			}
		}
		if(notSpoon) {
			System.out.println("There is indeed no spoon!");
			return notSpoon;
		}
		return false;
	}
	public boolean exploreColumn(String[] data, int C) throws IOException {
		String s = "";
		int idx = 0, i = 0;
		boolean stop = false;
		String[] temp = new String[C];
		for( ; !stop ; ) {
			if(i == data.length) {
				temp[idx] = s;
				s = "";
				i = 0;
				idx++;
				if(idx == C) {
					stop = true;
				}
			} else {
				s += data[i].charAt(idx);
				i++;
			}
		}
		return exploreRow(temp);
	}
	public static void main(String[] args) {
		new Spoon().input();
	}
}