package sample;

import UIElements.UIElemDescriptor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        ArrayList<UIElemDescriptor> elemList = new ArrayList<>();
        XMLParser.parseXML("src\\sample\\file.xml", elemList);
        for (UIElemDescriptor elem: elemList
        ) {
            System.out.println(elem.toString());
            if(elem.type.equals("Button")){
                Button button = new Button(elem.text);
                button.setLayoutX(elem.xCoordinate);
                button.setLayoutY(elem.yCoordinate);
            }
        }

    }
}
