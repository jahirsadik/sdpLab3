import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class SimplisticUIElemFactory028_032 implements IUIElemFactory028_032 {
    /* creates a JavaFx control object(UI node) from parsed UI Element Description
        In this case, the created object follows simplistic style
     */
    @Override
    public Control create(UIElemDescriptor028_032 uiElemDescriptor) throws Exception {
        Control control;
        String uiElemType = uiElemDescriptor.type;
        switch (uiElemType){
            case "Button":
                control = new SimplisticButton028_032(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            case "EditBox":
                control = new SimplisticEditBox028_032(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            case "TextBox":
                control = new SimplisticTextBox028_032(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            default:
                control = null;
                throw new Exception("Wrong argument passed to simplistic ui element factory class");
        }
        return control;
    }
    @Override
    public String toString() {
        return "SimplisticUIElemFactory028_032";
    }
}


class SimplisticButton028_032 extends Button implements ISimplisticUIElem028_032 {
    private Color color;
    SimplisticButton028_032(String text, double xCoordinate, double yCoordinate){
        super(text);
        this.setLayoutX(xCoordinate);
        this.setLayoutY(yCoordinate);
    }
    @Override
    public void changeColor(String color) {
        this.color = Color.web(color);
        this.setStyle(String.format("-fx-background-color: %s;", this.color.toString()));
    }
}


class SimplisticEditBox028_032 extends TextField implements ISimplisticUIElem028_032 {
    private Color color;
    SimplisticEditBox028_032(String text, double xCoordinate, double yCoordinate){
        super(text);
        this.setLayoutX(xCoordinate);
        this.setLayoutY(yCoordinate);
    }
    @Override
    public void changeColor(String color) {
        this.color = Color.web(color);
        this.setStyle(String.format("-fx-background-color: %s;", this.color.toString()));
    }
}

class SimplisticTextBox028_032 extends Label implements ISimplisticUIElem028_032 {
    private Color color;
    SimplisticTextBox028_032(String text, double xCoordinate, double yCoordinate){
        super(text);
        this.setLayoutX(xCoordinate);
        this.setLayoutY(yCoordinate);
    }
    @Override
    public void changeColor(String color) {
        this.color = Color.web(color);
        this.setStyle(String.format("-fx-background-color: %s;", this.color.toString()));
    }
}
