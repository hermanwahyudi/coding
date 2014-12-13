import java.io.DataInputStream;

public class BinaryComplement
{
	private DataInputStream baca;
	private String input;
	public BinaryComplement() {
		baca = new DataInputStream(System.in);
	}
	public void inputData() {
		try {
			this.input = baca.readLine();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String oneComplement() {
		char[] c = input.toCharArray();
		for(int i = 0; i < c.length; i++) {
			c[i] = (c[i] == '1') ? '0' : '1';
		}
		return concat(c, c.length-1);
	}
	public String twoComplement() {
		String str = oneComplement(), temp = "";
		char[] c = str.toCharArray();
		boolean valid = true;
		for(int i = c.length - 1 ; i >= 0 && valid; ) {
			if(c[i] == '0') {
				c[i] = '1';
				valid = false;
			} else {
				if(i == 0 && c[i] == '1') temp = "1";
				c[i] = '0';
				i--;
			}
		}
		return temp + concat(c, c.length - 1);
	}
	public String concat(char[] c, int i) {
		if(i == 0) return "" + c[i];
		return "" + concat(c, i-1) + c[i];
	}
	public static void main(String[] args) {
		BinaryComplement obj = new BinaryComplement();
		obj.inputData();
		System.out.println(obj.oneComplement());
		System.out.println(obj.twoComplement());
	}
}