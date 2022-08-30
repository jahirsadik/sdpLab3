package sample;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import UIElements.HighDetailedUIElemFactory;
import UIElements.SimplisticUIElemFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private final static String DEFAULT_CONFIG_FILE_XML = "src\\sample\\config.xml";

    /* Main function takes terminal inputs before creating
    the window using selected style and config
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WindowManager windowManager = null;

        try {
            System.out.println("Enter config file name: ");
            String configFileName = scanner.nextLine().trim();

            if (!(new File(configFileName).isFile())) {
                configFileName = DEFAULT_CONFIG_FILE_XML;
                System.out.println("File not found. Loading Default config.xml file");
                if(!(new File(configFileName).isFile())){
                    throw new Exception("File not found.");
                }
            }

            ConfigManager.getInstance(configFileName);

            boolean breakFlag = false;

            while (!breakFlag) {
                try {
                    System.out.println("Enter element style: ");
                    System.out.println("1. Simplistic Design");
                    System.out.println("2. High Detailed Design");
                    int option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1:
                            windowManager = WindowManager.getInstance(new SimplisticUIElemFactory());
                            breakFlag = true;
                            break;
                        case 2:
                            windowManager = WindowManager.getInstance(new HighDetailedUIElemFactory());
                            breakFlag = true;
                            break;
                        default:
                            System.out.println("Invalid option");
                            continue;
                    }
                } catch (InputMismatchException e) {
                    scanner.next();
                    System.out.println("Invalid option");
                    continue;
                }
            }
            breakFlag = false;
            while (!breakFlag) {
                if(windowManager.specificFactory.toString().equals("SimplisticUIElemFactory")){
                    System.out.println("Enter UI Element Color name:");
                    String colorName = scanner.nextLine().trim();
                    windowManager.childrenColor = colorName.toLowerCase();
                    breakFlag = true;
                }else{
                    System.out.println("Enter UI Element Color name:");
                    String colorName = scanner.nextLine().trim();
                    windowManager.childrenColor = colorName.toLowerCase();
                    System.out.println("Enter UI Element Text Size:");
                    int textSize = scanner.nextInt();
                    // Restrict the text size so that it fits in the window
                    if(textSize > windowManager.getHeight() || textSize < 1){
                        System.out.println("Input textSize too small/too big. Choosing default textSize 14");
                        textSize = 14;
                    }
                    windowManager.textSize = textSize;
                    breakFlag = true;
                }
            }
            // launch the javafx application
            launch(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    // Javafx application start method
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        WindowManager windowManager = WindowManager.getInstance(null);
        windowManager.loadUI(ConfigManager.getInstance(null), root);
        Scene scene = new Scene(root, windowManager.getWidth(), windowManager.getHeight());
        root.setStyle("-fx-background-color: gray");
        primaryStage.setTitle(windowManager.getTitle());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
