import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Class SDA11121A
 *  @author Nama (NPM)
 */
public class SDA11121A
   {
    public static void main(String[] args)
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try
	{
            String size = input.readLine();
            String door = input.readLine();

            // Create building representation
            Building building = new Building(Integer.parseInt(size.split(" ")[0]), Integer.parseInt(size.split(" ")[1]));
            for (int i = 0; i < building.getHeight(); i++)
	   {
                String sequence = input.readLine();
                for (int j = 0; j < building.getWidth(); j++)
                    building.setCell(j, i, sequence.charAt(j));
            }
	    int x = Integer.parseInt(door.split(" ")[0]);
	    int y = Integer.parseInt(door.split(" ")[1]);

	    if(building.getCell(x,y) == 'K')
		System.out.println("Minggu ini kamu tidak perlu masuk kantor.");
	    else
	    {
		    System.out.print("Berikut adalah langkah-langkah untuk mencapai ruang kerjamu: ");
		    new SDA11121A().rek(x,y, building.dapet());
	    }

        }
	catch (Exception e)
	{
            e.printStackTrace();
        }
    }
    public void rek(int x, int y, char[][] matrik)
    {
		//Selatan
		if(x+1 >= 0 && y >= 0 && x+1 < matrik.length && y < matrik[0].length)
		{
			if(matrik[x+1][y] == '-' && matrik[x-1][y] == 'D' && matrik[x][y+1] == 'D' && matrik[x][y-1] == 'D')
			{
				System.out.print("S");
				rek(x+1,y,matrik);
			}
			else if(matrik[x+1][y] == 'K' && matrik[x-1][y] == 'D' && matrik[x][y+1] == 'D' && matrik[x][y-1] == 'D')
			{
				System.out.print("S");
			}
		}
		//Barat
		else if(x >= 0 && y-1 >= 0 && x < matrik.length && y-1 < matrik[0].length)
		{
			if(matrik[x][y-1] == 'D' && matrik[x-1][y] == 'D' && matrik[x][y+1] == 'D' && matrik[x][y-1] == '-')
			{
				System.out.print("B");
				rek(x,y-1,matrik);
			}
			else if(matrik[x][y-1] == 'D' && matrik[x-1][y] == 'D' && matrik[x][y+1] == 'D' && matrik[x][y-1] == 'K')
			{
				System.out.print("B");
			}
		}
		//Utara
		else if(x-1 >= 0 && y >= 0 && x-1 < matrik.length && y < matrik[0].length)
		{
			if(matrik[x-1][y] == '-' && matrik[x+1][y] == 'D' && matrik[x][y+1] == 'D' && matrik[x][y-1] == 'D')
			{
				System.out.print("U");
				rek(x-1,y,matrik);
			}
			else if(matrik[x][y-1] == '-' && matrik[x-1][y] == 'D' && matrik[x][y+1] == 'D' && matrik[x][y-1] == 'D')
			{
				System.out.print("U");
			}
		}
		//Timur
		else if(x >= 0 && y+1 >= 0 && x < matrik.length && y+1 < matrik[0].length)
		{
			if(matrik[x+1][y] == 'D' && matrik[x-1][y] == 'D' && matrik[x][y+1] == '-' && matrik[x][y-1] == 'D')
			{
				System.out.print("T");
				rek(x,y+1,matrik);
			}
			else if(matrik[x][y-1] == 'D' && matrik[x-1][y] == 'D' && matrik[x][y+1] == 'K' && matrik[x][y-1] == 'D')
			{
				System.out.print("B");
			}
		}
    }

}

/** Class Building
 *  @author Nama (NPM)
 */
class Building {
    /** Constants
     */
    private final char WALL = 'D';
    private final char ROOM = 'K';

    /** Attributes
     */
    private int width;
    private int height;
    private char[][] matrix;

    /** Default constructor
     *  Initializes a matrix of character with size 1 x 1
     */
    public Building() {
        this(1, 1);
    }

    /** Constructor
     *  Initializes a matrix of character with size width x height
     *  @param w
     *  @param h
     */
    public Building(int w, int h) {
        width = w;
        height = h;
        matrix = new char[w][h];
    }

    /** Getter getWidth
     *  @return width
     */
    public int getWidth() {
        return width;
    }

    /** Getter getHeight
     *  @return height
     */
    public int getHeight() {
        return height;
    }

    /** Getter getCell
     *  @return matrix[x][y]
     */
    public char getCell(int x, int y) {
        return matrix[x][y];
    }

    /** Setter setWidth
     *  @param w
     */
    public void setWidth(int w) {
        width = w;
    }

    /** Setter setHeight
     *  @param h
     */
    public void setHeight(int h) {
        height = h;
    }

    /** Setter setCell
     *  @param x
     *  @param y
     *  @param value
     */
    public char[][] dapet()
    {
	    return matrix;
    }
    public void setCell(int x, int y, char value) {
        matrix[x][y] = value;
    }


    /** Method findPath
     *  @param <param-1>, <param-2>, ..., <param-n>
     *  @return ...
     */
    //public <return> findPath(<param-1>, <param-2>, ..., <param-n>) {
        // LENGKAPI
    //}

    // TAMBAHKAN ATTRIBUTE DAN METHOD JIKA PERLU
}

// TAMBAHKAN CLASS JIKA PERLU