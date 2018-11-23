import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AStarSearch extends ASearch {
	private PriorityQueue<ASearchNode> openList;
	private LinkedList<ASearchNode> closedList;

	@Override
	public String getSolverName() {
		return "AStar";
	}

	@Override
	public ASearchNode createSearchRoot(IProblemState problemState) {
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists() {
		Comparator<Object> comparator = new ASearchNodeComparator();
		openList = new PriorityQueue<>(comparator);
		closedList = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node) {
		for (ASearchNode SN : openList) {
			if (SN.equals(node))
				return SN;
		}
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node) {
		for (ASearchNode SN:openList){
			if(SN.equals(node))
				return true;
		}
		return false;
	}

	@Override
	public boolean isClosed(ASearchNode node) {
		for (ASearchNode SN: closedList){
			if(SN.equals(node))
				return true;
		}
		return false;
	}

	@Override
	public void addToOpen(ASearchNode node) {
		if(node!=null)
			openList.add(node);
	}

	@Override
	public void addToClosed(ASearchNode node) {
		if(node!=null)
			closedList.add(node);
	}

	@Override
	public int openSize() {
		return openList.size();
	}

	@Override
	public ASearchNode getBest() {
		return openList.poll();
	}

	public class ASearchNodeComparator implements Comparator<Object> {

		@Override
		public int compare(Object x, Object y) {
			ASearchNode x1 = (ASearchNode) x;
			ASearchNode y1 = (ASearchNode) y;
			double x1Func = x1.getH() + x1.getG();
			double y1Func = y1.getH() + y1.getG();
			if (x1Func < y1Func) {
				return -1;
			} else {
				if (x1Func > y1Func) {
					return 1;
				} else {
					if (x1.getH() > y1.getH())
						return 1;
					else {
						if (x1.getH() < y1.getH())
							return -1;
						else
							return 0;
					}
				}
			}
		}
	}
}
