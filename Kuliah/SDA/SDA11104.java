import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class SDA11104 {

    public static void main(String[] args) {
	BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	/* Test...
	BinaryTree<String> testedTree = new BinaryTree<String>(new BinaryTree<String>().new Node<String>("/"));
	testedTree.getRoot().setLeftChild(new BinaryTree<String>().new Node<String>("100"));
	testedTree.getRoot().setRightChild(new BinaryTree<String>().new Node<String>("-"));
	testedTree.getRoot().getRightChild().setLeftChild(new BinaryTree<String>().new Node<String>("*"));
	testedTree.getRoot().getRightChild().setRightChild(new BinaryTree<String>().new Node<String>("25"));
	testedTree.getRoot().getRightChild().getLeftChild().setLeftChild(new BinaryTree<String>().new Node<String>("10"));
	testedTree.getRoot().getRightChild().getLeftChild().setRightChild(new BinaryTree<String>().new Node<String>("5"));
	//*/

	try {
	    // buffWriter.write(testedTree.toString());
	    // buffWriter.newLine();

	    String line;
	    while ((line = buffReader.readLine()) != null) {
		MathExpression mathExpr = new MathExpression(new StringBuffer(line));
		buffWriter.write(mathExpr.getExpressionString().toString());
		buffWriter.write(" = ");

		if (mathExpr.containsDivByZero()) {
		    buffWriter.write("Error");
		} else {
		    buffWriter.write(mathExpr.result().toString());
		}
		buffWriter.newLine();

		buffWriter.write(mathExpr.expressionTree().toString());
		buffWriter.newLine();
	    }

	    buffWriter.flush();
	} catch (Exception theException) {
	    theException.printStackTrace();
	}
    }
}

/** MathExpression
 */
class MathExpression {

    protected StringBuffer exprString;
    protected BinaryTree<Integer> exprTree;

    public MathExpression(StringBuffer exprString) {
	setExpressionString(exprString);
	exprTree = new BinaryTree<Integer>(parse(0, exprString.length()));
    }

    public void setExpressionString(StringBuffer exprString) {
	this.exprString = exprString;
    }

    public StringBuffer getExpressionString() {
	return exprString;
    }

    private BinaryTree<Integer>.Node<Integer> parse(int start, int end) {

		int hitung = 0; int root = 0;
		boolean boole = true;
		while (boole) {
			for (int i = start+1; i < end-1; i++) {
				if (exprString.charAt(i) == '(')
					hitung++;
				else if (exprString.charAt(i) == ')')
					hitung--;
				if (hitung < 0)
					boole = false;
			}
			if ((exprString.charAt(start) == '(') && (exprString.charAt(end-1) == ')')) {
				if (boole && hitung == 0) {
					start++; end--;
				}
				else {
					boole = false;
				}
			}
			else {
				boole = false;
			}
		}
		hitung = 0;
		boolean boo = true;
		for (int j = start; j < end && boo; j++) {
			if (exprString.charAt(j) == '(')
				hitung++;
			else if (exprString.charAt(j) == ')')
				hitung--;
			if ((exprString.charAt(j) < '0') || (exprString.charAt(j) > '9')) {
				if (hitung == 0 && (exprString.charAt(j) != '(') && (exprString.charAt(j) != ')')) {
					root = j;
					boo = false;
				}
			}
		}
		BinaryTree<Integer>.Node<Integer> bantu;
		if (!boo) {
			bantu = new BinaryTree<Integer>().new Node<Integer>(null, parse(start, root), parse(root + 1, end));
			bantu.setName("" + exprString.charAt(root));

		}
		else {
			bantu = new BinaryTree<Integer>().new Node<Integer>(Integer.parseInt(exprString.substring(start, end)));
			bantu.setName(null);
		}
		return bantu;
    }

    public BinaryTree<Integer> expressionTree() {
	return exprTree;
    }

    public boolean containsDivByZero() {
	return containsDivByZero(exprTree.getRoot());
    }

    private boolean containsDivByZero(BinaryTree<Integer>.Node<Integer> node) {
	boolean bool = false;
	if (node.getDatum() != null)
	    bool = false;
	else if (containsDivByZero(node.getLeftChild()) || containsDivByZero(node.getRightChild()))
	    bool = true;
	else if (node.getName().equals("/"))
	{
	    if (new BigInteger(""+result(node.getRightChild())).equals(new BigInteger("0")))
		bool = true;
	}
	return bool;

    }

    // Choose the right data type!
    public BigInteger result() {
	return result(exprTree.getRoot());
    }

    // Choose the right data type!
    private BigInteger result(BinaryTree<Integer>.Node<Integer> node) {
	BigInteger big = null;
	BigInteger kiri = null;
	BigInteger kanan = null;
	if (!node.hasChildren())
	    big = new BigInteger("" + node.getDatum());
	else
	{
	    if (node.getName().equals("+"))
		big = new BigInteger("" + result(node.getLeftChild())).add(new BigInteger(""+result(node.getRightChild())));
	    else if (node.getName().equals("-"))
		big = new BigInteger("" + result(node.getLeftChild())).subtract(new BigInteger(""+result(node.getRightChild())));
	    else if (node.getName().equals("*"))
		big = new BigInteger("" + result(node.getLeftChild())).multiply(new BigInteger(""+result(node.getRightChild())));
	    else
	    {
		kiri = new BigInteger("" + result(node.getLeftChild()));
		kanan = new BigInteger("" + result(node.getRightChild()));
		BigInteger mutlakKiri = kiri.abs();
		BigInteger mutlakKanan = kanan.abs();
		if (kiri.multiply(kanan).compareTo(new BigInteger("0")) < 0 && !mutlakKiri.mod(mutlakKanan).equals(new BigInteger("0")))
		    big = mutlakKiri.divide(mutlakKanan).add(new BigInteger("1")).negate();
		else
		    big = kiri.divide(kanan);
	    }
	}
	return big;
    }
}

