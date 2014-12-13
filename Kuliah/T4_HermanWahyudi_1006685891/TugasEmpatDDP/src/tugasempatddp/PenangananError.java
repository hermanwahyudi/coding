/**
 * Nama         : Herman Wahyudi
 * NPM          : 1006685891
 * Fakultas     : Ilmu Komputer
 * Matakuliah   : Dasar-dasar Pemrograman (6 SKS)
 */

package tugasempatddp; //package di direktori tugasempatddp

/**
 *
 * @author Herman Wahyudi
 */

//mengimport semua class di package yang di import..

import java.io.*;
import java.util.*;
import java.awt.*;

//Class PenangananError untuk menangani error..

public class PenangananError
{
    //Method ambilGambar adalh method untuk mengambil file dengan isi String untuk digambar kembali..

    public ArrayList<Shape> ambilGambarDariFile(File file) throws FileNotFoundException, BadDataException
    {
			//deklarasi Shape dan gambar

            ArrayList<Shape> shape = new ArrayList();
            Shape gambar = null;
            Scanner bacaPerBaris = new Scanner(file);

            while(bacaPerBaris.hasNextLine()) //memeriksa konfigurasi gambar tiap baris
            {
                String baris = bacaPerBaris.nextLine();

                String[] str = baris.split(";"); //Memisahkan barisan string dengan bentuk array dan pemisah ';'

                 if(!str[0].equals("Rectangle") && !str[0].equals("Line") && !str[0].equals("Oval")){ //Array pertama diperiksa
                    throw new BadDataException("Shape type unexpedted, " + str[0] + " encountered");
                }

				//Array kedua sampai kelima di konversi ke Integer agar bisa digambar kembali
                int x1 = Integer.parseInt(str[1]);
                int y1 = Integer.parseInt(str[2]);
                int x2 = Integer.parseInt(str[3]);
                int y2 = Integer.parseInt(str[4]);

				//Array ke empat di konversi ke boolean agar bisa digambar kembali
                boolean bool = Boolean.parseBoolean(str[5]);

				//Array lima sampai keenam di konversi ke Integer agar bisa digambar kembali
                int merah = Integer.parseInt(str[6]);
                int hijau = Integer.parseInt(str[7]);
                int biru  = Integer.parseInt(str[8]);

				//Konversi konstanta warna ke warna
                Color warna = new Color(merah, hijau, biru);

				//Pemilihan array pertama apakah rectangle, line, ataukah oval..
                if(str[0].equals("Rectangle"))
                    gambar = new Rectangle(x1,y1,x2,y2,bool,warna);
                else if(str[0].equals("Line"))
                    gambar = new Line(x1,y1,x2,y2,bool,warna);
                else if(str[0].equals("Oval"))
                    gambar = new Rectangle(x1,y1,x2,y2,bool,warna);

				//menambah gambar ke array list
                shape.add(gambar);
             }
            return shape; //mengembalikan gambar ke kanvas
    }

    //Method simpanambar untuk menyimpan gambar dalam String ke file bertipe notepad..

    public void simpanGambar(ArrayList<Shape> shapes, File file) throws FileNotFoundException
    {
        PrintWriter tulis = new PrintWriter(file); //Inialisai objek dari class PrintWriter..

        int i = 0;
        while(i < shapes.size()){
            tulis.println(shapes.get(i));
            i++;
        }
        tulis.close(); //Menutup file yang telah ditulis..
    }
}

// class bila konfigurasi tidak sesuai, akan muncul error dan nge throw exception
class BadDataException extends IOException
{
    public BadDataException(){}
    public BadDataException(String pesan)
    {
        super(pesan);
    }
}
