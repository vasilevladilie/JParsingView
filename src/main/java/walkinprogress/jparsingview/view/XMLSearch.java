package walkinprogress.jparsingview.view;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
/**
 * Created by taoLen on 4/28/2018.
 */
/**
 * You have to add the jfxrt.\ jar library 
 * to the project to find the imports.
 */

public class XMLSearch extends Application {
    Button button;
    TextField filename;
    TextField pathName;
    Scene scene;


    @Override
    public void start(Stage primaryStage) throws Exception{

        Text scenetitle = new Text("get XML data");
        Label f = new Label("file name: ");
        filename = new TextField();
        Label path = new Label("path: ");
        pathName = new TextField();
        button = new Button("Done");
        HBox hbtn = new HBox(10);
        hbtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbtn.getChildren().add(button);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        grid.add(scenetitle, 0,0,2,1);
        grid.add(f,0,1);
        grid.add(filename,1,1);
        grid.add(path,0,2);
        grid.add(pathName,1,2);
        grid.add(hbtn,1,4);
        grid.setGridLinesVisible(false);
        scene = new Scene(grid, 300, 275);
        primaryStage.setTitle("Manipulating XML");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Reading XML as String using jCabi library
//         XML xml = new XMLDocument(new File("info.xml"));
//         String xmlString = xml.toString();
        button.setOnAction(event -> {

            try {
                //default path for xml
                //File xmlFile = new File("C:\Users\marius.nicolae1\IntelliJIDEAProjects\Spring\cust.xml");

                //storing the content of xml into another file
                PrintWriter fisier = new PrintWriter(filename.getText() + ".txt");
                //prepare the string builder
                StringBuilder builder = new StringBuilder();
                //getting the path from xml file
                String filePath = "/home/vladilie/workspace/github/JParsingView/src/main/resources/input/01.xml";
                File xmlFile = new File(filePath);
                //reading from xml file
                Reader fileReader = new FileReader(xmlFile); //using polymorphism here
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = bufferedReader.readLine();
                while(line != null){
                    builder.append(line).append("\n");
                    line = bufferedReader.readLine();
                    System.out.println(line);
                }
                bufferedReader.close();
//                //printing content
                fisier.print(builder.toString());
                fisier.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            primaryStage.close();
        });
    }
}
