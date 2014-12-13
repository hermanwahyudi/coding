import java.util.*;
import java.io.*;

public class SDA11101
{
    public static void mcss(BufferedReader entry) throws IOException
    {
	    int k = Integer.parseInt(entry.readLine());
	    for(int j = 0; j < k; j++)
	    {
		int n = Integer.parseInt(entry.readLine());
		StringTokenizer st = new StringTokenizer(entry.readLine());
		int maxSum = 0; int Sum = 0;
		int akhir = 1; int awal = 1; int akhirKedua = 1; int awalKedua = 1;
		for(int i = 0; i < n; i++){
			Sum += Integer.parseInt(st.nextToken());
			akhirKedua++;
			if(Sum > maxSum){ 
				maxSum = Sum;
				awal = awalKedua;
				akhir = akhirKedua;
			}	
			else if(Sum < 0){
				Sum = 0;
				awalKedua = i+2;
			}
			else if(maxSum == Sum){
				if((akhir-awal) < (akhirKedua-awalKedua)){
					akhir = akhirKedua;
					awal = awalKedua;
				}
			}
		}
	        if(maxSum == 0)
		    System.out.println("Rute "+(j+1)+" tidak asyik");
	        else
		    System.out.println("Jalan asyik rute "+(j+1)+" adalah diantara pemberhentian bus "+(awal)+" dan "+(akhir));
               }
    }
    public static void main(String[] args) throws IOException {
	mcss(new BufferedReader(new InputStreamReader(System.in)));
    }
}
	
