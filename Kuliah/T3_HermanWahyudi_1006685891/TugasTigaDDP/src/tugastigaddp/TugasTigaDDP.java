/** Nama			: Herman Wahyudi
 *  NPM			: 1006685891
 *  Mata Kuliah 	: Dasar-dasar Pemrograman (6 SKS)
 *  Fakultas    	: Ilmu Komputer, Universitas Indonesia
 *  Dosen		: Drs. Lim Yohanes Stefanus M.Math., Ph.D
 */

package tugastigaddp;

/**
 *
 * @author Herman
 */

import javax.swing.*;

    public class TugasTigaDDP extends JFrame //Class JFrame mewarisi class TugasTigaDDP..
    {
        public static void main(String[] args) //Method main untuk memerintahkan penggambaran barcode EAN-13..
        {
            JFrame frame = new JFrame("EAN-13 (By: Herman Wahyudi)"); //Membuat objek frame dan menge-set title..
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Agar jendela bisa ditutup..

            TugasTigaProgramming BarcodeEAN_13 = new TugasTigaProgramming(); //Membuat objek dari class TugasTigaProgramming..

            frame.getContentPane().add(BarcodeEAN_13); //Menambahkan isi di class TugasTigaProgramming agar bisa kegambar..

            frame.setResizable(false); //Agar tidak bisa diperbesar..
            frame.pack(); //Mengatur ukuran Jendela sesuai kebutuhan..
            frame.setVisible(true); //Agar bisa muncul di window..
        }
}
/************************************************************* Alhamdulillah *******************************************************************/
