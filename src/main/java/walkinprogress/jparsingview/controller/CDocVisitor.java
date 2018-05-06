package walkinprogress.jparsingview.controller;

import walkinprogress.jparsingview.ifc.Visitable;
import walkinprogress.jparsingview.ifc.Visitor;
import walkinprogress.jparsingview.model.CDocument;
import walkinprogress.jparsingview.model.CNode;

import java.util.ListIterator;

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
			CNode objNode = null;
			objNode = ((CNode)objVisitable);
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
	}
	public CDocVisitor ( )
	{
		objNodeVisitor = new CNodeVisitor ( );
	}
	@Override
	public void visit ( Visitable objVisitable )
	{
		objNodeVisitor.visit
		(((CDocument)objVisitable).getParent());
	}
	
	private CNodeVisitor objNodeVisitor;


}
