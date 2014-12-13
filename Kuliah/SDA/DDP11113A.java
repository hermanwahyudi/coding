import java.io.*;
import java.util.*;

public class DDP11113A
{
	public static void main(String[] args)
	{
		BufferedReader baca = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int ukuran = Integer.parseInt(baca.readLine());
			int key = Integer.parseInt(baca.readLine());
			int[] arr = new int[ukuran]; int x; int hasil;
			boolean bool;
			StringTokenizer tok = new StringTokenizer(baca.readLine());
			for(int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(tok.nextToken());
			if(arr.length == 1 || arr.length == 0)
				hasil = -3;
			else if(arr[0] < arr[ukuran-1])
			{
				bool = cekMenaik(arr);
				if(bool == true)
				{
					x = searchMenaik(key, arr, 0, arr.length-1);
					hasil = x >= 0 ? x : -1;
				}
				else
					hasil = -2;
			}
			else
			{
				bool = cekMenurun(arr);
				if(bool == true)
				{
					x = searchMenurun(key, arr, 0, arr.length-1);
					hasil = x >= 0 ? x : -1;
				}
				else
					hasil = -2;
			}
			System.out.print(hasil);

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	private static int searchMenaik(int key, int[] dt, int idxLeft, int idxRight)
	{
		int idxMid = idxLeft + (idxRight - idxLeft) / 2;
		if(idxLeft > idxRight) {
			return -1;
		}
		else if(key == dt[idxMid]) {
			return idxMid;
		}
		else if(key < dt[idxMid]){
			return searchMenaik(key, dt , idxLeft, idxMid - 1);
		}
		else {
			return searchMenaik(key, dt, idxMid + 1, idxRight);
		}
	}
	private static int searchMenurun(int key, int[] dt, int idxLeft, int idxRight)
	{
		int idxMid = idxLeft + (idxRight - idxLeft) / 2;
		if(idxLeft < idxRight) {
			return -1;
		}
		else if(key == dt[idxMid]) {
			return idxMid;
		}
		else if(key > dt[idxMid]){
			return searchMenurun(key, dt , idxLeft, idxMid - 1);
		}
		else {
			return searchMenurun(key, dt, idxMid + 1, idxRight);
		}
	}
	public static boolean cekMenaik(int[] arr)
	{
		boolean bool = true;
		for(int i = 0; i < arr.length && bool; i++)
		{
			for(int j = i+1; j < arr.length && bool; j++)
			{
				if(arr[i] > arr[j])
					bool =false;
			}
		}
		return bool;
	}
	public  static boolean cekMenurun(int[] arr)
	{
		boolean bool = true;
		for(int i = 0; i < arr.length && bool; i++)
		{
			for(int j = i+1; j < arr.length && bool; j++)
			{
				if(arr[i] < arr[j])
					bool =false;
			}
		}
		return bool;
	}
}
