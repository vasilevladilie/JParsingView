package walkinprogress.jparsingview.parser;

public class CParsingEvent extends Object
{
	public enum EVENT
	{
		START_DOCUMENT,
		END_DOCUMENT,
		START_ELEMENT,
		END_ELEMENT,
		CHARACTERS
	};
	
	public EVENT getEvent ( ) 
	{
		return m_eEvent;
	}
	public void setEvent ( EVENT eEvent ) 
	{
		this.m_eEvent = eEvent;
	}
	public String getQName ( ) 
	{
		return m_strQName;
	}
	public void setQName ( String strQName ) 
	{
		this.m_strQName = strQName;
	}
	public String getUri ( ) 
	{
		return m_strUri;
	}
	public void setUri ( String strUri )
	{
		this.m_strUri = strUri;
	}
	public String getLocalName ( )
	{
		return m_strLocalName;
	}
	public void setLocalName ( String strLocalName )
	{
		this.m_strLocalName = strLocalName;
	}
	public String getCharacters ( )
	{
		return m_strCharacters;
	}
	public void setCharacters ( String strCharacters )
	{
		this.m_strCharacters = strCharacters;
	}
	
	/*
	 * Data members
	 */
	private EVENT m_eEvent;
	private String m_strQName;
	private String m_strUri;
	private String m_strLocalName;
	private String m_strCharacters;
}
