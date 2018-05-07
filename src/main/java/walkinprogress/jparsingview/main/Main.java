package walkinprogress.jparsingview.main;
import walkinprogress.jparsingview.controller.parser.CParsingController;
import walkinprogress.jparsingview.controller.process.CDocVisitor;
import walkinprogress.jparsingview.model.CDocument;

public class Main 
{

	public static void main ( String [ ] args ) 
	{
		CDocument refModel = new CDocument ( );
		CParsingController refPController = new CParsingController ( refModel );
		refPController.setFile
		("/home/vladilie/workspace/github/JParsingView/src/main/resources/input/01.xml");
		refPController.startParsing ( );
		CDocVisitor refDocVisitor = new CDocVisitor ( null );
		System.out.println("Show the model:");
		refDocVisitor.visit ( refModel );
	}

}
