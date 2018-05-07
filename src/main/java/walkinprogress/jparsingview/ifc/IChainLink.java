package walkinprogress.jparsingview.ifc;

public interface IChainLink 
{
	public void setNext ( IChainLink objLink );
	public void process ( Object objCommand );
}
