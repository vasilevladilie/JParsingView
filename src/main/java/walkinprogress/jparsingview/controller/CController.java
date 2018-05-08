package walkinprogress.jparsingview.controller;

import walkinprogress.jparsingview.controller.cor.CChainController;
import walkinprogress.jparsingview.controller.parser.CParsingController;
import walkinprogress.jparsingview.controller.process.CDocVisitor;
import walkinprogress.jparsingview.ifc.IChainLink;
import walkinprogress.jparsingview.model.CDocument;

public class CController 
{
	public CController ( )
	{
		init ( );
	}
	
	public void init ( )
	{
		m_objChainController = new CChainController ( );
		m_objDocument		 = new CDocument ( );
		m_objParsing		 = new CParsingController ( m_objDocument );
	}
	public void processModel ( )
	{
		CDocVisitor objDocVisitor = new CDocVisitor
		(
				m_objChainController
		);
		objDocVisitor.visit ( m_objDocument );
		/**
		 * \desc When the call to visit returns the
		 * 		 CElements instance will have the visual elements
		 * 		 updated so the View can be refreshed.
		 */
	}
	
	public void readXML ( String strXMLFileWithPath )
	{
		m_objParsing.setFile 	  ( strXMLFileWithPath );
		m_objParsing.startParsing ( );
	}
	
	public void updateView ( )
	{
		/**
		 * \desc Use the CElements instance to
		 * 		 update the JavaFX Scene
		 */
	}
	/**
	 * \desc The Model of the app
	 */
	private CDocument 		   m_objDocument;
	private CParsingController m_objParsing;
	private IChainLink		   m_objChainController;
}
