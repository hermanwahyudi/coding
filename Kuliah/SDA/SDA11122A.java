import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.StringTokenizer;


public class SDA11122A {
    public static void main(String[] args) {
        BufferedReader buffReader = new BufferedReader(
            new InputStreamReader(System.in));

        BufferedWriter buffWriter = new BufferedWriter(
            new OutputStreamWriter(System.out));

        try {
            /* Test...
            BinarySearchTree<CityTravelInfo> testedTree =
                new BinarySearchTree<CityTravelInfo>(null,
                CityTravelInfo.NAME_NON_DESCENDING_ORDER);

            testedTree.insert(new BinaryTree<CityTravelInfo>().new Node<CityTravelInfo>(new CityTravelInfo("Depok", 1000), "Depok"));
            testedTree.insert(new BinaryTree<CityTravelInfo>().new Node<CityTravelInfo>(new CityTravelInfo("Ambon", 10000), "Ambon"));
            testedTree.insert(new BinaryTree<CityTravelInfo>().new Node<CityTravelInfo>(new CityTravelInfo("Jakarta", 1500), "Jakarta"));
            testedTree.insert(new BinaryTree<CityTravelInfo>().new Node<CityTravelInfo>(new CityTravelInfo("Medan", 8000), "Medan"));
            testedTree.insert(new BinaryTree<CityTravelInfo>().new Node<CityTravelInfo>(new CityTravelInfo("Padang", 2000), "Padang"));
            testedTree.insert(new BinaryTree<CityTravelInfo>().new Node<CityTravelInfo>(new CityTravelInfo("Garut", 3500), "Garut"));
            testedTree.insert(new BinaryTree<CityTravelInfo>().new Node<CityTravelInfo>(new CityTravelInfo("Bali", 4000), "Bali"));
            testedTree.insert(new BinaryTree<CityTravelInfo>().new Node<CityTravelInfo>(new CityTravelInfo("Kisaran", 1500), "Kisaran"));

            buffWriter.write(testedTree.toString());
            buffWriter.newLine();

            buffWriter.write(testedTree.find("Medan").toString());
            buffWriter.newLine();

            buffWriter.write(testedTree.numberOfLeafNode() + "");
            buffWriter.newLine();
            //*/

            TourIce tourIce = new TourIce();
            StringTokenizer strTokenizer;

            int K = Integer.parseInt(buffReader.readLine());
            while (K-- > 0) {
                strTokenizer = new StringTokenizer(buffReader.readLine());
                tourIce.add(new CityTravelInfo(strTokenizer.nextToken(),
                    Integer.parseInt(strTokenizer.nextToken())));
            }

            int N = Integer.parseInt(buffReader.readLine());
            char option;
            while (N-- > 0) {
                strTokenizer = new StringTokenizer(buffReader.readLine());
                option = strTokenizer.nextToken().charAt(0);
                switch (option) {
                    case '1':
                        buffWriter.write(
                            tourIce.getMostExpensiveTravelPackages() + "");
                        break;

                    case '2':
                        buffWriter.write(tourIce.getCostToCity(
                            strTokenizer.nextToken()) + "");
                        break;

                    case '3':
                        buffWriter.write(tourIce.getMaxCostPassed(
                            strTokenizer.nextToken()) + "");
                        break;

                    case '4':
                        buffWriter.write(tourIce.getNumberOfPackagesPassed(
                            strTokenizer.nextToken()) + "");
                        break;
                }

                buffWriter.newLine();
            }

            buffWriter.flush();
        } catch (Exception theException) {
            theException.printStackTrace();
        }
    }
}


class TourIce {
    private BinarySearchTree<CityTravelInfo> bst;

    public TourIce() {
        bst = new BinarySearchTree<CityTravelInfo>(null,
            CityTravelInfo.NAME_NON_DESCENDING_ORDER);
    }

    public void add(CityTravelInfo info) throws Exception {
        BinaryTree<CityTravelInfo>.Node<CityTravelInfo> node =
            new BinaryTree<CityTravelInfo>().new Node<CityTravelInfo>(info,
            info.getName());

        bst.insert(node);
    }

    // code 1
    public int getMostExpensiveTravelPackages() {
        return getMostExpensiveTravelPackages(bst.getRoot());
    }

    // recursive for code 1
    private int getMostExpensiveTravelPackages(BinaryTree<CityTravelInfo>.Node<CityTravelInfo> node) {
	if(node == null)
		return 0;
	else
		return 0;
    }

    // code 2
    public int getCostToCity(String cityName) {
        return getCostToCity(cityName, bst.getRoot(), 0);
    }

    // recursive for code 2
    private int getCostToCity(String cityName,
        BinaryTree<CityTravelInfo>.Node<CityTravelInfo> node, int cost) {
	CityTravelInfo n = new CityTravelInfo(cityName);
	if(bst.find(n) == null)
		return 0;
	else
		return 0;
    }

    // code 3
    public int getMaxCostPassed(String cityName) {
        CityTravelInfo n = new CityTravelInfo(cityName);
	if(bst.find(n) == null)
		return 0;
	else return 0;
    }

    // code 4
    public int getNumberOfPackagesPassed(String cityName) {
        CityTravelInfo n = new CityTravelInfo(cityName);
	if(bst.find(n) == null)
		return 0;
	else return 0;
    }
}


/** CityTravelInfo represents a city travel information (name and cost)
  * @author Arwin Halim
  */
class CityTravelInfo {
    /** the name for <code>this</code> */
    private String name;

    /** the cost for <code>this</code> */
    private int cost;

