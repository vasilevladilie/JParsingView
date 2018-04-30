package walkinprogress.jparsingview.model;

public class CNode
{
	/*
	 * Methods
	 */
	public CNode ( )
	{
		m_strName = null;
		m_strCharacters = null;
	}
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
	public CNode getParent ( )
	{
		return m_refParent;
	}
	public void setParent ( CNode refNode )
	{
		m_refParent = refNode;
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
	public void setCharacters ( String strCharacters )
	{
		m_strCharacters = strCharacters;
	}
	public String getCharacters ( )
	{
		return m_strCharacters;
	}
	public boolean hasCharacters ( )
	{
		return ( null != m_strCharacters );
	}
	/*
	 * Data members
	 */
	private String m_strName;
	private String m_strCharacters;
	private java.util.List<CNode> m_lstChildren;
	/*
	 * And eventually
	 */
	private java.util.HashMap<String, String> m_hmAttribute;
	private CNode m_refParent;
	
}
