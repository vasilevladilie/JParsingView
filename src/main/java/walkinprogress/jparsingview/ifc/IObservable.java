package walkinprogress.jparsingview.ifc;

public interface IObservable 
{
	public void registerObserver   ( IObserver iObserve );
	public void unregisterObserver ( IObserver iObserve );
	
}
