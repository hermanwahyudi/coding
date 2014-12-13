import java.util.Scanner;

public class SDA11100E
{
    public static void main(String[] args)
    {
	Scanner entry = new Scanner(System.in);
	
	SDA11100E ws = new SDA11100E();
	ws.SegitigaKarakter(entry.nextInt());
    }
    public void SegitigaKarakter(int batas)
    {
	char kar = 'A';
	if(batas >= 1 && batas <= 20)
	{
	    for(int i = 0; i <= batas; i++)
	    {
		for(int j = 0; j < i; j++)
		{
		    System.out.print(kar);
		    if(kar == 'Z')
			kar = 'A'-1;
		    kar++;
		}
		System.out.println();
	    }
	}
    }
}
