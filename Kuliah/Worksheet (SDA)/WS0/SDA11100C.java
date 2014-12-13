import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class SDA11100C 
{

    private static int byt= 0;
    private static byte[] buff = new byte[1024];
    public static void main(String[] args) throws IOException
   {
      BufferedInputStream masukan = new BufferedInputStream(System.in);
      BufferedOutputStream keluaran = new BufferedOutputStream(System.out);
      while (true){
	  if((byt = masukan.read(buff)) == -1){
		break;
	  }
	  keluaran.write(buff, 0, byt);
	}
	keluaran.flush();

    }
}
