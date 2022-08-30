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
    private int width = 1280;
    private int height = 720;
    private String title = "Window";
    public String color = "red";
    public int textSize = 14;

    private static WindowManager ref = null;
    public static synchronized WindowManager getInstance(IUIElemFactory specificFactory){
        if(ref == null){
            ref = new WindowManager(specificFactory);
        }
        return ref;
    }

    public WindowManager(IUIElemFactory specificFactory){
        this.specificFactory = specificFactory;
    }

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
                node.setStyle(String.format("-fx-background-color: %s;", this.color));
            }
        }
        else{
            for (Node node:
                    root.getChildren()) {
                node.setStyle(String.format("-fx-background-color: %s; -fx-font: %d arial;", this.color, this.textSize));
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
