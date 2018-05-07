package walkinprogress.jparsingview.view.cor;

import walkinprogress.jparsingview.ifc.IChainLink;

public class CChainController implements IChainLink
{
	
	public CChainController ( )
	{
		m_ifcFirstLink = null;
	}
	
	public void init ( )
	{
		m_ifcFirstLink = new CTreeViewLink ( );
		IChainLink ifcSecondLink = new CTextViewLink ( );
		m_ifcFirstLink.setNext ( ifcSecondLink );
	}
	@Override
	public void process ( Object objCommand )
	{
		if ( null != m_ifcFirstLink )
		{
			m_ifcFirstLink.process ( objCommand );
		}
	}
	
	private IChainLink m_ifcFirstLink;

	@Override
	public void setNext(IChainLink objLink) { }
	
}
