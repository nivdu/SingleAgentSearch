import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PureHeuristicSearch  extends ASearch
{
	private PriorityQueue<ASearchNode> openList;
	private Queue<ASearchNode> closedList;

	@Override
	public String getSolverName() 
	{
		return "PHS";
	}

	@Override
	public ASearchNode createSearchRoot(IProblemState problemState) {
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		Comparator compareIt = new PHSComparator();
		openList = new PriorityQueue<>(compareIt);
		closedList = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node) {
		for (ASearchNode SN:openList){
			if(SN.equals(node))
				return SN;
		}
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node) {
		if(openList.contains(node))
			return true;
		return false;
	}
	
	@Override
	public boolean isClosed(ASearchNode node) {
		if(closedList.contains(node))
			return true;
		return false;
	}

	

	@Override
	public void addToOpen(ASearchNode node) {
		if(node!=null)
			openList.add(node);
	}

	@Override
	public void addToClosed(ASearchNode node) {
		if (node!=null)
			closedList.add(node);
	}

	@Override
	public int openSize() 
	{
		return openList.size();
	}

	@Override
	public ASearchNode getBest() {
		return openList.remove();
	}

	private class PHSComparator implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			ASearchNode x1 = (ASearchNode)o1;
			ASearchNode x2 = (ASearchNode)o2;
			if(x1.getH()>x2.getH())
				return 1;
			if(x1.getH()<x2.getH())
				return -1;
			return 0;
		}
	}
}