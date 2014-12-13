import java.io.*;

public class BookPages
{
	private DataInputStream in;
	private BufferedWriter io;
	public BookPages() {
		in = new DataInputStream(System.in);
		io = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void input() {
		boolean stop = false;
		String str, res;
		try {
			while(!stop) {
				str = in.readLine();
				if(str.equals("#")) {
					stop = true;
				} else {
					res = solve(Integer.parseInt(str));
					io.write(res + "\n");
				}
			}
			io.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public String solve(int n) {
		long temp = n, x = 9, y = 0;
		int i = 1;
		while(temp > i * x){
			temp = temp - i * x;
			i++;
			y += x;
			x *= 10;
		}
		return (temp%i == 0) ? Long.toString((y + (temp/i))) : "Impossible!";
	}
	public static void main(String[] args) {
		new BookPages().input();
	}
}