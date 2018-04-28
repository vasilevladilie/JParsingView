package walkinprogress.jparsingview.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import walkinprogress.jparsingview.parser.CParser;
import walkinprogress.jparsingview.parser.CParserHandler;

/*
 * Couples the model with the parsing routines and parsing handlers, it sends
 * the messages to the model so that the model will get updated. It registers to the
 * Parser's handler.
 */

public class CParsingController 
{
	public CParsingController ( )
	{
		m_refParser  = new CParser ( );
		m_refHandler = new CParserHandler ( );
		m_strFile    = null;
	}
	void startParsing ( )
	{
		m_refParser.setHandler ( m_refHandler );
		try 
		{
			m_refParser.readDataFromXML ( m_strFile );
			
		} catch (IOException | SAXException | ParserConfigurationException e)
		{
			e.printStackTrace();
		}
	}
	public void setFile ( String strFile )
	{
		m_strFile = strFile;
	}
	public String getFile ( )
	{
		return m_strFile;
	}
	private CParser m_refParser;
	private CParserHandler m_refHandler;
	private String m_strFile;
}
