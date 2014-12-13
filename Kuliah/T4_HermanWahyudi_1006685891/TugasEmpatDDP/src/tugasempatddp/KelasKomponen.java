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

//Import package-package yang diperlukan dalam aplikasi

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

//Nama class yang meng extends JFrame sebagai class super

public class KelasKomponen extends JFrame
{
	//Inialisai grup yang diperlukan dalam container

    private ButtonGroup buttonGroup1 = new ButtonGroup();
    private ButtonGroup buttonGroup2 = new ButtonGroup();
    private JButton jButton1 = new JButton("Choose Color");
    private JMenu jMenu1 = new JMenu("File");
    private JMenuBar jMenuBar1 = new JMenuBar();
    private JMenuItem jMenuItem1 = new JMenuItem("New");
    private JMenuItem jMenuItem2 = new JMenuItem("Open");
    private JMenuItem jMenuItem3 = new JMenuItem("Save");
    private JMenuItem jMenuItem4 = new JMenuItem("Exit");
    private JRadioButton jRadioButton1 = new JRadioButton("Filled");
    private JRadioButton jRadioButton2 = new JRadioButton("Not Filled");
    private JToggleButton jToggleButton1 = new JToggleButton();
    private JToggleButton jToggleButton2 = new JToggleButton();
    private JToggleButton jToggleButton3 = new JToggleButton();
    private TempatGambar myCanvas1 = new TempatGambar();


	//inialisai variabel static yang diperlukan

	private static char pilihBentuk = 'R';
    private static Color warnaSekarang = Color.BLACK;
    private static boolean IsiWarna =  true;
    private static int awalX = 0;
    private static int awalY = 0;
    private static int akhirX = 0;
    private static int akhirY = 0;

    JFileChooser pilihFile;
    private Shape shape = null;

	//Constructor yang akan menyediakan objek komponen yang di add ke dalam container

