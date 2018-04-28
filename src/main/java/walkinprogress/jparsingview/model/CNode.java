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
	 * And eventually the attributes accessor
	 */
	public void addAttribute ( String strName, String strValue )
	{
		m_hmAttribute.put(strName, strValue);
	}
	public String getAttribute ( int iIndex )
	{
		/*
		 * Don't know yet what to return here because we have a pair.
		 */
		return "";
	}
	/*
	 * Data members
	 */
	private String m_strName;
	private java.util.List<CNode> m_lstChildren;
	/*
	 * And eventually
	 */
	private java.util.HashMap<String, String> m_hmAttribute;
	
}
