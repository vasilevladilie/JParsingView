package walkinprogress.jparsingview.model;


public class CDocument implements walkinprogress.jparsingview.ifc.Visitable
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
	public void accept ( walkinprogress.jparsingview.ifc.Visitor objVisitor )
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
