package sample;

import java.io.File;
import java.util.InputMismatchException;
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
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WindowManager windowManager = null;

        try {
            System.out.println("Enter config file name: ");
            String configFileName = scanner.nextLine().trim();

            if (configFileName.equals("")) {
                configFileName = DEFAULT_CONFIG_FILE_XML;
            }
            
            if (!(new File(configFileName).isFile())) {
                throw new Exception("File not found.");
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
            launch(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        WindowManager windowManager = WindowManager.getInstance(null);
        windowManager.loadUI(ConfigManager.getInstance(null), root);
        Scene scene = new Scene(root, windowManager.getWidth(), windowManager.getHeight());
        primaryStage.setTitle(windowManager.getTitle());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