/** BinaryTree<T> is a binary tree data structure
 * @author Ricky Suryadharma
 * @author Lasguido
 */
class BinaryTree<T> {

    /** Node<T> is a binary-tree node data structure
     * @author Ricky Suryadharma
     * @author Lasguido
     */
    protected class Node<T> {

	/** the datum for <code>this</code> */
	protected T datum;
	/** the left child for <code>this</code> */
	protected Node<T> leftChild;
	/** the right child for <code>this</code> */
	protected Node<T> rightChild;
	/** the name for <code>this</code> */
	protected String name;

	//Constructor(s).
	/** A constructor to set a datum
	 * @param datum a datum to be set
	 */
	public Node(T datum) {
	    this(datum, null, null);
	}

	/** A constructor to set a datum, left and right child
	 * @param datum a datum to be set
	 * @param leftChild a left child to be set
	 * @param rightChild a right child to be set
	 */
	public Node(T datum, Node<T> leftChild, Node<T> rightChild) {
	    setDatum(datum);
	    setLeftChild(leftChild);
	    setRightChild(rightChild);
	    setName(null);
	}

	//Method(s).
	/** set a datum for <code>this</code>
	 * @param datum a datum to be set
	 */
	public void setDatum(T datum) {
	    this.datum = datum;
	}

	/** set a left child for <code>this</code>
	 * @param leftChild a left child to be set
	 */
	public void setLeftChild(Node<T> leftChild) {
	    this.leftChild = leftChild;
	}

	/** set a right child for <code>this</code>
	 * @param rightChild a right child to be set
	 */
	public void setRightChild(Node<T> rightChild) {
	    this.rightChild = rightChild;
	}

	/** set a name for <code>this</code>
	 * @param name a name to be set
	 */
	public void setName(String name) {
	    this.name = name;
	}

	/** get a datum from <code>this</code>
	 * @return the datum
	 */
	public T getDatum() {
	    return datum;
	}

	/** get a left child from <code>this</code>
	 * @return the left child
	 */
	public Node<T> getLeftChild() {
	    return leftChild;
	}

	/** get a right child from <code>this</code>
	 * @return the right child
	 */
	public Node<T> getRightChild() {
	    return rightChild;
	}

	/** get a name from <code>this</code>
	 * @return the name
	 */
	public String getName() {
	    return name;
	}

	/** check whether <code>this</code> has one or two children
	 * @return true iff has one or two children
	 */
	public boolean hasChildren() {
	    return this != null && !(this.leftChild == null
		    && this.rightChild == null);
	}

	/** get a representation of this node
	 * @return the representation
	 */
	public String toString() {
	    return name == null ? datum.toString() : name;
	}
    }
    // EOL (End Of Line)
    final protected static StringBuffer EOL = new StringBuffer(
	    System.getProperty("line.separator"));
    /** the root for <code>this</code> */
    protected Node<T> root;

    //Constructor(s).
    /** Default constructor: root = null
     */
    public BinaryTree() {
	this(null);
    }

    /** A constructor to set a root
     * @param root a root to be set
     */
    public BinaryTree(Node<T> root) {
	setRoot(root);
    }

    //Method(s).
    /** set root for <code>this</this>
     * @param root a root to be set
     */
    public void setRoot(Node<T> root) {
	this.root = root;
    }

    /** get root from <code>this</code>
     * @return a root
     */
    public Node<T> getRoot() {
	return root;
    }

    /** get a representation of binary tree in text style
     * @param root a root and all its children to be represented
     * @param carry a text that will be placed at left position as a carry
     *            from the previous recursion or first call
     * @return the representation
     */
    public StringBuffer representation(Node<T> root, StringBuffer carry) {
	StringBuffer binaryTreeRep = new StringBuffer();

	if (root != null && root.hasChildren()) {
	    binaryTreeRep.append('[');
	    binaryTreeRep.append(root);
	    binaryTreeRep.append(']');
	    binaryTreeRep.append(EOL);

	    binaryTreeRep.append(carry);
	    binaryTreeRep.append('|');
	    binaryTreeRep.append(EOL);

	    StringBuffer nextCarry = new StringBuffer(carry);
	    nextCarry.append("|   ");

	    binaryTreeRep.append(carry);
	    binaryTreeRep.append("#=>");
	    binaryTreeRep.append(representation(root.getRightChild(), nextCarry));

	    binaryTreeRep.append(carry);
	    binaryTreeRep.append('|');
	    binaryTreeRep.append(EOL);

	    nextCarry = new StringBuffer(carry);
	    nextCarry.append("    ");

	    binaryTreeRep.append(carry);
	    binaryTreeRep.append("#=>");
	    binaryTreeRep.append(representation(root.getLeftChild(), nextCarry));
	} else {
	    binaryTreeRep.append(root).append(EOL);
	}

	return binaryTreeRep;
    }

    /** get a representation of binary tree in default text style
     * @return the representation
     */
    public String toString() {
	return representation(root, new StringBuffer(" ")).toString();
    }
}
