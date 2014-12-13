/**
 * Nama         : Herman Wahyudi
 * NPM          : 1006685891
 * Fakultas     : Ilmu Komputer
 * Matakuliah   : Dasar-dasar Pemrograman (6 SKS)
 */

package tugasempatddp;

/**
 *
 * @author Herman Wahyudi
 */

//import semua library di package untuk dipakai di class TempatGambar

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class TempatGambar extends JPanel //JPanel mewarisi kelas TempatGambar
{
    //buat objek shapes dari tipe arraylist karena objek yang digambar tak bisa ditentukan, oleh karena itu tidak bisa pakai array biasa..
    ArrayList<Shape> shapes = new ArrayList();
    PenangananError fe = new PenangananError(); //Pembuatan objek dari class PenagnanError

    //Constructor dengan inialisai awal tempat untuk menggambar adalah putih..
    public TempatGambar(){
        setBackground(Color.WHITE);
    }

    //method untuk menggambar objek..
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); //pemanggilan method dari kelas super..

        int i = 0;
        while(i < shapes.size()){ //gambar akan di tambah jika kita terus menggambar dalam arraylist
                Shape shape = (Shape) shapes.get(i);
                shape.draw((Graphics2D) g);
         i++;
        }
    }

	//method untuk menambah gambar
    public void tambahShape(Shape shap){
        shapes.add(shap);
    }

	//method untuk menghapus semua gambar dalam kanvas
    public void hapusKanvas(){
        shapes.clear();
        repaint();
    }

	//method unruk menyimpan gambar denagn memuncukan JFileChooser
    public void simpan() throws FileNotFoundException
    {
        JFileChooser file = new JFileChooser();
        int OK = file.showSaveDialog(null);

        if (OK == JFileChooser.APPROVE_OPTION) //Jika klik OK
            fe.simpanGambar(shapes, file.getSelectedFile());
    }

	//method unruk mengambil gambar denagn memuncukan JFileChooser
    public void ambilGambar() throws FileNotFoundException, BadDataException
    {
        JFileChooser file = new JFileChooser();
        int OK = file.showOpenDialog(null);

        if (OK == JFileChooser.APPROVE_OPTION) //Jika klik OK, gambar aka muncul kembali dengan memanggil method repaint
            shapes = fe.ambilGambarDariFile(file.getSelectedFile());
        repaint(); //gambar aka muncul kembali dengan memanggil method repaint
    }
}

class Shape
{
	//Variabel yang mempunyai access speciefier protected agar bisa di akses di kelas turunannya saja (Konsep Inheritance)
    protected boolean isiWarna;
    protected Color warna;
    protected int x1 ,x2, y1, y2;

	//method yang belum di deklarasikan dan dideklarasikan di kelas turunannya saja dengan aksi berbeda (Konsep Polimorfisme)
    protected void draw(Graphics2D g2){}
}

