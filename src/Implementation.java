
public class Implementation implements MineSweeper {
	Thread t1 = new Thread();

	public void setMineField(String mineField) throws IllegalArgumentException {

		t1.start();
		String[] i = mineField.split("\n");
		for (int x = 0; x < i.length; x++) {
			String t = i[x];

			for (char c : t.toCharArray()) {
				if (c != '*' && c != '.') {
					throw new IllegalArgumentException("wrong data in method argument");
				}

			}

		}

	}

	public String getHintField() throws IllegalStateException {
		t1.start();
		String mineField1 = "";
		return mineField1;
	}

}
