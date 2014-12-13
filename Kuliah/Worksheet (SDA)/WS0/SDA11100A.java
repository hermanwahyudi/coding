import java.io.*;
public class SDA11100A
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));
		String pesan = null;
		while((pesan = entry.readLine()) != null)
			System.out.println(pesan);
	 }
}
