import java.io.*;

public class sda09lat1A
{
	public static void pegunungan(int input)
	{
		if(input == 1)
			System.out.println("*");
		else
		{
			pegunungan(input-1);

			for(int i = 0; i < input; i++)
				System.out.print("*");
			System.out.println();
			pegunungan(input-1);
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader baca = new BufferedReader(new InputStreamReader(System.in));
		pegunungan(Integer.parseInt(baca.readLine()));
	}
}