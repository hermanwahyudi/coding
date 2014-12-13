/*******************************************
* SANGAT RAHASIA
* JANGAN DISEBARLUASKAN
*/

class Matrix
{
	/* Define Matrix width and height */
	private int[][] arr;
	private int arrLength = 0;

	/* Status */
	private boolean isRefleksif;
	private boolean isIrrefleksif;
	private boolean isSimetri;
	private boolean isAntiSimetri;
	private boolean isAsimetri;
	private boolean isTransitif;

	/**
	* Constructor for null matrix
	*/
	public Matrix(){
		arr = null;
	}

	/**
	* Constructor to make n x n Matrix
	* @param n
	* @throws Exception
	*/
	public Matrix(int[][] arrInput) throws Exception{
		setMatrix(arrInput);
	}

	/**
	* Set new matrix
	* Note : must be define input n x n Matrix
	* @param arrInput
	* @throws Exception
	*/
	public void setMatrix(int[][] arrInput) throws Exception {
		arrLength = arrInput[0].length;
		if (arrLength != arrInput.length) {
			throw new MatrixException("This is not an valid NxN matrix");
		}

		arr = arrInput;
		isRefleksif = isRefleksif();
		isIrrefleksif = isIrrefleksif();
		isSimetri = isSimetri();
		isAntiSimetri = isAntiSimetri();
		isAsimetri = isAsimetri();
		isTransitif = isTransitif();
	}

	/**
	* Get the matrix
	* @return
	*/
	public int[][] getMatrix(){
		return arr;
	}

	/**
	* Print the Main Matrix, based on given Writer tool
	* @param out
	* @throws IOException
	*/
	public void printMatrix(BufferedWriter out) throws IOException {
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				out.write(arr[i][j] + " ");
			}
			out.write("\n");
		}
	}

	/* PART 1 */

	/**
	* Return true if the Matrix is Refleksif
	* @return true / false
	*/
	public boolean isRefleksif(){
		boolean result = true;
		// Cek diagonal matrix
		for (int i = 0; i < arrLength; i++) {
			if (arr[i][i] == 1){
				// Jika diagonal sama dengan 1
				result = result && true;
			} else {
				result = false;
			}
		}
		return result;
	}

	/**
	* Return true if the Matrix is Irrefleksif
	* @return true / false
	*/
	public boolean isIrrefleksif(){
		boolean result = true;
		// Cek diagonal matrix
		for (int i = 0; i < arrLength; i++) {
			if (arr[i][i] == 1){
				// Jika diagonal sama dengan 1
				result = false;
			}
		}
		return result;
	}

	/**
	* Return true if the Matrix is Simetri
	* @return true / false
	*/
	public boolean isSimetri() {
		boolean result = true;
		// Cek transpose Matrix
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				if (arr[i][j] == arr[j][i]) {
					// Jika (a,b) ada maka (b,a) juga ada
					result = result && true;
				} else {
				result = false;
			}
		}
		return result;
	}

	/**
	* Return true if the Matrix is AntiSimetri
	* @return true / false
	*/
	public boolean isAntiSimetri() {
		boolean result = true;
		// Cek transpose Matrix and identity
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				if (arr[i][j] == 1 && arr[j][i] == 1 && i != j) {
					// Jika (a, b) ada maka (b, a) tidak boleh ada, (a, a) diperbolehkan
					result = false;
				}
			}
		}
		return result;
	}

	/**
	* Return true if the Matrix is Asimetri
	* @return true / false
	*/
	public boolean isAsimetri() {
		boolean result = true;
		// Cek transpose Matrix and identity
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				if (arr[i][j] == 1 && arr[j][i] == 1) {
				// Jika (a, b) ada maka (b, a) tidak boleh ada, (a, a) tidak diperbolehkan
				result = false;
				}
			}
		}
		return result;
	}

	/**
	* Return true if the Matrix is Transitif
	* @return true / false
	*/
	public boolean isTransitif() {
		boolean result = true;
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				// For each element if (a, b) exist and (b, c) exist then (a, c) must exist
				for (int k = 0; k < arrLength; k++) {
					if (arr[i][j] == 1 && arr[j][k] == 1) {
						if (arr[i][k] == 1) {
							result = result && true;
						} else {
							result = false;
						}
					}
				}
			}
		}
		return result;
	}

	/* PART 2 */

	/*
	* Note : Format for Relation Closer
	* String = i-j,k-l, and so on
	* */

	/**
	* Give the least superset to make Refleksif Matrix
	* @return closer refleksif
	*/
	public String closeRefleksifRelations() {
		String result = "";
		for (int i = 0; i < arrLength; i++) {
			if (arr[i][i] == 0){
				// Jika diagonal sama dengan 0
				result += i + "-" + i + ",";
			}
		}
		return (result.length() != 0)? result.substring(0, result.length() - 1): "null";
	}

	/**
	* Give the least superset to make Simetri Matrix
	* @return closer simetri
	*/
	public String closeSimetriRelations() {
		String result = "";
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				if (arr[i][j] == 1 && arr[j][i] == 0) {
					// Jika (a,b) ada maka (b,a) juga ada
					result += j + "-" + i + ",";
				}
			}
		}
		return (result.length() != 0)? result.substring(0, result.length() - 1): "null";
	}

	/**
	* Give the least superset to make Transitif Matrix
	* @return string representation of closer transitif
	*/
	public String closeTransitifRelations() {
		String result = "";
		int[][] temp = arr.clone();
		while (!isTransitif()) {
			for (int i = 0; i < arrLength; i++) {
				for (int j = 0; j < arrLength; j++) {
					// For each element if (a, b) exist and (b, c) exist then (a, c) must exist
					for (int k = 0; k < arrLength; k++) {
						if (arr[i][j] == 1 && arr[j][k] == 1 && arr[i][k] == 0) {
							arr[i][k] = 1;
							result += i + "-" + k + ",";
						}
					}
				}
			}
		}
		arr = temp;
		return (result.length() != 0)? result.substring(0, result.length() - 1): "null";
	}

	/* PART 3 */

	/*
	* Note : Format Partition
	* For each partition : i,j,k-l,m- etc..
	* */

	/**
	* Check Matrix is belong to Equivalen or not
	* @return true if Matrix is equivalen
	*/
	public boolean isEquivalen() {
		return isRefleksif && isSimetri && isTransitif;
	}

	/**
	* Get the partition of Equivalen Matrix
	* Note : Must be Equivalen Matrix
	* @return partition of Equivalen Matrix
	*/
	public String partitionSet() {
		String result = "";
		if (!isEquivalen()) {
			return "Not Equivalen Relation";
		}
		boolean[] status = new boolean[arrLength];
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				if (arr[i][j] == 1 && !status[j]) {
					status[j] = true;
					result += j + ",";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "\n";
		}
		return result;
	}

	/* PART 4 */

	/**
	* Check Matrix is belong to Partial Order or not
	* @return true if Matrix is Partial Order
	*/
	public boolean isPartialOrder() {
		return isRefleksif && isAntiSimetri && isTransitif;
	}
}