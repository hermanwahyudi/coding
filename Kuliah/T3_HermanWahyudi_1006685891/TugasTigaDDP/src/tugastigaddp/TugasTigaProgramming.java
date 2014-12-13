/** Nama			: Herman Wahyudi
 *  NPM			: 1006685891
 *  Mata Kuliah 	: Dasar-dasar Pemrograman (6 SKS)
 *  Fakultas    	: Ilmu Komputer, Universitas Indonesia
 *  Dosen		: Drs. Lim Yohanes Stefanus M.Math., Ph.D
 */

package tugastigaddp;

// Import semua library yang ada dipackage..

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TugasTigaProgramming extends JPanel //JPanel mewarisi class TugasTigaProgramming..
{
    // Deklarasi variabel yang dipakai..

    private JTextField inputUser;
    private JLabel labelInput;

    private String semuaBiner;
    private String aturanEAN13;
    private String cetakInput;

    private String[] pindahString = new String[12];
    private boolean validasi = false;

    private int checkSum = 0;
    private int checkDigit = 0;

    private final int awalKoorX = 51;
    private final int awalKoorY = 100;
    private final int lebarBar  = 2;
    private final int tinggiBar = 164;

    //Membuat Constructor dan menambah objek di Panel..

    public TugasTigaProgramming()
    {
                inputUser = new JTextField(12);
                labelInput= new JLabel("Enter code (12 decimal digits): ");

                add(labelInput);
                add(inputUser);

                inputUser.addActionListener(new Barcode_EAN13()); //Masukan user akan diproses di ActionListener..
                setPreferredSize(new Dimension(293, 310)); //Mengatur ukuran Frame..
    }
    private class Barcode_EAN13 implements ActionListener //Class Barcode_EAN13 mengimplementasi method di ActionListener dan mendeklarasikannya..
    {
                public void actionPerformed(ActionEvent e) //Mthod abstract ActionListener dan dideklarasikan didalamnya..
                {
                        //Variabel loka yand ada di method actionPerformed..

                        String Input      = inputUser.getText();
                        char[] ubahKeChar = Input.toCharArray();
                        int[]  ubahKeInt  = new int[Input.length()];
                        boolean charValid = true;

                        semuaBiner = ""; //Untuk mengembalikan kumpulan biner ke kosong jika user memasukan input lagi..

                        //Untuk mengecek apakah inputUser ada yang huruf atau tidak..

                        for(int i = 0; i < ubahKeChar.length ; i++){
                                if (Character.isLetter(ubahKeChar[i])){
                                        charValid = false;
                                        break;
                                }
                        }

                        //Kondisi dimana inputUser sebanyak 12digit dan tidaka ada yang huruf..

                        if(Input.length() == 12 && charValid)
                        {
                                //pindahString untuk menampilkan ke Panel dan ubahKeInt untuk menghitung checkSum oleh karena itu harus dikonversi dahulu..

                                for(int i = 0; i < Input.length(); i++){
                                        pindahString[i] = Character.toString(ubahKeChar[i]);
                                        ubahKeInt[i]    = Integer.parseInt(pindahString[i]);

                                        //Mencari checkSum

                                        if(i%2 == 1){
                                                checkSum = checkSum + ubahKeInt[i]*3;
                                        }
                                        else if(i%2 == 0){
                                                checkSum = checkSum + ubahKeInt[i]*1;
                                        }
                                }

                                //Mencari inputUser pada digit pertama apakah struktur inputUser dari tipe EAN-13..

                                if(Input.charAt(0) == '0'){
                                        aturanEAN13 = "LLLLLLRRRRRR";
                                }
                                else if(Input.charAt(0) == '1') { aturanEAN13 = "LLGLGGRRRRRR"; }
                                else if(Input.charAt(0) == '2') { aturanEAN13 = "LLGGLGRRRRRR"; }
                                else if(Input.charAt(0) == '3') { aturanEAN13 = "LLGGGLRRRRRR"; }
                                else if(Input.charAt(0) == '4') { aturanEAN13 = "LGLLGGRRRRRR"; }
                                else if(Input.charAt(0) == '5') { aturanEAN13 = "LGGLLGRRRRRR"; }
                                else if(Input.charAt(0) == '6') { aturanEAN13 = "LGGGLLRRRRRR"; }
                                else if(Input.charAt(0) == '7') { aturanEAN13 = "LGLGLGRRRRRR"; }
                                else if(Input.charAt(0) == '8') { aturanEAN13 = "LGLGGLRRRRRR"; }
                                else if(Input.charAt(0) == '9') { aturanEAN13 = "LGGLGLRRRRRR"; }

                                //Array dari biner 11 digit selanjutnya dan biner checkDigit(digit ke 12)..

                                String[] L = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
                                String[] G = {"0100111", "0110011", "0011011", "0100001", "0011101", "0111001", "0000101", "0010001", "0001001", "0010111"};
                                String[] R = {"1110010", "1100110", "1101100", "1000010", "1011100", "1001110", "1010000", "1000100", "1001000", "1110100"};

                                //Me-looping digit ke-2 s/d ke 11 apakah bertipe L or R or G digabung semua binernya..

                                for(int i = 0; i < aturanEAN13.length()-1; i++){
                                        if(aturanEAN13.charAt(i) == 'L'){ //Jika tipe L..
                                                semuaBiner = semuaBiner + L[Integer.parseInt(Character.toString(Input.charAt(i+1)))];
                                        }
                                        else if(aturanEAN13.charAt(i) == 'R'){ //Jika tipe R..
                                                semuaBiner = semuaBiner + R[Integer.parseInt(Character.toString(Input.charAt(i+1)))];
                                        }
                                        else if(aturanEAN13.charAt(i) == 'G'){ //Jika tipe G..
                                                semuaBiner = semuaBiner + G[Integer.parseInt(Character.toString(Input.charAt(i+1)))];
                                        }
                                }
                                checkDigit = checkSum%10; //Mencari checkDigit

                                //Mencari checkDigit dan checkDigit bukan nol..

                                if(checkDigit != 0){
                                        checkDigit = 10-checkDigit;
                                }

								semuaBiner = semuaBiner + R[checkDigit]; //Menggabungkan kumpulan biner dengan biner dari checkDigit..

                                //Untuk mencetak inputUser di bawah bar..

                                cetakInput = pindahString[0]+ "  " + pindahString[1] + " " + pindahString[2] + " " + pindahString[3] + " " + pindahString[4] + " " + pindahString[5] + " " + pindahString[6] + "   " + pindahString[7]+ " " + pindahString[8] + " " + pindahString[9] + " " + pindahString[10] + " " + pindahString[11] + " " + checkDigit;

                                validasi = true; //validasi jadi true karena masukan adalah 12 dan bukan huruf..
                                checkSum = 0; //Mengembalikan checkSum ke nol..
                        }
                        else if(Input.length() != 12 || charValid){
                                JOptionPane.showMessageDialog(null, "Input salah! Silahkan perbaiki."); //Jika inputUser dan huruf..
                        }
                        else if(Input.length() == 12 || charValid){
                                JOptionPane.showMessageDialog(null, "Input salah! Silahkan perbaiki."); //Jika inputUser 12 dan huruf..
                        }

                        TugasTigaProgramming.this.repaint(); // Untuk menggambar..
                }
        }
        public void paintComponent(Graphics g) //Method paintComponent untuk menggambar bar..
        {
                super.paintComponent(g); //Memanggil var g dari tipe Graphics..

                if(validasi){ //Jika kondisi benar, maka bar akan tergambar..

                    String pindahBiner = semuaBiner; //Memindahkan kumpulan biner ke mmethod paintComponent untuk menggambar bar..
                    String dibawahBar  = cetakInput;  //Memindahkan inputUser ke mmethod paintComponent untuk digambar dibawah bar..

                    int pindahCheckDigit = checkDigit;  //Memindahkan checkDigit ke mmethod paintComponent..

                    //Kumpulan biner dipotong dua bagian dari digit pertama ke 42 dan dari digit ke 43 ke 84..

                    String pindahBinerPertama = pindahBiner.substring(0, 42);
                    String pindahBinerKedua   = pindahBiner.substring(42, 84);

                    //Mengubah String ke Char..

                    char[] charBinerPertama   = pindahBinerPertama.toCharArray();
                    char[] charBinerKedua     = pindahBinerKedua.toCharArray();

                    //Menggambar tulisan EAN-Barcode diatas bar..

                    g.setFont(new Font("Arial", Font.BOLD, 17));
                    g.drawString("EAN-13 Barcode:", 80, 75);

                    //Menggambar inputUser dibawah bar..

                    g.setColor(Color.BLACK);
                    g.drawString(dibawahBar, 40 , 275);

                    //Tiga bar pertama sebelum bar-bar 6 digits pertama..

                    g.setColor(Color.BLACK);
                    g.fillRect(awalKoorX,   awalKoorY, lebarBar, tinggiBar);
                    g.setColor(Color.WHITE);
                    g.fillRect(awalKoorX+2, awalKoorY, lebarBar, tinggiBar);
                    g.setColor(Color.BLACK);
                    g.fillRect(awalKoorX+4, awalKoorY, lebarBar, tinggiBar);

                    //Tiga bar diantara bar-bar 6 digits pertama dan 6 digits kedua..

                    g.setColor(Color.BLACK);
                    g.fillRect(awalKoorX+92, awalKoorY, lebarBar, tinggiBar);
                    g.setColor(Color.WHITE);
                    g.fillRect(awalKoorX+94, awalKoorY, lebarBar, tinggiBar);
                    g.setColor(Color.BLACK);
                    g.fillRect(awalKoorX+96, awalKoorY, lebarBar, tinggiBar);

                    //Tiga bar setelah bar-bar 6 digits kedua..

                    g.setColor(Color.BLACK);
                    g.fillRect(awalKoorX+184, awalKoorY, lebarBar, tinggiBar);
                    g.setColor(Color.WHITE);
                    g.fillRect(awalKoorX+186, awalKoorY, lebarBar, tinggiBar);
                    g.setColor(Color.BLACK);
                    g.fillRect(awalKoorX+188, awalKoorY, lebarBar, tinggiBar);

                    //Mengatur tampilan Check Digit yang dibawah bar

                    g.setColor(Color.RED);
                    g.drawString("Check Digit: " + pindahCheckDigit, 85 , 298);

                    //Menggambar bar dari kumpulan biner

                    for(int i = 0; i < charBinerPertama.length; i++){
                                if(charBinerPertama[i] == '1'){
                                        g.setColor(Color.BLACK);
                                        g.fillRect(awalKoorX+6+i*2,awalKoorY, lebarBar, tinggiBar-12);
                                }
                                else if(charBinerPertama[i] == '0'){
                                        g.setColor(Color.WHITE);
                                        g.fillRect(awalKoorX+6+i*2,awalKoorY, lebarBar, tinggiBar-12);
                                }
                        }
                    for(int i = 0; i < charBinerKedua.length; i++){
                                if(charBinerKedua[i] == '1'){
                                        g.setColor(Color.BLACK);
                                        g.fillRect(awalKoorX+100+i*2,awalKoorY, lebarBar, tinggiBar-12);
                                }
                                else if(charBinerKedua[i] == '0'){
                                        g.setColor(Color.WHITE);
                                        g.fillRect(awalKoorX+100+i*2,awalKoorY, lebarBar, tinggiBar-12);
                                }
                    }
                }
        }
}