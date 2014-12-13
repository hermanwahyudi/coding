import java.io.*;

public class DDP11113C
{
    static char[][] ch;
    public static void main(String[] args)
    {
	BufferedReader baca = new BufferedReader(new InputStreamReader(System.in));
	try
	{
	    int kolom = Integer.parseInt(baca.readLine());
	    int baris = Integer.parseInt(baca.readLine());
	    ch = new char[baris][kolom];
	    for(int i = 0; i < baris; i++)
	    {
		String masukan = baca.readLine();
		for(int j = 0; j < kolom; j++)
		    ch[i][j] = masukan.charAt(j);
	    }
	    cek(baris, kolom);
	    cetak(baris, kolom);
	}
	catch(IOException e)
	{
	    e.printStackTrace();
	}
     }
     public static void cek(int baris, int kolom)
     {
	for(int i = 0; i < baris; i++)
	{
	    for(int j = 0; j < kolom; j++)
		if(ch[i][j] == '0')
		    ch[i][j] = apa(i,j);
	}
     }
     public static char apa(int i, int j)
     {
	char hitung = '0';
	if(i-1 >= 0 && j-1 >= 0 && ch[i-1][j-1] == '*')
	    hitung++;
	if(i-1 >= 0 && j >= 0 && ch[i-1][j] == '*')
	    hitung++;
	if(i-1 >= 0 && j+1 < ch[0].length && ch[i-1][j+1] == '*')
	    hitung++;
	if(i >= 0 && j+1 < ch[0].length && ch[i][j+1] == '*')
	    hitung++;
	if(i+1 < ch.length && j+1 < ch[0].length && ch[i+1][j+1] == '*')
	    hitung++;
	if(j >= 0 && i+1 < ch.length && ch[i+1][j] == '*')
	    hitung++;
	if(j-1 >= 0 && i+1 < ch.length && ch[i+1][j-1] == '*')
	    hitung++;
	if(i >= 0 && j-1 >= 0 && ch[i][j-1] == '*')
	    hitung++;
	return hitung;
    }
    public static void cetak(int baris, int kolom)
    {
	for(int i = 0; i < baris; i++)
	{
	    for(int j = 0; j < kolom; j++)
		System.out.print(ch[i][j]);
	    System.out.println();
	}
    }
}

