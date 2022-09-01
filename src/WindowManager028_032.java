import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class WindowManager028_032 {
    IUIElemFactory028_032 specificFactory;
    private int width = 640;
    private int height = 480;
    private String title = "Window";
    public String childrenColor = "red";
    public int textSize = 14;
    /* WindowManager028_032 is a Singleton class,
         ref holds the value of currently initiated ConfigManager028_032 reference
     */
    private static WindowManager028_032 ref = null;
    // getInstance ensures that the class follows Singleton pattern
    public static synchronized WindowManager028_032 getInstance(IUIElemFactory028_032 specificFactory){
        if(ref == null){
            ref = new WindowManager028_032(specificFactory);
        }
        return ref;
    }

    private WindowManager028_032(IUIElemFactory028_032 specificFactory){
        this.specificFactory = specificFactory;
    }
    /*
        This method iteratively takes UI element descriptions from the config file
            and displays the elements in the GUI.
        After loading the UI elements, it goes through them one by one and applies
            the style depending on the style selected by the user
     */
    public void loadUI(ConfigManager028_032 config, Pane root) {
        while(config.hasMoreItems()){
            try {
                root.getChildren().add(specificFactory.create(config.nextItem()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(specificFactory.toString().equals("SimplisticUIElemFactory028_032")){
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
    
    public void setSpecificFactory(IUIElemFactory028_032 specificFactory) {
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

    public IUIElemFactory028_032 getSpecificFactory() {
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
