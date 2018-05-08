package walkinprogress.jparsingview.controller.cor;

import walkinprogress.jparsingview.ifc.IChainLink;

public class CTreeViewLink 
	implements IChainLink 
{
	public CTreeViewLink ( )
	{
		m_objLink = null;		
	}	
	
	@Override
	public void setNext ( IChainLink objLink ) 
	{
		m_objLink = objLink;
	}

	@Override
	public void process ( Object objCommand ) 
	{
		/**
		 * \desc Do the classes particular processing
		 * 		 afterwards advance on the chain.
		 */
		if ( null != m_objLink )
		{
			m_objLink.process ( objCommand );
		}
	}
	
	private IChainLink m_objLink;

}
