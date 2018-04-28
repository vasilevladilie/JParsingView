package walkinprogress.jparsingview.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class CParser 
{
	public CParser ( )
	{
		m_refHandler = null;
	}
	
    public void readDataFromXML(String strFilename)
    		throws IOException,
    			   SAXException,
    			   ParserConfigurationException
    {
        SAXParserFactory refFactory = SAXParserFactory.newInstance();
        SAXParser refParser = refFactory.newSAXParser();
        if ( null == m_refHandler)
        {
        	throw new NullPointerException ( );
        }        
        refParser.parse( new File ( strFilename ), m_refHandler );
    }
    
    public void setHandler ( CParserHandler refHandler )
    {
    	m_refHandler = refHandler;
    }
    private CParserHandler m_refHandler;
}
