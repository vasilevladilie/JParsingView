package walkinprogress.jparsingview.controller.process;

import walkinprogress.jparsingview.ifc.IChainLink;
import walkinprogress.jparsingview.ifc.Visitable;
import walkinprogress.jparsingview.ifc.Visitor;
import walkinprogress.jparsingview.model.CDocument;
import walkinprogress.jparsingview.model.CNode;

import java.util.ListIterator;

public class CDocVisitor implements Visitor
{
	private class CNodeVisitor implements Visitor
	{
		public CNodeVisitor ( IChainLink ifcChainLink )
		{
			m_ifcChainLink = ifcChainLink;
		}
		@Override
		public void visit(Visitable objVisitable) 
		{
			/*
			 * \desc Add here method to process 
			 * sequentially each node of the Document Model
			 */
			
			CNode objNode = null;
			objNode = ((CNode)objVisitable);
			m_ifcChainLink.process ( objNode );
			System.out.println ( objNode.getName ( ) + "\n" );
			/*
			 * Do recursion on the list of children nodes 
			 */
	
			ListIterator<CNode> nodeIterator = null;
			nodeIterator = objNode.getChildren ( );
			while ( true == nodeIterator.hasNext ( ) )
			{				
				nodeIterator.next().accept ( this );
			}		
		}
		private IChainLink m_ifcChainLink;
	}
	public CDocVisitor ( IChainLink ifcChainLink )
	{
		objNodeVisitor = new CNodeVisitor ( ifcChainLink );
	}
	@Override
	public void visit ( Visitable objVisitable )
	{
		objNodeVisitor.visit
		(
				((CDocument)objVisitable).getParent()
		);
	}
	
	private CNodeVisitor objNodeVisitor;


}