class Rectangle extends Shape
{
    public Rectangle(int x1, int y1, int x2, int y2, boolean isi, Color color) //Constructor Rectangle dengan memasukkan nilai koordinat, warna, dan isi warna
    {
		//Assignment nilai dari lokal variabel ke instance variable class Shape

        isiWarna = isi;
        warna = color;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public void draw(Graphics2D g2)
    {
        g2.setColor(warna); //setColor untuk warna yang dipilih di JColorChooser
        if ((x1 > x2) && (y1 > y2)){ //Jika mouse digeser dari kanan bawah ke kiri atas
            if (isiWarna) //Jika gambar ingin diisi warna
                g2.fillRect(x2, y2, x1-x2, y1-y2);
            else
                g2.drawRect(x2, y2, x1-x2, y1-y2);
        }
        else if ((x1 < x2) && (y1 < y2)){ //Jika mouse digeser dari kiri atas ke kanan bawah
            if (isiWarna) //Jika gambar ingin diisi warna
                g2.fillRect(x1,y1,x2-x1,y2-y1);
            else
                g2.drawRect(x1,y1,x2-x1,y2-y1);
        }
        else if ((x1 < x2) && (y1 > y2)){ //Jika mouse digeser dari kiri bawah ke kanan atas
            if (isiWarna) //Jika gambar ingin diisi warna
                g2.fillRect(x1,y2,x2-x1,y1-y2);
            else
                g2.drawRect(x1,y2,x2-x1,y1-y2);
        }
        else if ((x1 > x2) && (y1 < y2)){ //Jika mouse digeser dari kanan atas ke kiri bawah
            if (isiWarna)//Jika gambar ingin diisi warna
                g2.fillRect(x2,y1,x1-x2,y2-y1);
            else
                g2.drawRect(x2,y1,x1-x2,y2-y1);
        }
    }
    public String toString(){ //Konfigurasi jika ingin disimpan ke file
        return "Rectangle;" + x1 + ";" + y1 + ";" + x2 + ";" + y2 + ";" + isiWarna + ";" + warna.getRed() + ";" + warna.getGreen() + ";" + warna.getBlue();
    }
}

class Line extends Shape
{
    public Line(int x1, int y1, int x2, int y2, boolean isi, Color color) //Constructor Line dengan memasukkan nilai koordinat, warna, dan isi warna
    {
		//Assignment nilai dari lokal variabel ke instance variable class Shape
        warna = color;
        isiWarna = isi;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public void draw(Graphics2D g2){
        g2.setColor(warna); //setColor untuk warna yang dipilih di JColorChooser
        g2.drawLine(x1, y1, x2, y2); //Menggambar garis dari arah mana pun
    }
    public String toString(){ //Konfigurasi jika ingin disimpan ke file
        return "Oval;" + x1 + ";" + y1 + ";" + x2 + ";" + y2 + ";" + isiWarna + ";" + warna.getRed() + ";" + warna.getGreen() + ";" + warna.getBlue();
    }
}

class Oval extends Shape
{
    public Oval(int x1, int y1, int x2, int y2, boolean isi, Color color) //Constructor Oval dengan memasukkan nilai koordinat, warna, dan isi warna
    {
		//Assignment nilai dari lokal variabel ke instance variable class Shape
        isiWarna = isi;
        warna = color;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public void draw(Graphics2D g2)
    {
        g2.setColor(warna); //setColor untuk warna yang dipilih di JColorChooser
        if ((x1 > x2) && (y1 > y2)){ //Jika mouse digeser dari kanan bawah ke kiri atas
            if (isiWarna) //Jika gambar ingin diisi warna
                g2.fillOval(x2, y2, x1-x2, y1-y2);
            else
                g2.drawOval(x2, y2, x1-x2, y1-y2);
        }
        else if ((x1 < x2) && (y1 < y2)){ //Jika mouse digeser dari kiri atas ke kanan bawah
            if (isiWarna) //Jika gambar ingin diisi warna
                g2.fillOval(x1,y1,x2-x1,y2-y1);
            else
                g2.drawOval(x1,y1,x2-x1,y2-y1);
        }
        else if ((x1 < x2) && (y1 > y2)){ //Jika mouse digeser dari kiri bawah ke kanan atas
            if (isiWarna) //Jika gambar ingin diisi warna
                g2.fillOval(x1,y2,x2-x1,y1-y2);
            else
                g2.drawOval(x1,y2,x2-x1,y1-y2);
        }
        else if ((x1 > x2) && (y1 < y2)){ //Jika mouse digeser dari kanan atas ke kiri bawah
            if (isiWarna) //Jika gambar ingin diisi warna
                g2.fillOval(x2,y1,x1-x2,y2-y1);
            else
                g2.drawOval(x2,y1,x1-x2,y2-y1);
        }
     }
     public String toString(){ //Konfigurasi jika ingin disimpan ke file
        return "Oval;" + x1 + ";" + y1 + ";" + x2 + ";" + y2 + ";" + isiWarna + ";" + warna.getRed() + ";" + warna.getGreen() + ";" + warna.getBlue();
    }
}
