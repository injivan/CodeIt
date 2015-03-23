import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Flow {
	private static int[][] arDesk;
	private static oneFlow[] arFlows;// array of flows

	public static void main(String[] args) {
		int N = 0, P = 0;
		try {
			readFile(N, P);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readFile(int N, int P) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("flow.in"));
		// read N and P
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		P = Integer.parseInt(token.nextToken());

		arDesk = new int[N][N];
		arFlows = new oneFlow[P];

		// read start and end of the road
		for (int i = 0; i < P; i++) {
			token = new StringTokenizer(br.readLine());
			int row1 = Integer.parseInt(token.nextToken());
			int col1 = Integer.parseInt(token.nextToken());
			int row2 = Integer.parseInt(token.nextToken());
			int col2 = Integer.parseInt(token.nextToken());
			arFlows[i] = new oneFlow(row1, col1, row2, col2);
		}

		// read rocks count positions
		token = new StringTokenizer(br.readLine());
		int j = Integer.parseInt(token.nextToken());
		for (int i = 0; i < j; i++) {
			token = new StringTokenizer(br.readLine());
			int row1 = Integer.parseInt(token.nextToken());
			int col1 = Integer.parseInt(token.nextToken());
			arDesk[row1][col1] = -1;
		}
		br.close();
	}
}

class oneFlow {
	Point p1, p2;
	private int minPath = 0;// minimum path length
	
	int activePath=0;
		
	// constructor
	oneFlow(int row1, int col1, int row2, int col2) {
		this.p1 = new Point(row1, col1);
		this.p2 = new Point(row2, col2);
		minPath = calculateMinPath();
	}

	public int getMinPath() {
		return minPath;
	}

	private int calculateMinPath() {
		return  Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	@Override
	public String toString(){
		return null;		
	}
}


class Path{
	ArrayList<Point> arPath = new ArrayList<Point>();
	 
}


