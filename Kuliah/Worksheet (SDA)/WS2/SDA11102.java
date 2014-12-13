import java.io.*;
import java.util.*;

public class SDA11102
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader entry = new BufferedReader(new InputStreamReader(System.in),5000000);
		BufferedWriter tulis = new BufferedWriter(new OutputStreamWriter(System.out),1000000);
		PriorityQueue<Setoran> antri = new PriorityQueue<Setoran>();
		HashSet<String> op = new HashSet<String>(100001);
		String input = entry.readLine();
		String nama; int uang;
		while(input != null)
		{
			StringTokenizer st = new StringTokenizer(input,",");
			nama = st.nextToken();
			uang = Integer.parseInt(st.nextToken());
			
			if(uang != 0 && !op.contains(nama))
				antri.add(new Setoran(nama,uang));
			
			op.add(nama);
			input = entry.readLine();
			
		}
		int i = 1;
		while(antri.size() > 0){
			Setoran t = antri.poll();
			tulis.write("Korban peringkat ke-"+i+" adalah "+t.nama+", jumlah setoran "+t.uang +"\n");
			i++;
		}
		tulis.flush();
	}
}
class Setoran implements Comparable<Setoran>
{
	String nama;
	int uang;
	public Setoran(String nama, int uang)
	{
		this.nama = nama;
		this.uang = uang;
	}
	public int compareTo(Setoran apa)
	{
		if(this.uang > apa.uang)
			return -1;
		else if(this.uang < apa.uang)
			return 1;
		else
			return this.nama.compareTo(apa.nama);
	}
}