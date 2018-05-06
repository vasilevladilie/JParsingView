package walkinprogress.jparsingview.model;


import walkinprogress.jparsingview.ifc.Visitable;
import walkinprogress.jparsingview.ifc.Visitor;

public class CDocument implements Visitable
{
	public CDocument ( )
	{
		m_strName = new String ( );
		m_refRoot = new CNode ( );
	}	
	public void linkNode ( CNode refParent, CNode refChild )
	{
		refParent.addChild(refChild);
	}
	public CNode linkNode ( CNode refParent, String strId )
	{
		CNode refNewNode = null;
		if ( null != refParent )
		{
			refNewNode = CNodeFactory.instance ( ).create ( );
			refNewNode.setName   ( strId );
			refParent.addChild   ( refNewNode );
			refNewNode.setParent ( refParent );
		}
		return refNewNode;
	}
	public CNode setParent ( String strQName )
	{
		m_refRoot.setName ( strQName );;
		return m_refRoot;
	}
	public CNode getParent ( )
	{
		return m_refRoot;
	}
	@Override
	public void accept ( Visitor objVisitor )
	{
		/*
		 * Just do the double dispatch
		 */
		objVisitor.visit ( this );
	}
	/*
	 * Data members
	 */
	String m_strName;
	CNode m_refRoot;
}
