
public class TilePuzzleHeuristic implements IHeuristic
{

	@Override
	public double getHeuristic(IProblemState problemState) {
		int length=0;
		int sum=0;
		if(problemState instanceof TilePuzzleState)
			length = ((TilePuzzleState) problemState)._tilePuzzle.length;
		else return 0;
		int[][] tilePuz = ((TilePuzzleState) problemState)._tilePuzzle;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				int curr = tilePuz[i][j];
				if(curr==0)
					continue;
				int shouldBeRow = curr/length;
				if(curr%length==0)
					shouldBeRow--;
				int distanceRow = Math.abs(shouldBeRow-i);
				int shouldBeCol = (curr%length)-1;
				if(shouldBeCol==-1)
					shouldBeCol=length-1;
				int distanceCol = Math.abs(shouldBeCol - j);
				sum += (distanceCol+distanceRow)*curr;
			}
		}
		return sum;
	}
}

