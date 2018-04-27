package walkinprogress.jparsingview.model;

public class CNode
{
	/*
	 * Methods
	 */
	public String getName ( )
	{
		return m_strName;
	}
	public void setName ( String strName )
	{
		m_strName = strName;
	}
	public void addChild ( CNode refChild )
	{
		m_lstChildren.add ( refChild );
	}
	public CNode getChild ( int iIndex )
	{
		return m_lstChildren.get ( iIndex );
	}
	/*
	 * Data members
	 */
	private String m_strName;
	private java.util.List<CNode> m_lstChildren;
}
