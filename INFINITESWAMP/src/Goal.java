
public class Goal {
	int row;
	int col;
	
	public Goal(int row, int col, Map m) {
		super();
		m.setWorld(row, col, 2);
		this.row = row;
		this.col = col;
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
