package walkinprogress.jparsingview.controller;

import walkinprogress.jparsingview.ifc.Visitable;
import walkinprogress.jparsingview.ifc.Visitor;

public class CDocVisitor implements Visitor
{
	private class CNodeVisitor implements Visitor
	{
		@Override
		public void visit(Visitable objVisitable) 
		{
			/*
			 * \desc Add here method to process 
			 * sequentially each node of the Document Model
			 */
			walkinprogress.jparsingview.model.CNode objNode = null;
			objNode = ((walkinprogress.jparsingview.model.CNode)objVisitable);
			System.out.println ( objNode.getName ( ) + "\n" );
			/*
			 * Do recursion on the list of children nodes 
			 */
	
			java.util.ListIterator
			<
				walkinprogress.jparsingview.model.CNode
			> nodeIterator = null;
			nodeIterator = objNode.getChildren ( );
			while ( true == nodeIterator.hasNext ( ) )
			{				
				nodeIterator.next().accept ( this );
			}		
		}		
	}
	public CDocVisitor ( )
	{
		objNodeVisitor = new CNodeVisitor ( );
	}
	@Override
	public void visit ( Visitable objVisitable )
	{
		
		objNodeVisitor.visit
		(
				(
					(walkinprogress.jparsingview.model.CDocument)objVisitable
				).getParent ( )
		);
	}
	
	private CNodeVisitor objNodeVisitor;


}
