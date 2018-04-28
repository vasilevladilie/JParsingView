package walkinprogress.jparsingview.parser;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CParserHandler extends DefaultHandler
{
	
    @Override
    public void startDocument ( )
    		throws SAXException
    {
       System.out.println("Start Document");
    }

    @Override
    public void endDocument ( ) 
    		throws SAXException
    {
        System.out.println("End Document");
    }

    @Override
    public void startElement
    (
    		String uri,
    		String localName,
    		String qName,
    		org.xml.sax.Attributes attributes
    )
    		throws SAXException
    {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement ( String uri, String localName, String qName )
    		throws SAXException
    {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters ( char[] ch, int start, int length )
    		throws SAXException 
    {
        System.out.println("Characters");
    }
}
