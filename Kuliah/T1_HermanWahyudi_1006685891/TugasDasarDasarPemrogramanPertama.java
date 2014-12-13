/** Nama	: Herman Wahyudi
 *  NPM		: 1006685891
 *  Mata Kuliah : Dasar-dasar Pemrograman (6 SKS)
 *  Fakultas    : Ilmu Komputer, Universitas Indonesia
 *  Dosen	: Drs. Lim Yohanes Stefanus M.Math., Ph.D
 */

import javax.swing.JOptionPane;
public class TugasDasarDasarPemrogramanPertama
{
    public static void main(String[] args)
    {
        //Deklarasi tipe variabel
        int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
        String InputAwal;

        //Untuk memunculkan kotak dialog
        InputAwal = JOptionPane.showInputDialog("Ketikan angka interval 0 - 99999");

        //Konversi tipe String menjadi Integer
        a = Integer.parseInt(InputAwal);

        //Perhitungan Desimal ke Binary
        b = a%2; c = a/2; d = c%2; e = c/2; f = e%2; g = e/2; h = g%2; i = g/2;
        j = i%2; k = i/2; l = k%2; m = k/2; n = m%2; o = m/2; p = o%2; q = o/2;
        r = q%2; s = q/2; t = s%2; u = s/2; v = u%2; w = u/2; x = w%2; y = w/2;
        int sisa01 = y%2;
        int HasilBagi01 = y/2;
        int sisa02 = HasilBagi01%2;
        int HasilBagi02 = HasilBagi01/2;
        int sisa03 = HasilBagi02%2;
        int HasilBagi03 = HasilBagi02/2;
        int sisa04 = HasilBagi03%2;
        int HasilBagi04 = HasilBagi03/2;
        int sisa05 = HasilBagi04%2;
        int HasilBagi05 = HasilBagi04/2;
        int sisa06 = HasilBagi05%2;

        //Untuk memunculkan kotak dialog yang berisi konversi Desimal ke Binary
        JOptionPane.showMessageDialog(null, "Konversi binernya adalah: " + sisa06 + sisa05 + sisa04 + sisa03 + sisa02 + sisa01 + x + v + t + r + p + n + l + j + h + f + d + b);

    }
}

/********************************************* - Selesai - **********************************************************************************************************************/
