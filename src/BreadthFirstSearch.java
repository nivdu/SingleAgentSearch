import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch  extends ASearch
{
	Queue<ASearchNode> openList;
	Queue<ASearchNode> closeList;
	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		openList = new LinkedList<>();
		closeList = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen (ASearchNode node) {
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
	public boolean isClosed(ASearchNode node) {
		for (ASearchNode SN:closeList){
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
			closeList.add(node);
	}

	@Override
	public int openSize() 
	{
		return openList.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return openList.remove();
	}

	

}
