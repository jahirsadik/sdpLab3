package sample;

import UIElements.IUIElemFactory;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WindowManager {
    IUIElemFactory specificFactory;
    private int width = 640;
    private int height = 480;
    private String title = "Window";
    public String childrenColor = "red";
    public int textSize = 14;
    /* WindowManager is a Singleton class,
         ref holds the value of currently initiated ConfigManager reference
     */
    private static WindowManager ref = null;
    // getInstance ensures that the class follows Singleton pattern
    public static synchronized WindowManager getInstance(IUIElemFactory specificFactory){
        if(ref == null){
            ref = new WindowManager(specificFactory);
        }
        return ref;
    }

    private WindowManager(IUIElemFactory specificFactory){
        this.specificFactory = specificFactory;
    }
    /*
        This method iteratively takes UI element descriptions from the config file
            and displays the elements in the GUI.
        After loading the UI elements, it goes through them one by one and applies
            the style depending on the style selected by the user
     */
    public void loadUI(ConfigManager config, Pane root) {
        while(config.hasMoreItems()){
            try {
                root.getChildren().add(specificFactory.create(config.nextItem()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(specificFactory.toString().equals("SimplisticUIElemFactory")){
            for (Node node:
                 root.getChildren()) {
                node.setStyle(String.format("-fx-background-color: %s;", this.childrenColor));
            }
        }
        else{
            for (Node node:
                    root.getChildren()) {
                node.setStyle(String.format("-fx-background-color: %s; -fx-font: %d arial;", this.childrenColor, this.textSize));
            }
        }
    }
    
    public void setSpecificFactory(IUIElemFactory specificFactory) {
        this.specificFactory = specificFactory;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IUIElemFactory getSpecificFactory() {
        return specificFactory;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }
}
