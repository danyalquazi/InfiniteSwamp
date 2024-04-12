
public class Person {
	int row;
	int col;
	
	public Person(int row, int col, Map m) {
		super();
		m.setWorld(col, row, 1);
		this.row = row;
		this.col = col;
	}
	public void setPositionOnMap(Map m) {
	}
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
}
