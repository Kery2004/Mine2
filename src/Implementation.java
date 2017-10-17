import java.util.Scanner;

//Implementation of MineSweeper interface, all details on MineSweeper interface

public class Implementation implements MineSweeper {
	private boolean initialized = false;
	private int rows = 0, columns = 0;
	private int[][] tab;

	// setMineField method wll be mostly checking if our input data is OK and
	// creating int array from string input
	public void setMineField(String mineField) throws IllegalArgumentException {
		String t = "", help = "";
		String helpField = mineField;

		if (helpField.length() < 4) // checking if we can do actually a field from input
			throw new IllegalArgumentException("wrong data in method argument length field is < 4");
		String[] i = mineField.split("(?<!\\\\)\\\\n"); // split mineField in '\n' place using regular expression to a
														// string array
		rows = i.length;
		if (i.length <= 1) { // checking if we can do actually a field from input
			throw new IllegalArgumentException("wrong data in method argument, cannot create a 1 row field");
		}
		t = i[0];
		columns = t.length(); // assign a number of columns in our field
		for (int x = 0; x < i.length; x++) {
			help = i[x];
			if (t.length() != help.length()) // checking if the field got the same number elements of each row
				throw new IllegalArgumentException(
						"wrong data in method argument, cannot create a field from diffrent numbers of elements in rows");
		}
		tab = new int[rows][columns]; // creating a two dimension int array
		int helpTemp = 0;
		for (int x = 0; x < i.length; x++) { // loop through all rows
			t = i[x];
			helpTemp = 0;
			for (char c : t.toCharArray()) { // this loop are checking all elements - loop accept only '*' and '.'
				if (c != '*' && c != '.') {
					throw new IllegalArgumentException("wrong data in method argument, check input data");
				}
				if (c == '*') { // Getting data into a int array. Mine in that array is number 9 and empty field
								// is 0
					tab[x][helpTemp] = 9;
				}

				if (c == '.') {
					tab[x][helpTemp] = 0;
				}
				helpTemp++;
			}

		}
		initialized = true;
	}

	// getHintField method will initialize a hint-field from input data
	public String getHintField() throws IllegalStateException {
		String n = "";
		Scanner scan = new Scanner(System.in);
		n = scan.next(); // getting input data
		scan.close();
		setMineField(n); // initializing setMineField

		if (initialized == false) {
			throw new IllegalStateException("setMineField was not initalized");
		}
		// we need to get through all elements and search mine
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < columns; y++) {
				if (tab[x][y] == 9) {
					// when we got position of a mine we need to get through all elements thats
					// adjacent to a mine
					for (int xx = x - 1; xx <= x + 1; xx++) {
						if (xx >= 0 && xx <= (rows - 1)) { // checking if we not out of rows index
							for (int yy = y - 1; yy <= y + 1; yy++) {
								if (yy >= 0 && yy <= (columns - 1)) { // checking if we not out of columns index
									if (tab[xx][yy] != 9) // we add ++ only to a non-mine field adjacent to a mine
										tab[xx][yy]++;
								}
							}
						}
					}
				}
			}
		}

		String fstring = ""; // creating final string
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < columns; y++) { // All elements in the array will be added to a simple String
				fstring += String.valueOf(tab[x][y]);
			}
			fstring += "\n";
		}

		return fstring.replace('9', '*');
	}

}
