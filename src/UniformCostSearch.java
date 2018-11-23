import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class UniformCostSearch extends ASearch
{
	private PriorityQueue<ASearchNode> openList;
	private LinkedList<ASearchNode> closedList;

	@Override
	public String getSolverName() 
	{
		return "UCS";
	}

	@Override
	public ASearchNode createSearchRoot(IProblemState problemState	)
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists()
	{
		Comparator<Object> comparator = new ASearchNodeComparator();
		openList = new PriorityQueue<>(comparator);
		closedList = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
	{
		for (ASearchNode SN:openList){
			if(SN.equals(node))
				return SN;
		}
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node)
	{
		for (ASearchNode SN:openList){
			if(SN.equals(node))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isClosed(ASearchNode node)
	{
		for (ASearchNode SN: closedList){
			if(SN.equals(node))
				return true;
		}
		return false;
	}

	@Override
	public void addToOpen(ASearchNode node)
	{
		if(node!=null)
			openList.add(node);
	}

	@Override
	public void addToClosed(ASearchNode node)
	{
		if(node!=null)
			closedList.add(node);
	}

	@Override
	public int openSize() 
	{
		return openList.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return openList.poll();
	}

	public class ASearchNodeComparator implements Comparator<Object> {

		@Override
		public int compare(Object x, Object y) {
			ASearchNode x1 = (ASearchNode)x;
			ASearchNode y1 = (ASearchNode)y;
			if (x1.getG() < y1.getG()) {
				return -1;
			} else {
				return x1.getG() > y1.getG() ? 1 : 0;
			}
		}
	}
}
