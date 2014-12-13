import java.io.*;

public class SpyYou
{
	private static BufferedReader in;
	private static String str, res = "";
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		str = in.readLine();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o') {
				i = i + 2;
			}
			res += str.charAt(i);
		}
		System.out.println(res);
	}
}