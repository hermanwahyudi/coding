import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame
{
	private PanelKalkulator obj;
	public Main() {
		super("Kalkulator");
		obj = new PanelKalkulator();
		add(obj);
		setSize(250, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Main();
	}
}
class PanelKalkulator extends JPanel
{
	private JTextField txt;
	private JPanel panelTombol;
	private boolean DigitAwal = true;
	private int temp = 0;
	private String op = "=";
	public PanelKalkulator() {
		setSize(300, 300);
		create();
	}
	public void create() {
		txt = new JTextField(15);
		txt.setText("0");
		setButton();
		add(txt, BorderLayout.NORTH);
		add(panelTombol, BorderLayout.SOUTH);
	}
	public void setButton() {
		panelTombol = new JPanel();
		panelTombol.setLayout(new GridLayout(4, 4));
		String[] sArr = {"789/", "456*", "123-", ".0=+"};
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				JButton btn = new JButton("" + sArr[i].charAt(j));
				panelTombol.add(btn);
				btn.addActionListener(new HitungKalkulator());
			}
		}
	}
	public void hitung(String s) {
		int nilai = Integer.parseInt(s);
		char c = op.charAt(0);
		switch(c) {
			case '=' : temp = nilai; break;
			case '+' : temp += nilai; break;
			case '-' : temp -= nilai; break;
			case '*' : temp *= nilai; break;
			case '/' : temp /= nilai; break;
		}
		txt.setText(""+temp);
	}
	private class HitungKalkulator implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if("0123456789".indexOf(s) != -1) {
				if(DigitAwal) {
					txt.setText(s);
					DigitAwal = false;
				} else {
					txt.setText(txt.getText() + s);
				}
			} else {
				hitung(txt.getText());
				DigitAwal = true;
				op = s;
			}
		}
	}
}