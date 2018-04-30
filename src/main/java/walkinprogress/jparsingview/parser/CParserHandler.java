package walkinprogress.jparsingview.parser;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import walkinprogress.jparsingview.ifc.IObserver;
import walkinprogress.jparsingview.parser.CParsingEvent.EVENT;

public class CParserHandler 
	extends DefaultHandler 
	implements walkinprogress.jparsingview.ifc.IObservable
{
	public CParserHandler ( )
	{
		m_objObserver = new CParsingEvent ( );		
	}
    @Override
    public void startDocument ( )
    		throws SAXException
    {
       System.out.println("Start Document");
       m_objObserver.setEvent ( EVENT.START_DOCUMENT );
       for ( IObserver iObserve : m_lstObservers )
       {
    	   iObserve.dispatch ( m_objObserver );
       }
    }

    @Override
    public void endDocument ( ) 
    		throws SAXException
    {
        System.out.println("End Document");
        m_objObserver.setEvent ( EVENT.END_DOCUMENT );
        for ( IObserver iObserve : m_lstObservers )
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
        m_objObserver.setEvent ( EVENT.START_ELEMENT );
        m_objObserver.setUri ( strUri );
        m_objObserver.setLocalName ( strLocalName );
        m_objObserver.setQName ( strQName );
        for ( IObserver iObserve : m_lstObservers )
        {
     	   iObserve.dispatch ( m_objObserver );
        }
    }

    @Override
    public void endElement ( String strUri, String strLocalName, String strQName )
    		throws SAXException
    {
        System.out.println("End element: " + strQName);
        m_objObserver.setEvent ( EVENT.END_ELEMENT );
        m_objObserver.setUri ( strUri );
        m_objObserver.setLocalName ( strLocalName );
        m_objObserver.setQName ( strQName );
        for ( IObserver iObserve : m_lstObservers )
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
        m_objObserver.setEvent      ( EVENT.CHARACTERS );
        m_objObserver.setCharacters ( objStrBuilder.toString ( ) );
        for ( IObserver iObserve : m_lstObservers )
        {
     	   iObserve.dispatch ( m_objObserver );
        }
    }
	public void registerObserver   ( IObserver iObserve )
	{
		if ( null != iObserve )
		{
			m_lstObservers.add ( iObserve );
		}
	}
	public void unregisterObserver ( IObserver iObserve )
	{
		if ( true == m_lstObservers.contains( iObserve ) )
		{
			m_lstObservers.remove ( iObserve );			
		}
	}
		
	/*
     * Data members
     */
    private java.util.List<IObserver> m_lstObservers;
    private CParsingEvent 			  m_objObserver;
}
