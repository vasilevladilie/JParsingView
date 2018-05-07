package walkinprogress.jparsingview.controller.parser;

public class CParsingMethod 
{
	public CParsingMethod ( )
	{
		m_bSibling   = true;
		m_bHasParent = false;
		m_refParent  = null;
		m_refChild   = null;
	}
	public void processEvent
	(
			Object objEvent,
			walkinprogress.jparsingview.model.CDocument refModel
	)
	{
		walkinprogress.jparsingview.parser.CParsingEvent
		evParsing = 
		(walkinprogress.jparsingview.parser.CParsingEvent)( objEvent );
		if ( null == evParsing )
		{
			throw new NullPointerException ( );
		}
		if ( null == refModel )
		{
			throw new NullPointerException ( );
		}
		switch ( evParsing.getEvent ( ) )
		{
			case START_DOCUMENT :
			{
				m_bSibling = true;
				break;
			}
			case END_DOCUMENT :
			{
				m_bSibling = false;
				break;				
			}
			case START_ELEMENT :
			{
				if ( false == m_bHasParent )
				{
					m_refParent = refModel.setParent ( evParsing.getQName ( ) );
					m_refChild = m_refParent;
					m_bHasParent = true;
				}
				else if ( true == m_bSibling )
				{
					//Keep the parent, it's a sibling
					m_refChild = refModel.linkNode
					(
						( walkinprogress.jparsingview.model.CNode )m_refParent,
						evParsing.getQName ( )
					);
					
				}
				else
				{
					m_refParent = m_refChild;
					//Child
					m_refChild = refModel.linkNode
					(
						( walkinprogress.jparsingview.model.CNode )m_refParent,
						evParsing.getQName ( )
					);
				}
				
				m_bSibling = false;
				break;
			}
			case END_ELEMENT :
			{
				if ( null == m_refChild )
				{
					throw new NullPointerException ( );					
				}
				Object objSiftUp = m_refParent;
				m_refParent = 
				(
					( walkinprogress.jparsingview.model.CNode )
					m_refChild
				).getParent ( );
				m_refChild = objSiftUp;
				m_bSibling = true;			
				break;				
			}
			case CHARACTERS :
			{
				/**
				 * Link the characters to the current parent;
				 */
				//assert null == m_refParent ;
				( ( walkinprogress.jparsingview.model.CNode ) m_refParent )
				.setCharacters ( evParsing.getCharacters ( ) );			
				break;
			}
			default :
			{
				break;
			}
		}
	}
	/**
	 *  The processing context
	 */
	private boolean m_bSibling;
	private boolean m_bHasParent;
	/*
	 * Store two nodes to link with them the children and the siblings
	 */
	private Object  m_refParent;
	private Object  m_refChild;
}
