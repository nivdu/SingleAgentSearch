
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
				int shouldBeRow = curr/length;
				int distanceRow = Math.abs(shouldBeRow-i);
				int shouldBeCol = (curr%length)-1;
				int distanceCol = Math.abs(shouldBeCol - i);
				sum += (distanceCol+distanceRow)*curr;
			}
		}
		return sum;
	}
}
