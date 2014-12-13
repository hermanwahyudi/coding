import java.io.*;
import java.util.*;

public class sda09kuis1
{
	private static int[][] matrix;
	public static void masukan(int i, int j, int nilai)
	{
		matrix[i][j] = nilai;
	}
	public static void ukuran(int x, int y)
	{
		matrix = new int[x][y];
	}
	public static int[][] hasilMasukan()
	{
		return matrix;
	}
	public static void Isi(BufferedReader entry) throws IOException
	{
		StringTokenizer tok = new StringTokenizer(entry.readLine());
		int x = Integer.parseInt(tok.nextToken());
		int y = Integer.parseInt(tok.nextToken());
		ukuran(x,y); int luas = 0;
		for(int i = 0; i < x; i++)
		{
			tok = new StringTokenizer(entry.readLine());
			for(int j = 0; j < y; j++)
			{
				masukan(i, j, Integer.parseInt(tok.nextToken()));
				if(matrix[i][j] == 1)
				    luas++;
			}
		}
		luasTotal(hasilMasukan(), x, y);
		System.out.println(luas);
	}
	public static void luasTotal(int[][] ar, int x, int y)
	{
		int sumber = 0;
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j ++)
			{
				if(ar[i][j] == 1)
				{
					ar[i][j] = 0;
					sumberApi(ar, i, j);
					    sumber++;
				 }

			}
		}
		System.out.println(sumber);

	}
	public static void sumberApi(int[][] ar, int x, int y)
	{
		if(x+1 >= 0 && y >= 0 && x+1 < ar.length && y < ar[0].length)
		{
			if(ar[x+1][y] == 1)
			{
				ar[x+1][y] = 0;
				sumberApi(ar, x+1,y);
			}
		}
		if(x >= 0 && y+1 >= 0 && x < ar.length && y+1 < ar[0].length)
		{
			if(ar[x][y+1] == 1)
			{
				ar[x][y+1] = 0;
				sumberApi(ar, x,y+1);
			}
		}
		if(x-1 >= 0 && y >= 0 && x-1 < ar.length && y < ar[0].length)
		{
			if(ar[x-1][y] == 1)
			{
				ar[x-1][y] = 0;
				sumberApi(ar, x-1,y);
			}
		}
		if(x >= 0 && y-1 >= 0 && x < ar.length && y-1< ar[0].length)
		{
			if(ar[x][y-1] == 1)
			{
				ar[x][y-1] = 0;
				sumberApi(ar, x, y-1);
			}
		}

	}
	public static void main(String[] args)
	{
		BufferedReader baca = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			Isi(baca);
		}
		catch(IOException e){ }
	}
}

