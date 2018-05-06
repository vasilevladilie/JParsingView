package walkinprogress.jparsingview.parser;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class CParserHandler 
	extends DefaultHandler 
	implements walkinprogress.jparsingview.ifc.IObservable
{
	public CParserHandler ( )
	{
		m_lstObservers = new java.util.ArrayList
		<
			walkinprogress.jparsingview.ifc.IObserver
		> ( );
		m_objObserver = new CParsingEvent ( );		
	}
    @Override
    public void startDocument ( )
    		throws SAXException
    {
       System.out.println("Start Document");
       m_objObserver.setEvent
       (
    		   walkinprogress.jparsingview.parser.CParsingEvent.EVENT.START_DOCUMENT
       );
       for
       (
    		   walkinprogress.jparsingview.ifc.IObserver iObserve : m_lstObservers
       )
       {
    	   iObserve.dispatch ( m_objObserver );
       }
    }

    @Override
    public void endDocument ( ) 
    		throws SAXException
    {
        System.out.println("End Document");
        m_objObserver.setEvent
        (
        		walkinprogress.jparsingview.parser.CParsingEvent.EVENT.END_DOCUMENT
        );
        for
        (
        		walkinprogress.jparsingview.ifc.IObserver iObserve : m_lstObservers
        )
        {
     	   iObserve.dispatch ( m_objObserver );
        }
    }

    @Override
    public void startElement
    (
    		String strUri,
    		String strLocalName,
    		String strQName,
    		org.xml.sax.Attributes attributes
    )
    		throws SAXException
    {
    	//! UNUSED
    	//! attributes
        System.out.println("Start element: " + strQName);
        m_objObserver.setEvent
        (
        		walkinprogress.jparsingview.parser.CParsingEvent.EVENT.START_ELEMENT 
        );
        m_objObserver.setUri ( strUri );
        m_objObserver.setLocalName ( strLocalName );
        m_objObserver.setQName ( strQName );
        for
        (
        		walkinprogress.jparsingview.ifc.IObserver iObserve : m_lstObservers
        )
        {
     	   iObserve.dispatch ( m_objObserver );
        }
    }

    @Override
    public void endElement ( String strUri, String strLocalName, String strQName )
    		throws SAXException
    {
        System.out.println("End element: " + strQName);
        m_objObserver.setEvent
        (
        		walkinprogress.jparsingview.parser.CParsingEvent.EVENT.END_ELEMENT
        );
        m_objObserver.setUri ( strUri );
        m_objObserver.setLocalName ( strLocalName );
        m_objObserver.setQName ( strQName );
        for
        (
        		walkinprogress.jparsingview.ifc.IObserver iObserve : m_lstObservers
        )
        {
     	   iObserve.dispatch ( m_objObserver );
        }
    }

    @Override
    public void characters ( char[] strCh, int iStart, int iLength )
    		throws SAXException 
    {
        System.out.println("Characters");
        StringBuilder objStrBuilder = new StringBuilder ( );
        objStrBuilder.append 		( strCh, iStart, iLength );
        m_objObserver.setEvent
        (
        		walkinprogress.jparsingview.parser.CParsingEvent.EVENT.CHARACTERS
        );
        m_objObserver.setCharacters ( objStrBuilder.toString ( ) );
        for
        (
        		walkinprogress.jparsingview.ifc.IObserver iObserve : m_lstObservers
        )
        {
     	   iObserve.dispatch ( m_objObserver );
        }
    }
	public void registerObserver
	( 
			walkinprogress.jparsingview.ifc.IObserver iObserve
	)
	{
		if ( null != iObserve )
		{
			m_lstObservers.add ( iObserve );
		}
	}
	public void unregisterObserver
	(
			walkinprogress.jparsingview.ifc.IObserver iObserve
	)
	{
		if ( true == m_lstObservers.contains( iObserve ) )
		{
			m_lstObservers.remove ( iObserve );			
		}
	}
		
	/*
     * Data members
     */
    private java.util.List
    <
    	walkinprogress.jparsingview.ifc.IObserver
    > m_lstObservers;
    private CParsingEvent 			  m_objObserver;
}