    public KelasKomponen()
    {
        super("Herman's Paint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //tombol exit agar program berhenti

        buttonGroup2.add(jToggleButton1); //Button group agar diantara group toggle button, hanya satu yang dipilih
        jToggleButton1.setIcon(new ImageIcon("C:\\Users\\Herman\\Documents\\NetBeansProjects\\TugasEmpatDDP\\Rectangle.gif")); //Memasang gambar rectagle di toggle button
        jToggleButton1.setSelected(true); //Kondisi awal true, jadi saat kita press dan released mouse akan langsung tergambar rectangle
        jToggleButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        jToggleButton1ActionPerformed(e);
                }
        });

        buttonGroup2.add(jToggleButton2); //Button group agar diantara group toggle button, hanya satu yang dipilih
        jToggleButton2.setIcon(new ImageIcon("C:\\Users\\Herman\\Documents\\NetBeansProjects\\TugasEmpatDDP\\Line.gif")); //Memasang gambar Line di toggle button
        jToggleButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        jToggleButton2ActionPerformed(e);
                }
        });

        buttonGroup2.add(jToggleButton3); //Button group agar diantara group toggle button, hanya satu yang dipilih
        jToggleButton3.setIcon(new ImageIcon("C:\\Users\\Herman\\Documents\\NetBeansProjects\\TugasEmpatDDP\\Oval.gif")); //Memasang gambar Oval di toggle button
        jToggleButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        jToggleButton3ActionPerformed(e);
                }
        });

		//tambahkan actionListener untuk memberikan aksi bila kita menekan buttton choose color
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        jButton1ActionPerformed(e);
                }
        });

		//tambahkan actionListener untuk memberikan aksi bila kita memilih Filled
        buttonGroup1.add(jRadioButton1); //Button group agar diantara group radio button, hanya satu yang dipilih
        jRadioButton1.setSelected(true); //Kondisi awal true, jadi saat kita press dan released mouse akan langsung tergambar gambar yang terisi warna
        jRadioButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        jRadioButton1ActionPerformed(e);
                }
        });

		//tambahkan actionListener untuk memberikan aksi bila kita memilih Not Filled
        buttonGroup1.add(jRadioButton2); //Button group agar diantara group radio button, hanya satu yang dipilih
        jRadioButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        jRadioButton2ActionPerformed(e);
                }
        });

		//tambahkan mouseListener untuk memberikan aksi bila kita menekan mouse dan di released maka akan muncul gambar
        myCanvas1.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                        myCanvas1MousePressed(e);
                }
                public void mouseReleased(MouseEvent e) {
                        myCanvas1MouseReleased(e);
                }
        });

        javax.swing.GroupLayout myCanvas1Layout = new javax.swing.GroupLayout(myCanvas1);
        myCanvas1.setLayout(myCanvas1Layout);
        myCanvas1Layout.setHorizontalGroup(
                myCanvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1000, Short.MAX_VALUE) //Ukuran lebar kanvas
        );
        myCanvas1Layout.setVerticalGroup(
                myCanvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 500, Short.MAX_VALUE) //ukuran tinggi kanvas
        );

		//tambahkan actionListener untuk memberikan aksi bila kita menekan menuItem new
        jMenuItem1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        jMenuItem1ActionPerformed(e);
                }
        });

		//tambahkan actionListener untuk memberikan aksi bila kita menekan menuItem Open
        jMenuItem2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        jMenuItem2ActionPerformed(e);
                }
        });

		//tambahkan actionListener untuk memberikan aksi bila kita menekan menuItem Save
        jMenuItem3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        jMenuItem3ActionPerformed(e);
                }
        });

		//tambahkan actionListener untuk memberikan aksi bila kita menekan menuItem exit
        jMenuItem4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        jMenuItem4ActionPerformed(e);
                }
        });

		//Menambahkan menuItem kedalan]m container dan da di dalm menuBar
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem3);
        jMenu1.add(jMenuItem4);

		//Menambahkan menuItem kedalan]m container
        jMenuBar1.add(jMenu1);

		//Mengatur menuBar
        setJMenuBar(jMenuBar1);

		//Layout untuk mengatur letak komponen-komponen..
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2))
                        .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(myCanvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(myCanvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack(); //Frame sesuai komponen yang ada..
        setVisible(true); //agar frame muncul di window
        }

        private void jMenuItem1ActionPerformed(ActionEvent e) {
                myCanvas1.hapusKanvas(); //menghapus gambar
        }

        private void jMenuItem2ActionPerformed(ActionEvent e) {
            //Gunakan try-catch untuk menagkap error bila file gambar yang diambil tidak ada..
			try
            {
                myCanvas1.ambilGambar();
            }
            catch (FileNotFoundException error){ //menangkap error jika file yang dipilih tidak ada..
                 JOptionPane.showMessageDialog(null, error.toString(), error.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
            catch (BadDataException error){ //menagkap erro bila isi file tidak sesuai dengan aturan toString
                 JOptionPane.showMessageDialog(null, error.toString(), error.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }

        private void jMenuItem3ActionPerformed(ActionEvent e) {
            //Gunakan try-catch bila untuk menyimpan gambar agar bisa menagkap error
			try
            {
                myCanvas1.simpan();
             }
             catch (FileNotFoundException error){ //menagkap error bila file tidak ada..
                JOptionPane.showMessageDialog(null, error.toString(), error.getMessage(), JOptionPane.ERROR_MESSAGE);
             }
        }

        private void jMenuItem4ActionPerformed(ActionEvent e) {
                System.exit(0); //akan keluar dari aplikasi bila menekan menuItem exit
        }

        private void jButton1ActionPerformed(ActionEvent e){
                Color updateWarna = JColorChooser.showDialog(null, "Choose Color", warnaSekarang);
                warnaSekarang = updateWarna; //Akan meng-update warna yang kita pilih di CSV
        }

        private void jRadioButton1ActionPerformed(ActionEvent e){
                IsiWarna = true; //Gambar diisi warna
        }

        private void jRadioButton2ActionPerformed(ActionEvent e){
                IsiWarna = false; //Gambar tidak diisi warna
        }

        private void jToggleButton1ActionPerformed(ActionEvent e){
                pilihBentuk = 'R'; //R akan di asignment ke pilihBentuk untuk memilih gambar rectangle
        }

        private void jToggleButton2ActionPerformed(ActionEvent e){
                pilihBentuk = 'L'; //L akan di asignment ke pilihBentuk untuk memilih gambar line
        }

        private void jToggleButton3ActionPerformed(ActionEvent e){
                pilihBentuk = 'O'; ////O akan di asignment ke pilihBentuk untuk memilih gambar oVAL
        }

		//method saat mouse di press pertama kali..
        private void myCanvas1MousePressed(MouseEvent e) {
                awalX = e.getX(); //Koordinat awal x
                awalY = e.getY(); //Koordinat awal y
        }

		//method saat mouse di released, gambar langsung muncul dikanvas
        private void myCanvas1MouseReleased(MouseEvent e) {
                akhirX = e.getX(); //Koordinat terakhir x
                akhirY = e.getY(); //Koordinat terakhir y

                if(pilihBentuk == 'R') //Jika memilih toggle button yang rectangle akan tergambar rectangle..
                    shape = new Rectangle(awalX, awalY, akhirX, akhirY, IsiWarna,warnaSekarang);
                else if(pilihBentuk == 'L')  //Jika memilih toggle button yang line akan tergambar line..
                    shape = new Line(awalX, awalY, akhirX, akhirY,IsiWarna, warnaSekarang);
                else if(pilihBentuk == 'O')  //Jika memilih toggle button yang oval akan tergambar oval..
                    shape = new Oval(awalX, awalY, akhirX, akhirY, IsiWarna, warnaSekarang);

                myCanvas1.tambahShape(shape); // akan menambah bentuk gambar yang kita pilih di toggle button
                myCanvas1.repaint(); //akan menggambra kembali dengan method repaint..
        }
}

