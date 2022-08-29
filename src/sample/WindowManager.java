package sample;

import UIElements.IUIElemFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WindowManager {
    IUIElemFactory specificFactory;
    private int width = 1280;
    private int height = 720;
    private String title = "Window";

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
