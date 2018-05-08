package walkinprogress.jparsingview.controller.cor;

import walkinprogress.jparsingview.ifc.IChainLink;

public class CTextViewLink 
	implements IChainLink 
{
	public CTextViewLink ( )
	{
		m_objChain = null;
	}

	@Override
	public void setNext ( IChainLink objChain ) 
	{
		m_objChain = objChain;
	}

	@Override
	public void process ( Object objNode ) 
	{
		/**
		 * \desc Do the classes particular processing
		 * 		 afterwards advance on the chain.
		 */
		if ( null != m_objChain )
		{
			m_objChain.process(objNode);
		}
	}
	
	private IChainLink m_objChain;

}