    /** the comparator for name in non-descending order */
    public static final Comparator<CityTravelInfo> NAME_NON_DESCENDING_ORDER =
        new Comparator<CityTravelInfo>() {
            public int compare(CityTravelInfo info1, CityTravelInfo info2) {
                return info1.getName().compareTo(info2.getName());
            }
        };

    //Constructor(s).

    /** A constructor to set a name
      * @param name a name to be set
      */
    public CityTravelInfo(String name) {
        this(name, 0);
    }

    /** A constructor to set a name and its cost
      * @param name a name to be set
      * @param cost cost to be set
      */
    public CityTravelInfo(String name, int cost) {
        setName(name);
        setCost(cost);
    }

    //Method(s).

    /** set a name for <code>this</this>
      * @param name a name to be set
      */
    public void setName(String name) {
        this.name = name;
    }

    /** set cost for <code>this</this>
      * @param cost cost to be set
      */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /** get a name from <code>this</code>
      * @return a name
      */
    public String getName() {
        return name;
    }

    /** get cost from <code>this</code>
      * @return cost
      */
    public int getCost() {
        return cost;
    }

    /** get a representation of a city travel information
      * @return the representation
      */
    public String toString() {
        return name + " (" + cost + ")";
    }
}


/** BinarySearchTree<T> is a binary search tree data structure
  * @author Ricky Suryadharma
  * @author Arwin Halim
  */
class BinarySearchTree<T> extends BinaryTree<T> {
    /** the comparator for <code>this</code> */
    protected Comparator<T> comparator;

    //Constructor(s).

    /** A constructor to set a root and a comparator
      * @param root a root to be set
      * @param comparator a comparator to be set
      */
    public BinarySearchTree(Node<T> root, Comparator<T> comparator) {
        super(root);
        setComparator(comparator);
    }

    //Method(s).

    /** set a comparator for <code>this</this>
      * @param comparator a comparator to be set
      */
    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /** get a comparator from <code>this</code>
      * @return a comparator
      */
    public Comparator<T> getComparator() {
        return comparator;
    }

    /** insert a node to <code>this</code> in BST-way
      * @param insNode node to be inserted
      * @throws Exception if insert duplicate node
      */
    public void insert(BinaryTree<T>.Node<T> insNode) throws Exception {
        if (root == null) {
            root = insNode;
        } else {
            insert(insNode, root);
        }
    }

    private void insert(BinaryTree<T>.Node<T> insNode, BinaryTree<T>.Node<T> node) throws Exception {
        int cmpResult = comparator.compare(insNode.getDatum(), node.getDatum());
        if (cmpResult < 0) {
            if (node.getLeftChild() == null) {
                node.setLeftChild(insNode);
            } else {
                insert(insNode, node.getLeftChild());
            }
        } else if (cmpResult > 0) {
            if (node.getRightChild() == null) {
                node.setRightChild(insNode);
            } else {
                insert(insNode, node.getRightChild());
            }
        } else {
            throw new Exception("Duplicate data!");
        }
    }

    /** find datum from <code>this</code> in BST-way start from root
      * @param datum datum to be found
      * @return a node contains datum, or null if not found
      */
    public BinaryTree<T>.Node<T> find(T datum) {
        return find(datum, root);
    }

    /** find datum from <code>this</code> in BST-way
      *     start from <code>node</code>
      * @param datum datum to be found
      * @param node starter node
      * @return a node contains datum, or null if not found
      */
    public BinaryTree<T>.Node<T> find(T datum, BinaryTree<T>.Node<T> node) {
        if (node == null) {
            return null;
        }

        int cmpResult = comparator.compare(datum, node.getDatum());
        if (cmpResult == 0) {
            return node;
        } else if (cmpResult < 0) {
            return find(datum, node.getLeftChild());
        }

        return find(datum, node.getRightChild());
    }

    /** find node's name from <code>this</code> in BST-way start from root
      * @param nodeName node's name to be found
      * @return a node which name equals to <code>nodeName</code>,
      *     or null if not found
      */
    public BinaryTree<T>.Node<T> find(String nodeName) {
        return find(nodeName, root);
    }

    /** find datum from <code>this</code> in BST-way
      *     start from <code>node</code>
      * @param nodeName node's name to be found
      * @param node starter node
      * @return a node which name equals to <code>nodeName</code>,
      *     or null if not found
      */
    public BinaryTree<T>.Node<T> find(String nodeName, BinaryTree<T>.Node<T> node) {
        if (node == null) {
            return null;
        }

        int cmpResult = nodeName.compareTo(node.getName());
        if (cmpResult == 0) {
            return node;
        } else if (cmpResult < 0) {
            return find(nodeName, node.getLeftChild());
        }

        return find(nodeName, node.getRightChild());
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

        /** A constructor to set a datum and node's name
          * @param datum a datum to be set
          * @param name node's name to be set
          */
        public Node(T datum, String name) {
            this(datum, null, null);
            setName(name);
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
            return this != null && !(this.leftChild == null &&
                this.rightChild == null);
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

    /** set a root for <code>this</this>
      * @param root a root to be set
      */
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /** get a root from <code>this</code>
      * @return a root
      */
    public Node<T> getRoot() {
        return root;
    }

    /** calculate number of leaf node(s) for <code>this</code>
      * @return number of leaf node(s)
      */
    public int numberOfLeafNode() {
        return numberOfLeafNode(root);
    }

    /** calculate number of leaf node(s) start from <code>node</code>
      * @param node starter node
      * @return number of leaf node(s)
      */
    public int numberOfLeafNode(Node<T> node) {
        if (node == null) {
            return 0;
        }

        if (!node.hasChildren()) {
            return 1;
        }

        return numberOfLeafNode(node.getLeftChild()) + numberOfLeafNode(node.getRightChild());
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
