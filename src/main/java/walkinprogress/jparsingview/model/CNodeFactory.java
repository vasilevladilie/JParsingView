package walkinprogress.jparsingview.model;

public class CNodeFactory
{
	public CNode create ( )
	{
		CNode refNode = new CNode ( );
		return refNode;
	}
	static public CNodeFactory instance ( )
	{
		return s_refNodeFactory;
	}
	/*
	 * Data members
	 */
	private CNodeFactory ( )
	{
		/*
		 * Initialize the singleton
		 */
	}
	static
	{
		s_refNodeFactory = new CNodeFactory ( );
	}
	static private CNodeFactory s_refNodeFactory;
}
