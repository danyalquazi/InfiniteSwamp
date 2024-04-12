import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Map {
	int rowS;
	int colS;
	int [][] world;
	ArrayList<String> saved = new ArrayList<String>(); 
	String savedFile;
	public Map(int rowS, int colS) {
		super();
		
		this.rowS = rowS;
		this.colS = colS;
		
		this.world = new int[this.rowS][this.colS];
		
		for (int i=0; i<rowS; i++) {
			for(int j = 0; j < colS; j++) {
				this.world[i][j] = 0;
			}
		}
	}
	public int getRowS() {
		return rowS;
	}
	public void setRowS(int rowS) {
		this.rowS = rowS;
	}
	public int getColS() {
		return colS;
	}
	public void setColS(int colS) {
		this.colS = colS;
	}
	public int[][] getWorld() {
		return world;
	}
	public void setWorld(int row, int col, int who) {
//		if(who == 1) {
//			this.world[col][row] = 1;
//		}
//		else if(who ==2) {
//			this.world[col][row] = 2;
//		}
		this.world[row][col] = who;
	}
	
	
	public void changePlayerPos(String d, Person p) {
		switch (d) {
		case "u": {
			
			if(p.row == 0) {
				p.row = rowS - 1;
			}
			else {
				p.row = p.row - 1;
			}
			setWorld(p.row, p.col, 1);
			printMap();
			break;
		}
		case "d": {
			
			if(p.row == rowS-1) {
				p.row = 0;
			}
			else {
				p.row = p.row + 1;
			}
			setWorld(p.row, p.col, 1);
			printMap();
			break;
			
		}
		case "l": {
			
			if(p.col == 0) {
				p.col = colS - 1;
			}
			else {
				p.col = p.col- 1;
			}
			setWorld(p.row, p.col, 1);
			printMap();
			break;
		}
		case "r": {
			
			if(p.col == colS-1) {
				p.col = 0;
			}
			else {
				p.col = p.col + 1;
			}
			setWorld(p.row, p.col, 1);
			printMap();
			break;
		}
		case "load": {
			// it should deserialize (file to array)
			if(saved.size() != 0) {
				savedGame(p);
			}
			break;
		}
		case "s": {
			// it should serialise the array(array to file)
			 try {
		            FileOutputStream fos = new FileOutputStream(savedFile);
		            ObjectOutputStream out = new ObjectOutputStream(fos);
		            out.writeObject(saved);
		            
		            out.flush();
		            out.close();
		        } catch (IOException e) {
		            System.out.println("Error while saving the file: " + e.getMessage());
		        }
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + d);
		}
	}
	
	public void savedGame(Person p) {
		for (String i : saved) {
			changePlayerPos(i,p);
		}
	}
	public void printMap() {
		for (int i = 0; i < rowS; i++) {
			System.out.println(Arrays.toString(world[i]));
		}
	}
	
}
