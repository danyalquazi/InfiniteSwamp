import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object math;
		Map m = new Map(5,5);
		Person p = new Person(1,1, m);
		Goal g = new Goal(3,3,m);
		Scanner sc = new Scanner(System.in);
		
		double dC;
		double dR;
		double dist;
		String inst;
//		p.setPositionOnMap(m);
//		for (int i=0; i<m.rowS; i++) {
//			for(int j = 0; j < m.colS; j++) {
//				System.out.println(m.world[i][j]);
//			}
//			
//		}
//		System.out.println(Arrays.deepToString(m.world));
		m.printMap();
		while(true) {
			if (p.col == g.col) {
				if (p.row == g.row) {
					System.out.println("Congrats! You won, we do not have a budget for prizes");
					break;
				}
			}
			
			dC = Math.pow(((m.colS-1) - p.col) - ((m.colS-1)-g.col),2);
			dR = Math.pow(((m.rowS-1) - p.row) - ((m.rowS-1)-g.row),2);
			dist = Math.sqrt(dC+dR);
			System.out.println("Your distance is" + dist);
			System.out.println("Select an option to move the player:\n u - Up, d - Down, l - Left, r - Right");
			inst = sc.nextLine();
			m.changePlayerPos(inst, p);
			m.saved.add(inst);

		}
		System.out.println(m.saved.size());
	}

}
