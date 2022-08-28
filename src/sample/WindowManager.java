package sample;

import UIElements.IUIElemFactory;
import UIElements.SimplisticUIElemFactory;

public class WindowManager {
    IUIElemFactory specificFactory;
    private int width;
    private int height;
    private String title;

    private static WindowManager ref = null;
    public static synchronized WindowManager getInstance(IUIElemFactory specificFactory){
        if(ref == null){
            ref = new WindowManager(specificFactory);
        }
        return ref;
    }
    private WindowManager(IUIElemFactory specificFactory){
        this.specificFactory = specificFactory;
    }

    public void loadUI(ConfigManager config){
        while(config.hasMoreItems()){

        }
    }

    //TODO: Setter functions need to refresh the UI
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
