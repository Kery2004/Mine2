import java.util.Scanner;

public class Implementation implements MineSweeper {
	private boolean initialized = false;
	int rows = 0, columns = 0;
	int[][] tab;

	public void setMineField(String mineField) throws IllegalArgumentException {
		String t = "", help = "";
		String helpField = mineField;

		if (helpField.length() < 4)
			throw new IllegalArgumentException("wrong data in method argument");
		String[] i = mineField.split("(?<!\\\\)\\\\n");
		rows = i.length;
		// System.out.println(rows);
		if (i.length <= 1) {
			throw new IllegalArgumentException("wrong data in method argument");
		}
		t = i[0];
		columns = t.length();
		for (int x = 0; x < i.length; x++) {
			// t = i[0];
			help = i[x];
			if (t.length() != help.length())
				throw new IllegalArgumentException("wrong data in method argument");
		}
		tab = new int[rows][columns];
		// System.out.println(columns);
		int helpz = 0;
		for (int x = 0; x < i.length; x++) {
			t = i[x];
			helpz = 0;
			for (char c : t.toCharArray()) {
				// System.out.println(helpz);
				if (c != '*' && c != '.') {
					throw new IllegalArgumentException("wrong data in method argument");
				}
				if (c == '*') {
					tab[x][helpz] = 9;
				}

				if (c == '.') {
					tab[x][helpz] = 0;
				}
				helpz++;
			}

		}

		// System.out.println(tab[2][3]);
		initialized = true;
	}

	public String getHintField() throws IllegalStateException {
		String n = "", p = "";
		Scanner scan = new Scanner(System.in);
		n = scan.next();

		setMineField(n);

		if (initialized == false) {
			throw new IllegalStateException("setMineField was not initalized");
		}
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < columns; y++) {
				// System.out.println(x + " " + y);
				if (tab[x][y] == 9) {
					for (int ii = x - 1; ii <= x + 1; ii++) {
						// System.out.println(ii);
						if (ii >= 0 && ii <= rows - 1) {

							for (int jj = y - 1; jj <= y + 1; jj++) {
								// System.out.println(ii + " " + jj + " " + rows + " " + columns);
								if (jj >= 0 && jj <= columns - 1) {
									if (tab[ii][jj] != 9)
										tab[ii][jj]++;
									// System.out.println("x");
								}
							}

						}
					}
				}
			}
		}

		// String[] fre = new String[rows * columns];
		String fre = "";
		int yui = 0;
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < columns; y++) {
				yui = tab[x][y];
				fre = fre + String.valueOf(yui);
			}
			fre = fre + "\n";
		}

		System.out.println(fre.replace('9', '*'));

		/*
		 * String tab1 = Arrays.toString(tab); System.out.println(tab1);
		 */

		// String[] i = n.split("(?<!\\\\)\\\\n");
		// String str = String.join("\n", i).replace("\n", "");

		// System.out.println(str);

		/*
		 * for (int k = 0; k < i.length; k++) { p = i[k]; //System.out.println(p[k]);
		 * for (char c : p.toCharArray()) {
		 * 
		 * }
		 * 
		 * }
		 */

		String mineField1 = "aaa";
		return mineField1;
	}

}
